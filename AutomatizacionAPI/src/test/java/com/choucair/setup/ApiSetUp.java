package com.choucair.setup;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.apache.log4j.*;


public class ApiSetUp {

    protected Actor actor = new Actor("James");

    protected void setUp(String urlBase){
        setUpLog4j();
        actorCallAnApi(urlBase);
    }
    private void actorCallAnApi(String urlBase){

        actor.can(CallAnApi.at(urlBase));
    }

    private void setUpLog4j() {
        Logger rootLogger = Logger.getRootLogger();
        rootLogger.setLevel(Level.INFO);
        ConsoleAppender stdoutAppender = new ConsoleAppender(new PatternLayout("%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L %m%n"));
        rootLogger.addAppender(stdoutAppender);
    }

}
