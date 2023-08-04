package com.choucair.stepdefinitions;

import com.choucair.interactions.Espera;
import com.choucair.setup.ApiSetUp;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

import static com.choucair.tasks.DoGet.doGet;
import static com.choucair.utils.UrlResources.BASE_API_URL;
import static com.choucair.utils.UrlResources.GET_API_URL;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class ObtenerInfoEmpleadoStepDefinition extends ApiSetUp {
    private final Logger LOGGER = Logger.getLogger(ObtenerInfoEmpleadoStepDefinition.class);

    @Given("estoy en la pagina de empleados de la API dummy restapiexample")
    public void estoyEnLaPaginaDeEmpleadosDeLaAPIDummyRestapiexample() {
        try {
            Espera.espera(60).performAs(actor);
            setUp(BASE_API_URL.getValue());
            LOGGER.info("INICIA LA AUTOMATIZACION");
        } catch (Exception e) {
            LOGGER.info("Fallo la configuracion inicial");
            LOGGER.error(e.getMessage());
            Assertions.fail();
        }
    }

    @When("obtengo informacion del empleado con ID {int}")
    public void obtengoInformacionDelEmpleadoConID(Integer id) {
        try {
            actor.attemptsTo(
                    doGet().withTheResource(GET_API_URL.getValue()).withTheId(id + "")
            );
            LOGGER.info("Response code: " + SerenityRest.lastResponse().getStatusCode());
            LOGGER.info("Response body: " + SerenityRest.lastResponse().asString());
        } catch (Exception e) {
            LOGGER.error("Error obteniendo informacion del empleado: " + e.getMessage());
            Assertions.fail();
        }
    }

    @Then("la respuesta debe ser un codigo {int}")
    public void laRespuestaDebeSerUnCodigo(Integer codigo) {
        try {
            actor.should(
                    seeThatResponse("El codigo de respuesta es: " + codigo,
                            response -> response.statusCode(codigo))
            );
        } catch (Exception e) {
            LOGGER.error("Error al obtener el codigo 200: " + e.getMessage());
        }
    }

    @Then("y de los datos consultados el ID debe coincidir")
    public void yDeLosDatosConsultadosElIDDebeCoincidir() {
        try {
            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(SerenityRest.lastResponse().getBody().asString(), JsonObject.class);
            Integer obtainedId = jsonObject.getAsJsonObject("data").get("id").getAsInt();
            actor.attemptsTo(
                    Ensure.that(obtainedId).isEqualTo(2)
            );
        } catch (Exception e) {
            LOGGER.error("Error verificando la obtencion de informacion del empleado: " + e.getMessage());
            Assertions.fail();
        }
    }

}


