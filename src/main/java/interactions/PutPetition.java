package interactions;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.Pet;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;

import static net.serenitybdd.screenplay.rest.abilities.CallAnApi.as;

public class PutPetition extends RestInteraction {

    private final String resource;
    private final Pet pet;

    public PutPetition(String resource, Pet pet) {
        this.resource = resource;
        this.pet = pet;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
         Response response = SerenityRest.given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(pet)
                .put(as(actor).resolve(resource))
                .then()
                .log().all()
                .extract().response();

        actor.remember("last_response", response);
    }

    public static PutPetition withResource(String resource, Pet pet) {
        return new PutPetition(resource, pet);
    }
}
