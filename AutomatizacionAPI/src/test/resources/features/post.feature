@E2E
Feature: Creando un nuevo empleado en API dummy restapiexample
  Yo como usuario de la API
  Quiero crear un nuevo empleado
  para agregar los datos del nuevo empleado a la API

  Scenario: Creando un nuevo empleado
    Given estoy en la pagina de creacion API dummy restapiexample
    When creo un nuevo empleado con nombre "Javier", salario 500 y edad 30
    Then la respuesta debee tener codigo 200
    And se debe observar un mensaje de confirmacion y que el salario coincida
