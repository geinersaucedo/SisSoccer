/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.ArrayList;
import java.util.Date;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import static proyectosissocer.frmPrincipal.gestor;

/**
 *
 * @author lsandoval
 */
public class Jornada implements TableModel{
   private int idJornada;
   private int numFecha;
   private int cantEncuentros_x_Jornada;
   private int idCampeonato;
   private ArrayList<Encuentro> listaEncuentro;

   public Jornada(){
    listaEncuentro = new ArrayList<Encuentro>();
   }
   
    public int getIdJornada() {
        return idJornada;
    }

    public void setIdJornada(int idJornada) {
        this.idJornada = idJornada;
    }

    public int getNumFecha() {
        return numFecha;
    }

    public void setNumFecha(int numFecha) {
        this.numFecha = numFecha;
    }

    public int getCantEncuentros_x_Jornada() {
        return cantEncuentros_x_Jornada;
    }

    public void setCantEncuentros_x_Jornada(int cantEncuentros_x_Jornada) {
        this.cantEncuentros_x_Jornada = cantEncuentros_x_Jornada;
    }

    public int getIdCampeonato() {
        return idCampeonato;
    }

    public void setIdCampeonato(int idCampeonato) {
        this.idCampeonato = idCampeonato;
    }

    public ArrayList<Encuentro> getListaEncuentro() {
        return listaEncuentro;
    }

    public void setListaEncuentro(ArrayList<Encuentro> listaEncuentro) {
        this.listaEncuentro = listaEncuentro;
    }

    @Override
    public int getRowCount() {
        return listaEncuentro.size();
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
                name="Fecha";
                break;
            case 1:
                name="VS";
                break;
            case 2:
                name="Visita";
                break;
            case 3:
                name="Visita";
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
        Encuentro j=listaEncuentro.get(rowIndex);
        
        switch(columnIndex){
            case 0:
                return j.getFechaEncuentro();
            case 1:
                return j.getNombreEquipoLocal() ;
                //return j.getIdEquipoLocal();
            case 2:
                return "vs";
                //return j.getIdEquipoVisita();
            case 3:
                return j.getNombreEquipoVisita() ;
                //return j.getIdEquipoVisita();
            default:
                return null;
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Encuentro j=listaEncuentro.get(rowIndex);
        
        switch(columnIndex){
            case 0:
                j.setFechaEncuentro((Date)aValue);
            case 2:
                j.setNombreEquipoLocal((String)aValue);
            case 3:
                j.setNombreEquipoVisita((String)aValue);    
        }       
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
        
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
        
    }
   
    public void agregarEncuentro(Encuentro ObjEncuentro){
        listaEncuentro.add(ObjEncuentro);
    }
}
