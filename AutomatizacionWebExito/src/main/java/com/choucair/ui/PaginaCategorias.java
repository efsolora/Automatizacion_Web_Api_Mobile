package com.choucair.ui;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class PaginaCategorias extends PageObject {

    public static final Target MENU = Target.the("Seleccionar el menu")
            .located(By.xpath("(//div[@id='category-menu'])[1]"));
    public static final Target CATEGORIA = Target.the("Seleccionar la categoria")
            .located(By.xpath("(//p[@id='undefined-nivel2-Dormitorio'])[1]"));
    public static final Target CABECEROS = Target.the("cubiertos")
            .located(By.xpath("//p[contains(text(),'Confort vital')]"));

}
