/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import clases.Encuentro;
import clases.Jornada;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author lsandoval
 */
public class clsVistaJornadaModoLiga implements TableModel{

    ArrayList<Encuentro> ObjListaEncuentro ;

    public ArrayList<Encuentro> getObjListaEncuentro() {
        return ObjListaEncuentro;
    }

    public void setObjListaEncuentro(ArrayList<Encuentro> ObjListaEncuentro) {
        this.ObjListaEncuentro = ObjListaEncuentro;
    }

    public clsVistaJornadaModoLiga() {
        ObjListaEncuentro = new ArrayList<Encuentro>();
    }

    @Override
    public int getRowCount() {
        return ObjListaEncuentro.size();
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
                name="ID";
                break;
            case 1:
                name="Fecha";
                break;
            case 2:
                name="Local";
                break;
            case 3:
                name="vs";
                break;                
            case 4:
                name="Visita";
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
                return "vs";
                //return j.getIdEquipoVisita();
            case 4:
                return j.getNombreEquipoVisita() ;
                //return j.getIdEquipoVisita();
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
