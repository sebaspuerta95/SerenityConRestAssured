package questions;

import io.restassured.response.Response;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class PetNameQuestion implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        Response response = actor.recall("last_response");
        return response.jsonPath().getString("name");
    }

    public static PetNameQuestion fromResponse(){
        return new PetNameQuestion();
    }
}
