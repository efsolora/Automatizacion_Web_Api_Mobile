package com.choucair.interactions;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getProxiedDriver;

public class Coordenadas implements Interaction {
    private int x;
    private int y;

    public Coordenadas(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Coordenadas coordenadas(int x, int y){
        return Tasks.instrumented(Coordenadas.class, x, y);    }
    
    @Override
    public <T extends Actor> void performAs(T actor) {
        AndroidDriver android = getProxiedDriver();
        TouchAction touchAction = new TouchAction(android);
        touchAction.press(PointOption.point(x, y)).release().perform();
    }
}
