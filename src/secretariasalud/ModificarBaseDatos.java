/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package secretariasalud;

import java.awt.HeadlessException;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 * @author Camilo Andres Rodriguez Reyes
 * @author Karen Yulieth Plazas Ramirez
 * @author Jhonatan Murcia Posso
 * @author Sebastian Saldaña Silva
 * @author Sebastian Lopez Galeano
 */
public class ModificarBaseDatos extends javax.swing.JFrame {

    //Variable Asignación Mes
    String idmes;
    String EMPTY = new String();

    /**
     * Creates new form ModificarBaseDatos
     */
    public ModificarBaseDatos() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnModificar = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        jpDatos = new javax.swing.JPanel();
        lblCodigo = new javax.swing.JLabel();
        txtIdentificacion = new javax.swing.JTextField();
        lblApellido = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        lblGenero = new javax.swing.JLabel();
        lblDireccion = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        lblCentroAtencion = new javax.swing.JLabel();
        txtCentroAtencion = new javax.swing.JTextField();
        lblMotivoConsulta = new javax.swing.JLabel();
        txtMotivoConsulta = new javax.swing.JTextField();
        lblMedico = new javax.swing.JLabel();
        txtMedico = new javax.swing.JTextField();
        lblFecha = new javax.swing.JLabel();
        lblHora = new javax.swing.JLabel();
        txtGenero = new javax.swing.JTextField();
        txtFecha = new javax.swing.JTextField();
        txtHora = new javax.swing.JTextField();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        lblEjemplo = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnModificar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        lblTitulo.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblTitulo.setText("MODIFICAR");

        jpDatos.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Datos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N
        jpDatos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        lblCodigo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblCodigo.setText("Codigo/Identificación");

        txtIdentificacion.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        lblApellido.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblApellido.setText("Apellidos");

        txtApellidos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        lblNombre.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblNombre.setText("Nombres");

        txtNombres.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        lblGenero.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblGenero.setText("Genero");

        lblDireccion.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblDireccion.setText("Dirección de Residencia");

        txtDireccion.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        lblCentroAtencion.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblCentroAtencion.setText("Centro de Atención");

        txtCentroAtencion.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        lblMotivoConsulta.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblMotivoConsulta.setText("Motivo de Consulta");

        txtMotivoConsulta.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        lblMedico.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblMedico.setText("Medico");

        txtMedico.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        lblFecha.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblFecha.setText("Fecha");

        lblHora.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblHora.setText("Hora");

        txtFecha.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        txtHora.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        javax.swing.GroupLayout jpDatosLayout = new javax.swing.GroupLayout(jpDatos);
        jpDatos.setLayout(jpDatosLayout);
        jpDatosLayout.setHorizontalGroup(
            jpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtGenero, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtCentroAtencion)
                    .addComponent(txtFecha)
                    .addComponent(txtIdentificacion)
                    .addComponent(txtApellidos)
                    .addComponent(txtNombres)
                    .addComponent(txtDireccion)
                    .addComponent(txtMotivoConsulta)
                    .addComponent(txtMedico)
                    .addGroup(jpDatosLayout.createSequentialGroup()
                        .addGroup(jpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblGenero, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCodigo, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblApellido, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNombre, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDireccion, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCentroAtencion, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMotivoConsulta, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMedico, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFecha, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblHora, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(0, 268, Short.MAX_VALUE))
                    .addComponent(txtHora, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jpDatosLayout.setVerticalGroup(
            jpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCodigo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblApellido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblGenero)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDireccion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCentroAtencion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCentroAtencion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMotivoConsulta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMotivoConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMedico)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblFecha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(lblHora)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtBuscar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        btnBuscar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        lblEjemplo.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        lblEjemplo.setText("Buscar por ID Ejemplo: 1,2,3,4");

        btnEliminar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnVolver.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitulo)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnVolver))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblEjemplo))
                    .addComponent(jpDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnBuscar)
                        .addComponent(lblEjemplo)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar)
                    .addComponent(btnVolver))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        try {
            String ID = txtBuscar.getText().trim();
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/bd_salud", "root", "");
            PreparedStatement pst = cn.prepareStatement("update pacientes set Identificacion = ?, ApellidoPaciente = ?,NombrePaciente = ?,Genero = ?,Direccion = ?,CentroAtencion = ?,MotivoConsulta = ?,Medico = ?,Fecha = ?,Hora = ? where ID = " + ID);
            pst.setString(1, txtIdentificacion.getText());
            pst.setString(2, txtApellidos.getText().trim());
            pst.setString(3, txtNombres.getText().trim());
            pst.setString(4, txtGenero.getText().trim());
            pst.setString(5, txtDireccion.getText().trim());
            pst.setString(6, txtCentroAtencion.getText().trim());
            pst.setString(7, txtMotivoConsulta.getText().trim());
            pst.setString(8, txtMedico.getText().trim());
            pst.setString(9, txtFecha.getText().trim());
            pst.setString(10, txtHora.getText().trim());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, " MODIFICACIÓN EXITOSA \n");
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, " MODIFICACIÓN FRACASO \n");
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/bd_salud", "root", "");
            PreparedStatement pst = cn.prepareStatement("select * from pacientes where ID = ?");
            pst.setString(1, txtBuscar.getText().trim());

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                String Datos[] = new String[10];
                Datos[0] = rs.getString("Identificacion");
                Datos[1] = rs.getString("ApellidoPaciente");
                Datos[2] = rs.getString("NombrePaciente");
                Datos[3] = rs.getString("Genero");
                Datos[4] = rs.getString("Direccion");
                Datos[5] = rs.getString("CentroAtencion");
                Datos[6] = rs.getString("MotivoConsulta");
                Datos[7] = rs.getString("Medico");
                Datos[8] = rs.getString("Fecha");
                Datos[9] = rs.getString("Hora");
                txtIdentificacion.setText(Datos[0]);
                txtApellidos.setText(Datos[1]);
                txtNombres.setText(Datos[2]);
                txtGenero.setText(Datos[3]);
                txtDireccion.setText(Datos[4]);
                txtCentroAtencion.setText(Datos[5]);
                txtMotivoConsulta.setText(Datos[6]);
                txtMedico.setText(Datos[7]);
                txtFecha.setText(Datos[8]);
                txtHora.setText(Datos[9]);
            } else {
                JOptionPane.showMessageDialog(null, " DATOS NO ENCONTRADOS \n");
            }
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, " ERROR A LA HORA DE CONSULTAR LA BASE DE DATOS \n");
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/bd_salud", "root", "");
            PreparedStatement pst = cn.prepareStatement("delete from pacientes where ID = ?");
            pst.setString(1, txtBuscar.getText().trim());
            pst.executeUpdate();
            txtIdentificacion.setText(EMPTY);
            txtApellidos.setText(EMPTY);
            txtNombres.setText(EMPTY);
            txtGenero.setText(EMPTY);
            txtDireccion.setText(EMPTY);
            txtCentroAtencion.setText(EMPTY);
            txtMotivoConsulta.setText(EMPTY);
            txtMedico.setText(EMPTY);
            txtFecha.setText(EMPTY);
            txtHora.setText(EMPTY);
            txtBuscar.setText(EMPTY);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, " MODIFICACIÓN EXITOSA \n");
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, " MODIFICACIÓN FRACASO \n");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        // TODO add your handling code here:
        muestraDatos md =new muestraDatos();
        md.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnVolverActionPerformed

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
            java.util.logging.Logger.getLogger(ModificarBaseDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModificarBaseDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModificarBaseDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModificarBaseDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModificarBaseDatos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JPanel jpDatos;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblCentroAtencion;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblEjemplo;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblGenero;
    private javax.swing.JLabel lblHora;
    private javax.swing.JLabel lblMedico;
    private javax.swing.JLabel lblMotivoConsulta;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCentroAtencion;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtGenero;
    private javax.swing.JTextField txtHora;
    private javax.swing.JTextField txtIdentificacion;
    private javax.swing.JTextField txtMedico;
    private javax.swing.JTextField txtMotivoConsulta;
    private javax.swing.JTextField txtNombres;
    // End of variables declaration//GEN-END:variables

}