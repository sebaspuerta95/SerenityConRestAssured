package tasks;

import interactions.GetPetition;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConsumeGetService implements Task {

    public static final Logger LOGGER = LoggerFactory.getLogger(ConsumeGetService.class);

    private final String resource;

    public ConsumeGetService(String resource){
        this.resource = resource;
    }

    @Override
    @Step("{0} sends the GET request to get the Pet information with resource #resource")
    public <T extends Actor> void performAs(T actor) {
        LOGGER.info("Obtaining pet information with resource {}:", resource);

        actor.attemptsTo(
                GetPetition.withResource(resource)
        );
    }

    public static ConsumeGetService withResource(String resource){
        return new ConsumeGetService(resource);
    }
}
