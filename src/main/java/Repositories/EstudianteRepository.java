package Repositories;

import Helpers.CriterioBusqueda;
import Modelos.Estudiante;

import java.util.List;

public interface EstudianteRepository extends GenericRepository<Estudiante, Integer> {
    List<Estudiante> findByCriterio(CriterioBusqueda criterioBusqueda);

}
