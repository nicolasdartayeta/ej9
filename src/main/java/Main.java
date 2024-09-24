import Modelos.Carrera;
import Modelos.Estudiante;
import Modelos.Inscripcion;
import Repositories.BaseRepository;
import Repositories.CarreraRepository;
import Repositories.EstudianteRepository;
import Repositories.InscripcionRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

import java.util.List;

public class Main {
    public static void main(String[] args){
        EntityManager em = Persistence.createEntityManagerFactory("persistencia").createEntityManager();

        EstudianteRepository er = new EstudianteRepository(em);
        CarreraRepository cr = new CarreraRepository(em);
        InscripcionRepository ir = new InscripcionRepository(em);

        Carrera nuevaCarrera = cr.getById(2);
//        er.persist(new Estudiante("nico", "darta", 20, 'm', 44859810, "mdp", 44859810));
        Estudiante est = er.getById(1);

//        ir.matricular(est, nuevaCarrera);
        List<Inscripcion>  result = ir.findAll();
        result.forEach(System.out::println);
    }

}
