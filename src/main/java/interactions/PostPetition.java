package interactions;

import io.restassured.http.ContentType;
import models.Pet;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;

import static net.serenitybdd.screenplay.rest.abilities.CallAnApi.as;

public class PostPetition extends RestInteraction {

    private final String resource;
    private final int id;

    public PostPetition(String resource, int id) {
        this.resource = resource;
        this.id = id;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Pet pet = new Pet(id);
        SerenityRest.given().
                log().all().
                contentType(ContentType.JSON).
                body(pet)
                .post(as(actor).resolve(resource))
                .then()
                .log().all();
    }

    public static PostPetition withResource(String resource, int id) {
        return new PostPetition(resource, id);
    }

}
