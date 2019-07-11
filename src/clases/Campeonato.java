
package clases;


import java.util.ArrayList;
import java.util.Date;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author Geiner Saucedo
 */
public class Campeonato implements TableModel{
    private int idCampeonato;
    private String nombreCampeonato;
    private String organizador;
    private int cantidadEquipos;
    private int tipoCampeonato;
    private String montoPremio;
    private ArrayList<Equipo> listaEquipos;
    private Date fechaInicio;

    private int golesWalkover;
    private Fixture objFixture;

    public Fixture getObjFixture() {
        return objFixture;
    }

    public void setObjFixture(Fixture objFixture) {
        this.objFixture = objFixture;
    }

    public int getGolesWalkover() {
        return golesWalkover;
    }

    public void setGolesWalkover(int golesWalkover) {
        this.golesWalkover = golesWalkover;
    }

    
    public Equipo buscarEquipo(int idEquipo){
        for (Equipo objEquipo : listaEquipos) {
            if(objEquipo.getIdEquipo()== idEquipo){
                return objEquipo;
            }
        }
        return null;
    }

    public Campeonato(ArrayList<Equipo> listaEquipos) {
        this.listaEquipos = listaEquipos;
    }
    public Campeonato() {
        listaEquipos=new ArrayList<>();
    }

    
    public int getIdCampeonato() {
        return idCampeonato;
    }

    public void setIdCampeonato(int idCampeonato) {
        this.idCampeonato = idCampeonato;
    }

    public String getNombreCampeonato() {
        return nombreCampeonato;
    }

    public void setNombreCampeonato(String nombreCampeonato) {
        this.nombreCampeonato = nombreCampeonato;
    }

    public String getOrganizador() {
        return organizador;
    }

    public void setOrganizador(String organizador) {
        this.organizador = organizador;
    }

    public int getCantidadEquipos() {
        return cantidadEquipos;
    }

    public void setCantidadEquipos(int cantidadEquipos) {
        this.cantidadEquipos = cantidadEquipos;
    }

    public int getTipoCampeonato() {
        return tipoCampeonato;
    }

    public void setTipoCampeonato(int tipoCampeonato) {
        this.tipoCampeonato = tipoCampeonato;
    }

    public String getMontoPremio() {
        return montoPremio;
    }

    public void setMontoPremio(String montoPremio) {
        this.montoPremio = montoPremio;
    }

    public ArrayList<Equipo> getListaEquipos() {
        return listaEquipos;
    }

    public void setListaEquipos(ArrayList<Equipo> listaEquipos) {
        this.listaEquipos = listaEquipos;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    /**
     * Método que permite validar que los datos del campeonato sean correctos
     * @return verdadero si pasa la validación
     */
    public boolean validaCampeonato(){
        if (fechaInicio!=null &&idCampeonato>=0&&
                !nombreCampeonato.equals("")&& !organizador.equals("")&&!montoPremio.equals("")) {
            return true;
        }else return false;
    }
    public void agregarEquipo(Equipo equipo){
        //Agregar validación, para agregar equipo el size de lista jugadores debe ser max de 12, min de 8
        listaEquipos.add(equipo);
    }
    
    public String getNomEquipoCorto_ById(int pIdEquipo) {
        for (Equipo e:listaEquipos) {
            if(e.getIdEquipo()==pIdEquipo) return e.getNomEquipoCorto();
        }
        return "-";
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
