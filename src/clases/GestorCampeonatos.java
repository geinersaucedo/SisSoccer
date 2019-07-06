
package clases;

import java.util.ArrayList;
import java.util.Date;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author Geiner Saucedo
 */
public class GestorCampeonatos implements TableModel{
    private int idGestorCampeonatos;
    private ArrayList<Campeonato> listaCampeonatos;

    public GestorCampeonatos(ArrayList<Campeonato> lista) {
        listaCampeonatos=lista;
    }

    public int getIdGestorCampeonatos() {
        return idGestorCampeonatos;
    }

    public void setIdGestorCampeonatos(int idGestorCampeonatos) {
        this.idGestorCampeonatos = idGestorCampeonatos;
    }

    public ArrayList<Campeonato> getListaCampeonatos() {
        return listaCampeonatos;
    }

    public void setListaCampeonatos(ArrayList<Campeonato> listaCampeonatos) {
        this.listaCampeonatos = listaCampeonatos;
    }
    
    public void agregarCampeonato(Campeonato camp){
        listaCampeonatos.add(camp);
    }
    public Campeonato buscarCampeonato(String nomCampeonato){
        for(Campeonato c:listaCampeonatos){
            if (c.getNombreCampeonato().equals(nomCampeonato)) {
                return c;
            }
        }
        return null;
    }
<<<<<<< HEAD
    
    public Campeonato buscarCampeonatoById(int idCampeonato){
        for(Campeonato c:listaCampeonatos){
            if (c.getIdCampeonato()== idCampeonato) {
                return c;
            }
        }
        return null;
    }
    
=======
>>>>>>> fc81c9af36c4937fcdd63473e51bf1bdf3cbb1d8
    @Override
    public int getRowCount() {
        return listaCampeonatos.size();
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
                name="Campeonato";
                break;
            case 2:
                name="Premio";
                break;
            case 3:
                name="Fecha Inicio";
                break;
        }
        return name;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return int.class;
            case 3:
                return Date.class;
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
        Campeonato c=listaCampeonatos.get(rowIndex);
        
        switch(columnIndex){
            case 0:
                return c.getIdCampeonato();
            case 1:
                return c.getNombreCampeonato();
            case 2:
                return c.getMontoPremio();
            case 3:
                return c.getFechaInicio();
            default:
                return null;
        }
        
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Campeonato c=listaCampeonatos.get(rowIndex);
        
        switch(columnIndex){
            case 0:
                c.setIdCampeonato((int)aValue);
            case 1:
                c.setNombreCampeonato((String)aValue);
            case 2:
                c.setMontoPremio((String)aValue);
            default:
                c.setFechaInicio((Date)aValue);
        }
    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }
}
