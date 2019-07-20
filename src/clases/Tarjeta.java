package clases;

/**
 * Clase que contiene los atributos y métodos necesarios generar una tarjeta
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
     * @return boolean True o False
     */
    public boolean validaTarjeta(){
        if(getNomEquipo().equals("Seleccionar") || getNomJugador().equals("Seleccionar") || getColorTarjeta().equals("Seleccionar") )
            return false;
        else 
            return true;
    }    
}
