import Helpers.CriterioAND;
import Helpers.CriterioBusqueda;
import Helpers.CriterioBusquedaGenero;
import Helpers.CriterioBusquedaLibretaUniversitaria;
import Repositories.EstudianteRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args){
        EntityManager em = Persistence.createEntityManagerFactory("persistencia").createEntityManager();
//
        EstudianteRepository er = new EstudianteRepository(em);
//        CarreraRepository cr = new CarreraRepository(em);
//        InscripcionRepository ir = new InscripcionRepository(em);
//
//        Carrera nuevaCarrera = cr.getById(2);
////        er.persist(new Estudiante("nico", "darta", 20, 'm', 44859810, "mdp", 44859810));
//        Estudiante est = er.getById(1);
//
////        ir.matricular(est, nuevaCarrera);
//        ir.setFechaGrauacion(est, nuevaCarrera, new Date());
//        List<Inscripcion>  result = ir.findAll();
//        result.forEach(System.out::println);

        CriterioBusqueda criterioLibreta = new CriterioBusquedaLibretaUniversitaria(44859810, 'e');
        CriterioBusqueda criterioGenero = new CriterioBusquedaGenero('m', 'e');
        CriterioBusqueda criterioAND = new CriterioAND(criterioLibreta, criterioGenero);

        System.out.println(er.findByCriterio(criterioAND));
    }

}
