package com.choucair.ui;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class PaginaInicioSesion extends PageObject {

    public static final Target BOTON_INGRESA_CON_EMAIL_Y_CLAVE = Target.the("Boton iniciar con email y clave")
            .located(By.cssSelector("div[class='vtex-login-2-x-button vtex-login-2-x-emailPasswordOptionBtn'] span"));

    public static final Target CAMPO_EMAIL = Target.the("campo email")
            .located(By.cssSelector("input[placeholder='Ingresa tu email']"));

    public static final Target CAMPO_CLAVE = Target.the("campo clave")
            .located(By.xpath("//input[@type='password']"));

    public static final Target BOTON_INICIAR_SESION = Target.the("Botón iniciar sesion")
            .located(By.cssSelector("button[type='submit'] div[class='vtex-button__label flex items-center justify-center h-100 ph5 ']"));
}
