package com.choucair.stepdefinitions;

import com.choucair.setup.Configuracion;
import com.choucair.tasks.AbrirPaginaInicial;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import java.io.IOException;
import java.util.List;

import static com.choucair.questions.CantidadProducto.cantidadProducto;
import static com.choucair.questions.NombreProducto.nombreProducto;
import static com.choucair.questions.TotalPrecioProductos.totalPrecioProductos;
import static com.choucair.questions.TotalProductos.totalProductos;
import static com.choucair.tasks.AgregarProductosAleatorios.agregarProductosAleatorios;
import static com.choucair.tasks.EscogerCategoria.escogerCategoria;
import static com.choucair.tasks.IniciarSesion.iniciarSesion;
import static com.choucair.tasks.IralCarrito.iralCarrito;
import static com.choucair.tasks.NavegarAMiCuenta.navegarAMiCuenta;
import static com.choucair.ui.PaginaProductos.*;
import static com.choucair.util.LoadCredentials.getCredentials;
import static com.google.common.base.Predicates.equalTo;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class AnadirProductosStepDefinitions extends Configuracion {
    private final List<String> credentials = getCredentials();
    public static Logger LOGGER = Logger.getLogger(AnadirProductosStepDefinitions.class);

    public AnadirProductosStepDefinitions() throws IOException {
    }

    @Given("Given que estoy en la pagina de exito")
    public void givenQueEstoyEnLaPaginaDeExito() {
        try {
            configurarNavegador();
            LOGGER.info("Inicio de la Automatizacion");
            theActorInTheSpotlight().wasAbleTo(
                    new AbrirPaginaInicial(),
                    navegarAMiCuenta()
            );
        } catch (Exception e) {
            LOGGER.warn(e.getMessage());
            Assertions.fail();
            quitarDriver();
        }
    }

    @When("he iniciado sesion con mis credenciales")
    public void heIniciadoSesionConMisCredenciales() {
        try {
            theActorInTheSpotlight().attemptsTo(
                    iniciarSesion()
                            .conElUsuario(credentials.get(0))
                            .yConLaContrasenna(credentials.get(1))
            );
        }catch (Exception e){
            LOGGER.warn(e.getMessage());
            Assertions.fail();
            quitarDriver();
        }
    }

    @When("he agregado los productos al carrito")
    public void heAgregadoLosProductosAlCarrito() {

        try {
            theActorInTheSpotlight().attemptsTo(
                    escogerCategoria(),
                    agregarProductosAleatorios(),
                    iralCarrito()
            );
        } catch (Exception e) {
            LOGGER.warn(e.getMessage());
            Assertions.fail();
            quitarDriver();
        }
    }

    @Then("se deberian ver los productos en el carrito coinciden con los productos agregados")
    public void seDeberianVerLosProductosEnElCarritoCoincidenConLosProductosAgregados() {
        int suma = 0, cantidad = 0;
        try {
            for (int i = 0; i<nombreDelProducto.size(); i++){
                suma = Integer.parseInt(precioDelProducto.get(i).substring(2).replace(".",""))*Integer.parseInt(cantidadDelProducto.get(i))+suma;
                cantidad += Integer.parseInt(cantidadDelProducto.get(i));
                theActorInTheSpotlight().should(
                        seeThat(nombreProducto().withThePosition(i+1), equalTo(nombreDelProducto.get(i))),
                        seeThat(cantidadProducto().withThePosition(i+1), equalTo(cantidadDelProducto.get(i)))
                        );
            }
            theActorInTheSpotlight().should(
                    seeThat(totalPrecioProductos(),equalTo(suma+"")),
                    seeThat(totalProductos(),equalTo(cantidad+""))
            );


        }catch (Exception e){
            LOGGER.warn(e.getMessage());
            Assertions.fail();
            quitarDriver();

        }

    }
}




