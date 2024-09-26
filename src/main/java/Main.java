import Factories.JPARepositoryFactory;
import Repositories.CarreraRepository;
import Repositories.EstudianteRepository;
import Repositories.InscripcionRepository;
import Services.ReporteService;

public class Main {
    public static void main(String[] args){
        JPARepositoryFactory repositoryFactory = JPARepositoryFactory.getInstance();

        EstudianteRepository er = repositoryFactory.getEstudianteRepository();
        CarreraRepository cr = repositoryFactory.getCarreraRepository();
        InscripcionRepository ir = repositoryFactory.getInscripcionRepository();
        ReporteService serviceDTO = new ReporteService();
        serviceDTO.getReporte();
    }

}
