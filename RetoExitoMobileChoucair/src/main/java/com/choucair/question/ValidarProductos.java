package com.choucair.question;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.choucair.ui.PaginaInicioSesion.MENSAJE_HOLA;
import static com.choucair.ui.PaginaSeleccionarProducto.PRODUCTO_AGREGADO;

public class ValidarProductos implements Question<String>  {

    @Override
    public String answeredBy(Actor actor) {
        return PRODUCTO_AGREGADO.resolveFor(actor).getText();
    }

    public static ValidarProductos validarProductos(){
        return  new ValidarProductos();
    }
}
