package com.choucair.ui;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PaginaRegistro {

    public static final Target NOMBRES = Target.the("nombre del usuario")
            .located(By.xpath("//android.widget.LinearLayout[@resource-id='com.exito.appcompania:id/CustomEditText_nombres']//android.widget.EditText"));

    public static final Target APELLIDOS = Target.the("apellido del usuario")
            .located(By.xpath("//android.widget.LinearLayout[@resource-id='com.exito.appcompania:id/CustomEditText_apellidos']//android.widget.EditText"));

    public static final Target TIPO_DOCUMENTO = Target.the("tipo de documento")
            .located(By.id("com.exito.appcompania:id/filled_exposed_dropdown"));

    public static final Target DOCUMENTO = Target.the("numero de documento")
            .located(By.xpath("//android.widget.LinearLayout[@resource-id='com.exito.appcompania:id/CustomEditText_numero_doc']//android.widget.EditText"));

    public static final Target ANIO = Target.the("año de nacimiento")
            .located(By.id("com.exito.appcompania:id/filled_exposed_dropdown_anio_registro"));

    public static final Target MES = Target.the("mes de nacimiento")
            .located(By.id("com.exito.appcompania:id/filled_exposed_dropdown_mes_registro"));

    public static final Target DIA = Target.the("dia de nacimiento")
            .located(By.id("com.exito.appcompania:id/filled_exposed_dropdown_dia_registro"));

    public static final Target CELULAR = Target.the("numero de celular")
            .located(By.id("com.exito.appcompania:id/TextInputEditText_tel"));

    public static final Target CORREO_REGISTRO = Target.the("correo a registrar")
            .located(By.xpath("//android.widget.LinearLayout[@resource-id='com.exito.appcompania:id/CustomEditText_email_register']//android.widget.EditText"));

    public static final Target BTN_CONFIRMAR = Target.the("boton de confirmar registro")
            .located(By.id("com.exito.appcompania:id/AppCompatButton_registrar"));
    public static final Target MENSAJE_REGISTRO = Target.the("Confirmacion del registro")
            .located(By.id("com.exito.appcompania:id/AppCompatTextView_bienvenido"));

}

