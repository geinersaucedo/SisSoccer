package vistas;

import clases.Tarjeta;
import java.util.ArrayList;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class vistaTarjetasRojas implements TableModel{
    ArrayList<Tarjeta> listaTarjetasRojas;

    public ArrayList<Tarjeta> getListaTarjetasRojas() {
        return listaTarjetasRojas;
    }

    public void setListaTarjetasRojas(ArrayList<Tarjeta> listaTarjetasRojas) {
        this.listaTarjetasRojas = listaTarjetasRojas;
    }
//Equipo,Jugador,Fecha,Cantidad
    @Override
    public int getRowCount() {
        return listaTarjetasRojas.size();
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
                name="Equipo";
                break;
            case 1:
                name="Jugador";
                break;
            case 2:
                name="NumFecha";
                break;
        }
        return name;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 2:
                return Integer.class;
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
        Tarjeta t=listaTarjetasRojas.get(rowIndex);
        
        switch(columnIndex){
            case 0:
                return t.getNomEquipo();
            case 1:
                return t.getNomJugador();
            case 2:
                return t.getNumFecha();                            
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
