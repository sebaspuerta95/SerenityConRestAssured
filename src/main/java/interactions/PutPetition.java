package interactions;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.Pet;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.serenitybdd.screenplay.rest.abilities.CallAnApi.as;

public class PutPetition extends RestInteraction {

    public static final Logger LOGGER = LoggerFactory.getLogger(PutPetition.class);

    private final String resource;
    private final Pet pet;

    public PutPetition(String resource, Pet pet) {
        this.resource = resource;
        this.pet = pet;
    }

    @Override
    @Step("{0} sends a PUT request to the resource #resource with the pet #pet")
    public <T extends Actor> void performAs(T actor) {
        LOGGER.info("Sending PUT request to resource {} with pet {}:", resource, pet);

        Response response = SerenityRest.given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(pet)
                .put(as(actor).resolve(resource))
                .then()
                .log().all()
                .extract().response();

        actor.remember("last_response", response);

        LOGGER.info("New pet information was updated successfully.");
    }

    public static PutPetition withResource(String resource, Pet pet) {
        return new PutPetition(resource, pet);
    }
}
