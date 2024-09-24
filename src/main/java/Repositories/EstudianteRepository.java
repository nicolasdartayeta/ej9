package Repositories;

import Modelos.Carrera;
import Modelos.Estudiante;
import jakarta.persistence.EntityManager;

import java.util.Date;

public class EstudianteRepository extends BaseRepository<Estudiante, Integer> {
    public EstudianteRepository(EntityManager em) {
        super(em, Estudiante.class, Integer.class);
    }
}
