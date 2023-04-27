package com.choucair.tasks;

import com.choucair.interactions.OurGet;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Delete;


public class DoGet implements Task {

    private String resource;
    private String id;

    public DoGet withTheResource(String resource){
        this.resource=resource;
        return this;
    }

    public DoGet withTheId(String id) {
        this.id = id;
        return this;

    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                OurGet.to(resource+"/"+id)
                        .with(RequestSpecification::relaxedHTTPSValidation)
                        .with(request->request.contentType(ContentType.JSON))
        );
    }

    public static DoGet doGet(){
        return new DoGet();
    }
}
