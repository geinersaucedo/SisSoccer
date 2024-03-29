package clases;

/**
 * Clase que contiene los atributos y metodos necesarios para un registro de gol
 * @author Giraldo Emilio, Mamani Omar, Saucedo Geiner, Villagaray Rodolfo
 * @version 1.0
 */
public class Gol extends Evento{
    private String tipoGol;

    public String getTipoGol() {
        return tipoGol;
    }

    public void setTipoGol(String tipoGol) {
        this.tipoGol = tipoGol;
    }
   
    /**
     * Metodo que permite validar el registro del gol
     * @return boolean True o False
     */
    public boolean validaGol(){
        if(getNomEquipo().equals("Seleccionar") || getNomJugador().equals("Seleccionar") || getTipoGol().equals("Seleccionar") )
            return false;
        else 
            return true;
    }
}
