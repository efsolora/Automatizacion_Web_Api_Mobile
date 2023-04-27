package com.choucair.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.choucair.ui.PaginaProductos.CARRITO;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class IralCarrito implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(CARRITO, isClickable()),
                Click.on(CARRITO)
        );
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public static IralCarrito iralCarrito() {
        return new IralCarrito();
    }
}
