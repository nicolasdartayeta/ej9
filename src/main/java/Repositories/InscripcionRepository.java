package Repositories;

import Modelos.Carrera;
import Modelos.Estudiante;
import Modelos.Inscripcion;
import jakarta.persistence.EntityManager;

import java.util.Date;

public class InscripcionRepository extends BaseRepository<Inscripcion, Integer> {
    public InscripcionRepository(EntityManager em) {
        super(em, Inscripcion.class, Integer.class);
    }

    public void matricular(Estudiante estudiante, Carrera carrera){
        em.getTransaction().begin();

        String jqpl = "INSERT INTO Inscripcion (inscripcion_id_estudiante, inscripcion_id_carrera, fecha_inscripcion, graduado) VALUES (?1, ?2, ?3, ?4)";

        em.createQuery(jqpl).setParameter(1,  estudiante.getId()).setParameter(2, carrera.getId()).setParameter(3, new Date()).setParameter(4, false).executeUpdate();

        em.getTransaction().commit();
    }
}
