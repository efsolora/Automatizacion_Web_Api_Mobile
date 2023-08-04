package com.choucair.tasks;

import com.choucair.ui.PaginaCategorias;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class AbrirPaginaInicial implements Task {
    private PaginaCategorias paginaCategorias;
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.browserOn(paginaCategorias)
        );
    }
}
