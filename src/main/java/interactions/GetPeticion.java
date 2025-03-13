package interactions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;

import static net.serenitybdd.screenplay.rest.abilities.CallAnApi.as;

public class GetPeticion extends RestInteraction {

    private final String recurso;

    public GetPeticion(String recurso){
        this.recurso = recurso;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        SerenityRest.given().
                log().all().
        get(as(actor).resolve(recurso)).
        then().
                log().all();
    }

    public static GetPeticion conRecurso(String recurso){
        return new GetPeticion(recurso);
    }

}
