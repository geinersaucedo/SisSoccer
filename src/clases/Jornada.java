/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.ArrayList;

/**
 *
 * @author lsandoval
 */
public class Jornada {
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

   
    public void agregarEncuentro(Encuentro ObjEncuentro){
        listaEncuentro.add(ObjEncuentro);
    }
    

    public Encuentro getEncuentro_ById(int pIdEncuentro) {
        for (Encuentro e:listaEncuentro) {
            if(e.getIdEncuentro()==pIdEncuentro){
                return e;
            }
        }
        return new Encuentro();
    }    
}
