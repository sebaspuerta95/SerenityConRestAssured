package tasks;

import interactions.PutPetition;
import models.Pet;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class ConsumePutService implements Task {

    private final String resource;
    private final Pet pet;

    public ConsumePutService(String resource, Pet pet) {
        this.resource = resource;
        this.pet = pet;
    }

    @Override
    @Step("{0} sends a PUT request to the resource #resource to update the pet #pet")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                PutPetition.withResource(resource, pet)
        );
    }

    public static ConsumePutService withResource(String resource, Pet pet) {
        return new ConsumePutService(resource, pet);
    }
}
