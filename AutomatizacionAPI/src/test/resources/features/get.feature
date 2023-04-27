@E2E
Feature: Obtener informacion de un empleado de la API dummy restapiexample
  Yo como usuario de la API
  Quiero obtener informacion un empleado existente
  para saber los datos correspondientes del empleado registrado en la API

  Scenario: Obtener informacion de un empleado exitosamente
    Given estoy en la pagina de empleados de la API dummy restapiexample
    When obtengo informacion del empleado con ID 2
    Then la respuesta debe ser un codigo 200
    And y de los datos consultados el ID debe coincidir

