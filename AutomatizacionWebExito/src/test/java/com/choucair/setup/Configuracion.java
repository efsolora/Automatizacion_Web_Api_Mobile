package com.choucair.setup;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.google.common.base.StandardSystemProperty.USER_DIR;
import static com.choucair.util.Log4j.LOG4J_PROPERTIES_FILE_PATH;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class Configuracion {
    private static final String ACTOR = "James Munoz";

    @Managed()
    protected WebDriver webDriver;


    private void setupUser() {
        configurarDriver();
        OnStage.setTheStage(new OnlineCast());
        theActorCalled(ACTOR).can(BrowseTheWeb.with(webDriver));
        maximizar(webDriver);
    }

    private void configurarDriver() {
        ChromeOptions co = new ChromeOptions();
        co.addArguments("--force-device-scale-factor=0.9"); // Agregar el argumento
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver(co);
    }


    private static void maximizar(WebDriver webDriver) {
        webDriver.manage().window().maximize();
    }

    protected void quitarDriver() {
        webDriver.quit();
    }

    protected void configurarNavegador() {
        setupUser();
        setUplog4j();
    }

    private void setUplog4j() {
        PropertyConfigurator.configure(USER_DIR.value() + LOG4J_PROPERTIES_FILE_PATH.getValue());

    }

}
