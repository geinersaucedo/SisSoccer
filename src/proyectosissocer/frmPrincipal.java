/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectosissocer;

import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Geiner Saucedo
 */
public class frmPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form frmPrincipal
     */
    public frmPrincipal() {
        initComponents();
        desktop.setBackground(Color.gray);
        setIconImage(new ImageIcon(getClass().getResource("/images/icon_pelota.png")).getImage());        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem2 = new javax.swing.JMenuItem();
        desktop = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        mItemNewEquipo = new javax.swing.JMenuItem();
        mItemNewCampeonato = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mItemSalir = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        mItemFixtures = new javax.swing.JMenuItem();
        mItemTablaPosiciones = new javax.swing.JMenuItem();
        mItemLlaves = new javax.swing.JMenuItem();

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SISSOCCER");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout desktopLayout = new javax.swing.GroupLayout(desktop);
        desktop.setLayout(desktopLayout);
        desktopLayout.setHorizontalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1150, Short.MAX_VALUE)
        );
        desktopLayout.setVerticalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 760, Short.MAX_VALUE)
        );

        getContentPane().add(desktop, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1150, 760));

        jMenu1.setText("Archivo");

        jMenu4.setText("Nuevo");

        mItemNewEquipo.setText("Equipo");
        mItemNewEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mItemNewEquipoActionPerformed(evt);
            }
        });
        jMenu4.add(mItemNewEquipo);

        mItemNewCampeonato.setText("Campeonato");
        mItemNewCampeonato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mItemNewCampeonatoActionPerformed(evt);
            }
        });
        jMenu4.add(mItemNewCampeonato);

        jMenu1.add(jMenu4);
        jMenu1.add(jSeparator1);

        mItemSalir.setText("Salir");
        mItemSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mItemSalirActionPerformed(evt);
            }
        });
        jMenu1.add(mItemSalir);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Ver");

        mItemFixtures.setText("Fixtures");
        mItemFixtures.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mItemFixturesActionPerformed(evt);
            }
        });
        jMenu2.add(mItemFixtures);

        mItemTablaPosiciones.setText("Tabla de posiciones");
        mItemTablaPosiciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mItemTablaPosicionesActionPerformed(evt);
            }
        });
        jMenu2.add(mItemTablaPosiciones);

        mItemLlaves.setText("Llaves");
        mItemLlaves.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mItemLlavesActionPerformed(evt);
            }
        });
        jMenu2.add(mItemLlaves);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mItemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItemSalirActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_mItemSalirActionPerformed

    private void mItemNewEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItemNewEquipoActionPerformed
        // TODO add your handling code here:
//        frmNuevoEquipo frm= new frmNuevoEquipo();
//        desktop.add(frm);
//        frm.show();

        if (frmNuevoEquipo.getInstancia().isVisible()) {
            frmNuevoEquipo.getInstancia().toFront();
            frmNuevoEquipo.getInstancia().requestFocus();
        }else{
            desktop.add(frmNuevoEquipo.getInstancia());
            frmNuevoEquipo.getInstancia().setVisible(true);
        }
            
        
    }//GEN-LAST:event_mItemNewEquipoActionPerformed

    private void mItemNewCampeonatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItemNewCampeonatoActionPerformed
        // TODO add your handling code here:
        if (frmNuevoCampeonato.getInstancia().isVisible()) {
            frmNuevoCampeonato.getInstancia().toFront();
            frmNuevoCampeonato.getInstancia().requestFocus();
        }else{
            desktop.add(frmNuevoCampeonato.getInstancia());
            frmNuevoCampeonato.getInstancia().setVisible(true);
        }
    }//GEN-LAST:event_mItemNewCampeonatoActionPerformed

    private void mItemFixturesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItemFixturesActionPerformed
        // TODO add your handling code here:
        frmEncuentro frm1 =new frmEncuentro();
        desktop.add(frm1);
        frm1.setVisible(true);
        if (frmFixtures.getInstancia().isVisible()) {
            frmFixtures.getInstancia().toFront();
            frmFixtures.getInstancia().requestFocus();
        }else{
            desktop.add(frmFixtures.getInstancia());
            frmFixtures.getInstancia().setVisible(true);
        }
    }//GEN-LAST:event_mItemFixturesActionPerformed

    private void mItemTablaPosicionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItemTablaPosicionesActionPerformed
        // TODO add your handling code here:
        if (frmTablaPosiciones.getInstancia().isVisible()) {
            frmTablaPosiciones.getInstancia().toFront();
            frmTablaPosiciones.getInstancia().requestFocus();
        }else{
            desktop.add(frmTablaPosiciones.getInstancia());
            frmTablaPosiciones.getInstancia().setVisible(true);
        }
    }//GEN-LAST:event_mItemTablaPosicionesActionPerformed

    private void mItemLlavesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItemLlavesActionPerformed
        // TODO add your handling code here:
        if (frmLlaves.getInstancia().isVisible()) {
            frmLlaves.getInstancia().toFront();
            frmLlaves.getInstancia().requestFocus();
        }else{
            desktop.add(frmLlaves.getInstancia());
            frmLlaves.getInstancia().setVisible(true);
        }
    }//GEN-LAST:event_mItemLlavesActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktop;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenuItem mItemFixtures;
    private javax.swing.JMenuItem mItemLlaves;
    private javax.swing.JMenuItem mItemNewCampeonato;
    private javax.swing.JMenuItem mItemNewEquipo;
    private javax.swing.JMenuItem mItemSalir;
    private javax.swing.JMenuItem mItemTablaPosiciones;
    // End of variables declaration//GEN-END:variables
}