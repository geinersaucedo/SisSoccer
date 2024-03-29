
package proyectosissocer;

import clases.Campeonato;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import static proyectosissocer.frmPrincipal.gestor;
import vistas.vistaCampeonatos;

/**
 *
 * @author Geiner Saucedo
 */
public class frmNuevoCampeonato extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmNuevoCampeonato
     */
    private static frmNuevoCampeonato frm;
    public String vAccion="";
    public Campeonato vCampeonato;
    
    public static frmNuevoCampeonato getInstancia(){
        if (frm==null) {
            frm= new frmNuevoCampeonato();
        }
        return frm;
    }
    public frmNuevoCampeonato() {
        initComponents();
        vCampeonato =new Campeonato();
        tabPanel.setEnabledAt(1, false);
        vistaCampeonatos objVistaGestor = new vistaCampeonatos();
        objVistaGestor.setListaCampeonatos(frmPrincipal.gestor.getListaCampeonatos());
        listadoCampeonatos.setModel(objVistaGestor);
    }
    


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSalir = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        tabPanel = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listadoCampeonatos = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cbTipoCampeonato = new javax.swing.JComboBox<>();
        txtOrganizador = new javax.swing.JTextField();
        txtNombreCampeonato = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cbCantidadEquipos = new javax.swing.JComboBox<>();
        dateInicio = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        txtMontoPremio = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtNumGolesWalkover = new javax.swing.JSpinner();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Registro Campeonato");
        setToolTipText("");

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("REGISTRAR NUEVO CAMPEONATO");

        listadoCampeonatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "Campeonato", "Premio", "Fecha Inicio"
            }
        ));
        listadoCampeonatos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(listadoCampeonatos);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 615, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        tabPanel.addTab("Listado", jPanel1);

        jLabel2.setText("Nombre:");

        jLabel5.setText("Organizador");

        jLabel4.setText("Premio:");

        jLabel1.setText("Tipo:");

        cbTipoCampeonato.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Modo Eliminación", "Modo Liga" }));
        cbTipoCampeonato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipoCampeonatoActionPerformed(evt);
            }
        });

        jLabel7.setText("N° Equipos:");

        cbCantidadEquipos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "4", "8", "16", "32" }));

        jLabel8.setText("Fecha Inicio:");

        jLabel6.setText("Goles por Walkover:");

        txtNumGolesWalkover.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtNumGolesWalkover.setModel(new javax.swing.SpinnerNumberModel(0, 0, 15, 1));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtOrganizador)
                    .addComponent(txtNombreCampeonato)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtMontoPremio, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbCantidadEquipos, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(dateInicio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cbTipoCampeonato, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addComponent(txtNumGolesWalkover, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 409, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtNombreCampeonato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtOrganizador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtMontoPremio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbTipoCampeonato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbCantidadEquipos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel8))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtNumGolesWalkover, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(115, Short.MAX_VALUE))
        );

        tabPanel.addTab("Campeonato", jPanel2);

        btnGuardar.setText("Guardar");
        btnGuardar.setEnabled(false);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.setEnabled(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3)
                    .addComponent(tabPanel)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNuevo)
                        .addGap(18, 18, 18)
                        .addComponent(btnGuardar)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(164, 164, 164)
                                .addComponent(jSeparator1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        cambiarVista(0);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void cbTipoCampeonatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipoCampeonatoActionPerformed
        // TODO add your handling code here:
        if (cbTipoCampeonato.getSelectedIndex()==1) {
            cbCantidadEquipos.removeAllItems();
            for (int i = 4; i <= 32; i++) {
                cbCantidadEquipos.addItem(String.valueOf(i));
            }
        }
        else{
            cbCantidadEquipos.removeAllItems();
            cbCantidadEquipos.addItem("4");
            cbCantidadEquipos.addItem("8");
            cbCantidadEquipos.addItem("16");
            cbCantidadEquipos.addItem("32");
        }
    }//GEN-LAST:event_cbTipoCampeonatoActionPerformed

    private void cambiarVista(int tipo){
        if (tipo==0) {
            tabPanel.setEnabledAt(0, true);
            tabPanel.setEnabledAt(1, false);
            tabPanel.setSelectedIndex(0);
            btnNuevo.setEnabled(true);
            btnGuardar.setEnabled(false);
            btnCancelar.setEnabled(false);
            btnModificar.setEnabled(true);
            btnEliminar.setEnabled(true);
        }else{
            tabPanel.setEnabledAt(0, false);
            tabPanel.setEnabledAt(1, true);
            tabPanel.setSelectedIndex(1);
            btnNuevo.setEnabled(false);
            btnGuardar.setEnabled(true);
            btnCancelar.setEnabled(true);
            btnModificar.setEnabled(false);
            btnEliminar.setEnabled(false);            
        }
    }
    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        vAccion="NUEVO";
        cambiarVista(1);
        //Limpia campos para ingreso de campeonato
        txtNombreCampeonato.setText("");
        txtOrganizador.setText("");
        txtMontoPremio.setText("");
        cbCantidadEquipos.setSelectedIndex(0);
        dateInicio.setDate(null);
        vCampeonato= new Campeonato();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnSalirActionPerformed
    
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        
        vCampeonato.setIdCampeonato(frmPrincipal.gestor.getListaCampeonatos().size()+1);
        vCampeonato.setNombreCampeonato(txtNombreCampeonato.getText());
        vCampeonato.setOrganizador(txtOrganizador.getText());
        vCampeonato.setMontoPremio(txtMontoPremio.getText());
        vCampeonato.setTipoCampeonato(cbTipoCampeonato.getSelectedIndex());
        vCampeonato.setCantidadEquipos(Integer.parseInt(cbCantidadEquipos.getSelectedItem().toString()));
        vCampeonato.setFechaInicio(dateInicio.getDate());
        vCampeonato.setGolesWalkover((int)txtNumGolesWalkover.getValue());
        
        if(vCampeonato.validaCampeonato()){
            if(vAccion.equals("NUEVO"))
                frmPrincipal.gestor.agregarCampeonato(vCampeonato);
            else if(vAccion.equals("MODIFICAR"))
                frmPrincipal.gestor.ActualizarCampeonato(vCampeonato);
            
            cambiarVista(0);
            vistaCampeonatos objVistaGestor = new vistaCampeonatos();
            objVistaGestor.setListaCampeonatos(frmPrincipal.gestor.getListaCampeonatos());
            listadoCampeonatos.setModel(objVistaGestor);            
            listadoCampeonatos.updateUI();
            JOptionPane.showMessageDialog(null, "Se guardó el campeonato "+txtNombreCampeonato.getText()+" correctamente!");
        }else{
            JOptionPane.showMessageDialog(null, "Datos incorrectos");
        }
       
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        vAccion="MODIFICAR";
        int column = 0;
        int row = listadoCampeonatos.getSelectedRow();
        int vIdCampeonato= Integer.parseInt(listadoCampeonatos.getModel().getValueAt(row, column).toString());
        
        vCampeonato = gestor.buscarCampeonatoById(vIdCampeonato);
        
        txtNombreCampeonato.setText(vCampeonato.getNombreCampeonato());
        txtOrganizador.setText(vCampeonato.getOrganizador());
        txtMontoPremio.setText(vCampeonato.getMontoPremio());
        txtNumGolesWalkover.setValue(vCampeonato.getGolesWalkover());
        cbTipoCampeonato.setSelectedIndex(vCampeonato.getTipoCampeonato());
        cbCantidadEquipos.setSelectedItem(String.valueOf(vCampeonato.getCantidadEquipos()));
        dateInicio.setDate(vCampeonato.getFechaInicio());
        cambiarVista(1);
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        vAccion="ELIMINAR";
        int column = 0;
        int row = listadoCampeonatos.getSelectedRow();        
        if(row>=0){
            if(JOptionPane.showConfirmDialog(this, "¿Esta Seguro de eliminar?")==0){
                int vIdCampeonato= Integer.parseInt(listadoCampeonatos.getModel().getValueAt(row, column).toString());
                gestor.EliminarCampeonato(vIdCampeonato);
                gestor.ReordenarLista();
                vistaCampeonatos objVistaGestor = new vistaCampeonatos();
                objVistaGestor.setListaCampeonatos(frmPrincipal.gestor.getListaCampeonatos());
                listadoCampeonatos.setModel(objVistaGestor);            
                listadoCampeonatos.updateUI();
            }
        }else{
            JOptionPane.showMessageDialog(null, "Seleccione un campeonato");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cbCantidadEquipos;
    private javax.swing.JComboBox<String> cbTipoCampeonato;
    private com.toedter.calendar.JDateChooser dateInicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable listadoCampeonatos;
    private javax.swing.JTabbedPane tabPanel;
    private javax.swing.JTextField txtMontoPremio;
    private javax.swing.JTextField txtNombreCampeonato;
    private javax.swing.JSpinner txtNumGolesWalkover;
    private javax.swing.JTextField txtOrganizador;
    // End of variables declaration//GEN-END:variables
}
