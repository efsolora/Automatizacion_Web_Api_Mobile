package com.choucair.setup;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;

import static com.google.common.base.StandardSystemProperty.USER_DIR;
import static com.choucair.util.Log4j.LOG4J_PROPERTIES_FILE_PATH;

public class AndroidDriver {
    protected Actor actor = Actor.named("User");
    @Managed(driver = "Appium")
    protected WebDriver theMobileDevice;

    private void setUplog4j() {
        PropertyConfigurator.configure(USER_DIR.value() + LOG4J_PROPERTIES_FILE_PATH.getValue());
    }
    private void setupUser( WebDriver theMobileDevice) {
        OnStage.setTheStage(new OnlineCast());
        actor.can(BrowseTheWeb.with(theMobileDevice));
    }

    protected void quitarDriver() {
        theMobileDevice.quit();
    }

    protected void configurarMobile() {
        setupUser(theMobileDevice);
        setUplog4j();
    }

}

