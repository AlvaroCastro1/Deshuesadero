/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package formularios;

import com.toedter.calendar.JTextFieldDateEditor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alvaro
 */
public class Venta extends javax.swing.JInternalFrame {

    PreparedStatement ps;
    ResultSet rs;
    Conexion conC = new Conexion();

    /**
     * Creates new form Venta
     */
    public Venta() {
        initComponents();
        setDateToday();
        txt_idVenta.setText("" + (idVenta() + 1));
        setVendedores();
        setCarros();
    }

    private int idVenta() {
        int id = 0;
        Connection con = null;

        try {
            con = conC.getConnection();
            ps = con.prepareStatement("SELECT id_venta FROM Venta ORDER by id_venta ASC LIMIT 1");
            rs = ps.executeQuery();

            while (rs.next()) {
                id = rs.getInt("id_venta");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hay un error en la BD", "Error", JOptionPane.ERROR_MESSAGE);
        }
        id = (id == 0) ? 0 : id;
        return id;
    }

    private void setVendedores() {
        Connection con = null;
        try {
            con = conC.getConnection();
            ps = con.prepareStatement("select id from vendedor");

            rs = ps.executeQuery();

            while (rs.next()) {
                cb_vendedores.addItem(rs.getString("id"));
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void setCarros() {
        Connection con = null;
        try {
            con = conC.getConnection();
            ps = con.prepareStatement(" select num_serie, linea from Carro");

            rs = ps.executeQuery();

            while (rs.next()) {
                cb_carros.addItem(rs.getString("num_serie"));
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void setPiezas() {
        cb_piezas.removeAllItems();
        cb_piezas.addItem("Seleccione");

        Connection con = null;

        try {
            con = conC.getConnection();
            Thread.sleep(100);
            ps = con.prepareStatement("select num_pieza from pieza Where num_serie = ? and estado = 1 or estado = 2");
            ps.setString(1, cb_carros.getSelectedItem().toString());

            rs = ps.executeQuery();

            while (rs.next()) {
                cb_piezas.addItem(rs.getString("num_pieza"));
            }

        } catch (Exception e) {
            System.err.println(e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jButton26 = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        cb_vendedores = new javax.swing.JComboBox<>();
        jLabel24 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txt_idVenta = new javax.swing.JTextField();
        jD_fech = new com.toedter.calendar.JDateChooser();
        txt_subtotal = new javax.swing.JTextField();
        btn_agregar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tb_productos = new javax.swing.JTable();
        txt_total = new javax.swing.JTextField();
        cb_carros = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        cb_piezas = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        txt_linea = new javax.swing.JTextField();
        txt_nomPieza = new javax.swing.JTextField();
        btn_borrar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Venta");

        jPanel5.setBackground(new java.awt.Color(0, 0, 0));

        jButton26.setText("Vender");
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });

        jLabel22.setText("N°");

        jLabel23.setText("ID Vendedor");

        cb_vendedores.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione" }));

        jLabel24.setText("Num Pieza:");

        jLabel26.setText("$");

        txt_idVenta.setEditable(false);

        jD_fech.setEnabled(false);

        btn_agregar.setText("Agregar");
        btn_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregarActionPerformed(evt);
            }
        });

        tb_productos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Numero Serie", "Numero Pieza", "Subtotal"
            }
        ));
        jScrollPane3.setViewportView(tb_productos);

        txt_total.setEditable(false);

        cb_carros.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione" }));
        cb_carros.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_carrosItemStateChanged(evt);
            }
        });

        jLabel21.setText("Carro:");

        cb_piezas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione" }));
        cb_piezas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_piezasItemStateChanged(evt);
            }
        });
        cb_piezas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_piezasActionPerformed(evt);
            }
        });

        jLabel1.setText("Total:");

        txt_linea.setEditable(false);

        txt_nomPieza.setEditable(false);

        btn_borrar.setText("Borrar");
        btn_borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_borrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cb_vendedores, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(txt_idVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jD_fech, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(54, 54, 54))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jButton26, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(41, 41, 41)
                        .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(0, 39, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_linea)
                                    .addComponent(cb_carros, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_nomPieza)
                                    .addComponent(cb_piezas, 0, 240, Short.MAX_VALUE))
                                .addGap(46, 46, 46)
                                .addComponent(jLabel26)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(txt_subtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btn_agregar))
                                    .addComponent(btn_borrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 929, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jD_fech, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_idVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel22)))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(cb_vendedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(cb_carros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel21)
                                    .addComponent(jLabel24))
                                .addGap(7, 7, 7)))
                        .addComponent(txt_linea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel26)
                                .addComponent(txt_subtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btn_agregar))
                            .addComponent(cb_piezas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_nomPieza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_borrar))
                        .addGap(226, 226, 226)))
                .addGap(43, 43, 43)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton26, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)))
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1013, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 558, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
        DefaultTableModel tbModelo = (DefaultTableModel) tb_productos.getModel();
        if (tbModelo.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "No hay datos a guardar", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            guardar_venta();
            guardar_productos(tbModelo);
        }
    }//GEN-LAST:event_jButton26ActionPerformed

    public void guardar_venta() {
        Connection con = null;

        try {
            con = conC.getConnection();

            ps = con.prepareStatement("INSERT INTO  venta VALUES (?,?,?,?)");
            ps.setString(1, txt_idVenta.getText().trim());
            ps.setObject(2, jD_fech.getDate());
            ps.setString(3, cb_vendedores.getSelectedItem().toString());
            ps.setString(4, txt_total.getText().trim());

            int res = ps.executeUpdate();
            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Venta Guardada Correctamente");
                idVenta();

            } else {
                JOptionPane.showMessageDialog(null, "Venta NO Guardado", "Error", JOptionPane.ERROR_MESSAGE);
            }

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void guardar_productos(DefaultTableModel tbModelo) {
        Connection con = null;
        String num, NumPieza, cantidad, subtotal, id;

        for (int i = 0; i < tbModelo.getRowCount(); i++) {
            try {
                num = tbModelo.getValueAt(i, 0).toString();
                NumPieza = tbModelo.getValueAt(i, 2).toString();
                subtotal = tbModelo.getValueAt(i, 3).toString();
                id = txt_idVenta.getText();

                con = conC.getConnection();

                ps = con.prepareStatement("INSERT INTO  Nota_venta VALUES (?,?,?,?)");
                ps.setString(1, num);
                ps.setString(2, NumPieza);
                ps.setString(3, id);
                ps.setString(4, subtotal);

                int res = ps.executeUpdate();
                if (res > 0) {
                    JOptionPane.showMessageDialog(null, "Nota Venta Guardada Correctamente");
                    //setIDventa();
                    limpiar();
                } else {
                    JOptionPane.showMessageDialog(null, "Venta NO Guardado", "Error", JOptionPane.ERROR_MESSAGE);
                }

                con.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
    private void btn_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarActionPerformed
        if ("Seleccione".equals(cb_carros.getSelectedItem().toString())
                || "Seleccione".equals(cb_piezas.getSelectedItem().toString())
                || "Seleccione".equals(cb_vendedores.getSelectedItem().toString())) {

            JOptionPane.showMessageDialog(null, "Faltan algunos datos", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            int i = tb_productos.getRowCount() + 1;
            String Data[] = {String.valueOf(i), String.valueOf(cb_carros.getSelectedItem()), String.valueOf(cb_piezas.getSelectedItem()), txt_subtotal.getText()};
            DefaultTableModel tbModelo = (DefaultTableModel) tb_productos.getModel();
            tbModelo.addRow(Data);

            cb_carros.setSelectedIndex(0);
            cb_piezas.setSelectedIndex(0);
            txt_subtotal.setText("");

        }
        total();
    }//GEN-LAST:event_btn_agregarActionPerformed

    private void cb_carrosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_carrosItemStateChanged
        cb_piezas.removeAllItems();
        cb_piezas.addItem("Seleccione");
        setPiezas();
    }//GEN-LAST:event_cb_carrosItemStateChanged

    private void cb_piezasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_piezasItemStateChanged
        txt_subtotal.setText("");
        Connection con = null;

        try {
            con = conC.getConnection();
            ps = con.prepareStatement("select precio_minimo from pieza Where num_pieza = ? ");
            ps.setString(1, String.valueOf(cb_piezas.getSelectedItem()));

            rs = ps.executeQuery();

            while (rs.next()) {
                txt_subtotal.setText(rs.getString("precio_minimo"));
            }

        } catch (Exception e) {
            System.err.println(e);
        }
    }//GEN-LAST:event_cb_piezasItemStateChanged

    private void cb_piezasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_piezasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_piezasActionPerformed

    private void btn_borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_borrarActionPerformed
        if (tb_productos.getSelectedRow() != -1) {
            DefaultTableModel tbModelo = (DefaultTableModel) tb_productos.getModel();
            tbModelo.removeRow(tb_productos.getSelectedRow());
            total();
            for (int i = 1; i <= tb_productos.getRowCount(); i++) {
                tb_productos.setValueAt(i, i - 1, 0);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un registro", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_borrarActionPerformed

    private void setDateToday() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = new java.util.Date();
        jD_fech.setDate(date);

        JTextFieldDateEditor editor = (JTextFieldDateEditor) jD_fech.getDateEditor();
        editor.setEditable(false);
    }

    public void total() {
        double fila = 0;
        double total = 0;
        for (int i = 0; i < tb_productos.getRowCount(); i++) {
            fila = Double.parseDouble((String) tb_productos.getValueAt(i, 3));
            total += fila;
        }
        txt_total.setText("" + total);
    }

    public void limpiar() {
        total();
        setDateToday();
        cb_vendedores.setSelectedIndex(0);
        cb_carros.setSelectedIndex(0);
        cb_piezas.setSelectedIndex(0);
        txt_subtotal.setText("");
        //nombre
        //nombre
        txt_total.setText("");
        DefaultTableModel tbModelo = (DefaultTableModel) tb_productos.getModel();
        
        for (int i = 0; i < tb_productos.getRowCount(); i++) {
            tbModelo.removeRow(i);
            tbModelo.removeRow(i);
            i -= 1;
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_agregar;
    private javax.swing.JButton btn_borrar;
    private javax.swing.JComboBox<String> cb_carros;
    private javax.swing.JComboBox<String> cb_piezas;
    private javax.swing.JComboBox<String> cb_vendedores;
    private javax.swing.JButton jButton26;
    private com.toedter.calendar.JDateChooser jD_fech;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tb_productos;
    private javax.swing.JTextField txt_idVenta;
    private javax.swing.JTextField txt_linea;
    private javax.swing.JTextField txt_nomPieza;
    private javax.swing.JTextField txt_subtotal;
    private javax.swing.JTextField txt_total;
    // End of variables declaration//GEN-END:variables
}
