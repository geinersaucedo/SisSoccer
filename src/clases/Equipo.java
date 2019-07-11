
package clases;

import java.util.ArrayList;
/**
 *
 * @author Geiner Saucedo
 */
public class Equipo{
    
    private int idEquipo;
    private Delegado delegado;
    private String nomEquipoLargo;
    private String nomEquipoCorto;
    private ArrayList<Jugador> listaJugadores;

    public Equipo(ArrayList<Jugador> listaJugadores) {
        this.listaJugadores = listaJugadores;
    }
    public Equipo() {
        listaJugadores = new ArrayList<Jugador>();
    }
        
    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public Delegado getDelegado() {
        return delegado;
    }

    public void setDelegado(Delegado delegado) {
        this.delegado = delegado;
    }

    public String getNomEquipoLargo() {
        return nomEquipoLargo;
    }

    public void setNomEquipoLargo(String nomEquipoLargo) {
        this.nomEquipoLargo = nomEquipoLargo;
    }

    public String getNomEquipoCorto() {
        return nomEquipoCorto;
    }

    public void setNomEquipoCorto(String nomEquipoCorto) {
        this.nomEquipoCorto = nomEquipoCorto;
    }

    public ArrayList<Jugador> getListaJugadores() {
        return listaJugadores;
    }

    public void setListaJugadores(ArrayList<Jugador> listaJugadores) {
        this.listaJugadores = listaJugadores;
    }

    public void agregarJugador(Jugador jugador){
        listaJugadores.add(jugador);
    }
    
    public Jugador getIdJugador_ByNombresCompletos(String pNombresCompletos){
        for (Jugador j: listaJugadores) {
            if((j.getNombre()+" " + j.getApellidos()).equals(pNombresCompletos)) return j;
        }
        return new Jugador();
    }
}
