Feature: Compra de un producto en la APP exito
  Yo como usuario de la app exito
  Quiero realizar la compra de un producto
  para hacer uso del producto

  Scenario: Compra de producto exitosa
    Given que inicio en la aplicacion app exito
    When inicio sesion en la app con credenciales validas
    And Agrego un producto al carrito
    Then deberia ver que el producto se añade correctamente