/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import clases.Equipo;
import java.util.ArrayList;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author lsandoval
 */
public class vistaEquipos implements TableModel{
    private ArrayList<Equipo> listaEquipos;

    public vistaEquipos() {
        this.listaEquipos = new ArrayList<Equipo>();
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
        return 3;
    }

    @Override
    public String getColumnName(int columnIndex) {
        String name=null;
        switch(columnIndex){
            case 0:
                name="Id";
                break;
            case 1:
                name="Nombre Corto";
                break;
            case 2:
                name="Nombre Largo";
                break;
        }
        return name;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return int.class;
            default:
                return String.class;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Equipo c=listaEquipos.get(rowIndex);
        
        switch(columnIndex){
            case 0:
                return c.getIdEquipo();
            case 1:
                return c.getNomEquipoCorto();
            case 2:
                return c.getNomEquipoLargo();
            default:
                return null;
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Equipo c=listaEquipos.get(rowIndex);
        
        switch(columnIndex){
            case 0:
                c.setIdEquipo((int)aValue);
            case 1:
                c.setNomEquipoCorto((String)aValue);
            case 2:
                c.setNomEquipoLargo((String)aValue);
        }
    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }
    
}
