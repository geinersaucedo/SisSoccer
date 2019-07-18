package vistas;

import clases.Encuentro;
import clases.Equipo;
import clases.Jornada;
import java.util.ArrayList;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class vistaTablaPosiciones implements TableModel{
    private ArrayList<Equipo> listaEquipos;
    private ArrayList<Jornada> listaJornadas;

    public ArrayList<Jornada> getListaJornadas() {
        return listaJornadas;
    }

    public void setListaJornadas(ArrayList<Jornada> listaJornadas) {
        this.listaJornadas = listaJornadas;
    }
    
    public ArrayList<Equipo> getListaEquipos() {
        return listaEquipos;
    }

    public void setListaEquipos(ArrayList<Equipo> listaEquipos) {
        this.listaEquipos = listaEquipos;
    }

    @Override
    public int getRowCount() {
        return listaEquipos.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public String getColumnName(int columnIndex) {
        String name=null;
        switch(columnIndex){
            case 0:
                name="Equipo";
                break;
            case 1:
                name="GF";
                break;
            case 2:
                name="GC";
                break;
            case 3:
                name="DG";
                break;
            case 4:
                name="PJ";
                break;
            case 5:
                name="Puntos";
                break;
        }
        return name;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return String.class;
            default:
                return Integer.class;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Equipo objEquipo=listaEquipos.get(rowIndex);
        int gf,gc,dg,pj,puntos;gf=gc=dg=pj=puntos=0;
        for(Jornada j: listaJornadas){
            for(Encuentro e:j.getListaEncuentro()){
                if (e.getIdEquipoLocal()==objEquipo.getIdEquipo() || e.getIdEquipoVisita()==objEquipo.getIdEquipo()) {
                    gf+=e.getGoles_x_Equipo(objEquipo.getIdEquipo());
                    gc+=e.getGolesEnContra_x_Equipo(objEquipo.getIdEquipo());

                    if (e.getEstado().equals("J") || e.getEstado().equals("W")) {
                        pj++;
                        if (e.getGoles_x_Equipo(objEquipo.getIdEquipo())>e.getGolesEnContra_x_Equipo(objEquipo.getIdEquipo())){
                            puntos+=3;
                        }else{
                            if (e.getGoles_x_Equipo(objEquipo.getIdEquipo())==e.getGolesEnContra_x_Equipo(objEquipo.getIdEquipo())){
                                puntos++;
                            }
                        }
                    }
                }
            }
        }
        //gf=listaJornadas.get(rowIndex)
        dg=gf-gc;
        switch(columnIndex){
        case 0:
            return objEquipo.getNomEquipoCorto();
        case 1:
            return gf;
        case 2:
            return gc;
        case 3:
            return dg;
        case 4:
            return pj;
        case 5:
            return puntos;
        default:
            return null;
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
        
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
        
    }
    
}
