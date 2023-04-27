package com.choucair.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static com.choucair.ui.PaginaInicioSesion.*;

public class IniciarSesion implements Task {

    private String usuario;
    private String contrasenna;

    public IniciarSesion conElUsuario(String usuario){
        this.usuario=usuario;
        return this;
    }

    public IniciarSesion yConLaContrasenna(String contrasenna){
        this.contrasenna=contrasenna;
        return this;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BOTON_INGRESA_CON_EMAIL_Y_CLAVE),
                Click.on(CAMPO_EMAIL),
                Enter.theValue(usuario).into(CAMPO_EMAIL),
                Click.on(CAMPO_CLAVE),
                Enter.theValue(contrasenna).into(CAMPO_CLAVE),
                Click.on(BOTON_INICIAR_SESION)
        );
    }
    public static IniciarSesion iniciarSesion(){
        return new IniciarSesion();
    }


}
