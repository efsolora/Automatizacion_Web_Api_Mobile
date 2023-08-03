package com.choucair.tasks;

import com.github.javafaker.Faker;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.choucair.ui.PaginaCarrito.*;
import static com.choucair.ui.PaginaProductos.CARRITO;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class IralCarrito implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        Faker faker = new Faker();
        String correoAleatorio = faker.internet().emailAddress();
        actor.attemptsTo(
                WaitUntil.the(CARRITO, isClickable()),
                Click.on(CARRITO),
                WaitUntil.the(CONFIRMAR_CORREO, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(correoAleatorio).into(CAMPO_CORREO),
                Click.on(CONFIRMAR_CORREO),
                WaitUntil.the(VALOR_TOTAL, isVisible()).forNoMoreThan(10).seconds()
        );
    }

    public static IralCarrito iralCarrito() {
        return new IralCarrito();
    }
}
