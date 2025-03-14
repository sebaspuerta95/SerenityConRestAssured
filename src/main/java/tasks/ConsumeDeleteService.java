package tasks;

import interactions.DeletePetition;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConsumeDeleteService implements Task {

    public static final Logger LOGGER = LoggerFactory.getLogger(ConsumeDeleteService.class);

    private final String resource;

    public ConsumeDeleteService(String resource) {
        this.resource = resource;
    }

    @Override
    @Step("{0} sends a DELETE request to the resource #resource to delete a pet")
    public <T extends Actor> void performAs(T actor) {
        LOGGER.info("Updating pet information with resource {}:", resource);

        actor.attemptsTo(
            DeletePetition.withResource(resource)
        );
    }

    public static ConsumeDeleteService withResource(String resource) {
        return new ConsumeDeleteService(resource);
    }
}
