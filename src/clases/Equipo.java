
package clases;

import java.util.ArrayList;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author Geiner Saucedo
 */
public class Equipo implements TableModel{
    private int idEquipo;
    private Delegado delegado;
    private String nomEquipoLargo;
    private String nomEquipoCorto;
    private ArrayList<Jugador> listaJugadores;

    public Equipo(ArrayList<Jugador> listaJugadores) {
        this.listaJugadores = listaJugadores;
    }
    public Equipo() {
        listaJugadores = new ArrayList<Jugador>();
    }
        
    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public Delegado getDelegado() {
        return delegado;
    }

    public void setDelegado(Delegado delegado) {
        this.delegado = delegado;
    }

    public String getNomEquipoLargo() {
        return nomEquipoLargo;
    }

    public void setNomEquipoLargo(String nomEquipoLargo) {
        this.nomEquipoLargo = nomEquipoLargo;
    }

    public String getNomEquipoCorto() {
        return nomEquipoCorto;
    }

    public void setNomEquipoCorto(String nomEquipoCorto) {
        this.nomEquipoCorto = nomEquipoCorto;
    }

    public ArrayList<Jugador> getListaJugadores() {
        return listaJugadores;
    }

    public void setListaJugadores(ArrayList<Jugador> listaJugadores) {
        this.listaJugadores = listaJugadores;
    }

    public void agregarJugador(Jugador jugador){
        listaJugadores.add(jugador);
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
