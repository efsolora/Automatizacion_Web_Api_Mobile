package com.choucair.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.choucair.ui.PaginaCarrito.cantidadCarrito;

public class CantidadProducto implements Question<String> {
    private int cantidad;

    @Override
    public String answeredBy(Actor actor) {

        return cantidadCarrito(cantidad).resolveFor(actor).getAttribute("value");
    }

    public CantidadProducto withThePosition(int cantidad){
        this.cantidad = cantidad;
        return this;
    }
    public static CantidadProducto cantidadProducto(){

        return new CantidadProducto();
    }
}
