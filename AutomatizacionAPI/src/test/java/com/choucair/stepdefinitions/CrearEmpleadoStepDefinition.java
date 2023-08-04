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
import static com.choucair.tasks.DoPost.doPost;
import static com.choucair.utils.UrlResources.BASE_API_URL;
import static com.choucair.utils.UrlResources.POST_API_URL;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class CrearEmpleadoStepDefinition extends ApiSetUp {

    User empleado = new User();

    private final Logger LOGGER = Logger.getLogger(CrearEmpleadoStepDefinition.class);

    @Given("estoy en la pagina de creacion API dummy restapiexample")
    public void estoyEnLaPaginaDeCreacionAPIDummyRestapiexample() {
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

    @When("creo un nuevo empleado con nombre {string}, salario {int} y edad {int}")
    public void creoUnNuevoEmpleadoConNombreSalarioYEdad(String nombre, Integer salario, Integer edad) {
        try {
            empleado.setNombre(nombre);
            empleado.setSalario(salario);
            empleado.setEdad(edad);
            actor.attemptsTo(
                    doPost().withTheResource(POST_API_URL.getValue())
                            .andTheRequestBody(empleado)
            );
            LOGGER.info("Response code: " + SerenityRest.lastResponse().getStatusCode());
            LOGGER.info("Response body: " + SerenityRest.lastResponse().asString());
        } catch (Exception e) {
            LOGGER.error("Error creando empleado: " + e.getMessage());
            Assertions.fail();
        }
    }

    @Then("la respuesta debee tener codigo {int}")
    public void laRespuestaDebeTenerCodigoYElNombreDelEmpleadoCreadoDebeSer(Integer codigo) {
        try {
            actor.should(
                    seeThatResponse("El codigo de respuesta es: " + codigo,
                            response -> response.statusCode(codigo))
            );
        } catch (Exception e) {
            LOGGER.error("Error verificando la creacion del empleado: " + e.getMessage());
            Assertions.fail();
        }
    }
    @Then("se debe observar un mensaje de confirmacion y que el salario coincida")
    public void seDebeObservarUnMensajeDeConfirmacionYQueElSalarioCoincida() {
        try {
            Gson gson = new Gson();
            JsonObject element = gson.fromJson(SerenityRest.lastResponse().getBody().asString(), JsonObject.class);
            Integer salario = element.getAsJsonObject("data").get("salario").getAsInt();
            actor.attemptsTo(
                    Ensure.that(salario).isEqualTo(500)
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

