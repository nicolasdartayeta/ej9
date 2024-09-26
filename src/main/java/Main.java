import Helpers.CriterioOrdenamiento;
import Helpers.CriterioOrdenamientoNombre;
import Repositories.CarreraRepository;
import Repositories.EstudianteRepository;
import Repositories.InscripcionRepository;
import Services.ReporteService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args){
        EntityManager em = Persistence.createEntityManagerFactory("persistencia").createEntityManager();

        EstudianteRepository er = new EstudianteRepository(em);
        CarreraRepository cr = new CarreraRepository(em);
        InscripcionRepository ir = new InscripcionRepository(em);

//        Estudiante esteban = er.getById(52);
//        Estudiante nacho = er.getById(53);
//        Estudiante fede = er.getById(54);
//        Estudiante santi = er.getById(55);
//        Carrera soft = cr.getById(2);
//        Carrera matematica = cr.getById(52);
//        Carrera sociales = cr.getById(102);
//        Carrera arqui = cr.getById(1);

        // er.persist(esteban);
        // er.persist(nacho);
        // er.persist(fede);
        // er.persist(santi);

        
        // ir.matricular(esteban, soft);
        // ir.matricular(esteban, matematica);
        // ir.matricular(esteban, arqui);
        // ir.matricular(santi, soft);
        // ir.matricular(santi, matematica);
        // ir.matricular(santi, arqui);
        // ir.matricular(nacho, soft);
        // ir.matricular(nacho, sociales);
        // ir.matricular(nacho, matematica);
        // ir.matricular(fede, matematica);

////        ir.matricular(est, nuevaCarrera);
//        ir.setFechaGrauacion(est, nuevaCarrera, new Date());
//        List<Inscripcion>  result = ir.findAll();
//        result.forEach(System.out::println);

//        CriterioOrdenamiento criterioNombre = new CriterioOrdenamientoNombre('c');
        ReporteService serviceDTO = new ReporteService();
        serviceDTO.getReporte();
    }

}
