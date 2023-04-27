package com.choucair.task;

import com.choucair.interactions.Espera;
import com.choucair.ui.PaginaInicioSesion;
import com.choucair.ui.PaginaSeleccionarProducto;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.choucair.ui.PaginaInicial.BTN_INGRESAR;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

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
                Click.on(BTN_INGRESAR),
                Enter.theValue(usuario).into(PaginaInicioSesion.CORREO),
                Enter.theValue(contrasenna).into(PaginaInicioSesion.CONTRASENA),
                WaitUntil.the(PaginaInicioSesion.BTN_INGRESAR, isClickable()).forNoMoreThan(5).seconds(),
                Click.on(PaginaInicioSesion.BTN_INGRESAR),
                Click.on(PaginaSeleccionarProducto.PERMISOS_UBICACION),
                Espera.espera(5)

        );
    }
    public static IniciarSesion iniciarSesion () {

        return new IniciarSesion();
    }
}

