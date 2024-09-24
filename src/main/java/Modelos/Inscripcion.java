package Modelos;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "inscripcion")
@IdClass(InscripcionId.class)
public class Inscripcion {
    @Id
    @Column(name = "inscripcion_id_estudiante")
    private int inscripcion_id_estudiante;

    @Id
    @Column(name = "inscripcion_id_carrera")
    private int inscripcion_id_carrera;

    @ManyToOne
    @JoinColumn(name = "inscripcion_id_estudiante", insertable = false, updatable = false)
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "inscripcion_id_carrera", insertable = false, updatable = false)
    private Carrera carrera;

    @Column(name = "fecha_inscripcion")
    private Date fecha_inscripcion;

    @Column(name = "graduado")
    private boolean graduado;

    @Override
    public String toString() {
        return "Inscripcion{" +
                "inscripcion_id_estudiante=" + inscripcion_id_estudiante +
                ", inscripcion_id_carrera=" + inscripcion_id_carrera +
                ", fecha_inscripcion=" + fecha_inscripcion +
                ", graduado=" + graduado +
                '}';
    }
}
