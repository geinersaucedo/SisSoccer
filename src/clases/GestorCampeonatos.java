
package clases;

import java.util.ArrayList;
/**
 * Clase que contiene los atributos y metodos necesario para un ..............
 * @author Giraldo Emilio, Mamani Omar, Saucedo Geiner, Villagaray Rodolfo
 * @version 1.0
 */
public class GestorCampeonatos{
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
    
    /**
     * Metodo que permite agregar un campeonato
     * @param camp 
     */
    public void agregarCampeonato(Campeonato camp){
        listaCampeonatos.add(camp);
    }
    
    /**
     * Metodo que permite actualizar un campeonato
     * @param pCamp 
     */
    public void ActualizarCampeonato(Campeonato pCamp){
        for (Campeonato c: listaCampeonatos) {
            if(c.getIdCampeonato()==pCamp.getIdCampeonato()){
                listaCampeonatos.remove(c);
                listaCampeonatos.add(pCamp);
                break;
            }
        }
    }
    
    /**
     * Metodo que permite eliminar un campeonato segun el ID
     * @param pIdCampeonato 
     */
    public void EliminarCampeonato(int pIdCampeonato){
        for (Campeonato c: listaCampeonatos) {
            if(c.getIdCampeonato()==pIdCampeonato){
                listaCampeonatos.remove(c);
                break;
            }
        }
    }    
    
    /**
     * Metodo que permite buscar un campeonato según el nombre del campeonato
     * @param nomCampeonato
     * @return 
     */
    public Campeonato buscarCampeonato(String nomCampeonato){
        for(Campeonato c:listaCampeonatos){
            if (c.getNombreCampeonato().equals(nomCampeonato)) {
                return c;
            }
        }
        return null;
    }
    
    /**
     * Metodo que permite buscar un campeonato segun el ID
     * @param idCampeonato
     * @return Campeonato c
     */
    public Campeonato buscarCampeonatoById(int idCampeonato){
        for(Campeonato c:listaCampeonatos){
            if (c.getIdCampeonato()== idCampeonato) {
                return c;
            }
        }
        return null;
    }

    /**
     * Metodo que permite reOrdenar el ID la lista de campeonatos
     */
    public void ReordenarLista(){
        ArrayList<Campeonato> OrderListaCampeonato = new ArrayList<Campeonato>();
        int row=1;
        for (Campeonato c:listaCampeonatos) {
            c.setIdCampeonato(row);
            OrderListaCampeonato.add(c);           
            row++;
        }
        setListaCampeonatos(OrderListaCampeonato);
    }      
}
