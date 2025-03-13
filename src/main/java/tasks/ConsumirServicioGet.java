package tasks;

import interactions.GetPeticion;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class ConsumirServicioGet implements Task {

    private String recurso;

    public ConsumirServicioGet (String recurso){
        this.recurso = recurso;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                GetPeticion.conRecurso(recurso)
        );
    }

    public static ConsumirServicioGet conRecurso(String recurso){
        return new ConsumirServicioGet(recurso);
    }

}
