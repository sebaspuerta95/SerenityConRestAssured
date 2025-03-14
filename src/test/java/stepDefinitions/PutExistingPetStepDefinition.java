package stepDefinitions;

import io.cucumber.java.en.And;
import models.Pet;
import net.serenitybdd.screenplay.GivenWhenThen;
import questions.PetNameQuestion;
import tasks.ConsumePutService;

import static org.hamcrest.Matchers.equalTo;
import static stepDefinitions.EstablishService.actor;

public class PutExistingPetStepDefinition {

    private Pet pet;

    @And("consume el recurso de actualización {string} para actualizar el dato de nombre a {string} y status {string} que pertence a la mascota con id {string}")
    public void updatePetInformation(String resource, String name, String status, String id) {
        pet = new Pet(
                Integer.parseInt(id),
                name,
                status
        );

        actor.attemptsTo(ConsumePutService.withResource(resource, pet));
    }

    @And("valida que el nombre de la mascota actualizado sea {string}")
    public void validateNewUpdatePet(String name) {
        actor.should(GivenWhenThen.seeThat("El nombre de la mascota actualizado es correcto",
                PetNameQuestion.fromResponse(), equalTo(name)));
    }
}
