package stepDefinitions;

import io.cucumber.java.en.And;
import tasks.ConsumeDeleteService;

import static stepDefinitions.EstablishService.actor;

public class DeleteExistingPetStepDefinition {
    @And("consume el recurso para eliminar la mascota con id en el recurso {string}")
    public void deletePetById(String id) {
        actor.attemptsTo(
                ConsumeDeleteService.withResource(id)
        );
    }
}
