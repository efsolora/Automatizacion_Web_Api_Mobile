package com.choucair.stepdefinitions;

import com.choucair.interactions.Espera;
import com.choucair.setup.ApiSetUp;
import com.choucair.models.User;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

import static com.choucair.tasks.DoPut.doPut;
import static com.choucair.utils.UrlResources.*;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;



public class ActualizarInfoEmpleadoStepDefinition extends ApiSetUp {

    User empleado = new User();

    private final Logger LOGGER = Logger.getLogger(ActualizarInfoEmpleadoStepDefinition.class);

    @Given("estoy en la pagina de detalles de dummy.restapiexample.com")
    public void estoyEnLaPaginaDeDetallesDeDummyRestapiexampleCom() {
        try {
            Espera.espera(60).performAs(actor);
            setUp(BASE_API_URL.getValue());
            LOGGER.info("INICIA LA AUTOMATIZACION");
        } catch (Exception e) {
            LOGGER.info("Fallo la configuración inicial");
            LOGGER.error(e.getMessage());
            Assertions.fail();
        }
    }

    @When("actualizo informacion del empleado con ID {int} y el nuevo nombre {string}")
    public void actualizoInformacionDelEmpleadoConIDYElNuevoNombre(Integer id, String nuevoNombre) {
        try {
            empleado.setId(id);
            empleado.setNombre(nuevoNombre);
            actor.attemptsTo(
                    doPut().withTheResource(PUT_API_URL.getValue()).withTheId(id + "")
                            .andTheRequestBody(empleado)
            );
            LOGGER.info("Response code: " + SerenityRest.lastResponse().getStatusCode());
            LOGGER.info("Response body: " + SerenityRest.lastResponse().asString());
        } catch (Exception e) {
            LOGGER.error("Error actualizando informacion del empleado: " + e.getMessage());
            Assertions.fail();
        }
    }

    @Then("laa respuesta debe tener codigo {int}")
    public void laRespuestaDebeTenerCodigo(Integer codigo) {
        try {
            actor.should(
                    seeThatResponse("El codigo de respuesta es: " + codigo,
                            response -> response.statusCode(codigo))
            );
        } catch (Exception e) {
            LOGGER.error("Error verificando la actualización del empleado: " + e.getMessage());
            Assertions.fail();
        }
    }

    @Then("se observa mensaje de confirmacion exitosa y que el nombre coincida")
    public void seObservaMensajeDeConfirmacionExitosaYQueElNombreCoincida() {
        try {
            Gson gson = new Gson();
            JsonObject element = gson.fromJson(SerenityRest.lastResponse().getBody().asString(), JsonObject.class);
            String nombre = element.getAsJsonObject("data").get("nombre").getAsString();
            actor.attemptsTo(
                    Ensure.that(nombre).isEqualTo("James")
            );
            actor.attemptsTo(
                    Ensure.that(element.get("status").getAsString()).isEqualTo("success")
            );
        } catch (Exception e) {
            LOGGER.error("Error validating response: " + e.getMessage());
            Assertions.fail();
        }
    }
}

