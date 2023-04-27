package com.choucair.question;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.Actor;

import static com.choucair.ui.PaginaInicioSesion.MENSAJE_HOLA;

public class ValidarInicioSesion implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        return MENSAJE_HOLA.resolveFor(actor).getText();
    }

    public static ValidarInicioSesion validarInicioSesion() {
        return new ValidarInicioSesion();
    }
}

