/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import clases.Encuentro;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author lsandoval
 */
public class vistaEncuentrosModoLiga implements TableModel{

    ArrayList<Encuentro> ObjListaEncuentro ;

    public vistaEncuentrosModoLiga() {
        ObjListaEncuentro = new ArrayList<Encuentro>();
    }
    
    public ArrayList<Encuentro> getObjListaEncuentro() {
        return ObjListaEncuentro;
    }

    public void setObjListaEncuentro(ArrayList<Encuentro> ObjListaEncuentro) {
        this.ObjListaEncuentro = ObjListaEncuentro;
    }

    @Override
    public int getRowCount() {
        return ObjListaEncuentro.size();
    }

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public String getColumnName(int columnIndex) {
        String name=null;
        switch(columnIndex){
            case 0:
                name="ID";
                break;
            case 1:
                name="Fecha";
                break;
            case 2:
                name="Local";
                break;
            case 3:
                name="Goles";
                break;                
            case 4:
                name="vs";
                break;                
            case 5:
                name="Visita";
                break;  
            case 6:
                name="Goles";
                break;  
            case 7:
                name="Estado";
                break;                  
        }
        return name;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch(columnIndex){
            case 1:
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
        Encuentro j=ObjListaEncuentro.get(rowIndex);
        
        switch(columnIndex){
            case 0:
                return j.getIdEncuentro();
            case 1:
                return j.getFechaEncuentro();                
            case 2:
                return j.getNombreEquipoLocal() ;
                //return j.getIdEquipoLocal();
            case 3:
                return j.getGoles_x_Equipo(j.getIdEquipoLocal()) ;
                //return j.getIdEquipoVisita();                
            case 4:
                return "vs";
                //return j.getIdEquipoVisita();
            case 5:
                return j.getNombreEquipoVisita() ;
                //return j.getIdEquipoVisita();
            case 6:
                return j.getGoles_x_Equipo(j.getIdEquipoVisita()) ;
            case 7:
                if(j.getEstado().equals("P"))return "Pendiente";
                else if(j.getEstado().equals("J"))return "Jugado";
                else if(j.getEstado().equals("W"))return "Walk Over";
            default:
                return null;
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Encuentro j=ObjListaEncuentro.get(rowIndex);
        
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
 
    
}
