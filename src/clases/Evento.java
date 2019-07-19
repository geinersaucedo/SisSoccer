package clases;

/**
 * Clase que contiene los atributos y metodos necesario para un Evento,
 * estos atrivutos seran heredados por las clases Gol y Tarjeta
 * @author Giraldo Emilio, Mamani Omar, Saucedo Geiner, Villagaray Rodolfo
 * @version 1.0
 */
public abstract class Evento {
    private int idEvento;
    private int idJugador;
    private String nomJugador;
    private int idEquipo;
    private String nomEquipo;
    private int numFecha;

    public int getNumFecha() {
        return numFecha;
    }

    public void setNumFecha(int numFecha) {
        this.numFecha = numFecha;
    }
    
    public int getIdEvento() {
        return idEvento;
    }

    public String getNomJugador() {
        return nomJugador;
    }

    public void setNomJugador(String nomJugador) {
        this.nomJugador = nomJugador;
    }

    public String getNomEquipo() {
        return nomEquipo;
    }

    public void setNomEquipo(String nomEquipo) {
        this.nomEquipo = nomEquipo;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public int getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(int idJugador) {
        this.idJugador = idJugador;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }
    
    
}
