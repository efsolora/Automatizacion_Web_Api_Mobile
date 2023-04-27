package com.choucair.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.choucair.ui.PaginaCarrito.nombreProductoCarrito;

public class NombreProducto implements Question<String> {
    private int nombre;

    @Override
    public String answeredBy(Actor actor) {

        return nombreProductoCarrito(nombre).resolveFor(actor).getText().trim();
    }

    public NombreProducto withThePosition(int nombre){
        this.nombre = nombre;
        return this;
    }

    public static NombreProducto nombreProducto(){

        return new NombreProducto();
    }
}
