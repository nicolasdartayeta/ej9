package Repositories;

import Modelos.Carrera;
import jakarta.persistence.EntityManager;

public class CarreraRepository extends BaseRepository<Carrera, Integer> {
    public CarreraRepository(EntityManager em) {
        super(em, Carrera.class, Integer.class);
    }
}
