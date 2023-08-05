package com.choucair.stepdefinitions;

import com.choucair.setup.Configuracion;
import com.choucair.tasks.AbrirPaginaInicial;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

import static com.choucair.questions.CantidadProducto.cantidadProducto;
import static com.choucair.questions.NombreProducto.nombreProducto;
import static com.choucair.questions.TotalPrecioProductos.totalPrecioProductos;
import static com.choucair.questions.TotalProductos.totalProductos;
import static com.choucair.tasks.AgregarProductosAleatorios.agregarProductosAleatorios;
import static com.choucair.tasks.EscogerCategoria.escogerCategoria;
import static com.choucair.tasks.IralCarrito.iralCarrito;
import static com.choucair.ui.PaginaProductos.*;
import static com.google.common.base.Predicates.equalTo;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class AnadirProductosStepDefinitions extends Configuracion {
    public static Logger LOGGER = Logger.getLogger(AnadirProductosStepDefinitions.class);

    public AnadirProductosStepDefinitions() {
    }

    @Given("Given que estoy en la pagina de exito")
    public void givenQueEstoyEnLaPaginaDeExito() {
        try {
            configurarNavegador();
            LOGGER.info("Inicio de la Automatizacion");
            theActorInTheSpotlight().wasAbleTo(
                    new AbrirPaginaInicial()
            );
        } catch (Exception e) {
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
        int suma = 0, cantidad = 1;
        try {
            for (int i = 0; i<nombreDelProducto.size(); i++){
                // Aserción para verificar el nombre del producto
                LOGGER.info("Nombre del producto antes" + i + ": " + nombreProducto().withThePosition(i).answeredBy(theActorInTheSpotlight()));
                LOGGER.info("Nombre del producto despues" + i + ": " + nombreDelProducto.get(i));
                // Aserción para verificar la cantidad del producto
                LOGGER.info("Cantidad del producto antes" + i + ": " + cantidadProducto().withThePosition(i).answeredBy(theActorInTheSpotlight()));
                LOGGER.info("Cantidad del producto despues " + i + ": " + cantidadDelProducto.get(i));

                suma= (Integer.parseInt(precioDelProducto.get(i)) * Integer.parseInt(cantidadDelProducto.get(i))) + suma;

                // Aserción para verificar el total del precio de los productos
                LOGGER.info("total antes: " + suma);
                LOGGER.info("Total despues: " + totalPrecioProductos().answeredBy(theActorInTheSpotlight()));
                // Aserción para verificar el contador de selecciones
                LOGGER.info("productos seleccionados antes: " + seleccionCount);
                LOGGER.info("productos seleccionados despues: " + totalProductos().answeredBy(theActorInTheSpotlight()));
                cantidad+= Integer.parseInt(String.valueOf(seleccionCount));
                theActorInTheSpotlight().should(
                        seeThat(nombreProducto().withThePosition(i), equalTo(nombreDelProducto.get(i))),
                        seeThat(cantidadProducto().withThePosition(i), equalTo(cantidadDelProducto.get(i)))
                        );
            }
            theActorInTheSpotlight().should(
                    //seeThat(totalPrecioProductos(),equalTo(suma+"")),
                    //seeThat(totalProductos(),equalTo(cantidad+""))
            );
        }catch (Exception e){
            LOGGER.warn(e.getMessage());
            Assertions.fail();
            quitarDriver();
        }
    }
}




