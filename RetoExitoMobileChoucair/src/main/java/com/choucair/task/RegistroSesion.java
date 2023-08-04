package com.choucair.task;


import com.choucair.interactions.Coordenadas;
import com.choucair.util.Datos;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import java.io.IOException;

import static com.choucair.ui.PaginaInicial.BTN_REGISTRARSE;
import static com.choucair.ui.PaginaRegistro.*;
import static org.apache.fontbox.afm.AFMParser.CC;

public class RegistroSesion implements Task {
    Datos datos = new Datos();
    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            actor.attemptsTo(
                    Click.on(BTN_REGISTRARSE),
                    Enter.theValue(datos.leerDatosExcel("Datos.xlsx","Registro",2,2)).into(NOMBRES),
                    Enter.theValue(datos.leerDatosExcel("Datos.xlsx","Registro",3,2)).into(APELLIDOS),
                    Enter.theValue(datos.leerDatosExcel("Datos.xlsx","Registro",4,2)).into(DOCUMENTO),
                    Click.on(ANIO),
                    Coordenadas.coordenadas(88, 1646),
                    Click.on(MES),
                    Coordenadas.coordenadas(488, 1646),
                    Click.on(DIA),
                    Coordenadas.coordenadas(888, 1646),
                    Enter.theValue(datos.leerDatosExcel("Datos.xlsx","Registro",5,2)).into(CELULAR),
                    Enter.theValue(datos.leerDatosExcel("Datos.xlsx","Registro",6,2)).into(CORREO_REGISTRO),
                    Coordenadas.coordenadas(88, 1574),
                    Coordenadas.coordenadas(88, 1646),
                    Click.on(BTN_CONFIRMAR)

            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static RegistroSesion registroSesion() {
        return new RegistroSesion();
    }

}
