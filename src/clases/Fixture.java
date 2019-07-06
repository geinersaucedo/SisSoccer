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
public abstract class Fixture {
    private int idFixture;
    private int idCampeonato;
    private int cantidadJornadas;
    private ArrayList<Jornada> listaJornadas;

    public Fixture() {
        listaJornadas = new  ArrayList<Jornada>();
    }
    
    
    public int getIdFixture() {
        return idFixture;
    }

    public void setIdFixture(int idFixture) {
        this.idFixture = idFixture;
    }

    public int getIdCampeonato() {
        return idCampeonato;
    }

    public void setIdCampeonato(int idCampeonato) {
        this.idCampeonato = idCampeonato;
    }

    public int getCantidadJornadas() {
        return cantidadJornadas;
    }

    public void setCantidadJornadas(int cantidadJornadas) {
        this.cantidadJornadas = cantidadJornadas;
    }

    public ArrayList<Jornada> getListaJornadas() {
        return listaJornadas;
    }

    public void setListaJornadas(ArrayList<Jornada> listaJornadas) {
        this.listaJornadas = listaJornadas;
    }
    
    public void generarFixture(){
    
    }
    
    public void agregarJornada(Jornada objJornada){
        listaJornadas.add(objJornada);
    }
    
}
