package com.choucair.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import org.awaitility.Awaitility;

import java.util.concurrent.TimeUnit;

public class Espera implements Interaction {

    private int tiempo;

    public Espera(int tiempo) {
        this.tiempo = tiempo;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Awaitility.await().forever().pollInterval(tiempo, TimeUnit.SECONDS).until(() -> true);

    }

    public static Espera espera(int tiempo) {
        return Tasks.instrumented(Espera.class, tiempo);
    }
}
