package interactions;

import io.restassured.http.ContentType;
import models.Pet;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;

import static net.serenitybdd.screenplay.rest.abilities.CallAnApi.as;

public class PutPeticion extends RestInteraction {

    private final String recurso;
    private final Pet pet;

    public PutPeticion(String recurso, Pet pet) {
        this.recurso = recurso;
        this.pet = pet;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        SerenityRest.given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(pet)
                .put(as(actor).resolve(recurso))
                .then()
                .log().all();
    }

    public static PutPeticion conRecurso(String recurso, Pet pet) {
        return new PutPeticion(recurso, pet);
    }
}
