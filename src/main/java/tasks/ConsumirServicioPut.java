package tasks;

import interactions.PutPeticion;
import models.Pet;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class ConsumirServicioPut implements Task {

    private String recurso;
    private Pet pet;

    public ConsumirServicioPut(String recurso, Pet pet) {
        this.recurso = recurso;
        this.pet = pet;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                PutPeticion.conRecurso(recurso, pet)
        );
    }

    public static ConsumirServicioPut conRecurso(String recurso, Pet pet) {
        return new ConsumirServicioPut(recurso, pet);
    }
}
