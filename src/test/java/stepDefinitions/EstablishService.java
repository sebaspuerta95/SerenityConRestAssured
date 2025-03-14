package stepDefinitions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static utils.Constants.ACTOR;

public class EstablishService {

    protected static final Actor actor = new Actor(ACTOR);

    protected void establishService(){
        actor.can(CallAnApi.at(utils.Constants.BASE_URL));
    }

}
