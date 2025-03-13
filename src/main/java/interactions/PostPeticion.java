package interactions;

import io.restassured.http.ContentType;
import models.Pet;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;

import static net.serenitybdd.screenplay.rest.abilities.CallAnApi.as;

public class PostPeticion extends RestInteraction {

    private final String recurso;
    private final int id;

    public PostPeticion(String recurso, int id) {
        this.recurso = recurso;
        this.id = id;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Pet pet = new Pet(id);
        SerenityRest.given().
                log().all().
                contentType(ContentType.JSON).
                body(pet).
        post(as(actor).resolve(recurso)).
        then().
                log().all();
    }

    public static PostPeticion conRecurso(String recurso, int id) {
        return new PostPeticion(recurso, id);
    }

}
