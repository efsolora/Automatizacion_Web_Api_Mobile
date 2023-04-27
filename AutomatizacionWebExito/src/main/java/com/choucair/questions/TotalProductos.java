package com.choucair.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.choucair.ui.PaginaCarrito.*;

public class TotalProductos implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {

        return TOTAL_PRODUCTOS.resolveFor(actor).getText().trim().substring(0,1);
    }
    public static TotalProductos totalProductos(){

        return new TotalProductos();
    }
}
