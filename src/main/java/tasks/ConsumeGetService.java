package tasks;

import interactions.GetPetition;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class ConsumeGetService implements Task {

    private final String resource;

    public ConsumeGetService(String resource){
        this.resource = resource;
    }

    @Override
    @Step("{0} sends the GET request to get the Pet information with resource #resource")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                GetPetition.withResource(resource)
        );
    }

    public static ConsumeGetService withResource(String resource){
        return new ConsumeGetService(resource);
    }
}
