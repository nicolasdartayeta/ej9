import Modelos.Estudiante;
import Repositories.EstudianteRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

import java.util.List;

public class Main {
    public static void main(String[] args){
        EntityManager em = Persistence.createEntityManagerFactory("persistencia").createEntityManager();

        EstudianteRepository er = new EstudianteRepository(em);

        er.persist(new Estudiante("nico", "darta", 20, 'm', 44859810, "mdp", 44859810));
        List<Estudiante>  result = er.findAll();
        result.forEach(System.out::println);
    }

}
