package com.choucair.task;

import com.choucair.interactions.Espera;
import com.choucair.ui.PaginaInicioSesion;
import com.choucair.ui.PaginaSeleccionarProducto;
import com.choucair.util.Datos;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.io.IOException;

import static com.choucair.ui.PaginaInicial.BTN_INGRESAR;
import static com.choucair.ui.PaginaInicioSesion.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class IniciarSesion implements Task {
    Datos datos = new Datos();
    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
            actor.attemptsTo(
                    Click.on(BTN_INGRESAR),
                    Enter.theValue(datos.leerDatosExcel("Datos.xlsx","Login",2,1)).into(CORREO),
                    Enter.theValue(datos.leerDatosExcel("Datos.xlsx","Login",2,2)).into(CONTRASENA),
                    WaitUntil.the(PaginaInicioSesion.BTN_INGRESAR, isClickable()).forNoMoreThan(5).seconds(),
                    Click.on(PaginaInicioSesion.BTN_INGRESAR),
                    Click.on(PaginaSeleccionarProducto.PERMISOS_UBICACION),
                    Espera.espera(5),
                    Click.on(CERRAR_PUBLICIDAD)

            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static IniciarSesion iniciarSesion () {

        return new IniciarSesion();
    }
}

