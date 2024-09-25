package Repositories;

import java.util.List;

import Helpers.CriterioBusqueda;
import Helpers.CriterioOrdenamiento;
import Modelos.Carrera;
import Modelos.Inscripcion;
import Modelos.JoinEstCarIns;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class CarreraRepository extends BaseRepository<Carrera, Integer> {
    public CarreraRepository(EntityManager em) {
        super(em, Carrera.class, Integer.class);
    }

    public List<JoinEstCarIns> reporte(CriterioOrdenamiento crit){
        //String result = "";

        String q = "SELECT c, i, e FROM Carrera c LEFT JOIN Inscripcion i ON c.id = i.inscripcion_id_carrera JOIN Estudiante e ON e.id = i.inscripcion_id_estudiante " + crit.getCriterioOrdenamiento();
        List<JoinEstCarIns> result = em.createQuery(q, JoinEstCarIns.class).getResultList();

        System.out.println(result);

        return result;
    }
}
