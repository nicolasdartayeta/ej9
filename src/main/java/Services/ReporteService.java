package Services;


import java.util.List;

import DTOs.ReporteCarrerasDTO;
import DTOs.ReporteCarrerasDTO.ItemReporte;
import DTOs.ReporteCarrerasDTO.ItemReporte.EstudianteFecha;
import Helpers.CriterioOrdenamiento;
import Helpers.CriterioOrdenamientoInscripcion;
import Helpers.CriterioOrdenamientoNombre;
import Modelos.Carrera;
import Modelos.Inscripcion;
import Repositories.CarreraRepository;
import Repositories.EstudianteRepository;
import Repositories.InscripcionRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class ReporteService {
    
    public void getReporte(){

        EntityManager em = Persistence.createEntityManagerFactory("persistencia").createEntityManager();
        CarreraRepository cr = new CarreraRepository(em);
        InscripcionRepository ir = new InscripcionRepository(em);
        EstudianteRepository er =  new EstudianteRepository(em);

        CriterioOrdenamiento crit = new CriterioOrdenamientoNombre('c');
        List<Carrera> lista_carrera = cr.getAllCarrerasOrdenadas(crit);

        CriterioOrdenamiento crit2 = new CriterioOrdenamientoInscripcion('i');
        List<Inscripcion> lista_inscripcion = ir.getAllCarrerasOrdenadas(crit2);
        
        ReporteCarrerasDTO dto = new ReporteCarrerasDTO();

        for (Carrera carrera: lista_carrera){
            ItemReporte itemReporte = dto.new ItemReporte(carrera);
            for(Inscripcion inscripcion: lista_inscripcion){
                if (inscripcion.getCarrera().equals(carrera)){
                    EstudianteFecha estudiante = itemReporte.new EstudianteFecha(er.getById(inscripcion.getIdEstudiante()));
                    estudiante.setInscripcion(ir.findById(inscripcion.getIdCarrera(), inscripcion.getIdEstudiante()).getInscripcion());
                    itemReporte.addItem(estudiante);
                }
            }
            dto.addItemReporte(itemReporte);
        }

        System.out.println(dto);
    }
}
