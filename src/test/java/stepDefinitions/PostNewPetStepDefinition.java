package stepDefinitions;

import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.equalTo;

import tasks.ConsumePostService;
import questions.AnswerCode;

public class PostNewPetStepDefinition extends EstablishService {

    @Given("el usuario obtiene la URL base de la API")
    public void getApiBaseUrl(){
        OnStage.setTheStage(new OnlineCast());
        establishService();
    }

    @When("crea una peticion para crear una nueva mascota con el recurso {string} con id {string}")
    public void createNewPet(String resource, String id) {
        actor.attemptsTo(
                ConsumePostService.withResource(resource, Integer.parseInt(id))
        );
    }

    @Then("valida el estado de dicha peticion")
    public void validatePetitionStatus() {
        actor.should(
                seeThat("El código de respuesta",
                        AnswerCode.answerCode(), equalTo(SC_OK))
        );
    }

}
