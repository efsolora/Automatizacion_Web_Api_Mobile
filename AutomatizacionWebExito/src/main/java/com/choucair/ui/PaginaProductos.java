package com.choucair.ui;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

import java.util.*;


public class PaginaProductos extends PageObject {

    public static ArrayList<Integer> productos = new ArrayList<>();
    public static ArrayList<String> nombreDelProducto = new ArrayList<>();
    public static ArrayList<String> precioDelProducto = new ArrayList<>();
    public static ArrayList<String> cantidadDelProducto = new ArrayList<>();
    public static int seleccionCount = 0;

    public static final Target CARRITO = Target.the("Boton carrito de compra")
            .located(By.xpath("//a[@class='exito-header-3-x-minicartLink']"));
    public static final Target AGREGAR = Target.the("Boton carrito de compra")
            .located(By.xpath("(//span[@class='exito-vtex-components-4-x-buttonText'])"));
    public static final Target CONTINUAR_COMPRANDO = Target.the("Boton carrito de compra")
            .located(By.xpath("(//p[@class='exito-vtex-components-4-x-continue'])"));
    public static final Target CANTIDAD = Target.the("Boton carrito de compra")
            .located(By.xpath("(//span[@class='product-details-exito-vtex-components-buy-button-manager-more'])"));
    public static final Target CANTIDAD_PRODUCTO = Target.the("numero del producto")
            .located(By.xpath("(//div[@class='exito-vtex-components-4-x-stepperContainerQty'])"));

    public static Target productoAleatorio(Actor actor) {
        Random random = new Random();
        int numeroAleatorio = random.nextInt(10) + 1;
        while (productos.contains(numeroAleatorio)) {
            numeroAleatorio = random.nextInt(10) + 1;
        }

        Target target = Target.the("productoAleatorio")
                .located(By.xpath("(//span[contains(text(), 'Compra r')])[" + numeroAleatorio + "]"));

        Target nombre = Target.the("nombreProducto")
                .located(By.xpath("(//span[@class='vtex-store-components-3-x-productBrand '])[" + numeroAleatorio + "]"));

        Target precio = Target.the("precioProducto")
                .located(By.xpath("(//div[@class='exito-vtex-components-4-x-PricePDP'])[" + numeroAleatorio + "]"));

        nombreDelProducto.add(nombre.resolveFor(actor).getText());

        precioDelProducto.add(precio.resolveFor(actor).getText().substring(2).replace(".", ""));

        productos.add(numeroAleatorio);

        // Incrementar contador de selecciones
        seleccionCount++;

        return target;

    }
}