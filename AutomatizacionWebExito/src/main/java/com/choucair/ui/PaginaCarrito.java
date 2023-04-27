package com.choucair.ui;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class PaginaCarrito extends PageObject {
    public static final Target TOTAL_PRODUCTOS = Target.the("total de productos")
            .located(By.xpath("(//div[@class='totalItems'])"));

    public static final Target VALOR_TOTAL = Target.the("valor total del precio")
            .located(By.xpath("(//td[@class='monetary exito-checkout-monetary'])"));

    public static Target nombreProductoCarrito(int posicion){
        Target nombreCarrito = Target.the("nombre de los productos")
                .located(By.xpath("(//a[@class='exito-checkout-product-name'])["+ posicion +"]"));
        return nombreCarrito;
    }
    public static Target cantidadCarrito (int posicion) {
        Target cantidadCarrito = Target.the("cantidad de productos")
                .located(By.xpath("(//input[@class='exito-checkout-quantity'])[" + posicion + "]"));
        return cantidadCarrito;
    }

}
