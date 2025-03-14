package tasks;

import interactions.PostPetition;
import net.serenitybdd.annotations.Step;
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
    @Step("{0} sends the request to resource #resource with ID #id")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                PostPetition.withResource(resource, id)
        );
    }

    public static ConsumePostService withResource(String resource, int id) {
        return new ConsumePostService(resource, id);
    }
}
