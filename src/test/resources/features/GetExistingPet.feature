Feature: Obtener una mascota existente con el metodo GET

  Scenario Outline: Se recupera correctamente la información de una mascota existente
    Given el usuario obtiene la URL base de la API
    When crea una peticion para crear una nueva mascota con el recurso "<recurso>" con id "<id>"
    And consume el recurso de busqueda "<recurso><id>"
    Then valida el estado de dicha peticion

    Examples:
      | recurso | id |
      | /pet/ | 950813 |