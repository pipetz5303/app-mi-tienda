/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.proyectoappmitienda;

import java.sql.Connection;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Felipe
 */
public class InterfazMostrarPedido extends javax.swing.JFrame {

    String numeroMesa;
    String numeroPedido;
    Conexion con;
    Connection condb;
    CRUDSqlServer crud;
    Pedido listaPedidos;
    List<Producto> listaProductos;
    Pedido pedidoTraido;
    /**
     * Creates new form InterfazRegistrarProducto
     */
    public InterfazMostrarPedido(Pedido pedido) {
        pedidoTraido = pedido;
        numeroMesa = String.valueOf(pedidoTraido.getNumeroMesa());
        numeroPedido = String.valueOf(pedidoTraido.getIdPedido());
        initComponents();
        jLblPedido.setText(jLblPedido.getText()+ " "+ pedido.getIdPedido());
        jTxtMesa.setText(numeroMesa);
        jTxtNombre.setText(pedido.getNombre());
        con = new Conexion();
        condb = con.ObtenerConexion();
        crud = new CRUDSqlServer();
        buscarPedidoProductos();
        
        if(pedido.getEstado()==1){
            jRBtnSi.setSelected(true);
        }else{
            jRBtnNo.setSelected(true);
        }
        
    }

    //busca el pedido y lo pone en la la info
    private void buscarPedidoProductos(){
        listaProductos = crud.obtenerPedidoProductos(condb, numeroPedido);
        //mostrarlos en la tabla productos       
        imprimirProductos();
    }
    
    public void imprimirProductos() {
        //defino el modelo de la tabla y le indico como se llama
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) jTProductos.getModel();

        //Limpiar la tabla
        int i = 0;
        if (modelo.getRowCount() != 0) {
            while (i != -1) {
                try {
                    modelo.removeRow(modelo.getRowCount() - 1);
                } catch (Exception e) {
                    i = -1;
                }
            }
        }
        try {

            List<Producto> listaP = listaProductos;
            Iterator<Producto> it = listaP.iterator();
            //como uso 5 columnas el arreglo es de 5
            String[] obj = new String[5];
            while (it.hasNext()) {
                Producto p = it.next();
                obj[0] = String.valueOf(p.getIdProducto());
                obj[1] = p.getNombreProducto();
                obj[2] = String.valueOf(p.getPrecioActual());
                obj[3] = String.valueOf(p.getUnidadesDisponibles());
                obj[4] = String.valueOf( p.getPrecioActual()* p.getUnidadesDisponibles());
                
                modelo.addRow(obj);

            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanelPedido = new javax.swing.JPanel();
        jLblPedido = new javax.swing.JLabel();
        jLblNombre = new javax.swing.JLabel();
        jLblCategoria = new javax.swing.JLabel();
        jLblPrecio = new javax.swing.JLabel();
        jLblPedidoPer = new javax.swing.JLabel();
        jRBtnSi = new javax.swing.JRadioButton();
        jRBtnNo = new javax.swing.JRadioButton();
        jTxtMesa = new javax.swing.JTextField();
        jTxtNombre = new javax.swing.JTextField();
        jPanelProductos = new javax.swing.JPanel();
        jLblProductos = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTProductos = new javax.swing.JTable();
        jBtnCancelar = new javax.swing.JButton();
        jBtnGuardarCambio = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 600));
        setName("JFrameRegProd"); // NOI18N
        setSize(new java.awt.Dimension(800, 600));

        jPanelPedido.setBackground(new java.awt.Color(255, 255, 255));
        jPanelPedido.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(125, 93, 251), 1, true));
        jPanelPedido.setForeground(new java.awt.Color(51, 51, 51));
        jPanelPedido.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N

        jLblPedido.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLblPedido.setForeground(new java.awt.Color(125, 93, 251));
        jLblPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pedido.PNG"))); // NOI18N
        jLblPedido.setText("Pedido No.");

        jLblNombre.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLblNombre.setText("Nombre:");

        jLblCategoria.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLblCategoria.setText("Mesa:");

        jLblPrecio.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLblPrecio.setText("Pago:");

        jLblPedidoPer.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLblPedidoPer.setForeground(new java.awt.Color(102, 102, 102));
        jLblPedidoPer.setText("Pedido por:");

        buttonGroup1.add(jRBtnSi);
        jRBtnSi.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        jRBtnSi.setText("Si");

        buttonGroup1.add(jRBtnNo);
        jRBtnNo.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        jRBtnNo.setText("No");

        jTxtMesa.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jTxtMesa.setDisabledTextColor(new java.awt.Color(125, 95, 219));
        jTxtMesa.setEnabled(false);

        jTxtNombre.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jTxtNombre.setDisabledTextColor(new java.awt.Color(125, 95, 219));
        jTxtNombre.setEnabled(false);

        javax.swing.GroupLayout jPanelPedidoLayout = new javax.swing.GroupLayout(jPanelPedido);
        jPanelPedido.setLayout(jPanelPedidoLayout);
        jPanelPedidoLayout.setHorizontalGroup(
            jPanelPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPedidoLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(jPanelPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelPedidoLayout.createSequentialGroup()
                        .addGroup(jPanelPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLblPedidoPer, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLblPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(409, 409, 409))
                    .addGroup(jPanelPedidoLayout.createSequentialGroup()
                        .addGroup(jPanelPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLblCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                            .addComponent(jTxtMesa))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(jPanelPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLblPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelPedidoLayout.createSequentialGroup()
                                .addComponent(jRBtnSi)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRBtnNo)))
                        .addGap(40, 40, 40))))
        );
        jPanelPedidoLayout.setVerticalGroup(
            jPanelPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPedidoLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLblPedido)
                .addGap(18, 18, 18)
                .addComponent(jLblPedidoPer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelPedidoLayout.createSequentialGroup()
                        .addGroup(jPanelPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLblNombre)
                            .addComponent(jLblPrecio)
                            .addComponent(jLblCategoria))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTxtMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jRBtnSi)
                        .addComponent(jRBtnNo)))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jPanelProductos.setBackground(new java.awt.Color(255, 255, 255));
        jPanelProductos.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(125, 93, 251), 1, true));
        jPanelProductos.setForeground(new java.awt.Color(51, 51, 51));
        jPanelProductos.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N

        jLblProductos.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLblProductos.setForeground(new java.awt.Color(102, 102, 102));
        jLblProductos.setText("Productos");

        jTProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id", "Nombre", "Precio", "Cantidad", "Subtotal"
            }
        ));
        jScrollPane2.setViewportView(jTProductos);

        javax.swing.GroupLayout jPanelProductosLayout = new javax.swing.GroupLayout(jPanelProductos);
        jPanelProductos.setLayout(jPanelProductosLayout);
        jPanelProductosLayout.setHorizontalGroup(
            jPanelProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProductosLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(jPanelProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLblProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanelProductosLayout.setVerticalGroup(
            jPanelProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProductosLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLblProductos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

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

        jBtnGuardarCambio.setBackground(new java.awt.Color(125, 93, 251));
        jBtnGuardarCambio.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jBtnGuardarCambio.setForeground(new java.awt.Color(255, 255, 255));
        jBtnGuardarCambio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/diskette.png"))); // NOI18N
        jBtnGuardarCambio.setText("Guardar");
        jBtnGuardarCambio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtnGuardarCambioMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jBtnGuardarCambioMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jBtnGuardarCambioMouseReleased(evt);
            }
        });
        jBtnGuardarCambio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnGuardarCambioActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo.PNG"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(197, 197, 197)
                .addComponent(jBtnGuardarCambio, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jBtnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanelPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanelProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(196, 196, 196))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanelPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanelProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnGuardarCambio, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnGuardarCambioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnGuardarCambioMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnGuardarCambioMouseClicked

    private void jBtnGuardarCambioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnGuardarCambioMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnGuardarCambioMousePressed

    private void jBtnGuardarCambioMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnGuardarCambioMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnGuardarCambioMouseReleased

    private void jBtnGuardarCambioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnGuardarCambioActionPerformed
        boolean pago = jRBtnSi.isSelected();
        
        if(pago){
            crud.actualizarPedido(condb, String.valueOf(pedidoTraido.getIdPedido()));
            dispose();
        }else{
            JOptionPane.showMessageDialog(null,"no hizo cambios");
            
        }
        
              
    }//GEN-LAST:event_jBtnGuardarCambioActionPerformed

    private void jBtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancelarActionPerformed
        int opcion = JOptionPane.showConfirmDialog(rootPane, "Esta seguro que desea cancelar", "Cancelar edición", JOptionPane.YES_NO_OPTION) ;
        if(opcion==1){
            JOptionPane.showMessageDialog(rootPane, "Usted ha cancelado la edición");
            dispose();
        }
    }//GEN-LAST:event_jBtnCancelarActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jBtnCancelar;
    private javax.swing.JButton jBtnGuardarCambio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLblCategoria;
    private javax.swing.JLabel jLblNombre;
    private javax.swing.JLabel jLblPedido;
    private javax.swing.JLabel jLblPedidoPer;
    private javax.swing.JLabel jLblPrecio;
    private javax.swing.JLabel jLblProductos;
    private javax.swing.JPanel jPanelPedido;
    private javax.swing.JPanel jPanelProductos;
    private javax.swing.JRadioButton jRBtnNo;
    private javax.swing.JRadioButton jRBtnSi;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTProductos;
    private javax.swing.JTextField jTxtMesa;
    private javax.swing.JTextField jTxtNombre;
    // End of variables declaration//GEN-END:variables
}
