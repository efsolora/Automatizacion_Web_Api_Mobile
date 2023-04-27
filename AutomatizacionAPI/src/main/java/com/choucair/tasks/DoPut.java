package com.choucair.tasks;

import com.choucair.interactions.OurPut;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class DoPut implements Task {
    private String resource;
    private Object requestBody;
    private String id;

    public DoPut withTheResource(String resource){
        this.resource=resource;
        return this;
    }

    public DoPut andTheRequestBody(Object requestBody){
        this.requestBody=requestBody;
        return this;
    }

    public DoPut withTheId(String id) {
        this.id = id;
        return this;
    }




    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                OurPut.to(resource+"/"+id)
                        .with(
                                requestSpecification -> requestSpecification.relaxedHTTPSValidation()
                                        .contentType(ContentType.JSON)
                                        .body(requestBody)
                        )
        );
    }
    public static DoPut doPut(){
        return new DoPut();
    }
}
