package clases;

import java.util.ArrayList;

/**
 * Clase que contiene los atributos y metodos necesario para un ..............
 * @author Giraldo Emilio, Mamani Omar, Saucedo Geiner, Villagaray Rodolfo
 * @version 1.0
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
    
    public void generarFixture(){}
    
    /**
     * Metodo que permite agregar una jornada a la lista de Jornadas del fixture
     * @param objJornada 
     */
    public void agregarJornada(Jornada objJornada){
        listaJornadas.add(objJornada);
    }
    
    /**
     * Metodo que permite obtener una Jornada según el numero de fecha
     * @param pNumFecha
     * @return Jornada e
     */
    public Jornada getJornadas_ByNumFecha(int pNumFecha) {
        for (Jornada e: listaJornadas) {
            if(e.getNumFecha()==pNumFecha){
                return e;
            }
        }
       return new Jornada();
    }    
    
}
