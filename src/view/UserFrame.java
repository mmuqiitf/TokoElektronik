/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.ConvertListToObject;
import com.Jenis;
import com.Merk;
import com.Pelanggan;
import db.ConnectionManager;
import exec.ExecutePelanggan;
import exec.ExecuteTransaksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author ALIK
 */
public class UserFrame extends javax.swing.JFrame {

    /**
     * Creates new form UserFrame
     */
    public UserFrame() {
        initComponents();
        setDataPegawai();
        setDataBarang();
    }
    
    public UserFrame(int id_pegawai){
        initComponents();
        setDataPegawai();
        setDataBarang();
        System.out.println("ID PEGAWAI : " + id_pegawai);
        this.id_pegawai = id_pegawai;
        lblNamaBarang.setVisible(false);
        lblJudulNamaBarang.setVisible(false);
    }
    
    public int id_pelanggan, id_pegawai, id_barang, harga_barang, stok;
    public String nama_barang;

    private void setDataBarang(){
        ConvertListToObject clto = new ConvertListToObject();
        String[][] dataBarang = clto.getDaftarBarang();
        tblDaftarBarang.setModel(new javax.swing.table.DefaultTableModel(
            dataBarang,
            new String [] {
                "ID Barang", "Nama", "Keterangan", "Garansi", "Stok", "Harga", "ID Jenis", "ID Merk", "Jenis", "Merk"
            }
        ));
        jScrollPane2.setViewportView(tblDaftarBarang);
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlInputPelanggan = new javax.swing.JPanel();
        txtNamaPelanggan = new javax.swing.JTextField();
        txtNoTelponPelanggan = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        taAlamatPelanggan = new javax.swing.JTextArea();
        btnSubmitPelanggan = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtQtyBarang = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        lblJudulNamaBarang = new javax.swing.JLabel();
        lblNamaBarang = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDaftarBarang = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        taAlamatPelanggan.setColumns(20);
        taAlamatPelanggan.setRows(5);
        jScrollPane1.setViewportView(taAlamatPelanggan);

        btnSubmitPelanggan.setText("Beli");
        btnSubmitPelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitPelangganActionPerformed(evt);
            }
        });

        jLabel1.setText("Nomor Telepon ");

        jLabel2.setText("Nama Pelanggan");

        jLabel3.setText("Alamat");

        jLabel4.setText("Quantity");

        lblJudulNamaBarang.setText("Nama Barang :");

        lblNamaBarang.setText("NamaBarang");

        javax.swing.GroupLayout pnlInputPelangganLayout = new javax.swing.GroupLayout(pnlInputPelanggan);
        pnlInputPelanggan.setLayout(pnlInputPelangganLayout);
        pnlInputPelangganLayout.setHorizontalGroup(
            pnlInputPelangganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInputPelangganLayout.createSequentialGroup()
                .addGroup(pnlInputPelangganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlInputPelangganLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(pnlInputPelangganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblNamaBarang)
                            .addComponent(lblJudulNamaBarang)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(txtNamaPelanggan)
                            .addComponent(txtNoTelponPelanggan)
                            .addComponent(jScrollPane1)
                            .addComponent(txtQtyBarang)))
                    .addGroup(pnlInputPelangganLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(btnSubmitPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        pnlInputPelangganLayout.setVerticalGroup(
            pnlInputPelangganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInputPelangganLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNamaPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNoTelponPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblJudulNamaBarang)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblNamaBarang)
                .addGap(16, 16, 16)
                .addComponent(jLabel4)
                .addGap(8, 8, 8)
                .addComponent(txtQtyBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(btnSubmitPelanggan)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblDaftarBarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblDaftarBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDaftarBarangMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblDaftarBarang);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlInputPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlInputPelanggan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 532, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubmitPelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitPelangganActionPerformed
        // TODO add your handling code here:
        String nama = txtNamaPelanggan.getText();
        String no_telp = txtNoTelponPelanggan.getText();
        String alamat = taAlamatPelanggan.getText();
        String qty = txtQtyBarang.getText();
        if(this.stok < Integer.parseInt(txtQtyBarang.getText())){
            JOptionPane.showMessageDialog(null, "Barang tidak lebih dari "+ this.stok +"! \n" + "Mohon input kembali atau pilih barang lain");
            txtQtyBarang.setText("");
        }else{
            Pelanggan p = new Pelanggan(nama, no_telp, alamat);
            ExecutePelanggan ex = new ExecutePelanggan();
            int hasil = ex.insertData(p);
            if(hasil >0){
                JOptionPane.showMessageDialog(null, "Data berhasil di simpan");
                String query = "select * from pelanggan ORDER BY id_pelanggan DESC LIMIT 1";
                ConnectionManager conMan = new ConnectionManager();
                Connection conn = conMan.logOn();
                try {
                    Statement stm = conn.createStatement();
                    ResultSet rs = stm.executeQuery(query);
                    if(rs.next()){
                        this.id_pelanggan = rs.getInt("id_pelanggan");
                        exec.ExecuteTransaksi et = new ExecuteTransaksi();
                        int hasil_insert = et.insertData(this.id_pelanggan, this.id_barang, this.id_pegawai, Integer.parseInt(qty));
                        int total = this.harga_barang * Integer.parseInt(qty);
                        if(hasil_insert > 0){
                            JOptionPane.showMessageDialog(null, 
                                    "Data transaksi berhasil di simpan : \n"
                                    + "Nama Pelanggan : " + nama + "\n"
                                    + "Barang : " + this.nama_barang + "\n"
                                    + "Quantity : " + qty + "\n"
                                    + "Total Harga : " + total
                            );
                        }
                        System.out.println("ID Pelanggan : " + rs.getInt("id_pelanggan"));
                        setDataBarang();
                    }
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Data gagal di simpan");
            }
        }
        
    }//GEN-LAST:event_btnSubmitPelangganActionPerformed

    private void tblDaftarBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDaftarBarangMouseClicked
        // TODO add your handling code here:
        int row = tblDaftarBarang.getSelectedRow();
        String id = tblDaftarBarang.getValueAt(row, 0).toString();
        String nama = tblDaftarBarang.getValueAt(row, 1).toString();
        String stok = tblDaftarBarang.getValueAt(row, 4).toString();
        String harga = tblDaftarBarang.getValueAt(row, 5).toString();
        this.id_barang = Integer.parseInt(id);
        this.nama_barang = nama;
        this.harga_barang = Integer.parseInt(harga);
        this.stok = Integer.parseInt(stok);
        if(this.stok == 0){
            JOptionPane.showMessageDialog(null, "Barang habis!");
        }
        lblNamaBarang.setVisible(true);
        lblJudulNamaBarang.setVisible(true);
        lblNamaBarang.setText(nama);
        System.out.println("ID Barang : " + this.id_barang);
    }//GEN-LAST:event_tblDaftarBarangMouseClicked

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
            java.util.logging.Logger.getLogger(UserFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSubmitPelanggan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblJudulNamaBarang;
    private javax.swing.JLabel lblNamaBarang;
    private javax.swing.JPanel pnlInputPelanggan;
    private javax.swing.JTextArea taAlamatPelanggan;
    private javax.swing.JTable tblDaftarBarang;
    private javax.swing.JTextField txtNamaPelanggan;
    private javax.swing.JTextField txtNoTelponPelanggan;
    private javax.swing.JTextField txtQtyBarang;
    // End of variables declaration//GEN-END:variables

    private void setDataPegawai() {
        System.out.println("ID Pegawai : " + this.id_pegawai);
    }
}
