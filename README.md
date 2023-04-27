# Proyecto de Automatización de Pruebas

Este proyecto incluye automatizaciones de pruebas en tres tecnologías distintas: web, APIs y móvil, para el sitio web y la aplicación de Tiendas Éxito, así como para la API de ejemplo http://dummy.restapiexample.com/. 

## Tecnología Web

La automatización de pruebas para la tecnología web utiliza Java 11 como lenguaje de programación y el framework de automatización de pruebas Selenium. La automatización realiza los siguientes pasos:

- Ingresa a la página de Tiendas Éxito (https://www.exito.com/).
- Elige una categoría y subcategoría.
- Agrega 5 productos aleatoriamente al carrito, con cantidades aleatorias entre 1 y 10.
- Valida que el nombre de los productos agregados sea igual al nombre en el carrito.
- Valida que el total de los precios de los productos agregados sea igual al total en el carrito.
- Valida que las cantidades de los productos agregados sean iguales a las cantidades en el carrito.
- Valida que el número de productos agregados sea igual al número en el carrito.
- **Valor agregado**: Se realiza un inicio de sesión en la página de Tiendas Éxito.

## Tecnología API

Tecnología APIs
La automatización de pruebas para la tecnología de APIs utiliza Java 11 como lenguaje de programación y el framework RestAssured. La automatización realiza los siguientes pasos:

- Realiza la automatizacion end-to-end de los escenarios de prueba para los métodos GET, POST, PUT y DELETE probando los endpoints de la API (http://dummy.restapiexample.com/).

## Tecnología Móvil
La automatización de pruebas para la tecnología móvil utiliza Java 8 como lenguaje de programación y el framework Appium. La automatización realiza los siguientes pasos:

- Se registra en la aplicación móvil Éxito.
- Inicia sesión en la aplicación móvil Éxito.
- Agrega un producto al carrito.
- Valida que el producto haya sido agregado correctamente al carrito.
- **Valor Agregado**: Se realizan validaciones del inicio de sesión y del registro en la aplicación móvil Éxito.

## Requisitos de Ejecución

Se recomienda usar Java 8 para la automatización móvil y Java 11 para las automatizaciones web y de APIs.

*By: James Muñoz*
