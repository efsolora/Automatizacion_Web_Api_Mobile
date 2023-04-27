package com.choucair.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.targets.Target;
import java.util.Random;

import static com.choucair.ui.PaginaProductos.*;

public class AgregarProductosAleatorios implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(8000);
            } catch (Exception e) {
            }
            Target target = productoAleatorio(actor);
            actor.attemptsTo(
                    Scroll.to(target),
                    Check.whether(target.resolveFor(actor).isVisible()).andIfSo(
                            JavaScriptClick.on(target),
                            JavaScriptClick.on(AGREGAR)
                    ).otherwise(
                            Click.on(target),
                            Click.on(AGREGAR)
                    )
            );
            Random random = new Random();
            int cantidadAleatorio = random.nextInt(9) + 1;
            for (int j = 0; j < cantidadAleatorio; j++) {
                actor.attemptsTo(
                        Check.whether(target.resolveFor(actor).isVisible()).andIfSo(
                                JavaScriptClick.on(CANTIDAD)
                        ).otherwise(
                                Click.on(CANTIDAD)
                        )
                );
            }
            cantidadDelProducto.add(CANTIDAD_PRODUCTO.resolveFor(actor).getText().trim().substring(0,1));
            actor.attemptsTo(
                    Click.on(CONTINUAR_COMPRANDO)

            );
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public static AgregarProductosAleatorios agregarProductosAleatorios() {
        return new AgregarProductosAleatorios();
    }

}
