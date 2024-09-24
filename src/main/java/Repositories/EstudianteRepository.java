package Repositories;

import Helpers.CriterioBusqueda;
import Modelos.Carrera;
import Modelos.Estudiante;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.Date;
import java.util.List;

public class EstudianteRepository extends BaseRepository<Estudiante, Integer> {
    public EstudianteRepository(EntityManager em) {
        super(em, Estudiante.class, Integer.class);
    }

    public List<Estudiante> findByCriterio(CriterioBusqueda criterioBusqueda) {
        String jqpl = "select e from Estudiante e where " + criterioBusqueda.getCriterioBusqueda();

        TypedQuery<Estudiante> query = em.createQuery(jqpl, this.entityClass);

        return query.getResultList();
    }
}
