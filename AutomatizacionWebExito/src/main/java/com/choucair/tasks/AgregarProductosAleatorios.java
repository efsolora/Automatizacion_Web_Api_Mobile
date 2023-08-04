package com.choucair.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.targets.Target;

import java.util.Random;

import com.choucair.interactions.Espera;

import static com.choucair.ui.PaginaProductos.*;

public class AgregarProductosAleatorios implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        for (int i = 0; i < 1; i++) {
            actor.attemptsTo(
                    Espera.espera(5)
            );
            Target target = productoAleatorio(actor);
            actor.attemptsTo(
                    Scroll.to(target),
                    JavaScriptClick.on(target),
                    JavaScriptClick.on(AGREGAR)
            );
            Random random = new Random();
            int cantidadAleatorio = random.nextInt(2) + 1;
            for (int j = 0; j < cantidadAleatorio; j++) {
                actor.attemptsTo(
                        JavaScriptClick.on(CANTIDAD)
                );
            }
            cantidadDelProducto.add(CANTIDAD_PRODUCTO.resolveFor(actor).getText().trim().substring(0, 1));
            actor.attemptsTo(
                    Click.on(CONTINUAR_COMPRANDO)
            );
        }
    }

    public static AgregarProductosAleatorios agregarProductosAleatorios() {
        return new AgregarProductosAleatorios();
    }

}
