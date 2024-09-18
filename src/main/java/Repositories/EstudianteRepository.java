package Repositories;

import Modelos.Carrera;
import Modelos.Estudiante;
import jakarta.persistence.EntityManager;

import java.util.Date;

public class EstudianteRepository extends BaseRepository<Estudiante, Integer> {
    public EstudianteRepository(EntityManager em) {
        super(em, Estudiante.class, Integer.class);
    }

    public void matricular(Estudiante estudiante, Carrera carrera){
        em.getTransaction().begin();

        String jqpl = "INSERT INTO inscripcion (inscripcion_id_estudiante, inscripcion_id_carrera, fecha_inscripcion, graduado) VALUES (?, ?, ?, ?)";

        em.createQuery(jqpl).setParameter(1,  estudiante.getId()).setParameter(2, carrera.getId()).setParameter(3, new Date()).setParameter(4, false).executeUpdate();

        em.getTransaction().commit();

    }
}
