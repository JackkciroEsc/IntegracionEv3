Feature: Autenticacion de Usuario

  Scenario: Iniciar sesion con credenciales validas
    Given el usuario accede a la pagina de inicio de sesion
    When ingresa "user123" como nombre de usuario y "pass123" como contraseña
    Then se muestra un mensaje "Acceso autorizado" para el usuario

  Scenario: Intento de inicio de sesion con credenciales incorrectas
    Given el usuario accede a la pagina de inicio de sesion
    When ingresa "usuario123" como nombre de usuario y "contra123" como contraseña
    Then se muestra un mensaje "Credenciales invalidas, intente nuevamente" para el usuario

  Scenario: Intento de inicio de sesion con valores vacio
    Given el usuario accede a la pagina de inicio de sesion
    When ingresa "" como nombre de usuario y "" como contraseña
    Then se muestra un mensaje "Credenciales invalidas, intente nuevamente" para el usuario