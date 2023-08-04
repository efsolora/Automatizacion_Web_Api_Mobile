package com.choucair.setup;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

import org.apache.log4j.*;

public class AndroidDriver {

    protected Actor actor = Actor.named("User");
    @Managed(driver = "Appium")
    protected WebDriver theMobileDevice;

    private void setUplog4j() {
        Logger rootLogger = Logger.getRootLogger();
        rootLogger.setLevel(Level.INFO);
        ConsoleAppender stdoutAppender = new ConsoleAppender(new PatternLayout("%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L %m%n"));
        rootLogger.addAppender(stdoutAppender);
    }

    private void setupUser(WebDriver theMobileDevice) {
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


