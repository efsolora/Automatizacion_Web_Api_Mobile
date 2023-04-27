package com.choucair.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.choucair.ui.PaginaCategorias.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;


public class EscogerCategoria implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Click.on(MENU),
                WaitUntil.the(CATEGORIA,isClickable()),
                Click.on(CATEGORIA),
                Click.on(CABECEROS)
        );
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public static EscogerCategoria escogerCategoria() {
        return new EscogerCategoria();
    }
}
