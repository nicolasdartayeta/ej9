package Helpers;

public class CriterioAND extends CriterioOperacionBinaria{
    public CriterioAND(CriterioBusqueda criterioBusqueda1, CriterioBusqueda criterioBusqueda2) {
        super(criterioBusqueda1, criterioBusqueda2);
    }

    @Override
    public String getCriterioBusqueda() {
        return criterioBusqueda1.getCriterioBusqueda() + " AND " + criterioBusqueda2.getCriterioBusqueda();
    }
}
