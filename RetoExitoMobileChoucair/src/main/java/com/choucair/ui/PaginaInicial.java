package com.choucair.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PaginaInicial {
    public static final Target BTN_REGISTRARSE = Target.the("boton para registrarse")
            .located(By.id("com.exito.appcompania:id/AppCompatButton_registrarse"));

    public static final Target BTN_INGRESAR = Target.the("boton para ingresar")
            .located(By.id("com.exito.appcompania:id/AppCompatButton_ingresar"));

}
