Feature: Eliminar una mascota existente

  Scenario Outline: Eliminar una mascota existente
    Given el usuario obtiene la URL base de la API
    When crea una peticion para crear una nueva mascota con el recurso "<recurso>" con id "<id>"
    And consume el recurso para eliminar la mascota con id en el recurso "<recurso><id>"
    Then valida el estado de dicha peticion
    Examples:
      | recurso | id |
      | /pet/ | 950813 |