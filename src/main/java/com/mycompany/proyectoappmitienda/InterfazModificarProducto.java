/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.proyectoappmitienda;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Felipe
 */
public class InterfazModificarProducto extends javax.swing.JFrame {

    Conexion con;
    Connection condb;
    CRUDSqlServer crud;
    List<Producto> listaProductos;
    List<Categoria> ListaCategorias;
    
    /**
     * Creates new form InterfazRegistrarProducto
     */
    public InterfazModificarProducto() {
        initComponents();
        con = new Conexion();
        condb = con.ObtenerConexion();
        crud = new CRUDSqlServer();
        listaProductos = crud.obtenerProductos(condb);
        ListaCategorias = crud.obtenerCategorias(condb);
        cargarComboBoxCategoria();
        
        
        jCBCategoria.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            jCBNombre.removeAllItems();
            listaProductos = crud.obtenerProductosPorCategoria(condb, jCBCategoria.getSelectedItem().toString());
            cargarComboBoxProductos();
        }
});
        
        
    }
    
    public void cargarComboBoxCategoria(){
        for(Categoria categoria : ListaCategorias){
            jCBCategoria.addItem(categoria.getNombre());
        }
    }
    
    public void cargarComboBoxProductos(){
        jCBNombre.addItem("Seleccione");
        for(Producto producto : listaProductos){
            jCBNombre.addItem(producto.getNombreProducto());
        }
    }

    public void limpiarCasillas(){
        jCBNombre.removeAllItems();
        jCBNombre.addItem("Seleccione");
        jCBCategoria.setSelectedIndex(0);
        jCBNombre.setSelectedIndex(0);
        jTxtFPrecio.setText("Precio");
        jSpnUnidades.setValue(0);
        jTxtFNombre.setText("Nombre");
        jSpnUnidades.setEnabled(false);
        jTxtFPrecio.setEnabled(false);
        jTxtFNombre.setEnabled(false);
        jBtnEliminar.setEnabled(false);
        jBtnGuardarPro.setEnabled(false);
        jTxtFId.setText("");
        
    }    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelModProducto = new javax.swing.JPanel();
        jLblModProducto = new javax.swing.JLabel();
        jLblNombre = new javax.swing.JLabel();
        jLblCategoria = new javax.swing.JLabel();
        jLblPrecio = new javax.swing.JLabel();
        jLblUnidades = new javax.swing.JLabel();
        jCBCategoria = new javax.swing.JComboBox<>();
        jTxtFPrecio = new javax.swing.JTextField();
        jSpnUnidades = new javax.swing.JSpinner();
        jBtnGuardarPro = new javax.swing.JButton();
        jBtnCancelar = new javax.swing.JButton();
        jBtnBuscar = new javax.swing.JButton();
        jBtnEliminar = new javax.swing.JButton();
        jCBNombre = new javax.swing.JComboBox<>();
        jLblPrecio1 = new javax.swing.JLabel();
        jTxtFId = new javax.swing.JTextField();
        jBtnEditar = new javax.swing.JButton();
        jLblNombre1 = new javax.swing.JLabel();
        jTxtFNombre = new javax.swing.JTextField();
        jBtnVerProductos = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 600));
        setName("JFrameRegProd"); // NOI18N
        setSize(new java.awt.Dimension(800, 600));

        jPanelModProducto.setBackground(new java.awt.Color(255, 255, 255));
        jPanelModProducto.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(125, 93, 251), 1, true));
        jPanelModProducto.setForeground(new java.awt.Color(51, 51, 51));
        jPanelModProducto.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N

        jLblModProducto.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLblModProducto.setForeground(new java.awt.Color(125, 93, 251));
        jLblModProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/producto-mod.png"))); // NOI18N
        jLblModProducto.setText("Modificar Producto");

        jLblNombre.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        jLblNombre.setText("Nombre:");

        jLblCategoria.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        jLblCategoria.setText("Categoria:");

        jLblPrecio.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        jLblPrecio.setText("Precio:");

        jLblUnidades.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        jLblUnidades.setText("Unidades:");

        jCBCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione" }));
        jCBCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBCategoriaActionPerformed(evt);
            }
        });

        jTxtFPrecio.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jTxtFPrecio.setText("Precio");
        jTxtFPrecio.setDisabledTextColor(new java.awt.Color(125, 95, 219));
        jTxtFPrecio.setEnabled(false);
        jTxtFPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtFPrecioActionPerformed(evt);
            }
        });
        jTxtFPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTxtFPrecioKeyTyped(evt);
            }
        });

        jSpnUnidades.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jSpnUnidades.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        jSpnUnidades.setEnabled(false);

        jBtnGuardarPro.setBackground(new java.awt.Color(125, 93, 251));
        jBtnGuardarPro.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jBtnGuardarPro.setForeground(new java.awt.Color(255, 255, 255));
        jBtnGuardarPro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/diskette.png"))); // NOI18N
        jBtnGuardarPro.setText("Guardar");
        jBtnGuardarPro.setEnabled(false);
        jBtnGuardarPro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtnGuardarProMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jBtnGuardarProMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jBtnGuardarProMouseReleased(evt);
            }
        });
        jBtnGuardarPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnGuardarProActionPerformed(evt);
            }
        });

        jBtnCancelar.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jBtnCancelar.setForeground(new java.awt.Color(125, 93, 251));
        jBtnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x-button.png"))); // NOI18N
        jBtnCancelar.setText("Cancelar");
        jBtnCancelar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(125, 93, 251)));
        jBtnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jBtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCancelarActionPerformed(evt);
            }
        });

        jBtnBuscar.setBackground(new java.awt.Color(188, 177, 252));
        jBtnBuscar.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jBtnBuscar.setForeground(new java.awt.Color(125, 93, 251));
        jBtnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/loupe.png"))); // NOI18N
        jBtnBuscar.setText("Buscar");
        jBtnBuscar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(125, 93, 251)));
        jBtnBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtnBuscarMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jBtnBuscarMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jBtnBuscarMouseReleased(evt);
            }
        });
        jBtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnBuscarActionPerformed(evt);
            }
        });

        jBtnEliminar.setBackground(new java.awt.Color(125, 93, 251));
        jBtnEliminar.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jBtnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        jBtnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete.png"))); // NOI18N
        jBtnEliminar.setText("Eliminar");
        jBtnEliminar.setEnabled(false);
        jBtnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtnEliminarMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jBtnEliminarMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jBtnEliminarMouseReleased(evt);
            }
        });
        jBtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEliminarActionPerformed(evt);
            }
        });

        jCBNombre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione" }));

        jLblPrecio1.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        jLblPrecio1.setText("Id:");

        jTxtFId.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jTxtFId.setText("Id");
        jTxtFId.setDisabledTextColor(new java.awt.Color(125, 95, 219));
        jTxtFId.setEnabled(false);
        jTxtFId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtFIdActionPerformed(evt);
            }
        });
        jTxtFId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTxtFIdKeyTyped(evt);
            }
        });

        jBtnEditar.setBackground(new java.awt.Color(125, 93, 251));
        jBtnEditar.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jBtnEditar.setForeground(new java.awt.Color(255, 255, 255));
        jBtnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/edit.png"))); // NOI18N
        jBtnEditar.setText("Editar");
        jBtnEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtnEditarMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jBtnEditarMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jBtnEditarMouseReleased(evt);
            }
        });
        jBtnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEditarActionPerformed(evt);
            }
        });

        jLblNombre1.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        jLblNombre1.setText("Nombre:");

        jTxtFNombre.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jTxtFNombre.setForeground(new java.awt.Color(125, 95, 219));
        jTxtFNombre.setText("Nombre");
        jTxtFNombre.setDisabledTextColor(new java.awt.Color(125, 95, 219));
        jTxtFNombre.setEnabled(false);

        javax.swing.GroupLayout jPanelModProductoLayout = new javax.swing.GroupLayout(jPanelModProducto);
        jPanelModProducto.setLayout(jPanelModProductoLayout);
        jPanelModProductoLayout.setHorizontalGroup(
            jPanelModProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelModProductoLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanelModProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelModProductoLayout.createSequentialGroup()
                        .addComponent(jBtnGuardarPro)
                        .addGap(18, 18, 18)
                        .addComponent(jBtnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBtnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBtnEliminar))
                    .addGroup(jPanelModProductoLayout.createSequentialGroup()
                        .addGroup(jPanelModProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLblPrecio1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTxtFId, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelModProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLblNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTxtFNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanelModProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanelModProductoLayout.createSequentialGroup()
                                .addComponent(jLblPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50))
                            .addComponent(jTxtFPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelModProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLblUnidades, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpnUnidades, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelModProductoLayout.createSequentialGroup()
                        .addGroup(jPanelModProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLblCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCBCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelModProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelModProductoLayout.createSequentialGroup()
                                .addGroup(jPanelModProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jCBNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(25, 25, 25)
                                .addComponent(jBtnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLblModProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanelModProductoLayout.setVerticalGroup(
            jPanelModProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelModProductoLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLblModProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelModProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblCategoria)
                    .addComponent(jLblNombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelModProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCBNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanelModProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelModProductoLayout.createSequentialGroup()
                        .addComponent(jLblPrecio1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTxtFId, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelModProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanelModProductoLayout.createSequentialGroup()
                            .addComponent(jLblNombre1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTxtFNombre))
                        .addGroup(jPanelModProductoLayout.createSequentialGroup()
                            .addComponent(jLblPrecio)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTxtFPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanelModProductoLayout.createSequentialGroup()
                            .addComponent(jLblUnidades)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jSpnUnidades, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(jPanelModProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnGuardarPro, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        jBtnVerProductos.setBackground(new java.awt.Color(125, 93, 251));
        jBtnVerProductos.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jBtnVerProductos.setForeground(new java.awt.Color(255, 255, 255));
        jBtnVerProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ver-productos.png"))); // NOI18N
        jBtnVerProductos.setText("Ver Productos");
        jBtnVerProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnVerProductosActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo.PNG"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanelModProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jBtnVerProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(84, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jPanelModProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jBtnVerProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTxtFPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtFPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtFPrecioActionPerformed

    private void jBtnGuardarProMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnGuardarProMouseReleased
        jBtnGuardarPro.setBackground(new java.awt.Color(125, 93, 251));
        
    }//GEN-LAST:event_jBtnGuardarProMouseReleased

    private void jBtnGuardarProMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnGuardarProMouseClicked
       
    }//GEN-LAST:event_jBtnGuardarProMouseClicked

    private void jBtnGuardarProMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnGuardarProMousePressed
        jBtnGuardarPro.setBackground(new java.awt.Color(188, 177, 252));
    }//GEN-LAST:event_jBtnGuardarProMousePressed

    private void jBtnBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnBuscarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnBuscarMouseClicked

    private void jBtnBuscarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnBuscarMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnBuscarMousePressed

    private void jBtnBuscarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnBuscarMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnBuscarMouseReleased

    private void jBtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancelarActionPerformed
        limpiarCasillas();
        
    }//GEN-LAST:event_jBtnCancelarActionPerformed

    private void jTxtFPrecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtFPrecioKeyTyped
       char c = evt.getKeyChar();
            if (!Character.isDigit(c)) {
                evt.consume();  // Ignora si no es un número
            }
    }//GEN-LAST:event_jTxtFPrecioKeyTyped

    private void jBtnVerProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnVerProductosActionPerformed
        new InterfazMostrarProductos().setVisible(true);
        dispose();
        
    }//GEN-LAST:event_jBtnVerProductosActionPerformed

    private void jBtnEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnEliminarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnEliminarMouseClicked

    private void jBtnEliminarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnEliminarMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnEliminarMousePressed

    private void jBtnEliminarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnEliminarMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnEliminarMouseReleased

    private void jCBCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBCategoriaActionPerformed
        
    }//GEN-LAST:event_jCBCategoriaActionPerformed

    private void jTxtFIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtFIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtFIdActionPerformed

    private void jTxtFIdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtFIdKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtFIdKeyTyped

    private void jBtnEditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnEditarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnEditarMouseClicked

    private void jBtnEditarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnEditarMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnEditarMousePressed

    private void jBtnEditarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnEditarMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnEditarMouseReleased

    //busca en base de datos y lo asigna
    private void jBtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnBuscarActionPerformed
        String categoria = jCBCategoria.getSelectedItem().toString();
        String nombre = jCBNombre.getSelectedItem().toString();
        
        
        con = new Conexion();
        condb = con.ObtenerConexion();
        crud = new CRUDSqlServer();
        
              
        if(!categoria.matches("Seleccione") && !nombre.matches("Seleccione")){
            Producto p = new Producto();
            p.setNombreProducto(nombre);
            p = crud.buscarProducto(condb, p);
            jTxtFId.setText(String.valueOf(p.getIdProducto()));
            jTxtFNombre.setText(p.getNombreProducto());
            jSpnUnidades.setValue(p.getUnidadesDisponibles());
            jTxtFPrecio.setText(String.valueOf(p.getPrecioActual()));
            
                       
        }else{
            JOptionPane.showMessageDialog(rootPane, "Nombre ingresado no es válido. Intente de nuevo", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        jSpnUnidades.setEnabled(false);
        jTxtFPrecio.setEnabled(false);
        jTxtFNombre.setEnabled(false);
        jBtnEliminar.setEnabled(false);
        jBtnGuardarPro.setEnabled(false);
               
    }//GEN-LAST:event_jBtnBuscarActionPerformed

    //habilita todo para que pueda editar
    private void jBtnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEditarActionPerformed
        jSpnUnidades.setEnabled(true);
        jTxtFPrecio.setEnabled(true);
        jTxtFNombre.setEnabled(true);
        jBtnEliminar.setEnabled(true);
        jBtnGuardarPro.setEnabled(true);
    }//GEN-LAST:event_jBtnEditarActionPerformed

    private void jBtnGuardarProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnGuardarProActionPerformed
        //recolecta la info
        int id = Integer.parseInt(jTxtFId.getText());
        String nombre = jTxtFNombre.getText();
        String categoria = jCBCategoria.getSelectedItem().toString();
        int unidades = (int) jSpnUnidades.getValue();
        int precio = Integer.parseInt(jTxtFPrecio.getText());
        
        
        //conexion
        con = new Conexion();
        condb = con.ObtenerConexion();
        crud = new CRUDSqlServer();
        
        //cambios
        if(!categoria.matches("Seleccione") && !nombre.matches("Nombre")){
            Producto p = new Producto();
            p.setNombreProducto(nombre);
            p.setIdProducto(id);
            p.setCategoria(categoria);
            p.setPrecioActual(precio);
            p.setUnidadesDisponibles(unidades);
                       
            p = crud.editarProducto(condb, p);
            
            dispose();
            
                       
        }else{
            JOptionPane.showMessageDialog(rootPane, "Nombre ingresado no es válido. Intente de nuevo", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_jBtnGuardarProActionPerformed

    private void jBtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEliminarActionPerformed
        //recolecta la info
        int id = Integer.parseInt(jTxtFId.getText());
        int opcion = JOptionPane.showConfirmDialog(rootPane, ("Esta seguuro que desea eliminar "+ jTxtFNombre.getText()), "Eliminar producto",JOptionPane.YES_NO_OPTION);
        
        if(opcion ==0){
            //conexion
            con = new Conexion();
            condb = con.ObtenerConexion();
            crud = new CRUDSqlServer();

            //cambios
            crud.eliminarProducto(condb, id);
            dispose();
        }
        
        
            
                       
        
        
    }//GEN-LAST:event_jBtnEliminarActionPerformed
    
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnBuscar;
    private javax.swing.JButton jBtnCancelar;
    private javax.swing.JButton jBtnEditar;
    private javax.swing.JButton jBtnEliminar;
    private javax.swing.JButton jBtnGuardarPro;
    private javax.swing.JButton jBtnVerProductos;
    private javax.swing.JComboBox<String> jCBCategoria;
    private javax.swing.JComboBox<String> jCBNombre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLblCategoria;
    private javax.swing.JLabel jLblModProducto;
    private javax.swing.JLabel jLblNombre;
    private javax.swing.JLabel jLblNombre1;
    private javax.swing.JLabel jLblPrecio;
    private javax.swing.JLabel jLblPrecio1;
    private javax.swing.JLabel jLblUnidades;
    private javax.swing.JPanel jPanelModProducto;
    private javax.swing.JSpinner jSpnUnidades;
    private javax.swing.JTextField jTxtFId;
    private javax.swing.JTextField jTxtFNombre;
    private javax.swing.JTextField jTxtFPrecio;
    // End of variables declaration//GEN-END:variables
}
