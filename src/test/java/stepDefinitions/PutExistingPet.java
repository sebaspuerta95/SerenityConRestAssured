package stepDefinitions;

import interactions.PutPeticion;
import io.cucumber.java.en.And;
import models.Category;
import models.Pet;
import models.Tag;

import java.util.ArrayList;
import java.util.Arrays;

import static stepDefinitions.EstablecerServicio.actor;

public class PutExistingPet {

    private Pet pet;

    @And("consume el recurso de actualización {string} para actualizar el dato de nombre a {string} y status {string} que pertence a la mascota con id {string}")
    public void consumeElRecursoDeActualizaciónParaActualizarElDatoDeNombreAYStatusQuePertenceALaMascotaConId(String recurso, String nombre, String status, String id) {
        pet = new Pet(
                Integer.parseInt(id),
                nombre,
                status
        );

        actor.attemptsTo(PutPeticion.conRecurso(recurso, pet));
    }
}
