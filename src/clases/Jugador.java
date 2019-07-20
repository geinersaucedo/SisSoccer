
package clases;

import javax.swing.JOptionPane;

/**
 * Clase que contiene los atributos y métodos necesarios para un jugador
 * @author Giraldo Emilio, Mamani Omar, Saucedo Geiner, Villagaray Rodolfo
 * @version 1.0
 */
public class Jugador extends Persona{
    private int idJugador;
    private int numCamiseta;
    private String posicion;

    public int getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(int idJugador) {
        this.idJugador = idJugador;
    }

    public int getNumCamiseta() {
        return numCamiseta;
    }

    public void setNumCamiseta(int numCamiseta) {
        this.numCamiseta = numCamiseta;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }
    
    /**
     * Metodo que permite Validar un juegador
     * @return boolean True o False
     */
    @Override
    public boolean valida(){
        if (this.getNombre().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingresar nombre","Datos incompletos",JOptionPane.WARNING_MESSAGE);
            return false;
        }else{
            if (this.getApellidos().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Ingresar apellidos","Datos incompletos",JOptionPane.WARNING_MESSAGE);
                return false;
            }else{
                if (numCamiseta<1 || numCamiseta>100) {
                    JOptionPane.showMessageDialog(null, "Ingresar Camiseta correcta 1-99","Datos incompletos",JOptionPane.WARNING_MESSAGE);
                    return false;
                }else{
                    if (this.getTelefono().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Ingresar teléfono","Datos incompletos",JOptionPane.WARNING_MESSAGE);
                        return false;
                    }else{
                        if (this.getDireccion().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Ingresar dirección","Datos incompletos",JOptionPane.WARNING_MESSAGE);
                            return false;
                        }else{
                            if (this.getDni().isEmpty()) {
                                JOptionPane.showMessageDialog(null, "Ingresar DNI","Datos incompletos",JOptionPane.WARNING_MESSAGE);
                                return false;
                            }else{
                                return true;
                            }
                        }
                    }
                }
            }
        }
    }
}
