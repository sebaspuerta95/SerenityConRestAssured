package interactions;

import io.restassured.http.ContentType;
import models.Pet;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import static net.serenitybdd.screenplay.rest.abilities.CallAnApi.as;

public class PostPetition extends RestInteraction {

    public static final Logger LOGGER = LoggerFactory.getLogger(PostPetition.class);

    private final String resource;
    private final int id;

    public PostPetition(String resource, int id) {
        this.resource = resource;
        this.id = id;
    }

    @Override
    @Step("{0} sends the POST request to the resource #resource with ID #id")
    public <T extends Actor> void performAs(T actor) {
        LOGGER.info("Creating a new pet by sending POST to {} with ID {}", resource, id);

        Pet pet = new Pet(id);
        SerenityRest.given().
                log().all().
                contentType(ContentType.JSON).
                body(pet)
                .post(as(actor).resolve(resource))
                .then()
                .log().all();

        LOGGER.info("POST request was sent and the new pet was created.");
    }

    public static PostPetition withResource(String resource, int id) {
        return new PostPetition(resource, id);
    }

}
