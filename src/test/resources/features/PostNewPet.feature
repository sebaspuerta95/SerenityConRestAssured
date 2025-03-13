Feature: Crear una nueva mascota con el método POST

  Scenario Outline: Creación de una nueva mascota con un ID valido
    Given el usuario obtiene la URL base de la API
    When crea una peticion para crear una nueva mascota con el recurso "<recurso>" con id "<id>"
    Then valida el estado de dicha peticion

    Examples:
      | recurso | id |
      | /pet | 950813 |
      | /pet | 0 |