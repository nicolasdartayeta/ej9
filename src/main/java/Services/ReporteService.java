package Services;


import java.util.List;

import DTOs.ReporteCarrerasDTO;
import DTOs.ReporteCarrerasDTO.ItemReporte;
import DTOs.ReporteCarrerasDTO.ItemReporte.EstudianteFecha;
import Factories.RepositoryFactory;
import Helpers.CriterioOrdenamiento;
import Helpers.CriterioOrdenamientoInscripcion;
import Helpers.CriterioOrdenamientoNombre;
import Modelos.Carrera;
import Modelos.Inscripcion;
import Repositories.CarreraRepository;
import Repositories.EstudianteRepository;
import Repositories.InscripcionRepository;
import Repositories.JPAImplementation.JPACarreraRepository;
import Repositories.JPAImplementation.JPAEstudianteRepository;
import Repositories.JPAImplementation.JPAInscripcionRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class ReporteService {
    RepositoryFactory repositoryFactory;
    CarreraRepository carreraRepository;
    EstudianteRepository estudianteRepository;
    InscripcionRepository inscripcionRepository;

    public ReporteService(RepositoryFactory repositoryFactory) {
        this.repositoryFactory = repositoryFactory;
        this.carreraRepository = repositoryFactory.getCarreraRepository();
        this.estudianteRepository = repositoryFactory.getEstudianteRepository();
        this.inscripcionRepository = repositoryFactory.getInscripcionRepository();
    }

    public ReporteCarrerasDTO getReporte(){
        //Get de lista de Carreras, ordenadas alfabeticamente
        CriterioOrdenamiento crit = new CriterioOrdenamientoNombre('c');
        List<Carrera> lista_carrera = carreraRepository.getAllCarrerasOrdenadas(crit);

        //Get de lista de Inscripciones, ordenadas cronologicamente por fecha_inscripcion
        CriterioOrdenamiento crit2 = new CriterioOrdenamientoInscripcion('i');
        List<Inscripcion> lista_inscripcion = inscripcionRepository.getAllCarrerasOrdenadas(crit2);
        
        ReporteCarrerasDTO dto = new ReporteCarrerasDTO();

        for (Carrera carrera: lista_carrera){   //Itera por carreras ordenadas
            ItemReporte itemReporte = dto.new ItemReporte(carrera);
            for(Inscripcion inscripcion: lista_inscripcion){    //Itera por las inscripciones ordenadas
                if (inscripcion.getCarrera().equals(carrera)){
                    EstudianteFecha estudiante = itemReporte.new EstudianteFecha(estudianteRepository.getById(inscripcion.getIdEstudiante()));
                    estudiante.setInscripcion(inscripcionRepository.findById(inscripcion.getIdCarrera(), inscripcion.getIdEstudiante()).getInscripcion());
                    itemReporte.addItem(estudiante);
                }
            }
            dto.addItemReporte(itemReporte);
        }

        return dto;
    }
}
