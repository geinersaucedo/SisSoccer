/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import clases.Jugador;
import java.util.ArrayList;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author lsandoval
 */
public class vistaJugadores implements TableModel {

    private ArrayList<Jugador> listaJugadores;

    public vistaJugadores() {
        listaJugadores = new ArrayList<Jugador>();
    }

    public ArrayList<Jugador> getListaJugadores() {
        return listaJugadores;
    }

    public void setListaJugadores(ArrayList<Jugador> listaJugadores) {
        this.listaJugadores = listaJugadores;
    }
    
    
    @Override
    public int getRowCount() {
        return listaJugadores.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public String getColumnName(int columnIndex) {
        String name=null;
        switch(columnIndex){
            case 0:
                name="DNI";
                break;
            case 1:
                name="Nombres";
                break;
            case 2:
                name="Apellidos";
                break;
            case 3:
                name="Direccion";
                break;
            case 4:
                name="Telefono";
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
        Jugador j=listaJugadores.get(rowIndex);
        
        switch(columnIndex){
            case 0:
                return j.getDni();
            case 1:
                return j.getNombre();
            case 2:
                return j.getApellidos();
            case 3:
                return j.getDireccion();
            case 4:
                return j.getTelefono();
            default:
                return null;
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Jugador j =listaJugadores.get(rowIndex);
        
        switch(columnIndex){
            case 0:
                j.setDni((String)aValue);
            case 1:
                j.setNombre((String)aValue);
            case 2:
                j.setApellidos((String)aValue);
            case 3:
                j.setDireccion((String)aValue);
            case 4:
                j.setTelefono((String)aValue);
        }
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
        
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }
}
