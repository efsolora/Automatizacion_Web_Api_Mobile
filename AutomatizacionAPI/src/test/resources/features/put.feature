@E2E
Feature: Actualizar información de un empleado en la APU dummy restapiexample
  Yo como usuario de la API
  Quiero actualizar información de un empleado existente
  para mantener los datos del empleado actualizados

  Scenario: Actualizar información de un empleado
    Given estoy en la pagina de detalles de dummy.restapiexample.com
    When actualizo informacion del empleado con ID 5 y el nuevo nombre "James"
    Then laa respuesta debe tener codigo 200
    And se observa mensaje de confirmacion exitosa y que el nombre coincida

