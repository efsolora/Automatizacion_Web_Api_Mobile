package com.choucair.task;

import com.choucair.interactions.Espera;
import com.choucair.ui.PaginaSeleccionarProducto;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class EscogerProductos implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(PaginaSeleccionarProducto.BTN_CELULAR),
                WaitUntil.the(PaginaSeleccionarProducto.DIRECCION, isClickable()).forNoMoreThan(5).seconds(),
                Click.on(PaginaSeleccionarProducto.DIRECCION),
                WaitUntil.the(PaginaSeleccionarProducto.BTN_CONTINUAR, isClickable()).forNoMoreThan(5).seconds(),
                Click.on(PaginaSeleccionarProducto.BTN_CONTINUAR),
                WaitUntil.the(PaginaSeleccionarProducto.AGREGAR_PRODUCTO, isClickable()).forNoMoreThan(120).seconds(),
                Click.on(PaginaSeleccionarProducto.AGREGAR_PRODUCTO),
                WaitUntil.the(PaginaSeleccionarProducto.BTN_CARRITO, isClickable()).forNoMoreThan(5).seconds(),
                Click.on(PaginaSeleccionarProducto.BTN_CARRITO),
                WaitUntil.the(PaginaSeleccionarProducto.PRODUCTO_AGREGADO, isClickable()).forNoMoreThan(5).seconds(),
                Espera.espera(5)
        );

    }

    public static EscogerProductos escogerProductos() {
        return new EscogerProductos();
    }
}
