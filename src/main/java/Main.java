import Factories.JPARepositoryFactory;
import Repositories.CarreraRepository;
import Repositories.EstudianteRepository;
import Repositories.InscripcionRepository;
import Repositories.JPAImplementation.JPACarreraRepository;
import Repositories.JPAImplementation.JPAEstudianteRepository;
import Repositories.JPAImplementation.JPAInscripcionRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args){
        JPARepositoryFactory repositoryFactory = JPARepositoryFactory.getInstance();

        EstudianteRepository er = repositoryFactory.getEstudianteRepository();
        CarreraRepository cr = repositoryFactory.getCarreraRepository();
        InscripcionRepository ir = repositoryFactory.getInscripcionRepository();

        System.out.println(cr.getCarrrerasConInscriptos());
    }

}
