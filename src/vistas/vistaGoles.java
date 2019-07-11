/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import clases.Gol;
import java.util.ArrayList;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author lsandoval
 */
public class vistaGoles implements TableModel{

    private ArrayList<Gol> listaGoles;

    public ArrayList<Gol> getListaGoles() {
        return listaGoles;
    }

    public void setListaGoles(ArrayList<Gol> listaGoles) {
        this.listaGoles = listaGoles;
    }        
    
    @Override
    public int getRowCount() {
        return listaGoles.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public String getColumnName(int columnIndex) {
        String name=null;
        switch(columnIndex){
            case 0:
                name="Id";
                break;
            case 1:
                name="Equipo";
                break;
            case 2:
                name="Jugador";
                break;
            case 3:
                name="Tipo Gol";
                break;                
        }
        return name;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;        
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Gol j=listaGoles.get(rowIndex);
        
        switch(columnIndex){
            case 0:
                return j.getIdEvento();
            case 1:
                return j.getNomEquipo();                
            case 2:
                return j.getNomJugador();                                
            case 3:
                return j.getTipoGol();
            default:
                return null;
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Gol j=listaGoles.get(rowIndex);
        
        switch(columnIndex){
            case 0:
                j.setIdEvento((int)aValue);
            case 1:
                j.setNomEquipo((String)aValue);
            case 2:
                j.setNomJugador((String)aValue);    
            case 3:
                j.setTipoGol((String)aValue);    
        }       
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
        
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
        
    }       
}
