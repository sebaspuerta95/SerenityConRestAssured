package tasks;

import interactions.PostPeticion;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class ConsumirServicioPost implements Task {

    private String recurso;
    private int id;

    public ConsumirServicioPost(String recurso, int id) {
        this.recurso = recurso;
        this.id = id;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                PostPeticion.conRecurso(recurso, id)
        );
    }

    public static ConsumirServicioPost conRecurso(String recurso, int id) {
        return new ConsumirServicioPost(recurso, id);
    }
}
