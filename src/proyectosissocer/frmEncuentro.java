/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectosissocer;

import clases.Campeonato;
import clases.Encuentro;
import clases.Equipo;
import clases.Jugador;
import clases.Gol;
import clases.Tarjeta;
import vistas.vistaGoles;
import vistas.vistaTarjetas;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import static proyectosissocer.frmFixtures.pNomCampeonato;
import static proyectosissocer.frmFixtures.pIdEncuentro;
import static proyectosissocer.frmFixtures.pNumFecha;
import static proyectosissocer.frmPrincipal.gestor;

/**
 *
 * @author Geiner Saucedo
 */
public class frmEncuentro extends javax.swing.JInternalFrame {
    
    public Encuentro ObjEncuentro;
    public ArrayList<Tarjeta> ObjListaTarjetaEncuentro;
    public ArrayList<Gol> ObjListaGolEncuentro;
    
    public int GolesPorWalkover;
//    private static frmEncuentro frm;
//    public static frmEncuentro getInstancia(){
//        if (frm==null) {
//            frm= new frmEncuentro();
//        }
//        return frm;
//    }
    
    public frmEncuentro() {
        initComponents();
        ObjListaTarjetaEncuentro = new ArrayList<Tarjeta>();
        ObjListaGolEncuentro = new ArrayList<Gol>();
                
        inhabilitaSpinner(spinerGolLocal);
        inhabilitaSpinner(spinerGolVisita);
        CargaDatosIniciales();
    }
    
    public void CargaDatosIniciales(){
        Campeonato ObjCamp = gestor.buscarCampeonato(pNomCampeonato);
        GolesPorWalkover = ObjCamp.getGolesWalkover();
        lblTituloEncuentro.setText(pNomCampeonato +  " - Fecha " + pNumFecha );
        ObjEncuentro = ObjCamp.getObjFixture().getJornadas_ByNumFecha(pNumFecha).getEncuentro_ById(pIdEncuentro);                              
        lblEquipoLocal.setText(ObjCamp.getNomEquipoCorto_ById(ObjEncuentro.getIdEquipoLocal()));
        lblEquipoVisita.setText(ObjCamp.getNomEquipoCorto_ById(ObjEncuentro.getIdEquipoVisita()));
        rbLocal.setText(lblEquipoLocal.getText());
        rbVisita.setText(lblEquipoVisita.getText());
        rbNinguno.setVisible(false);
        
        cbEquipoGoles.removeAllItems();
        cbEquipoGoles.addItem("Seleccionar");
        cbEquipoGoles.addItem(lblEquipoLocal.getText());
        cbEquipoGoles.addItem(lblEquipoVisita.getText());
        
        cbEquipoTarjetas.removeAllItems();
        cbEquipoTarjetas.addItem("Seleccionar");
        cbEquipoTarjetas.addItem(lblEquipoLocal.getText());
        cbEquipoTarjetas.addItem(lblEquipoVisita.getText());
    }
    
    public void inhabilitaSpinner(JSpinner spiner){
        if ( spiner.getEditor() instanceof JSpinner.DefaultEditor ) {
            JSpinner.DefaultEditor editor = ( JSpinner.DefaultEditor ) spiner.getEditor();
            editor.getTextField().setEnabled( true );
            editor.getTextField().setEditable( false );
        }
    }
    
    public boolean AgregarTarjeta(String ColorTarjeta){
        Tarjeta ObjTarjeta= new Tarjeta();
        ObjTarjeta.setIdEvento(ObjListaTarjetaEncuentro.size()+1);
        ObjTarjeta.setIdEquipo(gestor.buscarCampeonato(pNomCampeonato).getEquipo_ByNomEquipoCorto(cbEquipoTarjetas.getSelectedItem().toString()).getIdEquipo());
        ObjTarjeta.setNomEquipo(cbEquipoTarjetas.getSelectedItem().toString());
        ObjTarjeta.setIdJugador(gestor.buscarCampeonato(pNomCampeonato).getEquipo_ByNomEquipoCorto(cbEquipoTarjetas.getSelectedItem().toString()).getIdJugador_ByNombresCompletos(cbJugadoresTarjeta.getSelectedItem().toString()).getIdJugador());
        ObjTarjeta.setNomJugador(cbJugadoresTarjeta.getSelectedItem().toString());
        ObjTarjeta.setColorTarjeta(ColorTarjeta);
        ObjTarjeta.setNumFecha(pNumFecha);
        if(ObjTarjeta.validaTarjeta()){
            ObjListaTarjetaEncuentro.add(ObjTarjeta);            
            
            if(lblEquipoLocal.getText().equals(ObjTarjeta.getNomEquipo())){
                if(ColorTarjeta.equals("Amarilla"))
                   spinerTALocal.setValue((int)spinerTALocal.getValue()+1);
                else if (ColorTarjeta.equals("Roja"))
                   spinerTRLocal.setValue((int)spinerTRLocal.getValue()+1);
            }else if(lblEquipoVisita.getText().equals(ObjTarjeta.getNomEquipo())){            
                if(ColorTarjeta.equals("Amarilla"))
                   spinerTAVisita.setValue((int)spinerTAVisita.getValue()+1);
                else if (ColorTarjeta.equals("Roja"))
                   spinerTRVisita.setValue((int)spinerTRVisita.getValue()+1);            
            }
            return true;
        }else{
            return false;
        }   
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoWalkover = new javax.swing.ButtonGroup();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblEquipoLocal = new javax.swing.JLabel();
        spinerGolLocal = new javax.swing.JSpinner();
        jPanel2 = new javax.swing.JPanel();
        lblEquipoVisita = new javax.swing.JLabel();
        spinerGolVisita = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        spinerTALocal = new javax.swing.JSpinner();
        spinerTAVisita = new javax.swing.JSpinner();
        spinerTRVisita = new javax.swing.JSpinner();
        spinerTRLocal = new javax.swing.JSpinner();
        jLabel8 = new javax.swing.JLabel();
        admDatos = new javax.swing.JTabbedPane();
        panelGoles = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        cbJugadoresGol = new javax.swing.JComboBox<>();
        cbTipoGol = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        cbEquipoGoles = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblGoles = new javax.swing.JTable();
        btnAgregarGol = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        panelTarjetas = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cbJugadoresTarjeta = new javax.swing.JComboBox<>();
        cbColorTarjeta = new javax.swing.JComboBox<>();
        cbEquipoTarjetas = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTarjetas = new javax.swing.JTable();
        btnAgregartarjeta = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtObservaciones = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        rbLocal = new javax.swing.JRadioButton();
        rbVisita = new javax.swing.JRadioButton();
        chkWalkover = new javax.swing.JCheckBox();
        rbNinguno = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        btnCerrar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        lblTituloEncuentro = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Registro Encuentro");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("VS");

        lblEquipoLocal.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblEquipoLocal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEquipoLocal.setText("EQUIPO A");

        spinerGolLocal.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        spinerGolLocal.setModel(new javax.swing.SpinnerNumberModel(0, 0, 15, 1));
        spinerGolLocal.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblEquipoLocal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(spinerGolLocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(69, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblEquipoLocal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spinerGolLocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        lblEquipoVisita.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblEquipoVisita.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEquipoVisita.setText("EQUIPO B");

        spinerGolVisita.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        spinerGolVisita.setModel(new javax.swing.SpinnerNumberModel(0, 0, 15, 1));
        spinerGolVisita.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(spinerGolVisita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(79, Short.MAX_VALUE))
            .addComponent(lblEquipoVisita, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblEquipoVisita)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spinerGolVisita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("GOLES:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Tarjetas Amarillas:");

        spinerTALocal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        spinerTALocal.setModel(new javax.swing.SpinnerNumberModel(0, 0, 15, 1));
        spinerTALocal.setEnabled(false);

        spinerTAVisita.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        spinerTAVisita.setModel(new javax.swing.SpinnerNumberModel(0, 0, 15, 1));
        spinerTAVisita.setEnabled(false);

        spinerTRVisita.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        spinerTRVisita.setModel(new javax.swing.SpinnerNumberModel(0, 0, 15, 1));
        spinerTRVisita.setEnabled(false);

        spinerTRLocal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        spinerTRLocal.setModel(new javax.swing.SpinnerNumberModel(0, 0, 15, 1));
        spinerTRLocal.setEnabled(false);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Tarjetas Rojas:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(45, 45, 45)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spinerTRLocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spinerTALocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spinerTAVisita, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spinerTRVisita, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(136, 136, 136))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(spinerTALocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spinerTAVisita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(spinerTRLocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spinerTRVisita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jLabel13.setText("Jugador:");

        cbJugadoresGol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar" }));

        cbTipoGol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Disparo", "Tiro Libre", "Olimpico", "Cabeza", "Penal", "Chalaca", "Rabona", "Palomita", "Tijera", "Tiro del Tigre", "A lo Checho", "Auto Gol", " " }));

        jLabel14.setText("Tipo:");

        jLabel15.setText("Equipo:");

        cbEquipoGoles.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbEquipoGolesItemStateChanged(evt);
            }
        });

        tblGoles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "idGol", "Jugador", "Equipo", "Tipo Gol"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblGoles);

        btnAgregarGol.setText("Agregar");
        btnAgregarGol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarGolActionPerformed(evt);
            }
        });

        jButton2.setText("Eliminar");

        jButton3.setText("Modificar");

        javax.swing.GroupLayout panelGolesLayout = new javax.swing.GroupLayout(panelGoles);
        panelGoles.setLayout(panelGolesLayout);
        panelGolesLayout.setHorizontalGroup(
            panelGolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGolesLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel15)
                .addGap(18, 18, 18)
                .addComponent(cbEquipoGoles, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGolesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelGolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 595, Short.MAX_VALUE)
                    .addGroup(panelGolesLayout.createSequentialGroup()
                        .addGroup(panelGolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel13))
                        .addGap(18, 18, 18)
                        .addGroup(panelGolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelGolesLayout.createSequentialGroup()
                                .addComponent(cbTipoGol, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(cbJugadoresGol, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGolesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAgregarGol)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(146, 146, 146))
        );
        panelGolesLayout.setVerticalGroup(
            panelGolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGolesLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(panelGolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(cbEquipoGoles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelGolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(cbJugadoresGol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelGolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(cbTipoGol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelGolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarGol)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap())
        );

        admDatos.addTab("Goles", panelGoles);

        jLabel10.setText("Color:");

        jLabel11.setText("Equipo:");

        jLabel12.setText("Jugador:");

        cbJugadoresTarjeta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar" }));

        cbColorTarjeta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Amarilla", "Roja" }));

        cbEquipoTarjetas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbEquipoTarjetasItemStateChanged(evt);
            }
        });

        tblTarjetas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "idTarjeta", "Jugador", "Equipo", "ColorTarjeta"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblTarjetas);

        btnAgregartarjeta.setText("Agregar");
        btnAgregartarjeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregartarjetaActionPerformed(evt);
            }
        });

        jButton7.setText("Modificar");

        jButton8.setText("Eliminar");

        javax.swing.GroupLayout panelTarjetasLayout = new javax.swing.GroupLayout(panelTarjetas);
        panelTarjetas.setLayout(panelTarjetasLayout);
        panelTarjetasLayout.setHorizontalGroup(
            panelTarjetasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTarjetasLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAgregartarjeta)
                .addGap(18, 18, 18)
                .addComponent(jButton7)
                .addGap(18, 18, 18)
                .addComponent(jButton8)
                .addGap(152, 152, 152))
            .addGroup(panelTarjetasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTarjetasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 595, Short.MAX_VALUE)
                    .addGroup(panelTarjetasLayout.createSequentialGroup()
                        .addGroup(panelTarjetasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(panelTarjetasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbJugadoresTarjeta, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panelTarjetasLayout.createSequentialGroup()
                                .addGroup(panelTarjetasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbEquipoTarjetas, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbColorTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        panelTarjetasLayout.setVerticalGroup(
            panelTarjetasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTarjetasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTarjetasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(cbEquipoTarjetas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTarjetasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(cbJugadoresTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTarjetasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cbColorTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(panelTarjetasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregartarjeta)
                    .addComponent(jButton8)
                    .addComponent(jButton7))
                .addContainerGap())
        );

        admDatos.addTab("Tarjetas", panelTarjetas);

        txtObservaciones.setColumns(20);
        txtObservaciones.setRows(5);
        jScrollPane3.setViewportView(txtObservaciones);

        grupoWalkover.add(rbLocal);
        rbLocal.setText("EQUIPO A");
        rbLocal.setEnabled(false);
        rbLocal.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbLocalItemStateChanged(evt);
            }
        });

        grupoWalkover.add(rbVisita);
        rbVisita.setText("EQUIPO B");
        rbVisita.setEnabled(false);
        rbVisita.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbVisitaItemStateChanged(evt);
            }
        });

        chkWalkover.setText("Walkover");
        chkWalkover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkWalkoverActionPerformed(evt);
            }
        });

        grupoWalkover.add(rbNinguno);
        rbNinguno.setSelected(true);
        rbNinguno.setEnabled(false);
        rbNinguno.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbNingunoItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chkWalkover)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rbLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(rbVisita, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(rbNinguno)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rbLocal)
                        .addComponent(chkWalkover)
                        .addComponent(rbVisita))
                    .addComponent(rbNinguno))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jLabel3.setText("Observaciones:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 595, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                .addContainerGap())
        );

        admDatos.addTab("Walkover", jPanel3);

        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        btnGuardar.setText("Grabar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        lblTituloEncuentro.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTituloEncuentro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTituloEncuentro.setText("Campeonato Los Peloteros - Fecha 1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jLabel5)
                .addGap(26, 26, 26)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(admDatos)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))))
            .addComponent(lblTituloEncuentro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTituloEncuentro)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel2)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(admDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCerrar, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(6, 6, 6))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void chkWalkoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkWalkoverActionPerformed
        // TODO add your handling code here:
        rbNinguno.setSelected(true);
        
        if(chkWalkover.isSelected()){
            rbLocal.setEnabled(true);
            rbVisita.setEnabled(true);
            admDatos.setEnabledAt(0, false);
            admDatos.setEnabledAt(1, false);
        }
        else{
            rbLocal.setEnabled(false);
            rbVisita.setEnabled(false);
            admDatos.setEnabledAt(0, true);
            admDatos.setEnabledAt(1, true);   
            spinerGolLocal.setValue(0);
            spinerGolVisita.setValue(0);            
        }
        
    }//GEN-LAST:event_chkWalkoverActionPerformed

    private void cbEquipoGolesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbEquipoGolesItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == ItemEvent.SELECTED) {
                 Equipo ObjEquipo = gestor.buscarCampeonato(pNomCampeonato).getEquipo_ByNomEquipoCorto(evt.getItem().toString());
                 cbJugadoresGol.removeAllItems();
                 cbJugadoresGol.addItem("Seleccionar");
                 for (Jugador j:ObjEquipo.getListaJugadores() ) {
                    cbJugadoresGol.addItem(j.getNombre()+" " + j.getApellidos());
                 }
        }
    }//GEN-LAST:event_cbEquipoGolesItemStateChanged

    private void cbEquipoTarjetasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbEquipoTarjetasItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == ItemEvent.SELECTED) {
                 Equipo ObjEquipo = gestor.buscarCampeonato(pNomCampeonato).getEquipo_ByNomEquipoCorto(evt.getItem().toString());
                 cbJugadoresTarjeta.removeAllItems();
                 cbJugadoresTarjeta.addItem("Seleccionar");
                 for (Jugador j:ObjEquipo.getListaJugadores() ) {
                    cbJugadoresTarjeta.addItem(j.getNombre()+" " + j.getApellidos());
                 }
        }        
    }//GEN-LAST:event_cbEquipoTarjetasItemStateChanged

    private void btnAgregarGolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarGolActionPerformed
        // TODO add your handling code here:        
        Gol ObjGol= new Gol();
        ObjGol.setIdEvento(ObjListaGolEncuentro.size()+1);
        ObjGol.setIdEquipo(gestor.buscarCampeonato(pNomCampeonato).getEquipo_ByNomEquipoCorto(cbEquipoGoles.getSelectedItem().toString()).getIdEquipo());
        ObjGol.setNomEquipo(cbEquipoGoles.getSelectedItem().toString());
        ObjGol.setIdJugador(gestor.buscarCampeonato(pNomCampeonato).getEquipo_ByNomEquipoCorto(cbEquipoGoles.getSelectedItem().toString()).getIdJugador_ByNombresCompletos(cbJugadoresGol.getSelectedItem().toString()).getIdJugador());
        ObjGol.setNomJugador(cbJugadoresGol.getSelectedItem().toString());
        ObjGol.setTipoGol(cbTipoGol.getSelectedItem().toString());

        if(ObjGol.validaGol()){
            ObjListaGolEncuentro.add(ObjGol);
            //ObjEncuentro.setAgregarGol(ObjGol);        
            vistaGoles objVistaGol = new vistaGoles();
            objVistaGol.setListaGoles(ObjListaGolEncuentro);

            if(lblEquipoLocal.getText().equals(ObjGol.getNomEquipo())){
                if(cbTipoGol.getSelectedItem().toString().equals("Auto Gol"))
                    spinerGolVisita.setValue((int)spinerGolVisita.getValue()+1);
                else
                    spinerGolLocal.setValue((int)spinerGolLocal.getValue()+1);
            }else if(lblEquipoVisita.getText().equals(ObjGol.getNomEquipo())){
                if(cbTipoGol.getSelectedItem().toString().equals("Auto Gol"))
                    spinerGolLocal.setValue((int)spinerGolLocal.getValue()+1);                
                else
                    spinerGolVisita.setValue((int)spinerGolVisita.getValue()+1);                
            }            
            chkWalkover.setEnabled(false);
            tblGoles.setModel(objVistaGol);
            tblGoles.updateUI();   
        }else{
            JOptionPane.showMessageDialog(null, "Datos incorrectos al agregar un gol");
        }
    }//GEN-LAST:event_btnAgregarGolActionPerformed

      
   public boolean validarCantidadTarjetaRoja(int pIdEquipo, int pIdJugador){
       for (Tarjeta t: ObjListaTarjetaEncuentro) {         
           if(t.getIdJugador()==pIdJugador && t.getColorTarjeta().equals("Roja") && t.getIdEquipo()==pIdEquipo ){
               return true;
           }
       }
       return false;
   } 
   
   public boolean validarCantidadTarjetaAmarilla(int pIdEquipo,int pIdJugador){
       int TotalAmarillas=0;
       for (Tarjeta t: ObjListaTarjetaEncuentro) {
           if(t.getIdJugador()==pIdJugador && t.getColorTarjeta().equals("Amarilla") && t.getIdEquipo()==pIdEquipo){
               TotalAmarillas++;
           }
       }
       if(TotalAmarillas>1) return true;
       return false;
   }    
    
    private void btnAgregartarjetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregartarjetaActionPerformed
        
        if(validarCantidadTarjetaRoja(gestor.buscarCampeonato(pNomCampeonato).getEquipo_ByNomEquipoCorto(cbEquipoTarjetas.getSelectedItem().toString()).getIdEquipo(), gestor.buscarCampeonato(pNomCampeonato).getEquipo_ByNomEquipoCorto(cbEquipoTarjetas.getSelectedItem().toString()).getIdJugador_ByNombresCompletos(cbJugadoresTarjeta.getSelectedItem().toString()).getIdJugador())){
            JOptionPane.showMessageDialog(null, "El Jugdor ya tiene una Tarjeta Roja");
            return;
        }     
        if(AgregarTarjeta(cbColorTarjeta.getSelectedItem().toString())){
            if(validarCantidadTarjetaAmarilla(gestor.buscarCampeonato(pNomCampeonato).getEquipo_ByNomEquipoCorto(cbEquipoTarjetas.getSelectedItem().toString()).getIdEquipo(), gestor.buscarCampeonato(pNomCampeonato).getEquipo_ByNomEquipoCorto(cbEquipoTarjetas.getSelectedItem().toString()).getIdJugador_ByNombresCompletos(cbJugadoresTarjeta.getSelectedItem().toString()).getIdJugador())){
                AgregarTarjeta("Roja");
            }
            vistaTarjetas objVistaTarjeta = new vistaTarjetas();
            objVistaTarjeta.setListaTarjetas(ObjListaTarjetaEncuentro);
            chkWalkover.setEnabled(false);
            tblTarjetas.setModel(objVistaTarjeta);
            tblTarjetas.updateUI();
        }else{
            JOptionPane.showMessageDialog(null, "Datos incorrectos al agregar una tarjeta");
        }
    }//GEN-LAST:event_btnAgregartarjetaActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        ObjEncuentro = gestor.buscarCampeonato(pNomCampeonato).getObjFixture().getJornadas_ByNumFecha(pNumFecha).getEncuentro_ById(pIdEncuentro);
        ObjEncuentro.setListaGoles(ObjListaGolEncuentro);
        ObjEncuentro.setListatarjeta(ObjListaTarjetaEncuentro);
        if(chkWalkover.getSelectedObjects()!=null){
            if(rbLocal.getSelectedObjects()== null && rbVisita.getSelectedObjects() ==  null){
                JOptionPane.showMessageDialog(null, "Debe indicar el equipo que hizo el walkover");
                return;
            }
            ObjEncuentro.setWalkover(1);
            if(rbLocal.getSelectedObjects()!=null) ObjEncuentro.setEquipoWalkover("L");
            if(rbVisita.getSelectedObjects()!=null) ObjEncuentro.setEquipoWalkover("V");
        }
        ObjEncuentro.setObservaciones(txtObservaciones.getText());
        if(ObjEncuentro.getWalkover()==1)ObjEncuentro.setEstado("W"); else ObjEncuentro.setEstado("J");
        gestor.buscarCampeonato(pNomCampeonato).getObjFixture().getJornadas_ByNumFecha(pNumFecha).getEncuentro_ById(pIdEncuentro).RegistrarResultado(ObjEncuentro);
        ObjEncuentro = gestor.buscarCampeonato(pNomCampeonato).getObjFixture().getJornadas_ByNumFecha(pNumFecha).getEncuentro_ById(pIdEncuentro);
        
        JOptionPane.showMessageDialog(null, "Resultados registrados exitosamente");
        this.setVisible(false);
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void rbLocalItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbLocalItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == ItemEvent.SELECTED) {            
            spinerGolVisita.setValue(GolesPorWalkover);
        }
        else if (evt.getStateChange() == ItemEvent.DESELECTED) {
            spinerGolVisita.setValue(0);
        }        
    }//GEN-LAST:event_rbLocalItemStateChanged

    private void rbVisitaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbVisitaItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            spinerGolLocal.setValue(GolesPorWalkover);
        }
        else if (evt.getStateChange() == ItemEvent.DESELECTED) {
            spinerGolLocal.setValue(0);
        }         
    }//GEN-LAST:event_rbVisitaItemStateChanged

    private void rbNingunoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbNingunoItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_rbNingunoItemStateChanged

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnCerrarActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane admDatos;
    private javax.swing.JButton btnAgregarGol;
    private javax.swing.JButton btnAgregartarjeta;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cbColorTarjeta;
    private javax.swing.JComboBox<String> cbEquipoGoles;
    private javax.swing.JComboBox<String> cbEquipoTarjetas;
    private javax.swing.JComboBox<String> cbJugadoresGol;
    private javax.swing.JComboBox<String> cbJugadoresTarjeta;
    private javax.swing.JComboBox<String> cbTipoGol;
    private javax.swing.JCheckBox chkWalkover;
    private javax.swing.ButtonGroup grupoWalkover;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblEquipoLocal;
    private javax.swing.JLabel lblEquipoVisita;
    private javax.swing.JLabel lblTituloEncuentro;
    private javax.swing.JPanel panelGoles;
    private javax.swing.JPanel panelTarjetas;
    private javax.swing.JRadioButton rbLocal;
    private javax.swing.JRadioButton rbNinguno;
    private javax.swing.JRadioButton rbVisita;
    private javax.swing.JSpinner spinerGolLocal;
    private javax.swing.JSpinner spinerGolVisita;
    private javax.swing.JSpinner spinerTALocal;
    private javax.swing.JSpinner spinerTAVisita;
    private javax.swing.JSpinner spinerTRLocal;
    private javax.swing.JSpinner spinerTRVisita;
    private javax.swing.JTable tblGoles;
    private javax.swing.JTable tblTarjetas;
    private javax.swing.JTextArea txtObservaciones;
    // End of variables declaration//GEN-END:variables
}
