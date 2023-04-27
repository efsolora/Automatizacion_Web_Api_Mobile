@E2E
Feature: Eliminar un empleado de la API dummy restapiexample
  Yo como usuario de la API
  Quiero eliminar un empleado existente
  para sacar el empleado de los registros de la API

  Scenario: Eliminar un empleado exitosamente
    Given estoy en la pagina de la API dummy restapiexample
    When elimino el empleado con ID 1
    Then la respuesta debe tener codigo 200
    And mostrar un mensaje de borrado exitoso


