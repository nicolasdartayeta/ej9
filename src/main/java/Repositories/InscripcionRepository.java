package Repositories;

import Modelos.Carrera;
import Modelos.Estudiante;
import Modelos.Inscripcion;

import java.util.Date;

public interface InscripcionRepository extends GenericRepository<Inscripcion, Integer> {
    void matricular(Estudiante estudiante, Carrera carrera);
    void setFechaGrauacion(Estudiante estudiante, Carrera carrera, Date fecha_graduacion);
}
