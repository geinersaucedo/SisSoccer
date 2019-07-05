
package clases;

import javax.swing.JOptionPane;

/**
 *
 * @author Geiner Saucedo
 */
public class Delegado extends Persona{
    private int idDelegado;

    public int getIdDelegado() {
        return idDelegado;
    }

    public void setIdDelegado(int idDelegado) {
        this.idDelegado = idDelegado;
    }
    public boolean validarDelegado(){
        if (this.getDni().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingresar DNI","Datos incompletos",JOptionPane.WARNING_MESSAGE);
            return false;
        }else{
            if (this.getNombre().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Ingresar nombre","Datos incompletos",JOptionPane.WARNING_MESSAGE);
                return false;
            }else{
                if (this.getApellidos().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Ingresar apellidos","Datos incompletos",JOptionPane.WARNING_MESSAGE);
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
                            return true;
                        }
                    }
                }
            }
        }
    }
}
