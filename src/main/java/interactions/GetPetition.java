package interactions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;

import static net.serenitybdd.screenplay.rest.abilities.CallAnApi.as;

public class GetPetition extends RestInteraction {

    private final String resource;

    public GetPetition(String resource){
        this.resource = resource;
    }

    @Override
    @Step("{0} sends a GET request to the resoure #resource")
    public <T extends Actor> void performAs(T actor) {

        SerenityRest.given().
                log().all()
                .get(as(actor).resolve(resource))
                .then()
                .log().all();
    }

    public static GetPetition withResource(String resource){
        return new GetPetition(resource);
    }

}
