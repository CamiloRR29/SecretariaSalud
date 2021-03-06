/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package secretariasalud;

import java.awt.HeadlessException;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * @author Camilo Andres Rodriguez Reyes
 * @author Karen Yulieth Plazas Ramirez
 * @author Jhonatan Murcia Posso
 * @author Sebastian Saldaña Silva
 * @author Sebastian Lopez Galeano
 */
public class muestraDatos extends javax.swing.JFrame {

    //Función para campos en blanco
    String EMPTY = new String();
    //Diseño de tabla para el constructor
    DefaultTableModel modelo2;
    //Array para envio de datos y constructores
    ArrayList<listadatos> lista = new ArrayList<>();

    /**
     * Creates new form muestraDatos
     */
    public muestraDatos() {
        initComponents();
        this.setLocationRelativeTo(null);
        modelo2 = new DefaultTableModel();
        modelo2.addColumn("ID");
        modelo2.addColumn("Identificación");
        modelo2.addColumn("Apellidos");
        modelo2.addColumn("Nombres");
        modelo2.addColumn("Genero");
        modelo2.addColumn("Dirección de Residencia");
        modelo2.addColumn("Centro de Atención");
        modelo2.addColumn("Motivo de Consulta");
        modelo2.addColumn("Medico");
        modelo2.addColumn("Fecha");
        modelo2.addColumn("Hora");
        tblDatos.setModel(modelo2);
    }

    public void mostrar() {
        //Matriz de asignacion de datos
        String matriz[][] = new String[lista.size()][11];
        for (int i = 0; i < lista.size(); i++) {
            //Posición en la tabla
            matriz[i][0] = lista.get(i).getID();
            matriz[i][1] = lista.get(i).getIdentificación();
            matriz[i][2] = lista.get(i).getApellidos();
            matriz[i][3] = lista.get(i).getNombres();
            matriz[i][4] = lista.get(i).getGenero();
            matriz[i][5] = lista.get(i).getDireccion();
            matriz[i][6] = lista.get(i).getCentro();
            matriz[i][7] = lista.get(i).getMotivo();
            matriz[i][8] = lista.get(i).getMedico();
            matriz[i][9] = lista.get(i).getFecha();
            matriz[i][10] = lista.get(i).getHora();
        }
        tblDatos.setModel(new javax.swing.table.DefaultTableModel(
                matriz,
                new String[]{
                    "Identificación", "Apellidos", "Nombres", "Genero", "Dirección de Residencia", "Centro de Atención", "Motivo de Consulta", "Medico", "Fecha", "Hora"
                }
        )
        );

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpTablaDatos = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();
        lblTitulo = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        btnDatosCompletos = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        lblEjemplo = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpTablaDatos.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Tabla de Datos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N

        tblDatos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tblDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Identificación", "Apellidos", "Nombres", "Genero", "Dirección de Residencia", "Centro de Atención", "Motivo de Consulta", "Medico", "Fecha", "Hora"
            }
        ));
        jScrollPane5.setViewportView(tblDatos);

        javax.swing.GroupLayout jpTablaDatosLayout = new javax.swing.GroupLayout(jpTablaDatos);
        jpTablaDatos.setLayout(jpTablaDatosLayout);
        jpTablaDatosLayout.setHorizontalGroup(
            jpTablaDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1191, Short.MAX_VALUE)
        );
        jpTablaDatosLayout.setVerticalGroup(
            jpTablaDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpTablaDatosLayout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        lblTitulo.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblTitulo.setText("Control y Muestra de Datos");

        btnBuscar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        txtBuscar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        btnDatosCompletos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnDatosCompletos.setText("Datos Completos");
        btnDatosCompletos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatosCompletosActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnModificar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnModificar.setText("Modificar Base Datos");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        lblEjemplo.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        lblEjemplo.setText("Buscar por ID Ejemplo: 1,2,3,4");

        jButton1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton1.setText("Menu");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTitulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblEjemplo))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(btnDatosCompletos)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnModificar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jpTablaDatos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitulo)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(lblEjemplo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpTablaDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDatosCompletos)
                    .addComponent(btnSalir)
                    .addComponent(btnModificar)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/bd_salud", "root", "");
            PreparedStatement pst = cn.prepareStatement("select * from pacientes where ID = ?");
            pst.setString(1, txtBuscar.getText().trim());

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                String Datos[] = new String[11];
                Datos[0] = rs.getString("ID");
                Datos[1] = rs.getString("Identificacion");
                Datos[2] = rs.getString("ApellidoPaciente");
                Datos[3] = rs.getString("NombrePaciente");
                Datos[4] = rs.getString("Genero");
                Datos[5] = rs.getString("Direccion");
                Datos[6] = rs.getString("CentroAtencion");
                Datos[7] = rs.getString("MotivoConsulta");
                Datos[8] = rs.getString("Medico");
                Datos[9] = rs.getString("Fecha");
                Datos[10] = rs.getString("Hora");
                modelo2.addRow(Datos);
                txtBuscar.setText(EMPTY);
            } else {
                JOptionPane.showMessageDialog(null, " DATOS NO ENCONTRADOS \n");
            }
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, " ERROR A LA HORA DE CONSULTAR LA BASE DE DATOS \n");
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnDatosCompletosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatosCompletosActionPerformed
        // TODO add your handling code here:
        btnBuscar.setEnabled(false);
        txtBuscar.setEnabled(false);
        modelo2.getDataVector().removeAllElements();
        modelo2.fireTableDataChanged();
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/bd_salud", "root", "");
            PreparedStatement pst = cn.prepareStatement("select * from pacientes where ID = ?");
            for (int i = 1; i < 50; i++) {
                pst.setString(1, Integer.toString(i));
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    String Datos[] = new String[11];
                    Datos[0] = rs.getString("ID");
                    Datos[1] = rs.getString("Identificacion");
                    Datos[2] = rs.getString("ApellidoPaciente");
                    Datos[3] = rs.getString("NombrePaciente");
                    Datos[4] = rs.getString("Genero");
                    Datos[5] = rs.getString("Direccion");
                    Datos[6] = rs.getString("CentroAtencion");
                    Datos[7] = rs.getString("MotivoConsulta");
                    Datos[8] = rs.getString("Medico");
                    Datos[9] = rs.getString("Fecha");
                    Datos[10] = rs.getString("Hora");
                    modelo2.addRow(Datos);
                }
            }
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, " ERROR A LA HORA DE CONSULTAR LA BASE DE DATOS \n");
        }
    }//GEN-LAST:event_btnDatosCompletosActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        if (JOptionPane.showConfirmDialog(rootPane, "¿Estas seguro de querer salir?",
                "Salir", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE) == JOptionPane.YES_OPTION) {
            dispose();
            System.exit(0);
        } else {
            setDefaultCloseOperation(0);
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        ModificarBaseDatos mbd = new ModificarBaseDatos();
        mbd.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnModificarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Menu m=new Menu();
        m.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(muestraDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(muestraDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(muestraDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(muestraDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new muestraDatos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnDatosCompletos;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JPanel jpTablaDatos;
    private javax.swing.JLabel lblEjemplo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tblDatos;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
