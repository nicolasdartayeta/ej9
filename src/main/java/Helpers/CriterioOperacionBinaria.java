package Helpers;

public abstract class CriterioOperacionBinaria implements CriterioBusqueda {
    protected CriterioBusqueda criterioBusqueda1;
    protected CriterioBusqueda criterioBusqueda2;

    public CriterioOperacionBinaria(CriterioBusqueda criterioBusqueda1, CriterioBusqueda criterioBusqueda2) {
        this.criterioBusqueda1 = criterioBusqueda1;
        this.criterioBusqueda2 = criterioBusqueda2;
    }
}
