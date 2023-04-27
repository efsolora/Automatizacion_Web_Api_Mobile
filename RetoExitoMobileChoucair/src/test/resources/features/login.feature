Feature: Inicio de sesion en la app exito
  Yo como usuario de la app exito
  Quiero iniciar sesion
  para quedar logueado en la app

  Scenario: inicio de sesion exitoso
    Given que accedo a la aplicacion exito
    When Ingreso los datos de usuario y contraseña
    Then el inicio de sesion se deberia realizar correctamente