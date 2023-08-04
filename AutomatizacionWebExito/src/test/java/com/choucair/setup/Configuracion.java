package com.choucair.setup;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.apache.log4j.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

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
        Logger rootLogger = Logger.getRootLogger();
        rootLogger.setLevel(Level.INFO);
        ConsoleAppender stdoutAppender = new ConsoleAppender(new PatternLayout("%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L %m%n"));
        rootLogger.addAppender(stdoutAppender);
    }
}
