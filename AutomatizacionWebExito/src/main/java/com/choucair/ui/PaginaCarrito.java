package com.choucair.ui;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class PaginaCarrito extends PageObject {
    public static final Target TOTAL_PRODUCTOS = Target.the("total de productos")
            .located(By.xpath("//div[@class='exito-checkout-io-0-x-totalItemsSeller']"));

    public static final Target VALOR_TOTAL = Target.the("valor total del precio")
            .located(By.xpath("(//span[@data-molecule-summary-item-value='true'])[3]"));

    public static final Target CAMPO_CORREO=Target.
            the("Campo del correo electronico")
            .located(By.xpath("//input[@placeholder='correo@email.com']"));

    public static final Target CONFIRMAR_CORREO=Target.
            the("")
            .located(By.xpath("//button[normalize-space()='Confirmar']"));

    public static Target nombreProductoCarrito(int posicion){
        posicion+=1;
        Target nombreCarrito = Target.the("nombre de los productos")
                .located(By.xpath("(//span[@data-molecule-product-detail-name-span='true'])["+ posicion +"]"));
        return nombreCarrito;
    }
    public static Target cantidadCarrito(int posicion) {
        posicion += 1;
        Target cantidadCarrito = Target.the("cantidad de productos")
                .located(By.xpath("(//span[@data-molecule-quantity-und-value='true'])[" + posicion + "]"));
        return cantidadCarrito;
    }

}
