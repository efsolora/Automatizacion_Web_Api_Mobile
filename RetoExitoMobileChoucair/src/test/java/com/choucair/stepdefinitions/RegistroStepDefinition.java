package com.choucair.stepdefinitions;

import com.choucair.setup.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

import static com.choucair.question.ValidarRegistro.validarRegistro;
import static com.choucair.task.RegistroSesion.registroSesion;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.containsString;

public class RegistroStepDefinition extends AndroidDriver {

    private static final Logger LOGGER = Logger.getLogger(RegistroStepDefinition.class);

    @Given("que inicio en la aplicacion del exito")
    public void queInicioEnLaAplicacionDelExito() {
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

    @When("voy a la opcion de registro y registro mis datos")
    public void voyALaOpcionDeRegistro() {
        try {
            actor.attemptsTo(
                    registroSesion()
            );
            LOGGER.info("Se inicia el registro");
        } catch (Exception e) {
            LOGGER.info("Fallo al entrar a la opcion y realizar el registro");
            LOGGER.warn(e.getMessage());
            Assertions.fail();
            quitarDriver();
        }
    }

    @Then("deberia ver un mensaje de registro exitoso")
    public void deberiaVerUnMensajeDeRegistroExitoso() {
        try {
            actor.should(
                    seeThat(validarRegistro(), containsString("Código de confirmación"))
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


