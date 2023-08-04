package com.choucair.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PaginaSeleccionarProducto {
    public static final Target PERMISOS_UBICACION = Target.the("notificacion de permisos de ubciacion")
            .located(By.id("com.android.permissioncontroller:id/permission_deny_button"));
    public static final Target BTN_CELULAR = Target.the("seleccionar celular")
            .located(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.HorizontalScrollView/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.view.ViewGroup[2]/android.widget.ImageView"));
    public static final Target DOMICILIO = Target.the("Direccion del producto")
            .located(By.id("com.exito.appcompania:id/appCompatTextView_item_title"));

    public static final Target BTN_CONTINUAR = Target.the("boton de continuar")
            .located(By.id("com.exito.appcompania:id/appCompatButton_continue"));

    public static final Target AGREGAR_PRODUCTO = Target.the("agregar producto")
            .located(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]"));

    public static final Target PRODUCTO_AGREGADO = Target.the("nombre del producto")
            .located(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.widget.TextView[2]"));

    public static final Target BTN_CARRITO = Target.the("boton del carrito")
            .located(By.id("com.exito.appcompania:id/appCompatImageView_shopping_cart"));








}
