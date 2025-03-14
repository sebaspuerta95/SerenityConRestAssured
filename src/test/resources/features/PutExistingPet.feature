Feature: Actualizar la información de una mascota por medio del metodo PUT

  Scenario Outline: Actualización de la información de una mascota existente
    Given el usuario obtiene la URL base de la API
    When crea una peticion para crear una nueva mascota con el recurso "<recurso>" con id "<id>"
    And consume el recurso de actualización "<recurso>" para actualizar el dato de nombre a "<name>" y status "<status>" que pertence a la mascota con id "<id>"
    Then valida el estado de dicha peticion
    And valida que el nombre de la mascota actualizado sea "<name>"

    Examples:
      | recurso | id | name | status
      | /pet | 950813 | Firulais | sold