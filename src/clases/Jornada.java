package clases;

import java.util.ArrayList;

/**
 * Clase que contiene los atributos y métodos necesario para una jornada
 * @author Giraldo Emilio, Mamani Omar, Saucedo Geiner, Villagaray Rodolfo
 * @version 1.0
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

    /**
     *Metodo que permite agregar un encuentro 
     * @param ObjEncuentro Objeto Encuentro
     */   
    public void agregarEncuentro(Encuentro ObjEncuentro){
        listaEncuentro.add(ObjEncuentro);
    }
    
    /**
     * Metodo que permite obtener un encuentro según el ID
     * @param pIdEncuentro Id del Encuentro
     * @return Encuentro e
     */
    public Encuentro getEncuentro_ById(int pIdEncuentro) {
        for (Encuentro e:listaEncuentro) {
            if(e.getIdEncuentro()==pIdEncuentro){
                return e;
            }
        }
        return new Encuentro();
    }    
}
