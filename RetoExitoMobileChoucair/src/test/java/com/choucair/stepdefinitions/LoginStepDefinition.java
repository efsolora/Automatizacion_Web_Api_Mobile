package com.choucair.stepdefinitions;

import com.choucair.setup.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;
import java.util.List;

import static com.choucair.question.ValidarInicioSesion.validarInicioSesion;
import static com.choucair.task.IniciarSesion.iniciarSesion;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.containsString;

public class LoginStepDefinition extends AndroidDriver {

    private static final Logger LOGGER = Logger.getLogger(LoginStepDefinition.class);

    public LoginStepDefinition() throws IOException {
    }

    @Given("que accedo a la aplicacion exito")
    public void queAccedoALaAplicacionSwaglabs() {
        try {
            configurarMobile();
            LOGGER.info("Inicia la automatizacion");
        } catch (Exception e) {
            LOGGER.info("Fallo la configuracion");
            LOGGER.warn(e.getMessage());
            Assertions.fail();
            quitarDriver();
        }
    }
    @When("Ingreso los datos de usuario y contraseña")
    public void ingresoLosDatosDeUsuarioYContrasena()  {
        try {
            actor.attemptsTo(
                    iniciarSesion()
            );
            LOGGER.info("Se inicia sesion");
        } catch (Exception e) {
            LOGGER.info("Fallo el entrar en la opcion");
            LOGGER.warn(e.getMessage());
            Assertions.fail();
            quitarDriver();
        }
    }

    @Then("el inicio de sesion se deberia realizar correctamente")
    public void elInicioDeSesionSeDeberiaRealizarCorrectamente() {
        try {
            actor.should(
                    seeThat(validarInicioSesion(), containsString("Hola"))
            );
            LOGGER.info("Hace la comparacion");
        } catch (Exception e) {
            LOGGER.info("Fallo la comparacion");
            LOGGER.warn(e.getMessage());
            Assertions.fail();
            quitarDriver();
        }
    }
}
