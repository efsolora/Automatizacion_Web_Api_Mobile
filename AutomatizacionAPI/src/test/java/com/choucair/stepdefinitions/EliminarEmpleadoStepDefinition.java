package com.choucair.stepdefinitions;

import com.choucair.setup.ApiSetUp;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import net.serenitybdd.screenplay.ensure.Ensure;
import static com.choucair.tasks.DoDelete.doDelete;
import static com.choucair.utils.UrlResources.BASE_API_URL;
import static com.choucair.utils.UrlResources.DELETE_API_URL;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class EliminarEmpleadoStepDefinition extends ApiSetUp {

    private final Logger LOGGER = Logger.getLogger(EliminarEmpleadoStepDefinition.class);

    @Given("estoy en la pagina de la API dummy restapiexample")
    public void estoyEnLaPaginaDeLaAPIDummyRestapiexample() {
        try {
            setUp(BASE_API_URL.getValue());
            LOGGER.info("INICIA LA AUTOMATIZACION");
        } catch (Exception e) {
            LOGGER.info("Fallo la configuracion inicial");
            LOGGER.error(e.getMessage());
            Assertions.fail();
        }
    }

    @When("elimino el empleado con ID {int}")
    public void eliminoElEmpleadoConID(Integer id) {
        try {
            actor.attemptsTo(
                    doDelete().withTheResource(DELETE_API_URL.getValue()).withTheId(id + "")
            );
            LOGGER.info("Response code: " + SerenityRest.lastResponse().getStatusCode());
            LOGGER.info("Response body: " + SerenityRest.lastResponse().asString());
        } catch (Exception e) {
            LOGGER.error("Error eliminando el empleado: " + e.getMessage());
            Assertions.fail();
        }
    }

    @Then("la respuesta debe tener codigo {int}")
    public void laRespuestaDebeTenerCodigo(Integer codigo) {
        try {
            actor.should(
                    seeThatResponse("El codigo de respuesta es: " + codigo,
                            response -> response.statusCode(codigo))
            );
        } catch (Exception e) {
            LOGGER.error("Error al eliminar el empleado: " + e.getMessage());
        }
    }

    @Then("mostrar un mensaje de borrado exitoso")
    public void mostrarUnMensajeDeBorradoExitoso() {
        try {
            Gson gson = new Gson();
            JsonObject element = gson.fromJson(SerenityRest.lastResponse().getBody().asString(), JsonObject.class);

            actor.attemptsTo(
                    Ensure.that(element.get("message").getAsString()).isEqualTo("Successfully! Record has been deleted")
            );

        } catch (Exception e) {
            LOGGER.error("Error validating response: " + e.getMessage());
        }
    }
}


