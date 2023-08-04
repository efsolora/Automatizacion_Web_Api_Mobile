package com.choucair.task;

import com.choucair.interactions.Espera;
import com.choucair.ui.PaginaInicioSesion;
import com.choucair.ui.PaginaSeleccionarProducto;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.choucair.ui.PaginaInicioSesion.CERRAR_PUBLICIDAD;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class EscogerProductos implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(PaginaSeleccionarProducto.BTN_CELULAR),
                WaitUntil.the(PaginaSeleccionarProducto.DOMICILIO, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(PaginaSeleccionarProducto.DOMICILIO),
                WaitUntil.the(PaginaSeleccionarProducto.BTN_CONTINUAR, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(PaginaSeleccionarProducto.BTN_CONTINUAR),
                WaitUntil.the(PaginaSeleccionarProducto.AGREGAR_PRODUCTO, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(PaginaSeleccionarProducto.AGREGAR_PRODUCTO),
                WaitUntil.the(PaginaSeleccionarProducto.BTN_CARRITO, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(PaginaSeleccionarProducto.BTN_CARRITO),
                WaitUntil.the(PaginaSeleccionarProducto.PRODUCTO_AGREGADO, isVisible()).forNoMoreThan(10).seconds()
        );

    }

    public static EscogerProductos escogerProductos() {
        return new EscogerProductos();
    }
}
