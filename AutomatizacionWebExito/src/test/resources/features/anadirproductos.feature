Feature: Compra de productos en Almacen Exito
  yo como usuario de la pagina exito
  quiero añadir productos al carrito

  Scenario: anadir productos aleatorios de una categoria al carrito
    Given Given que estoy en la pagina de exito
    And he agregado los productos al carrito
    Then se deberian ver los productos en el carrito coinciden con los productos agregados
