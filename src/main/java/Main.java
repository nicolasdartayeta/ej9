import Factories.JPARepositoryFactory;
import Helpers.CriterioBusqueda;
import Helpers.CriterioBusquedaCiudadResidencia;
import Helpers.CriterioOrdenamientoGenero;
import Modelos.Estudiante;
import Repositories.CarreraRepository;
import Repositories.EstudianteRepository;
import Repositories.InscripcionRepository;
import Repositories.JPAImplementation.JPACarreraRepository;
import Repositories.JPAImplementation.JPAEstudianteRepository;
import Repositories.JPAImplementation.JPAInscripcionRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        JPARepositoryFactory repositoryFactory = JPARepositoryFactory.getInstance();

        EstudianteRepository er = repositoryFactory.getEstudianteRepository();
        CarreraRepository cr = repositoryFactory.getCarreraRepository();
        InscripcionRepository ir = repositoryFactory.getInscripcionRepository();

        int opcion = 1;
        Scanner scanner = new Scanner(System.in);

        while (opcion >= 0 ) {
            System.out.println("Ingresa opcion: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 0:
//                    dar de alta un estudiante
                    System.out.println("Ingrese el nombre del estudiante: ");
                    String nombre = scanner.next();
                    System.out.println("Ingrese el apellido del estudiante: ");
                    String apellido = scanner.next();
                    System.out.println("Ingrese la edad del estudiante: ");
                    int edad = scanner.nextInt();
                    System.out.println("Ingrese el genero del estudiante (m/f): ");
                    char genero = scanner.next().charAt(0);
                    System.out.println("Ingrese el dni del estudiante: ");
                    int dni = scanner.nextInt();
                    System.out.println("Ingrese la ciudad del estudiante: ");
                    String ciudad = scanner.next();
                    System.out.println("Ingrese la libreta del estudiante: ");
                    int libreta = scanner.nextInt();

                    er.persist(new Estudiante(nombre,apellido,edad,genero,dni,ciudad,libreta));
                    break;
                case 1:
//                    matricular un estudiante en una carrera
                    break;
                case 2:
//                    recuperar todos los estudiantes, y especificar algún criterio de ordenamiento simple.
                    break;
                case 3:
//                    recuperar un estudiante, en base a su número de libreta universitaria.
                    break;
                case 4:
//                    recuperar todos los estudiantes, en base a su género.
                    System.out.println(er.findOrdenadoByCriterio(new CriterioOrdenamientoGenero('e')));
                    break;
                case 5:
//                    recuperar las carreras con estudiantes inscriptos, y ordenar por cantidad de inscriptos.
                    System.out.println(cr.getCarrrerasConInscriptos());
                    break;
                case 6:
//                    recuperar los estudiantes de una determinada carrera, filtrado por ciudad de residencia.
                    System.out.println("Ingrese ciudad: ");
                    String ciudad2 = scanner.next();

                    System.out.println(er.findByCriterio(new CriterioBusquedaCiudadResidencia(ciudad2, 'e')));
                    break;
                case 7:
//                    Generar un reporte de las carreras, que para cada carrera incluya información de los
//                    inscriptos y egresados por año. Se deben ordenar las carreras alfabéticamente, y presentar los años de manera cronológica.
                    break;

            }
        }
    }

}
