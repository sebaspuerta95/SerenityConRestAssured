package stepDefinitions;

import io.cucumber.java.en.When;
import tasks.ConsumeGetService;

public class GetExistingPetStepDefinition extends EstablishService {

    @When("consume el recurso de busqueda {string}")
    public void findPetById(String resource) {
        actor.attemptsTo(
                ConsumeGetService.withResource(resource)
        );
    }

}
