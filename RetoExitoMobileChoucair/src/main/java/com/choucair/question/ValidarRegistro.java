package com.choucair.question;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.choucair.ui.PaginaRegistro.MENSAJE_REGISTRO;

public class ValidarRegistro implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return MENSAJE_REGISTRO.resolveFor(actor).getText();
    }

    public static ValidarRegistro validarRegistro(){
        return  new ValidarRegistro();
    }
}
