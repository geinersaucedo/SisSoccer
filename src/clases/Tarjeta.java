package clases;

/**
 * Clase que contiene los atributos y metodos necesario para un ..............
 * @author Giraldo Emilio, Mamani Omar, Saucedo Geiner, Villagaray Rodolfo
 * @version 1.0
 */
public class Tarjeta extends Evento{
    private String colorTarjeta;

    public String getColorTarjeta() {
        return colorTarjeta;
    }

    public void setColorTarjeta(String colorTarjeta) {
        this.colorTarjeta = colorTarjeta;
    }
    
    /**
     * Metodo que permite validar una tarjeta
     * @return 
     */
    public boolean validaTarjeta(){
        if(getNomEquipo().equals("Seleccionar") || getNomJugador().equals("Seleccionar") || getColorTarjeta().equals("Seleccionar") )
            return false;
        else 
            return true;
    }    
}
