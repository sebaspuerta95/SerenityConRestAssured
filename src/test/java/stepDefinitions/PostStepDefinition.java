package stepDefinitions;

import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.equalTo;
import static utils.Constantes.BASE_URL;

import tasks.ConsumirServicioPost;
import questions.CodigoRespuesta;

public class PostStepDefinition extends EstablecerServicio {

    @Given("el usuario obtiene la URL base de la API")
    public void elUsuarioObtieneLaURLBaseDeLaAPI(){
        OnStage.setTheStage(new OnlineCast());
        establecerServicio(BASE_URL);
    }

    @When("crea una peticion para crear una nueva mascota con el recurso {string} con id {string}")
    public void creaUnaPeticionParaCrearUnaNuevaMascota(String recurso, String id) {
        actor.attemptsTo(
                ConsumirServicioPost.conRecurso(recurso, Integer.parseInt(id))
        );
    }

    @Then("valida el estado de dicha peticion")
    public void valida_el_estado_de_dicha_peticion() {
        actor.should(
                seeThat("El código de respuesta",
                        CodigoRespuesta.codigoRespuesta(), equalTo(SC_OK))
        );
    }

}
