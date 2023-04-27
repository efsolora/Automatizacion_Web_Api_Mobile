package com.choucair.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static com.choucair.ui.PaginaInicial.BOTON_MI_CUENTA;

public class NavegarAMiCuenta implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BOTON_MI_CUENTA)
        );
    }
    public static NavegarAMiCuenta navegarAMiCuenta(){
        return new NavegarAMiCuenta();
    }
}
