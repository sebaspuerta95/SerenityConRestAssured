package stepDefinitions;

import io.cucumber.java.en.When;
import tasks.ConsumirServicioGet;

public class GetStepDefinition extends EstablecerServicio{

    @When("consume el recurso de búsqueda {string}")
    public void consumeElRecursoDeBusqueda(String recurso) {
        actor.attemptsTo(
                ConsumirServicioGet.conRecurso(recurso)
        );
    }

}
