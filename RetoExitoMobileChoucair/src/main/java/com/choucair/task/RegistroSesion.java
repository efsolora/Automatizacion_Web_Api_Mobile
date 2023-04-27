package com.choucair.task;


import com.choucair.interactions.Coordenadas;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static com.choucair.ui.PaginaInicial.BTN_REGISTRARSE;
import static com.choucair.ui.PaginaRegistro.*;

public class RegistroSesion implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BTN_REGISTRARSE),
                Enter.theValue("James").into(NOMBRES),
                Enter.theValue("Munoz").into(APELLIDOS),
                Enter.theValue("C.C").into(TIPO_DOCUMENTO),
                Enter.theValue("123456789").into(DOCUMENTO),
                Click.on(ANIO),
                Coordenadas.coordenadas(88, 1646),
                Click.on(MES),
                Coordenadas.coordenadas(488, 1646),
                Click.on(DIA),
                Coordenadas.coordenadas(888, 1646),
                Enter.theValue("3507615418").into(CELULAR),
                Enter.theValue("arley@gmail.com").into(CORREO_REGISTRO),
                Coordenadas.coordenadas(88, 1574),
                Coordenadas.coordenadas(88, 1646),
                Click.on(BTN_CONFIRMAR)

        );
    }
    public static RegistroSesion registroSesion() {
        return new RegistroSesion();
    }

}
