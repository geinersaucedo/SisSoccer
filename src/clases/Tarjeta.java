/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author lsandoval
 */
public class Tarjeta extends Evento{
    private String colorTarjeta;

    public String getColorTarjeta() {
        return colorTarjeta;
    }

    public void setColorTarjeta(String colorTarjeta) {
        this.colorTarjeta = colorTarjeta;
    }
    
    public boolean validaTarjeta(){
        if(getNomEquipo().equals("Seleccionar") || getNomJugador().equals("Seleccionar") || getColorTarjeta().equals("Seleccionar") )
            return false;
        else 
            return true;
    }    
}
