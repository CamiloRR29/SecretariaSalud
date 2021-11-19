/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package secretariasalud;

import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

/**
 * @author Camilo Andres Rodriguez Reyes
 * @author Karen Yulieth Plazas Ramirez
 * @author Jhonatan Murcia Posso
 * @author Sebastian Saldaña Silva
 * @author Sebatian Lopez Galeano
 */
public class InserccionDatosMedicos extends javax.swing.JFrame {

    //Variable Asignación Mes
    String idmes;
    //Diseño de tabla para el constructor
    DefaultTableModel modelo;
    //Array para envio de datos y constructores
    ArrayList<listadatos> lista = new ArrayList<>();
    //Función para campos en blanco
    String EMPTY = new String();
    //Validar Casillas de texto como nombres,apellidos,etc.
    Pattern p = Pattern.compile("^\\p{L}+[\\p{L}\\p{Z}\\p{P}]{0,}");
    Pattern n = Pattern.compile("[0-9]*");
    /**
             * Creates new form InserccionDatosMedicos
             */

    public InserccionDatosMedicos() {
        initComponents();
        this.setLocationRelativeTo(null);
        lblCual.setVisible(false);
        txtGeneroOtro.setVisible(false);
        modelo = new DefaultTableModel();
        modelo.addColumn("Identificación");
        modelo.addColumn("Apellidos");
        modelo.addColumn("Nombres");
        modelo.addColumn("Genero");
        modelo.addColumn("Dirección de Residencia");
        modelo.addColumn("Centro de Atención");
        modelo.addColumn("Motivo de Consulta");
        modelo.addColumn("Medico");
        modelo.addColumn("Fecha");
        modelo.addColumn("Hora");
        tblDatosPrincipales.setModel(modelo);
    }

    public String fecha() {
        String fechafinal;
        String opcion1 = (String) cboDia.getSelectedItem();
        String opcion2 = (String) cboAño.getSelectedItem();
        fechafinal = opcion1 + "-" + idmes + "-" + opcion2;
        return fechafinal;
    }

    public String hora() {
        String Horafinal;
        String opcion1 = (String) cboHora.getSelectedItem();
        String opcion2 = (String) cboMinutos.getSelectedItem();
        Horafinal = opcion1 + ":" + opcion2;
        return Horafinal;
    }

    public String centrosalud() {
        String centrofinal;
        String opcion = (String) cboCentro.getSelectedItem();
        centrofinal = opcion + " " + txtCentroAtencion.getText();
        return centrofinal;
    }

    public String genero() {
        String generofinal = null;
        String opcion = (String) cboGenero.getSelectedItem();
        if (opcion.equals("Otro")) {
            generofinal = txtGeneroOtro.getText();
        } else {
            generofinal = (String) cboGenero.getSelectedItem();
        }
        return generofinal;

    }

    public void rellenar() {
        listadatos citas = new listadatos(txtIdentificacion.getText(), txtApellidos.getText(), txtNombres.getText(), genero(), txtDireccion.getText(), centrosalud(), txtMotivoConsulta.getText(), txtMedico.getText(), fecha(), hora());
        lista.add(citas);
        mostrar();
    }

    public void restaurar() {
        txtIdentificacion.setText(EMPTY);
        txtApellidos.setText(EMPTY);
        txtNombres.setText(EMPTY);
        txtDireccion.setText(EMPTY);
        txtCentroAtencion.setText(EMPTY);
        txtMotivoConsulta.setText(EMPTY);
        txtMedico.setText(EMPTY);
        txtGeneroOtro.setText(EMPTY);
        cboAño.setSelectedItem("--Seleccionar--");
        cboMes.setSelectedItem("--Seleccionar--");
        cboDia.setSelectedItem("--Seleccionar--");
        cboGenero.setSelectedItem("--Seleccionar--");
        cboHora.setSelectedItem("--Seleccionar--");
        cboMinutos.setSelectedItem("--Seleccionar--");
        cboCentro.setSelectedItem("--Seleccionar--");
    }

    public void mostrar() {
        //Matriz de asignacion de datos
        String matriz[][] = new String[lista.size()][10];
        for (int i = 0; i < lista.size(); i++) {
            //Posición en la tabla
            matriz[i][0] = lista.get(i).getIdentificación();
            matriz[i][1] = lista.get(i).getApellidos();
            matriz[i][2] = lista.get(i).getNombres();
            matriz[i][3] = lista.get(i).getGenero();
            matriz[i][4] = lista.get(i).getDireccion();
            matriz[i][5] = lista.get(i).getCentro();
            matriz[i][6] = lista.get(i).getMotivo();
            matriz[i][7] = lista.get(i).getMedico();
            matriz[i][8] = lista.get(i).getFecha();
            matriz[i][9] = lista.get(i).getHora();
        }
        tblDatosPrincipales.setModel(new javax.swing.table.DefaultTableModel(
                matriz,
                new String[]{
                    "Identificación", "Apellidos", "Nombres", "Genero", "Dirección de Residencia", "Centro de Atención", "Motivo de Consulta", "Medico", "Fecha", "Hora"
                }
        )
        );

    }

    public void validarIdentificacion() {
        Matcher Identificacion = n.matcher(txtIdentificacion.getText());
        if (Identificacion.matches() == false) {
            txtIdentificacion.setBorder(BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
            txtIdentificacion.setForeground(new java.awt.Color(0, 0, 0));
        } else {
            txtIdentificacion.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
            txtIdentificacion.setForeground(new java.awt.Color(0, 155, 5));
        }
    }

    public void validarNombre() {
        Matcher Nombres = p.matcher(txtNombres.getText());
        if (Nombres.matches() == false) {
            txtNombres.setBorder(BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
            txtNombres.setForeground(new java.awt.Color(0, 0, 0));
        } else {
            txtNombres.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
            txtNombres.setForeground(new java.awt.Color(0, 155, 5));
        }
    }

    public void validarApellido() {
        Matcher Apellidos = p.matcher(txtApellidos.getText());
        if (Apellidos.matches() == false) {
            txtApellidos.setBorder(BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
            txtApellidos.setForeground(new java.awt.Color(0, 0, 0));
        } else {
            txtApellidos.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
            txtApellidos.setForeground(new java.awt.Color(0, 155, 5));
        }
    }

    public void validarGenero() {
        Matcher Genero = p.matcher(txtGeneroOtro.getText());
        if (Genero.matches() == false) {
            txtGeneroOtro.setBorder(BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
            txtGeneroOtro.setForeground(new java.awt.Color(0, 0, 0));
        } else {
            txtGeneroOtro.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
            txtGeneroOtro.setForeground(new java.awt.Color(0, 155, 5));
        }
    }

    public void validarCentroAtencion() {
        Matcher Centro = p.matcher(txtCentroAtencion.getText());
        if (Centro.matches() == false) {
            txtCentroAtencion.setBorder(BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
            txtCentroAtencion.setForeground(new java.awt.Color(0, 0, 0));
        } else {
            txtCentroAtencion.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
            txtCentroAtencion.setForeground(new java.awt.Color(0, 155, 5));
        }
    }

    public void validarMotivo() {
        Matcher Motivo = p.matcher(txtMotivoConsulta.getText());
        if (Motivo.matches() == false) {
            txtMotivoConsulta.setBorder(BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
            txtMotivoConsulta.setForeground(new java.awt.Color(0, 0, 0));
        } else {
            txtMotivoConsulta.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
            txtMotivoConsulta.setForeground(new java.awt.Color(0, 155, 5));
        }
    }

    public void validarMedico() {
        Matcher Medico = p.matcher(txtMedico.getText());
        if (Medico.matches() == false) {
            txtMedico.setBorder(BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
            txtMedico.setForeground(new java.awt.Color(0, 0, 0));
        } else {
            txtMedico.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
            txtMedico.setForeground(new java.awt.Color(0, 155, 5));
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

        lblTitulo = new javax.swing.JLabel();
        jpDatos = new javax.swing.JPanel();
        lblCodigo = new javax.swing.JLabel();
        txtIdentificacion = new javax.swing.JTextField();
        lblApellido = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        lblGenero = new javax.swing.JLabel();
        cboGenero = new javax.swing.JComboBox<>();
        lblDireccion = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        lblCentroAtencion = new javax.swing.JLabel();
        txtCentroAtencion = new javax.swing.JTextField();
        lblMotivoConsulta = new javax.swing.JLabel();
        txtMotivoConsulta = new javax.swing.JTextField();
        lblMedico = new javax.swing.JLabel();
        txtMedico = new javax.swing.JTextField();
        lblFecha = new javax.swing.JLabel();
        cboAño = new javax.swing.JComboBox<>();
        cboMes = new javax.swing.JComboBox<>();
        cboDia = new javax.swing.JComboBox<>();
        lblDia = new javax.swing.JLabel();
        lblMes = new javax.swing.JLabel();
        lblAño = new javax.swing.JLabel();
        lblHora = new javax.swing.JLabel();
        cboHora = new javax.swing.JComboBox<>();
        cboMinutos = new javax.swing.JComboBox<>();
        lblHoras = new javax.swing.JLabel();
        lblMinutos = new javax.swing.JLabel();
        lblCual = new javax.swing.JLabel();
        txtGeneroOtro = new javax.swing.JTextField();
        cboCentro = new javax.swing.JComboBox<>();
        jpPanelControl = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        Restaurar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnEnviarTodo = new javax.swing.JButton();
        btnRellenar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnDatos = new javax.swing.JButton();
        btnMenu = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDatosPrincipales = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitulo.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblTitulo.setText("Secretaria de Salud");

        jpDatos.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Datos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N
        jpDatos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        lblCodigo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblCodigo.setText("Codigo/Identificación");

        txtIdentificacion.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtIdentificacion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtIdentificacionFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtIdentificacionFocusLost(evt);
            }
        });
        txtIdentificacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtIdentificacionKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdentificacionKeyTyped(evt);
            }
        });

        lblApellido.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblApellido.setText("Apellidos");

        txtApellidos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtApellidos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtApellidosFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtApellidosFocusLost(evt);
            }
        });
        txtApellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtApellidosKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidosKeyTyped(evt);
            }
        });

        lblNombre.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblNombre.setText("Nombres");

        txtNombres.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtNombres.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNombresFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNombresFocusLost(evt);
            }
        });
        txtNombres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombresKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombresKeyTyped(evt);
            }
        });

        lblGenero.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblGenero.setText("Genero");

        cboGenero.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cboGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Seleccionar--", "Masculino", "Femenino", "Otro" }));
        cboGenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboGeneroActionPerformed(evt);
            }
        });

        lblDireccion.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblDireccion.setText("Dirección de Residencia");

        txtDireccion.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        lblCentroAtencion.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblCentroAtencion.setText("Centro de Atención");

        txtCentroAtencion.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtCentroAtencion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCentroAtencionFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCentroAtencionFocusLost(evt);
            }
        });
        txtCentroAtencion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCentroAtencionKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCentroAtencionKeyTyped(evt);
            }
        });

        lblMotivoConsulta.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblMotivoConsulta.setText("Motivo de Consulta");

        txtMotivoConsulta.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtMotivoConsulta.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtMotivoConsultaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMotivoConsultaFocusLost(evt);
            }
        });
        txtMotivoConsulta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMotivoConsultaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMotivoConsultaKeyTyped(evt);
            }
        });

        lblMedico.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblMedico.setText("Medico");

        txtMedico.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtMedico.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtMedicoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMedicoFocusLost(evt);
            }
        });
        txtMedico.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMedicoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMedicoKeyTyped(evt);
            }
        });

        lblFecha.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblFecha.setText("Fecha");

        cboAño.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cboAño.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Seleccionar--", "2021", "2022", "2023", "2024", "2025" }));

        cboMes.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cboMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Seleccionar--", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
        cboMes.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboMesItemStateChanged(evt);
            }
        });

        cboDia.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cboDia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Seleccionar--", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        lblDia.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblDia.setText("Dia:");

        lblMes.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblMes.setText("Mes:");

        lblAño.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblAño.setText("Año:");

        lblHora.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblHora.setText("Hora");

        cboHora.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cboHora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Seleccionar--", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));

        cboMinutos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cboMinutos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Seleccionar--", "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));

        lblHoras.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblHoras.setText("Hora");

        lblMinutos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblMinutos.setText("Minutos");

        lblCual.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblCual.setText("Cual");

        txtGeneroOtro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtGeneroOtroFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtGeneroOtroFocusLost(evt);
            }
        });
        txtGeneroOtro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtGeneroOtroKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGeneroOtroKeyTyped(evt);
            }
        });

        cboCentro.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cboCentro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Seleccionar--", "Centro de Salud", "Clinica", "Hospital" }));

        javax.swing.GroupLayout jpDatosLayout = new javax.swing.GroupLayout(jpDatos);
        jpDatos.setLayout(jpDatosLayout);
        jpDatosLayout.setHorizontalGroup(
            jpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpDatosLayout.createSequentialGroup()
                        .addGroup(jpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cboHora, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboAño, javax.swing.GroupLayout.Alignment.LEADING, 0, 200, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboMinutos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(txtIdentificacion)
                    .addComponent(txtApellidos)
                    .addComponent(txtNombres)
                    .addComponent(txtDireccion)
                    .addComponent(txtMotivoConsulta)
                    .addComponent(txtMedico, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                    .addGroup(jpDatosLayout.createSequentialGroup()
                        .addGroup(jpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblGenero))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCual)
                            .addComponent(txtGeneroOtro)))
                    .addGroup(jpDatosLayout.createSequentialGroup()
                        .addGroup(jpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCodigo)
                            .addComponent(lblApellido)
                            .addComponent(lblNombre)
                            .addComponent(lblDireccion)
                            .addComponent(lblCentroAtencion)
                            .addComponent(lblMotivoConsulta)
                            .addComponent(lblMedico)
                            .addComponent(lblFecha)
                            .addComponent(lblMes)
                            .addComponent(lblAño)
                            .addComponent(cboDia, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDia)
                            .addComponent(cboMes, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblHora)
                            .addGroup(jpDatosLayout.createSequentialGroup()
                                .addComponent(lblHoras)
                                .addGap(183, 183, 183)
                                .addComponent(lblMinutos)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jpDatosLayout.createSequentialGroup()
                        .addComponent(cboCentro, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCentroAtencion)))
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
                .addGroup(jpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGenero)
                    .addComponent(lblCual))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGeneroOtro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDireccion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCentroAtencion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCentroAtencion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboCentro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addComponent(lblDia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblAño)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboAño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblHora)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHoras)
                    .addComponent(lblMinutos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboMinutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpPanelControl.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Panel de Control", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        btnGuardar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        Restaurar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        Restaurar.setText("Restaurar");
        Restaurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RestaurarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnEnviarTodo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnEnviarTodo.setText("Enviar Todo");
        btnEnviarTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarTodoActionPerformed(evt);
            }
        });

        btnRellenar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnRellenar.setText("Rellenar");
        btnRellenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRellenarActionPerformed(evt);
            }
        });

        btnSalir.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnDatos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnDatos.setText("Control");
        btnDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatosActionPerformed(evt);
            }
        });

        btnMenu.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnMenu.setText("Menu");
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpPanelControlLayout = new javax.swing.GroupLayout(jpPanelControl);
        jpPanelControl.setLayout(jpPanelControlLayout);
        jpPanelControlLayout.setHorizontalGroup(
            jpPanelControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPanelControlLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpPanelControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnEnviarTodo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpPanelControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnRellenar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Restaurar, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpPanelControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jpPanelControlLayout.createSequentialGroup()
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpPanelControlLayout.createSequentialGroup()
                        .addComponent(btnMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jpPanelControlLayout.setVerticalGroup(
            jpPanelControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPanelControlLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpPanelControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(Restaurar)
                    .addComponent(btnEliminar)
                    .addComponent(btnDatos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpPanelControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEnviarTodo)
                    .addComponent(btnRellenar)
                    .addComponent(btnSalir)
                    .addComponent(btnMenu))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Tabla de Datos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N

        tblDatosPrincipales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Identificación", "Apellidos", "Nombres", "Genero", "Dirección de Residencia", "Centro de Atención", "Motivo de Consulta", "Medico", "Fecha", "Hora"
            }
        ));
        jScrollPane1.setViewportView(tblDatosPrincipales);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1061, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitulo)
                    .addComponent(jpDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jpPanelControl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jpDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jpPanelControl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboMesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboMesItemStateChanged
        // TODO add your handling code here:
        if (cboMes.getSelectedIndex() > 0) {
            switch (cboMes.getSelectedIndex()) {
                case 1:
                    idmes = "01";
                    break;
                case 2:
                    idmes = "02";
                    break;
                case 3:
                    idmes = "03";
                    break;
                case 4:
                    idmes = "04";
                    break;
                case 5:
                    idmes = "05";
                    break;
                case 6:
                    idmes = "06";
                    break;
                case 7:
                    idmes = "07";
                    break;
                case 8:
                    idmes = "08";
                    break;
                case 9:
                    idmes = "09";
                    break;
                case 10:
                    idmes = "10";
                    break;
                case 11:
                    idmes = "11";
                    break;
                case 12:
                    idmes = "12";
                    break;
                default:
                    break;
            }
        }
    }//GEN-LAST:event_cboMesItemStateChanged

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        String opcion = (String) cboAño.getSelectedItem();
        String opcion2 = (String) cboDia.getSelectedItem();
        String opcion3 = (String) cboMes.getSelectedItem();
        String opcion4 = (String) cboCentro.getSelectedItem();
        String opcion5 = (String) cboGenero.getSelectedItem();
        String opcion6 = (String) cboHora.getSelectedItem();
        String opcion7 = (String) cboMinutos.getSelectedItem();
        Matcher Nombres = p.matcher(txtNombres.getText());
        Matcher Apellidos = p.matcher(txtApellidos.getText());
        Matcher Centro = p.matcher(txtCentroAtencion.getText());
        Matcher Motivo = p.matcher(txtMotivoConsulta.getText());
        Matcher Medico = p.matcher(txtMedico.getText());
        Matcher Genero = p.matcher(txtGeneroOtro.getText());
        if (txtIdentificacion.getText().length() == 0 || txtNombres.getText().length() == 0 || txtApellidos.getText().length() == 0 || txtDireccion.getText().length() == 0 || txtCentroAtencion.getText().length() == 0 || txtMotivoConsulta.getText().length() == 0 || txtMedico.getText().length() == 0 || opcion.equals("--Seleccionar--") || opcion2.equals("--Seleccionar--") || opcion3.equals("--Seleccionar--") || opcion4.equals("--Seleccionar--") || opcion5.equals("--Seleccionar--") || opcion6.equals("--Seleccionar--") || opcion7.equals("--Seleccionar--") || (opcion5.equals("Otro") && txtGeneroOtro.getText().length() == 0)) {
            JOptionPane.showMessageDialog(null, " LOS CAMPOS ESTAN EN BLANCO \n");
        } else if (Nombres.matches() == false || Apellidos.matches() == false || Centro.matches() == false || Motivo.matches() == false || Medico.matches() == false) {
            validarNombre();
            validarApellido();
            validarCentroAtencion();
            validarMotivo();
            validarMedico();
        } else if (opcion5.equals("Otro") && Genero.matches() == false) {
            validarGenero();
        } else {
            btnEnviarTodo.setEnabled(true);
            for (int i = 0; i < tblDatosPrincipales.getRowCount(); i++) {
                if (tblDatosPrincipales.getValueAt(i, 3).equals(genero()) && tblDatosPrincipales.getValueAt(i, 5).equals(centrosalud()) && tblDatosPrincipales.getValueAt(i, 7).equals(txtMedico.getText()) && tblDatosPrincipales.getValueAt(i, 8).equals(fecha()) && tblDatosPrincipales.getValueAt(i, 9).equals(hora())) {
                    JOptionPane.showMessageDialog(null, " HAY UN PROCEDIMIENTO AGENDADO EN LAS MISMAS FECHAS,HORA,CENTRO DE SALUD Y MEDICO \n ");
                    lista.remove(i);
                }
            }
            rellenar();
            restaurar();
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void RestaurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RestaurarActionPerformed
        // TODO add your handling code here:
        restaurar();
    }//GEN-LAST:event_RestaurarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        int fsel = tblDatosPrincipales.getSelectedRow();
        if (fsel == -1) {
            JOptionPane.showMessageDialog(null, "Debe selecionar el procedimiento a eliminar", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else if (fsel != -1) {
            if (JOptionPane.showConfirmDialog(rootPane, "¿Estas seguro de querer eliminar los datos?",
                    "Eliminar", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE) == JOptionPane.YES_OPTION) {
                lista.remove(tblDatosPrincipales.getSelectedRow());
                mostrar();
            } else {
                setDefaultCloseOperation(0);
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnEnviarTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarTodoActionPerformed
        // TODO add your handling code here:
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/bd_salud", "root", "");
            PreparedStatement pst = cn.prepareStatement("insert into pacientes values(?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, "0");
            if (JOptionPane.showConfirmDialog(rootPane, "¿Estas seguro de enviar todo?\n",
                    "Enviar Todo", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE) == JOptionPane.YES_OPTION) {
                for (int i = 0; i < tblDatosPrincipales.getRowCount(); i++) {
                    String Datos[] = new String[10];
                    Datos[0] = tblDatosPrincipales.getValueAt(i, 0).toString();
                    Datos[1] = tblDatosPrincipales.getValueAt(i, 1).toString();
                    Datos[2] = tblDatosPrincipales.getValueAt(i, 2).toString();
                    Datos[3] = tblDatosPrincipales.getValueAt(i, 3).toString();
                    Datos[4] = tblDatosPrincipales.getValueAt(i, 4).toString();
                    Datos[5] = tblDatosPrincipales.getValueAt(i, 5).toString();
                    Datos[6] = tblDatosPrincipales.getValueAt(i, 6).toString();
                    Datos[7] = tblDatosPrincipales.getValueAt(i, 7).toString();
                    Datos[8] = tblDatosPrincipales.getValueAt(i, 8).toString();
                    Datos[9] = tblDatosPrincipales.getValueAt(i, 9).toString();
                    pst.setString(2, Datos[0]);
                    pst.setString(3, Datos[1]);
                    pst.setString(4, Datos[2]);
                    pst.setString(5, Datos[3]);
                    pst.setString(6, Datos[4]);
                    pst.setString(7, Datos[5]);
                    pst.setString(8, Datos[6]);
                    pst.setString(9, Datos[7]);
                    pst.setString(10, Datos[8]);
                    pst.setString(11, Datos[9]);
                    pst.executeUpdate();
                }
            }
//            pst.setString(1, "0");
//            pst.setString(2, txtIdentificacion.getText().trim());
//            pst.setString(3, txtApellidos.getText().trim());
//            pst.setString(4, txtNombres.getText().trim());
//            pst.setString(5, genero());
//            pst.setString(6, txtDireccion.getText().trim());
//            pst.setString(7, txtCentroAtencion.getText().trim());
//            pst.setString(8, txtMotivoConsulta.getText().trim());
//            pst.setString(9, txtMedico.getText().trim());
//            pst.setString(10, fecha());
//            pst.setString(11, hora());
//            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, " REGISTRO EXITOSO \n");
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, " REGISTRO FALLIDO \n");
        }
    }//GEN-LAST:event_btnEnviarTodoActionPerformed

    private void btnRellenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRellenarActionPerformed
        // TODO add your handling code here:
        txtIdentificacion.setText("1003535625");
        txtApellidos.setText("Rodriguez Reyes");
        txtNombres.setText("Camilo Andres");
        txtDireccion.setText("Carrera 18A Numero 10-54");
        txtCentroAtencion.setText("El Rosal");
        txtMotivoConsulta.setText("Miopia");
        txtMedico.setText("Roberto Diaz Calderon");
        cboAño.setSelectedItem("2022");
        cboMes.setSelectedItem("Marzo");
        cboDia.setSelectedItem("29");
        cboGenero.setSelectedItem("Masculino");
        cboHora.setSelectedItem("6");
        cboMinutos.setSelectedItem("30");
        cboCentro.setSelectedItem("Centro de Salud");
    }//GEN-LAST:event_btnRellenarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        //Salir de la pestaña
        if (JOptionPane.showConfirmDialog(rootPane, "¿Estas seguro de querer salir?",
                "Salir", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE) == JOptionPane.YES_OPTION) {
            dispose();
            System.exit(0);
        } else {
            setDefaultCloseOperation(0);
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    private void cboGeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboGeneroActionPerformed
        // TODO add your handling code here:
        String opcion = (String) cboGenero.getSelectedItem();
        if (opcion.equals("Otro")) {
            lblCual.setVisible(true);
            txtGeneroOtro.setVisible(true);
        } else {
            lblCual.setVisible(false);
            txtGeneroOtro.setVisible(false);
        }
    }//GEN-LAST:event_cboGeneroActionPerformed

    private void btnDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatosActionPerformed
        // TODO add your handling code here:
        muestraDatos m = new muestraDatos();
        m.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnDatosActionPerformed

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        // TODO add your handling code here:
        Menu p = new Menu();
        p.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnMenuActionPerformed

    private void txtIdentificacionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdentificacionKeyPressed
        // TODO add your handling code here:
        validarIdentificacion();
    }//GEN-LAST:event_txtIdentificacionKeyPressed

    private void txtApellidosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidosKeyPressed
        // TODO add your handling code here:
        validarApellido();
    }//GEN-LAST:event_txtApellidosKeyPressed

    private void txtNombresKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombresKeyPressed
        // TODO add your handling code here:
        validarNombre();
    }//GEN-LAST:event_txtNombresKeyPressed

    private void txtGeneroOtroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGeneroOtroKeyPressed
        // TODO add your handling code here:
        validarGenero();
    }//GEN-LAST:event_txtGeneroOtroKeyPressed

    private void txtCentroAtencionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCentroAtencionKeyPressed
        // TODO add your handling code here:
        validarCentroAtencion();
    }//GEN-LAST:event_txtCentroAtencionKeyPressed

    private void txtMotivoConsultaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMotivoConsultaKeyPressed
        // TODO add your handling code here:
        validarMotivo();
    }//GEN-LAST:event_txtMotivoConsultaKeyPressed

    private void txtMedicoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMedicoKeyPressed
        // TODO add your handling code here:
        validarMedico();
    }//GEN-LAST:event_txtMedicoKeyPressed

    private void txtIdentificacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdentificacionKeyTyped
        char c = evt.getKeyChar();
        if (c < '0' || c > '9') {
            evt.consume();
        }
    }//GEN-LAST:event_txtIdentificacionKeyTyped

    private void txtApellidosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidosKeyTyped
        // TODO add your handling code here:
        validarApellido();
        char c = evt.getKeyChar();
        if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c > ' ') && (c < 'á' || c > 'ú') && (c < 'Á' || c > 'Ú')) {
            evt.consume();
        }
    }//GEN-LAST:event_txtApellidosKeyTyped

    private void txtNombresKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombresKeyTyped
        // TODO add your handling code here:
        validarNombre();
        char c = evt.getKeyChar();
        if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c > ' ') && (c < 'á' || c > 'ú') && (c < 'Á' || c > 'Ú')) {
            evt.consume();
        }
    }//GEN-LAST:event_txtNombresKeyTyped

    private void txtGeneroOtroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGeneroOtroKeyTyped
        // TODO add your handling code here:
        validarGenero();
        char c = evt.getKeyChar();
        if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c > ' ') && (c < 'á' || c > 'ú') && (c < 'Á' || c > 'Ú')) {
            evt.consume();
        }
    }//GEN-LAST:event_txtGeneroOtroKeyTyped

    private void txtCentroAtencionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCentroAtencionKeyTyped
        // TODO add your handling code here:
        validarCentroAtencion();
        char c = evt.getKeyChar();
        if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c > ' ') && (c < 'á' || c > 'ú') && (c < 'Á' || c > 'Ú')) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCentroAtencionKeyTyped

    private void txtMotivoConsultaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMotivoConsultaKeyTyped
        // TODO add your handling code here:
        validarMotivo();
        char c = evt.getKeyChar();
        if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c > ' ') && (c < 'á' || c > 'ú') && (c < 'Á' || c > 'Ú')) {
            evt.consume();
        }
    }//GEN-LAST:event_txtMotivoConsultaKeyTyped

    private void txtMedicoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMedicoKeyTyped
        // TODO add your handling code here:
        validarMedico();
        char c = evt.getKeyChar();
        if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c > ' ') && (c < 'á' || c > 'ú') && (c < 'Á' || c > 'Ú')) {
            evt.consume();
        }
    }//GEN-LAST:event_txtMedicoKeyTyped

    private void txtIdentificacionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIdentificacionFocusGained
        // TODO add your handling code here:
        validarIdentificacion();
    }//GEN-LAST:event_txtIdentificacionFocusGained

    private void txtApellidosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtApellidosFocusGained
        // TODO add your handling code here:
        validarApellido();
    }//GEN-LAST:event_txtApellidosFocusGained

    private void txtNombresFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombresFocusGained
        // TODO add your handling code here:
        validarNombre();
    }//GEN-LAST:event_txtNombresFocusGained

    private void txtGeneroOtroFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtGeneroOtroFocusGained
        // TODO add your handling code here:
        validarGenero();
    }//GEN-LAST:event_txtGeneroOtroFocusGained

    private void txtCentroAtencionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCentroAtencionFocusGained
        // TODO add your handling code here:
        validarCentroAtencion();
    }//GEN-LAST:event_txtCentroAtencionFocusGained

    private void txtMotivoConsultaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMotivoConsultaFocusGained
        // TODO add your handling code here:
        validarMotivo();
    }//GEN-LAST:event_txtMotivoConsultaFocusGained

    private void txtMedicoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMedicoFocusGained
        // TODO add your handling code here:
        validarMedico();
    }//GEN-LAST:event_txtMedicoFocusGained

    private void txtIdentificacionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIdentificacionFocusLost
        // TODO add your handling code here:
        validarIdentificacion();
    }//GEN-LAST:event_txtIdentificacionFocusLost

    private void txtApellidosFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtApellidosFocusLost
        // TODO add your handling code here:
        validarApellido();
    }//GEN-LAST:event_txtApellidosFocusLost

    private void txtNombresFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombresFocusLost
        // TODO add your handling code here:
        validarNombre();
    }//GEN-LAST:event_txtNombresFocusLost

    private void txtGeneroOtroFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtGeneroOtroFocusLost
        // TODO add your handling code here:
        validarGenero();
    }//GEN-LAST:event_txtGeneroOtroFocusLost

    private void txtCentroAtencionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCentroAtencionFocusLost
        // TODO add your handling code here:
        validarCentroAtencion();
    }//GEN-LAST:event_txtCentroAtencionFocusLost

    private void txtMotivoConsultaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMotivoConsultaFocusLost
        // TODO add your handling code here:
        validarMotivo();
    }//GEN-LAST:event_txtMotivoConsultaFocusLost

    private void txtMedicoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMedicoFocusLost
        // TODO add your handling code here:
        validarMedico();
    }//GEN-LAST:event_txtMedicoFocusLost

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
            java.util.logging.Logger.getLogger(InserccionDatosMedicos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InserccionDatosMedicos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InserccionDatosMedicos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InserccionDatosMedicos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InserccionDatosMedicos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Restaurar;
    private javax.swing.JButton btnDatos;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnEnviarTodo;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnMenu;
    private javax.swing.JButton btnRellenar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cboAño;
    private javax.swing.JComboBox<String> cboCentro;
    private javax.swing.JComboBox<String> cboDia;
    private javax.swing.JComboBox<String> cboGenero;
    private javax.swing.JComboBox<String> cboHora;
    private javax.swing.JComboBox<String> cboMes;
    private javax.swing.JComboBox<String> cboMinutos;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jpDatos;
    private javax.swing.JPanel jpPanelControl;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblAño;
    private javax.swing.JLabel lblCentroAtencion;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblCual;
    private javax.swing.JLabel lblDia;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblGenero;
    private javax.swing.JLabel lblHora;
    private javax.swing.JLabel lblHoras;
    private javax.swing.JLabel lblMedico;
    private javax.swing.JLabel lblMes;
    private javax.swing.JLabel lblMinutos;
    private javax.swing.JLabel lblMotivoConsulta;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tblDatosPrincipales;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtCentroAtencion;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtGeneroOtro;
    private javax.swing.JTextField txtIdentificacion;
    private javax.swing.JTextField txtMedico;
    private javax.swing.JTextField txtMotivoConsulta;
    private javax.swing.JTextField txtNombres;
    // End of variables declaration//GEN-END:variables
}
