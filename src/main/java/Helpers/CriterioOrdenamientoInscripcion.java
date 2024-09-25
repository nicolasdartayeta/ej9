package Helpers;

public class CriterioOrdenamientoInscripcion implements CriterioOrdenamiento{

    private char alias;
    @Override
    public String getCriterioOrdenamiento() {
        return "ORDER BY " + this.alias + ".fecha_inscripcion ASC";
    }
    
}
