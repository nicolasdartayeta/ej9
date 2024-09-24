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

        String jqpl = "INSERT INTO Inscripcion (inscripcion_id_estudiante, inscripcion_id_carrera, fecha_inscripcion, fecha_graduacion) VALUES (?1, ?2, ?3, ?4)";

        em.createQuery(jqpl).setParameter(1,  estudiante.getId()).setParameter(2, carrera.getId()).setParameter(3, new Date()).setParameter(4, null).executeUpdate();

        em.getTransaction().commit();
    }

    public void setFechaGrauacion(Estudiante estudiante, Carrera carrera, Date fecha_graduacion) {
        em.getTransaction().begin();

        String jqpl = "UPDATE Inscripcion i SET i.fecha_graduacion = :fecha_graduacion WHERE i.inscripcion_id_estudiante = :id_estudiante and i.inscripcion_id_carrera = :id_carrera";

        em.createQuery(jqpl).setParameter("id_estudiante",  estudiante.getId()).setParameter("id_carrera", carrera.getId()).setParameter("fecha_graduacion", fecha_graduacion).executeUpdate();

        em.getTransaction().commit();
    }
}
