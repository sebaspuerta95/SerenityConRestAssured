package tasks;

import interactions.PostPetition;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class ConsumePostService implements Task {

    private final String resource;
    private final int id;

    public ConsumePostService(String resource, int id) {
        this.resource = resource;
        this.id = id;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                PostPetition.withResource(resource, id)
        );
    }

    public static ConsumePostService withResource(String resource, int id) {
        return new ConsumePostService(resource, id);
    }
}
