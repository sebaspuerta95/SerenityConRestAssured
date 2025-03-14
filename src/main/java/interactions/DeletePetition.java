package interactions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;

import static net.serenitybdd.screenplay.rest.abilities.CallAnApi.as;

public class DeletePetition extends RestInteraction {

    private final String resource;

    public DeletePetition(String resource) {
        this.resource = resource;
    }

    @Override
    @Step("{0} sends a DELETE request to the resource #resource")
    public <T extends Actor> void performAs(T actor) {
        SerenityRest.given()
                .log().all()
                .delete(as(actor).resolve(resource))
                .then()
                .log().all();
    }

    public static DeletePetition withResource(String resource) {
        return new DeletePetition(resource);
    }
}
