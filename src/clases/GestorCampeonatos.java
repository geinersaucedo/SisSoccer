
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
    
    public void ActualizarCampeonato(Campeonato pCamp){
        for (Campeonato c: listaCampeonatos) {
            if(c.getIdCampeonato()==pCamp.getIdCampeonato()){
                listaCampeonatos.remove(c);
                listaCampeonatos.add(pCamp);
            }
        }
    }
    
    public void EliminarCampeonato(int pIdCampeonato){
        for (Campeonato c: listaCampeonatos) {
            if(c.getIdCampeonato()==pIdCampeonato){
                listaCampeonatos.remove(c);
                return;
            }
        }
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
