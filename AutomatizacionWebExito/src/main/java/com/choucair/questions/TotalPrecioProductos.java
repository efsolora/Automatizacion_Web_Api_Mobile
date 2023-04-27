package com.choucair.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.choucair.ui.PaginaCarrito.VALOR_TOTAL;

public class TotalPrecioProductos implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {

        return VALOR_TOTAL.resolveFor(actor).getText().trim().substring(2).replace(".","");
    }

    public static TotalPrecioProductos totalPrecioProductos(){

        return new TotalPrecioProductos();
    }
}
