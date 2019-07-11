
package clases;

import java.util.ArrayList;
/**
 *
 * @author Geiner Saucedo
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
    
    public void agregarCampeonato(Campeonato camp){
        listaCampeonatos.add(camp);
    }
    public Campeonato buscarCampeonato(String nomCampeonato){
        for(Campeonato c:listaCampeonatos){
            if (c.getNombreCampeonato().equals(nomCampeonato)) {
                return c;
            }
        }
        return null;
    }
    
    public Campeonato buscarCampeonatoById(int idCampeonato){
        for(Campeonato c:listaCampeonatos){
            if (c.getIdCampeonato()== idCampeonato) {
                return c;
            }
        }
        return null;
    }

}
