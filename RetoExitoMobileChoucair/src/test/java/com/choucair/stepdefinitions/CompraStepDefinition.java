package com.choucair.stepdefinitions;

import com.choucair.setup.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;
import java.util.List;

import static com.choucair.question.ValidarProductos.validarProductos;
import static com.choucair.task.EscogerProductos.escogerProductos;
import static com.choucair.task.IniciarSesion.iniciarSesion;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.containsString;

public class CompraStepDefinition extends AndroidDriver {
    private static final Logger LOGGER = Logger.getLogger(CompraStepDefinition.class);

    public CompraStepDefinition() throws IOException {
    }

    @Given("que inicio en la aplicacion app exito")
    public void queInicioEnLaAplicacionExito() {
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

    @When("inicio sesion en la app con credenciales validas")
    public void inicioSesionEnLaAppConCredencialesValidas() {
        try {
            actor.attemptsTo(
                    iniciarSesion()
            );
            LOGGER.info("Se inicia sesion");
        } catch (Exception e) {
            LOGGER.info("Fallo al iniciar la sesion");
            LOGGER.warn(e.getMessage());
            Assertions.fail();
            quitarDriver();
        }
    }
    @When("Agrego un producto al carrito")
    public void agregoUnProductoAlCarrito() {
        try {
            actor.attemptsTo(
                    escogerProductos()
            );
            LOGGER.info("Se realiza la eleccion del producto");
        } catch (Exception e) {
            LOGGER.info("Fallo la eleccion del producto");
            LOGGER.warn(e.getMessage());
            Assertions.fail();
            quitarDriver();
        }
    }

    @Then("deberia ver que el producto se añade correctamente")
    public void deberiaVerQueElProductoSeAnadeCorrectamente() {
        try {
            actor.should(
                    seeThat(validarProductos(), containsString("Celular Xiaomi Redmi Note 12 4G 128Gb / 4Ram / 50Mp Azul"))
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

