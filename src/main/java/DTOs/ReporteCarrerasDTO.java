package DTOs;

import Modelos.Carrera;

import java.util.List;

public class ReporteCarrerasDTO {
    public class ItemReporte {
        public class DatosAnio {
            private int anio;
            private int inscriptos;
            private int egresados;

            public DatosAnio(int anio, int inscriptos, int egresados) {
                this.anio = anio;
                this.inscriptos = inscriptos;
                this.egresados = egresados;
            }

            public int getAnio() {
                return anio;
            }

            public void setAnio(int anio) {
                this.anio = anio;
            }

            public int getInscriptos() {
                return inscriptos;
            }

            public void setInscriptos(int inscriptos) {
                this.inscriptos = inscriptos;
            }

            public int getEgresados() {
                return egresados;
            }

            public void setEgresados(int egresados) {
                this.egresados = egresados;
            }
        }

        private Carrera carrera;
        List<DatosAnio> datosAnios;

        public ItemReporte(Carrera carrera) {
            this.carrera = carrera;
        }

        public Carrera getCarrera() {
            return carrera;
        }

        public void addItem(DatosAnio datosAnio) {
            this.datosAnios.add(datosAnio);
        }

        public List<DatosAnio> getDatosAnios() {
            return datosAnios;
        }
    }

    private List<ItemReporte> itemReporte;
}
