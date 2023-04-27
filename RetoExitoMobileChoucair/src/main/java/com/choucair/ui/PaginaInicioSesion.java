package com.choucair.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PaginaInicioSesion {

    public static final Target CORREO = Target.the("correo del usuario")
            .located(By.id("com.exito.appcompania:id/TextInputEditText_email"));

    public static final Target CONTRASENA = Target.the("contraseña del usuario")
            .located(By.xpath("//android.widget.LinearLayout[@resource-id='com.exito.appcompania:id/CustomEditText_password']//android.widget.EditText"));

    public static final Target BTN_INGRESAR = Target.the("boton de ingresar")
            .located(By.id("com.exito.appcompania:id/AppCompatButton_ingresar"));

    public static final Target MENSAJE_HOLA = Target.the("mensaje confirmacion de inicio de sesion")
            .located(By.id("com.exito.appcompania:id/textView_hello"));




}
