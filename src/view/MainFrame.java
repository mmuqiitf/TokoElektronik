/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.Barang;
import com.ConvertListToObject;
import com.Jabatan;
import com.Jenis;
import com.Merk;
import com.Pegawai;
import com.Pelanggan;
import com.Transaksi;
import db.ConnectionManager;
import exec.ExecuteBarang;
import exec.ExecuteJabatan;
import exec.ExecuteJenis;
import exec.ExecuteMerk;
import exec.ExecutePegawai;
import exec.ExecutePelanggan;
import exec.ExecuteTransaksi;
import java.awt.CardLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author ALIK
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        setDataPegawai();
        setDataBarang();
        setDataPelanggan();
        setDataJabatan();
        setDataJenis();
        setDataMerk();
        setDataTransaksi();
    }
    public MainFrame(int id_pegawai) {
        initComponents();
        setDataPegawai();
        setDataBarang();
        setDataPelanggan();
        setDataJabatan();
        setDataJenis();
        setDataMerk();
        setDataTransaksi();
        this.id_admin = id_pegawai;
    }
    public int id_pegawai, id_pelanggan, id_barang, id_merk, id_jenis, id_jabatan, id_transaksi;
    public int id_admin;
    private void setDataPegawai(){
        ConvertListToObject clto = new ConvertListToObject();
        String[][] dataSpek = clto.getPegawai();
        tblPegawai.setModel(new javax.swing.table.DefaultTableModel(
            dataSpek,
            new String [] {
                "ID Pegawai", "Username", "Password", "Nama", "No Telp", "Alamat", "ID Jabatan", "Level"
            }
        ));
        jScrollPane1.setViewportView(tblPegawai);
        PreparedStatement ps;
        try{
            ConnectionManager conMan = new ConnectionManager();
            Connection conn = conMan.logOn();
            ps = conn.prepareStatement("select * from jabatan");
            Vector<Jabatan> vector = new Vector<>();
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                  vector.addElement(new Jabatan(rs.getInt(1), rs.getString(2)));
                  cbbJabatan.setModel(new DefaultComboBoxModel(vector));
            }
        }catch(SQLException sQLException){
            sQLException.printStackTrace();
        }
    }
    
    private void setDataPelanggan(){
        ConvertListToObject clto = new ConvertListToObject();
        String[][] dataPelanggan = clto.getPelanggan();
        tblPelanggan.setModel(new javax.swing.table.DefaultTableModel(
            dataPelanggan,
            new String [] {
                "ID Pelanggan", "Nama", "No Telp", "Alamat"
            }
        ));
        jScrollPane5.setViewportView(tblPelanggan);
    }
    
    private void setDataBarang(){
        ConvertListToObject clto = new ConvertListToObject();
        String[][] dataBarang = clto.getBarang();
        tblBarang.setModel(new javax.swing.table.DefaultTableModel(
            dataBarang,
            new String [] {
                "ID Barang", "Nama", "Keterangan", "Garansi", "Stok", "Harga", "ID Jenis", "ID Merk"
            }
        ));
        jScrollPane11.setViewportView(tblBarang);
        PreparedStatement ps;
        PreparedStatement ps2;
        try{
            ConnectionManager conMan = new ConnectionManager();
            ConnectionManager conMan2 = new ConnectionManager();
            Connection conn = conMan.logOn();
            Connection conn2 = conMan2.logOn();
            ps = conn.prepareStatement("select * from jenis");
            ps2 = conn2.prepareStatement("select * from merk");
            Vector<Jenis> vector = new Vector<>();
            Vector<Merk> vectorSupplier = new Vector<>();
            ResultSet rs = ps.executeQuery();
            ResultSet rs2 = ps2.executeQuery();
            while(rs.next()){
                  vector.addElement(new Jenis(rs.getInt(1), rs.getString(2)));
                  cbbJenisBarang.setModel(new DefaultComboBoxModel(vector));
                  while(rs2.next()){
                  vectorSupplier.addElement(new Merk(rs2.getInt(1), rs2.getString(2)));
                  cbbMerkBarang.setModel(new DefaultComboBoxModel(vectorSupplier));
                }
            }
            
        }catch(SQLException sQLException){
            sQLException.printStackTrace();
        }
    }
    
    private void setDataJabatan(){
        ConvertListToObject clto = new ConvertListToObject();
        String[][] dataJabatan = clto.getJabatan();
        tblJabatan.setModel(new javax.swing.table.DefaultTableModel(
            dataJabatan,
            new String [] {
                "ID Jabatan", "Nama"
            }
        ));
        jScrollPane6.setViewportView(tblJabatan);
    }
    
    private void setDataJenis(){
        ConvertListToObject clto = new ConvertListToObject();
        String[][] dataJabatan = clto.getJenis();
        tblJenis.setModel(new javax.swing.table.DefaultTableModel(
            dataJabatan,
            new String [] {
                "ID Jenis", "Nama", "Keterangan"
            }
        ));
        jScrollPane7.setViewportView(tblJenis);
    }
    
    private void setDataMerk(){
        ConvertListToObject clto = new ConvertListToObject();
        String[][] dataMerk = clto.getMerk();
        tblMerk.setModel(new javax.swing.table.DefaultTableModel(
            dataMerk,
            new String [] {
                "ID Merk", "Nama"
            }
        ));
        jScrollPane8.setViewportView(tblMerk);
    }
    
    private void setDataTransaksi(){
        ConvertListToObject clto = new ConvertListToObject();
        String[][] dataTransaksi = clto.getTransaksi();
        tblTransaksi.setModel(new javax.swing.table.DefaultTableModel(
            dataTransaksi,
            new String [] {
                "ID Transaksi", "ID Pelanggan", "ID Barang", "ID Pegawai", "Qty"
            }
        ));
        jScrollPane10.setViewportView(tblTransaksi);
        PreparedStatement ps;
        PreparedStatement ps2;
        PreparedStatement ps3;
        try{
            ConnectionManager conMan = new ConnectionManager();
            ConnectionManager conMan2 = new ConnectionManager();
            ConnectionManager conMan3 = new ConnectionManager();
            Connection conn = conMan.logOn();
            Connection conn2 = conMan2.logOn();
            Connection conn3 = conMan3.logOn();
            ps = conn.prepareStatement("select * from pelanggan");
            ps2 = conn2.prepareStatement("select * from barang");
            ps3 = conn3.prepareStatement("select * from pegawai");
            Vector<Pelanggan> vectorPelanggan = new Vector<>();
            Vector<Barang> vectorBarang = new Vector<>();
            Vector<Pegawai> vectorPegawai = new Vector<>();
            ResultSet rs = ps.executeQuery();
            ResultSet rs2 = ps2.executeQuery();
            ResultSet rs3 = ps3.executeQuery();
            while(rs.next()){
                vectorPelanggan.addElement(new Pelanggan(rs.getInt("id_pelanggan"), rs.getString("nama")));
                cbbPelanggan.setModel(new DefaultComboBoxModel(vectorPelanggan));
                while(rs2.next()){
                    vectorBarang.addElement(new Barang(rs2.getInt("id_barang"), rs2.getString("nama")));
                    cbbBarang.setModel(new DefaultComboBoxModel(vectorBarang));
                    while(rs3.next()){
                        vectorPegawai.addElement(new Pegawai(rs3.getInt("id_pegawai"), rs3.getString("nama")));
                        cbbPegawai.setModel(new DefaultComboBoxModel(vectorPegawai));
                    }
                }
            }
            
        }catch(SQLException sQLException){
            sQLException.printStackTrace();
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

        jToolBar1 = new javax.swing.JToolBar();
        btnPegawai = new javax.swing.JButton();
        btnBarang = new javax.swing.JButton();
        btnPelanggan = new javax.swing.JButton();
        btnJabatan = new javax.swing.JButton();
        btnMerkJenis = new javax.swing.JButton();
        btnTransaksi = new javax.swing.JButton();
        btnTransaksiPenjualan = new javax.swing.JButton();
        pnlUtama = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pnlPegawai = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        txtUsername = new javax.swing.JTextField();
        txtPassword = new javax.swing.JTextField();
        txtNama = new javax.swing.JTextField();
        txtNoTelpon = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        taAlamat = new javax.swing.JTextArea();
        cbbJabatan = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnSubmitPegawai = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPegawai = new javax.swing.JTable();
        pnlBarang = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txtNamaBarang = new javax.swing.JTextField();
        txtGaransiBarang = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        taKeteranganBarang = new javax.swing.JTextArea();
        txtStokBarang = new javax.swing.JTextField();
        cbbJenisBarang = new javax.swing.JComboBox<>();
        cbbMerkBarang = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        btnSubmitBarang = new javax.swing.JButton();
        btnUpdateBarang = new javax.swing.JButton();
        btnDeleteBarang = new javax.swing.JButton();
        txtHargaBarang = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        tblBarang = new javax.swing.JTable();
        pnlPelanggan = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        txtNamaPelanggan = new javax.swing.JTextField();
        txtNoTelponPelanggan = new javax.swing.JTextField();
        txtAlamatPelanggan = new javax.swing.JTextField();
        btnSubmitPelanggan = new javax.swing.JButton();
        btnUpdatePelanggan = new javax.swing.JButton();
        btnDeletePelanggan = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblPelanggan = new javax.swing.JTable();
        pnlJabatan = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblJabatan = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        txtNamaJabatan = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        btnJabatanSubmit = new javax.swing.JButton();
        btnJabatanUpdate = new javax.swing.JButton();
        btnJabatanDelete = new javax.swing.JButton();
        pnlTransaksi = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        cbbPelanggan = new javax.swing.JComboBox<>();
        cbbBarang = new javax.swing.JComboBox<>();
        cbbPegawai = new javax.swing.JComboBox<>();
        txtQtyTransaksi = new javax.swing.JTextField();
        btnSubmitTransaksi = new javax.swing.JButton();
        btnUpdateTransaksi = new javax.swing.JButton();
        btnDeleteTransaksi = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        tblTransaksi = new javax.swing.JTable();
        pnlMerkJenis = new javax.swing.JPanel();
        pnlJenis = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        txtNamaJenis = new javax.swing.JTextField();
        jScrollPane9 = new javax.swing.JScrollPane();
        taKeteranganJenis = new javax.swing.JTextArea();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        btnSubmitJenis = new javax.swing.JButton();
        btnUpdateJenis = new javax.swing.JButton();
        btnDeleteJenis = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblJenis = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        txtNamaMerk = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        btnSubmitMerk = new javax.swing.JButton();
        btnUpdateMerk = new javax.swing.JButton();
        btnDeleteMerk = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblMerk = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jToolBar1.setRollover(true);

        btnPegawai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/technical-support.png"))); // NOI18N
        btnPegawai.setText("Pengelolaan Pegawai");
        btnPegawai.setFocusable(false);
        btnPegawai.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPegawai.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPegawai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPegawaiActionPerformed(evt);
            }
        });
        jToolBar1.add(btnPegawai);

        btnBarang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/computer.png"))); // NOI18N
        btnBarang.setText("Pengelolaan Barang");
        btnBarang.setFocusable(false);
        btnBarang.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBarang.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBarangActionPerformed(evt);
            }
        });
        jToolBar1.add(btnBarang);

        btnPelanggan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/login.png"))); // NOI18N
        btnPelanggan.setText("Pengelolaan Pelanggan");
        btnPelanggan.setFocusable(false);
        btnPelanggan.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPelanggan.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPelangganActionPerformed(evt);
            }
        });
        jToolBar1.add(btnPelanggan);

        btnJabatan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/corporate-identity.png"))); // NOI18N
        btnJabatan.setText("Pengelolaan Jabatan");
        btnJabatan.setFocusable(false);
        btnJabatan.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnJabatan.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnJabatan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJabatanActionPerformed(evt);
            }
        });
        jToolBar1.add(btnJabatan);

        btnMerkJenis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/list.png"))); // NOI18N
        btnMerkJenis.setText("Pengelolaan Merk & Jenis");
        btnMerkJenis.setFocusable(false);
        btnMerkJenis.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMerkJenis.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMerkJenis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMerkJenisActionPerformed(evt);
            }
        });
        jToolBar1.add(btnMerkJenis);

        btnTransaksi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/wallet.png"))); // NOI18N
        btnTransaksi.setText("Pengelolaan Transaksi");
        btnTransaksi.setFocusable(false);
        btnTransaksi.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTransaksi.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransaksiActionPerformed(evt);
            }
        });
        jToolBar1.add(btnTransaksi);

        btnTransaksiPenjualan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/sale.png"))); // NOI18N
        btnTransaksiPenjualan.setText("Transaksi Penjualan");
        btnTransaksiPenjualan.setFocusable(false);
        btnTransaksiPenjualan.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTransaksiPenjualan.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnTransaksiPenjualan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransaksiPenjualanActionPerformed(evt);
            }
        });
        jToolBar1.add(btnTransaksiPenjualan);

        pnlUtama.setLayout(new java.awt.CardLayout());

        jLabel1.setText("Aplikasi Toko Elektronik");
        pnlUtama.add(jLabel1, "card3");

        taAlamat.setColumns(20);
        taAlamat.setRows(5);
        jScrollPane2.setViewportView(taAlamat);

        jLabel2.setText("Username");

        jLabel3.setText("Password");

        jLabel4.setText("Nama");

        jLabel5.setText("No Telpon");

        jLabel6.setText("Alamat");

        jLabel7.setText("Jabatan");

        btnSubmitPegawai.setText("Submit");
        btnSubmitPegawai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitPegawaiActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDelete)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnSubmitPegawai)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUpdate))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane2)
                        .addComponent(txtNoTelpon)
                        .addComponent(txtNama)
                        .addComponent(txtPassword)
                        .addComponent(txtUsername)
                        .addComponent(cbbJabatan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNoTelpon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbbJabatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSubmitPegawai)
                    .addComponent(btnUpdate))
                .addGap(18, 18, 18)
                .addComponent(btnDelete)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        tblPegawai.setModel(new javax.swing.table.DefaultTableModel(
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
        tblPegawai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPegawaiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPegawai);

        javax.swing.GroupLayout pnlPegawaiLayout = new javax.swing.GroupLayout(pnlPegawai);
        pnlPegawai.setLayout(pnlPegawaiLayout);
        pnlPegawaiLayout.setHorizontalGroup(
            pnlPegawaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPegawaiLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 544, Short.MAX_VALUE))
        );
        pnlPegawaiLayout.setVerticalGroup(
            pnlPegawaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );

        pnlUtama.add(pnlPegawai, "cardPegawai");

        taKeteranganBarang.setColumns(20);
        taKeteranganBarang.setRows(5);
        jScrollPane4.setViewportView(taKeteranganBarang);

        txtStokBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStokBarangActionPerformed(evt);
            }
        });

        jLabel8.setText("Nama Barang");

        jLabel9.setText("Garansi");

        jLabel10.setText("Keterangan");

        jLabel11.setText("Stok");

        jLabel12.setText("Jenis Barang");

        jLabel13.setText("Merk Barang");

        btnSubmitBarang.setText("Submit");
        btnSubmitBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitBarangActionPerformed(evt);
            }
        });

        btnUpdateBarang.setText("Update");
        btnUpdateBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateBarangActionPerformed(evt);
            }
        });

        btnDeleteBarang.setText("Delete");
        btnDeleteBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteBarangActionPerformed(evt);
            }
        });

        txtHargaBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHargaBarangActionPerformed(evt);
            }
        });

        jLabel25.setText("Harga Barang");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel25))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDeleteBarang)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnSubmitBarang)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUpdateBarang))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane4)
                        .addComponent(txtNamaBarang)
                        .addComponent(txtGaransiBarang)
                        .addComponent(txtStokBarang)
                        .addComponent(cbbJenisBarang, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbbMerkBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtHargaBarang)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGaransiBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtStokBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHargaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25))
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbJenisBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbMerkBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSubmitBarang)
                    .addComponent(btnUpdateBarang))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDeleteBarang)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblBarang.setModel(new javax.swing.table.DefaultTableModel(
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
        tblBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBarangMouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(tblBarang);

        javax.swing.GroupLayout pnlBarangLayout = new javax.swing.GroupLayout(pnlBarang);
        pnlBarang.setLayout(pnlBarangLayout);
        pnlBarangLayout.setHorizontalGroup(
            pnlBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBarangLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 562, Short.MAX_VALUE))
        );
        pnlBarangLayout.setVerticalGroup(
            pnlBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE)
        );

        pnlUtama.add(pnlBarang, "cardBarang");

        btnSubmitPelanggan.setText("Submit");
        btnSubmitPelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitPelangganActionPerformed(evt);
            }
        });

        btnUpdatePelanggan.setText("Update");
        btnUpdatePelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdatePelangganActionPerformed(evt);
            }
        });

        btnDeletePelanggan.setText("Delete");
        btnDeletePelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletePelangganActionPerformed(evt);
            }
        });

        jLabel14.setText("Nama Pelanggan");

        jLabel15.setText("Nomor Telepon");

        jLabel16.setText("Alamat");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16))
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDeletePelanggan)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnSubmitPelanggan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUpdatePelanggan))
                    .addComponent(txtAlamatPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNoTelponPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNamaPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNamaPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNoTelponPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtAlamatPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSubmitPelanggan)
                    .addComponent(btnUpdatePelanggan))
                .addGap(18, 18, 18)
                .addComponent(btnDeletePelanggan)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblPelanggan.setModel(new javax.swing.table.DefaultTableModel(
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
        tblPelanggan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPelangganMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblPelanggan);

        javax.swing.GroupLayout pnlPelangganLayout = new javax.swing.GroupLayout(pnlPelanggan);
        pnlPelanggan.setLayout(pnlPelangganLayout);
        pnlPelangganLayout.setHorizontalGroup(
            pnlPelangganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPelangganLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlPelangganLayout.setVerticalGroup(
            pnlPelangganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE)
        );

        pnlUtama.add(pnlPelanggan, "cardPelanggan");

        tblJabatan.setModel(new javax.swing.table.DefaultTableModel(
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
        tblJabatan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblJabatanMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tblJabatan);

        jLabel17.setText("Nama Jabatan");

        btnJabatanSubmit.setText("Submit");
        btnJabatanSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJabatanSubmitActionPerformed(evt);
            }
        });

        btnJabatanUpdate.setText("Update");
        btnJabatanUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJabatanUpdateActionPerformed(evt);
            }
        });

        btnJabatanDelete.setText("Delete");
        btnJabatanDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJabatanDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnJabatanDelete)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnJabatanSubmit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnJabatanUpdate))
                    .addComponent(jLabel17)
                    .addComponent(txtNamaJabatan, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNamaJabatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnJabatanSubmit)
                    .addComponent(btnJabatanUpdate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnJabatanDelete)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlJabatanLayout = new javax.swing.GroupLayout(pnlJabatan);
        pnlJabatan.setLayout(pnlJabatanLayout);
        pnlJabatanLayout.setHorizontalGroup(
            pnlJabatanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlJabatanLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 544, Short.MAX_VALUE))
        );
        pnlJabatanLayout.setVerticalGroup(
            pnlJabatanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnlUtama.add(pnlJabatan, "cardJabatan");

        btnSubmitTransaksi.setText("Submit");
        btnSubmitTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitTransaksiActionPerformed(evt);
            }
        });

        btnUpdateTransaksi.setText("Update");
        btnUpdateTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateTransaksiActionPerformed(evt);
            }
        });

        btnDeleteTransaksi.setText("Delete");
        btnDeleteTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteTransaksiActionPerformed(evt);
            }
        });

        jLabel21.setText("ID Pelanggan");

        jLabel22.setText("ID Barang");

        jLabel23.setText("ID Pegawai");

        jLabel24.setText("Quantity");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23)
                    .addComponent(jLabel24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDeleteTransaksi)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(btnSubmitTransaksi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUpdateTransaksi))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(cbbPegawai, 0, 161, Short.MAX_VALUE)
                        .addComponent(cbbBarang, 0, 161, Short.MAX_VALUE)
                        .addComponent(cbbPelanggan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtQtyTransaksi)))
                .addGap(28, 28, 28))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbPegawai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtQtyTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSubmitTransaksi)
                    .addComponent(btnUpdateTransaksi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDeleteTransaksi)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblTransaksi.setModel(new javax.swing.table.DefaultTableModel(
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
        tblTransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTransaksiMouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(tblTransaksi);

        javax.swing.GroupLayout pnlTransaksiLayout = new javax.swing.GroupLayout(pnlTransaksi);
        pnlTransaksi.setLayout(pnlTransaksiLayout);
        pnlTransaksiLayout.setHorizontalGroup(
            pnlTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTransaksiLayout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE))
        );
        pnlTransaksiLayout.setVerticalGroup(
            pnlTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE)
        );

        pnlUtama.add(pnlTransaksi, "cardTransaksi");

        taKeteranganJenis.setColumns(20);
        taKeteranganJenis.setRows(5);
        jScrollPane9.setViewportView(taKeteranganJenis);

        jLabel18.setText("Nama Jenis");

        jLabel19.setText("Keterangan");

        btnSubmitJenis.setText("Submit");
        btnSubmitJenis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitJenisActionPerformed(evt);
            }
        });

        btnUpdateJenis.setText("Update");
        btnUpdateJenis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateJenisActionPerformed(evt);
            }
        });

        btnDeleteJenis.setText("Delete");
        btnDeleteJenis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteJenisActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(jLabel19)
                    .addComponent(jLabel18)
                    .addComponent(txtNamaJenis)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnDeleteJenis)
                            .addComponent(btnUpdateJenis)
                            .addComponent(btnSubmitJenis))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNamaJenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSubmitJenis)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnUpdateJenis)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDeleteJenis)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblJenis.setModel(new javax.swing.table.DefaultTableModel(
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
        tblJenis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblJenisMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tblJenis);

        javax.swing.GroupLayout pnlJenisLayout = new javax.swing.GroupLayout(pnlJenis);
        pnlJenis.setLayout(pnlJenisLayout);
        pnlJenisLayout.setHorizontalGroup(
            pnlJenisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlJenisLayout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlJenisLayout.setVerticalGroup(
            pnlJenisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE)
        );

        jLabel20.setText("Nama Merk");

        btnSubmitMerk.setText("Submit");
        btnSubmitMerk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitMerkActionPerformed(evt);
            }
        });

        btnUpdateMerk.setText("Update");
        btnUpdateMerk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateMerkActionPerformed(evt);
            }
        });

        btnDeleteMerk.setText("Delete");
        btnDeleteMerk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteMerkActionPerformed(evt);
            }
        });

        tblMerk.setModel(new javax.swing.table.DefaultTableModel(
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
        tblMerk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMerkMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(tblMerk);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(txtNamaMerk, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeleteMerk)
                    .addComponent(btnUpdateMerk)
                    .addComponent(btnSubmitMerk))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNamaMerk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSubmitMerk)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnUpdateMerk)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDeleteMerk)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane8)
        );

        javax.swing.GroupLayout pnlMerkJenisLayout = new javax.swing.GroupLayout(pnlMerkJenis);
        pnlMerkJenis.setLayout(pnlMerkJenisLayout);
        pnlMerkJenisLayout.setHorizontalGroup(
            pnlMerkJenisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMerkJenisLayout.createSequentialGroup()
                .addComponent(pnlJenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlMerkJenisLayout.setVerticalGroup(
            pnlMerkJenisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlJenis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnlUtama.add(pnlMerkJenis, "cardMerkJenis");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlUtama, javax.swing.GroupLayout.PREFERRED_SIZE, 840, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlUtama, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPegawaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPegawaiActionPerformed
        // TODO add your handling code here:
        cl = (CardLayout) pnlUtama.getLayout();
        cl.show(pnlUtama, "cardPegawai");
    }//GEN-LAST:event_btnPegawaiActionPerformed

    private void btnBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBarangActionPerformed
        // TODO add your handling code here:
        cl = (CardLayout) pnlUtama.getLayout();
        cl.show(pnlUtama, "cardBarang");
    }//GEN-LAST:event_btnBarangActionPerformed

    private void btnPelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPelangganActionPerformed
        // TODO add your handling code here:
        cl = (CardLayout) pnlUtama.getLayout();
        cl.show(pnlUtama, "cardPelanggan");
    }//GEN-LAST:event_btnPelangganActionPerformed

    private void btnJabatanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJabatanActionPerformed
        // TODO add your handling code here:
        cl = (CardLayout) pnlUtama.getLayout();
        cl.show(pnlUtama, "cardJabatan");
    }//GEN-LAST:event_btnJabatanActionPerformed

    private void btnMerkJenisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMerkJenisActionPerformed
        // TODO add your handling code here:
        cl = (CardLayout) pnlUtama.getLayout();
        cl.show(pnlUtama, "cardMerkJenis");
    }//GEN-LAST:event_btnMerkJenisActionPerformed

    private void btnTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransaksiActionPerformed
        // TODO add your handling code here:
        cl = (CardLayout) pnlUtama.getLayout();
        cl.show(pnlUtama, "cardTransaksi");
    }//GEN-LAST:event_btnTransaksiActionPerformed

    private void btnSubmitPegawaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitPegawaiActionPerformed
        // TODO add your handling code here:
        String nama = txtNama.getText();
        String username = txtUsername.getText();
        String password = txtPassword.getText();
        String no_telp = txtNoTelpon.getText();
        String alamat = taAlamat.getText();
        int id_jabatan = ((Jabatan)cbbJabatan.getSelectedItem()).getId_jabatan();
        Pegawai p = new Pegawai(username, password, nama, no_telp, alamat, alamat, id_jabatan);
        exec.ExecutePegawai executePegawai = new ExecutePegawai();
        int hasil = executePegawai.insertData(p);
        if(hasil >0){
            JOptionPane.showMessageDialog(null, "Data berhasil di simpan");
            setDataPegawai();
        }
        else{
            JOptionPane.showMessageDialog(null, "Data gagal di simpan");
        }
    }//GEN-LAST:event_btnSubmitPegawaiActionPerformed

    private void tblPegawaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPegawaiMouseClicked
        // TODO add your handling code here:
        int row = tblPegawai.getSelectedRow();
        String id = tblPegawai.getValueAt(row, 0).toString();
        String nama = tblPegawai.getValueAt(row, 3).toString();
        String username = tblPegawai.getValueAt(row, 1).toString();
        String password = tblPegawai.getValueAt(row, 2).toString();
        String no_telp = tblPegawai.getValueAt(row, 4).toString();
        String alamat = tblPegawai.getValueAt(row,5).toString();
        String id_jabatan = tblPegawai.getValueAt(row,6).toString();
        txtNama.setText(nama);
        txtUsername.setText(username);
        txtPassword.setText(password);
        txtNoTelpon.setText(no_telp);
        taAlamat.setText(alamat);
//        cbbJabatan.setSelectedItem(new Jabatan(id_jabatan).toString());
//        cbbJabatan.setSelectedIndex(Integer.parseInt(id_jabatan)-1);
//        cbbJabatan.setSelectedItem(new Jabatan(id_jabatan));
        this.id_pegawai = Integer.parseInt(id);
    }//GEN-LAST:event_tblPegawaiMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        String nama = txtNama.getText();
        String username = txtUsername.getText();
        String password = txtPassword.getText();
        String no_telp = txtNoTelpon.getText();
        String alamat = taAlamat.getText();
        int id_jabatan = ((Jabatan)cbbJabatan.getSelectedItem()).getId_jabatan();
        Pegawai p = new Pegawai(this.id_pegawai, username, password, nama, no_telp, alamat, alamat, id_jabatan);
        exec.ExecutePegawai executePegawai = new ExecutePegawai();
        int hasil = executePegawai.updateData(p);
        if(hasil >0){
            JOptionPane.showMessageDialog(null, "Data berhasil di ubah");
            setDataPegawai();
        }
        else{
            JOptionPane.showMessageDialog(null, "Data gagal di ubah");
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        exec.ExecutePegawai ep = new ExecutePegawai();
        int hasil = ep.deleteData(this.id_pegawai);
        if(hasil >0){
            JOptionPane.showMessageDialog(null, "Data berhasil di hapus");
            setDataPegawai();
        }
        else{
            JOptionPane.showMessageDialog(null, "Data gagal di hapus");
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void txtStokBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStokBarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStokBarangActionPerformed

    private void btnSubmitBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitBarangActionPerformed
        // TODO add your handling code here:
        String nama = txtNamaBarang.getText();
        String keterangan = taKeteranganBarang.getText();
        String garansi = txtGaransiBarang.getText();
        String stok = txtStokBarang.getText();
        String harga = txtHargaBarang.getText();
        int id_jenis = ((Jenis)cbbJenisBarang.getSelectedItem()).getId_jenis();
        int id_merk = ((Merk)cbbMerkBarang.getSelectedItem()).getId_merk();
        Barang b = new Barang(nama, keterangan, garansi, Integer.parseInt(stok), Integer.parseInt(harga), id_jenis, id_merk);
        ExecuteBarang ex = new ExecuteBarang();
        int hasil = ex.insertData(b);
        if(hasil >0){
            JOptionPane.showMessageDialog(null, "Data berhasil di simpan");
            setDataBarang();
        }
        else{
            JOptionPane.showMessageDialog(null, "Data gagal di simpan");
        }
    }//GEN-LAST:event_btnSubmitBarangActionPerformed

    private void btnUpdateBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateBarangActionPerformed
        // TODO add your handling code here:
        String nama = txtNamaBarang.getText();
        String keterangan = taKeteranganBarang.getText();
        String garansi = txtGaransiBarang.getText();
        String stok = txtStokBarang.getText();
        String harga = txtHargaBarang.getText();
        int id_jenis = ((Jenis)cbbJenisBarang.getSelectedItem()).getId_jenis();
        int id_merk = ((Merk)cbbMerkBarang.getSelectedItem()).getId_merk();
        Barang b = new Barang(this.id_barang, nama, keterangan, garansi, Integer.parseInt(stok), Integer.parseInt(harga), id_jenis, id_merk);
        ExecuteBarang ex = new ExecuteBarang();
        int hasil = ex.updateData(b);
        if(hasil >0){
            JOptionPane.showMessageDialog(null, "Data berhasil di ubah");
            setDataBarang();
        }
        else{
            JOptionPane.showMessageDialog(null, "Data gagal di ubah");
        }
    }//GEN-LAST:event_btnUpdateBarangActionPerformed

    private void btnDeleteBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteBarangActionPerformed
        // TODO add your handling code here:
        ExecuteBarang ex = new ExecuteBarang();
        int hasil = ex.deleteData(this.id_barang);
        if(hasil >0){
            JOptionPane.showMessageDialog(null, "Data berhasil di hapus");
            setDataBarang();
        }
        else{
            JOptionPane.showMessageDialog(null, "Data gagal di hapus");
        }
    }//GEN-LAST:event_btnDeleteBarangActionPerformed

    private void btnSubmitPelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitPelangganActionPerformed
        // TODO add your handling code here:
        String nama = txtNamaPelanggan.getText();
        String no_telp = txtNoTelponPelanggan.getText();
        String alamat = txtAlamatPelanggan.getText();
        Pelanggan p = new Pelanggan(nama, no_telp, alamat);
        ExecutePelanggan ex = new ExecutePelanggan();
        int hasil = ex.insertData(p);
        if(hasil >0){
            JOptionPane.showMessageDialog(null, "Data berhasil di simpan");
            setDataPelanggan();
        }
        else{
            JOptionPane.showMessageDialog(null, "Data gagal di simpan");
        }
    }//GEN-LAST:event_btnSubmitPelangganActionPerformed

    private void tblPelangganMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPelangganMouseClicked
        // TODO add your handling code here:
        int row = tblPelanggan.getSelectedRow();
        String id = tblPelanggan.getValueAt(row, 0).toString();
        String nama = tblPelanggan.getValueAt(row, 1).toString();
        String no_telp = tblPelanggan.getValueAt(row, 2).toString();
        String alamat = tblPelanggan.getValueAt(row,3).toString();
        txtNamaPelanggan.setText(nama);
        txtAlamatPelanggan.setText(alamat);
        txtNoTelponPelanggan.setText(no_telp);
        this.id_pelanggan = Integer.parseInt(id);
    }//GEN-LAST:event_tblPelangganMouseClicked

    private void btnUpdatePelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdatePelangganActionPerformed
        // TODO add your handling code here:
        String nama = txtNamaPelanggan.getText();
        String no_telp = txtNoTelponPelanggan.getText();
        String alamat = txtAlamatPelanggan.getText();
        Pelanggan p = new Pelanggan(this.id_pelanggan, nama, no_telp, alamat);
        ExecutePelanggan ex = new ExecutePelanggan();
        int hasil = ex.updateData(p);
        if(hasil >0){
            JOptionPane.showMessageDialog(null, "Data berhasil di ubah");
            setDataPelanggan();
        }
        else{
            JOptionPane.showMessageDialog(null, "Data gagal di ubah");
        }
    }//GEN-LAST:event_btnUpdatePelangganActionPerformed

    private void btnDeletePelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletePelangganActionPerformed
        // TODO add your handling code here:
        ExecutePelanggan ex = new ExecutePelanggan();
        int hasil = ex.deleteData(this.id_pelanggan);
        if(hasil >0){
            JOptionPane.showMessageDialog(null, "Data berhasil di simpan");
            setDataPelanggan();
        }
        else{
            JOptionPane.showMessageDialog(null, "Data gagal di simpan");
        }
    }//GEN-LAST:event_btnDeletePelangganActionPerformed

    private void tblJabatanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblJabatanMouseClicked
        // TODO add your handling code here:
        int row = tblJabatan.getSelectedRow();
        String id = tblJabatan.getValueAt(row, 0).toString();
        String nama = tblJabatan.getValueAt(row, 1).toString();
        this.id_jabatan = Integer.parseInt(id);
        txtNamaJabatan.setText(nama);
    }//GEN-LAST:event_tblJabatanMouseClicked

    private void btnJabatanSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJabatanSubmitActionPerformed
        // TODO add your handling code here:
        String nama = txtNamaJabatan.getText();
        Jabatan j = new Jabatan( nama);
        ExecuteJabatan ex = new ExecuteJabatan();
        int hasil = ex.insertData(j);
        if(hasil >0){
            JOptionPane.showMessageDialog(null, "Data berhasil di simpan");
            setDataJabatan();
        }
        else{
            JOptionPane.showMessageDialog(null, "Data gagal di simpan");
        }
    }//GEN-LAST:event_btnJabatanSubmitActionPerformed

    private void btnJabatanUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJabatanUpdateActionPerformed
        // TODO add your handling code here:
        String nama = txtNamaJabatan.getText();
        Jabatan j = new Jabatan(this.id_jabatan, nama);
        ExecuteJabatan ex = new ExecuteJabatan();
        int hasil = ex.updateData(j);
        if(hasil >0){
            JOptionPane.showMessageDialog(null, "Data berhasil di ubah");
            setDataJabatan();
        }
        else{
            JOptionPane.showMessageDialog(null, "Data gagal di ubah");
        }
    }//GEN-LAST:event_btnJabatanUpdateActionPerformed

    private void btnJabatanDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJabatanDeleteActionPerformed
        // TODO add your handling code here:
        ExecuteJabatan ex = new ExecuteJabatan();
        int hasil = ex.deleteData(this.id_jabatan);
        if(hasil >0){
            JOptionPane.showMessageDialog(null, "Data berhasil di hapus");
            setDataJabatan();
        }
        else{
            JOptionPane.showMessageDialog(null, "Data gagal di hapus");
        }
    }//GEN-LAST:event_btnJabatanDeleteActionPerformed

    private void btnDeleteMerkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteMerkActionPerformed
        // TODO add your handling code here:
        ExecuteMerk ex = new ExecuteMerk();
        int hasil = ex.deleteData(this.id_merk);
        if(hasil >0){
            JOptionPane.showMessageDialog(null, "Data berhasil di hapus");
            setDataMerk();
        }
        else{
            JOptionPane.showMessageDialog(null, "Data gagal di hapus");
        }
    }//GEN-LAST:event_btnDeleteMerkActionPerformed

    private void btnUpdateMerkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateMerkActionPerformed
        // TODO add your handling code here:
        String nama = txtNamaMerk.getText();
        Merk j = new Merk(this.id_merk, nama);
        ExecuteMerk ex = new ExecuteMerk();
        int hasil = ex.updateData(j);
        if(hasil >0){
            JOptionPane.showMessageDialog(null, "Data berhasil di ubah");
            setDataMerk();
        }
        else{
            JOptionPane.showMessageDialog(null, "Data gagal di ubah");
        }
    }//GEN-LAST:event_btnUpdateMerkActionPerformed

    private void btnSubmitMerkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitMerkActionPerformed
        // TODO add your handling code here:
        String nama = txtNamaMerk.getText();
        Merk j = new Merk(nama);
        ExecuteMerk ex = new ExecuteMerk();
        int hasil = ex.insertData(j);
        if(hasil >0){
            JOptionPane.showMessageDialog(null, "Data berhasil di simpan");
            setDataMerk();
        }
        else{
            JOptionPane.showMessageDialog(null, "Data gagal di simpan");
        }
    }//GEN-LAST:event_btnSubmitMerkActionPerformed

    private void tblJenisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblJenisMouseClicked
        // TODO add your handling code here:
        int row = tblJenis.getSelectedRow();
        String id = tblJenis.getValueAt(row, 0).toString();
        String nama = tblJenis.getValueAt(row, 1).toString();
        String keterangan = tblJenis.getValueAt(row, 2).toString();
        this.id_jenis = Integer.parseInt(id);
        txtNamaJenis.setText(nama);
        taKeteranganJenis.setText(keterangan);
    }//GEN-LAST:event_tblJenisMouseClicked

    private void btnDeleteJenisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteJenisActionPerformed
        // TODO add your handling code here:
        ExecuteJenis ex = new ExecuteJenis();
        int hasil = ex.deleteData(this.id_jenis);
        if(hasil >0){
            JOptionPane.showMessageDialog(null, "Data berhasil di hapus");
            setDataJenis();
        }
        else{
            JOptionPane.showMessageDialog(null, "Data gagal di hapus");
        }
    }//GEN-LAST:event_btnDeleteJenisActionPerformed

    private void btnUpdateJenisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateJenisActionPerformed
        // TODO add your handling code here:
        String nama = txtNamaJenis.getText();
        String keterangan = taKeteranganJenis.getText();
        Jenis j = new Jenis(this.id_jenis, nama, keterangan);
        ExecuteJenis ex = new ExecuteJenis();
        int hasil = ex.updateData(j);
        if(hasil >0){
            JOptionPane.showMessageDialog(null, "Data berhasil di ubah");
            setDataJenis();
        }
        else{
            JOptionPane.showMessageDialog(null, "Data gagal di ubah");
        }
    }//GEN-LAST:event_btnUpdateJenisActionPerformed

    private void btnSubmitJenisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitJenisActionPerformed
        // TODO add your handling code here:
        String nama = txtNamaJenis.getText();
        String keterangan = taKeteranganJenis.getText();
        Jenis j = new Jenis( nama, keterangan);
        ExecuteJenis ex = new ExecuteJenis();
        int hasil = ex.insertData(j);
        if(hasil >0){
            JOptionPane.showMessageDialog(null, "Data berhasil di simpan");
            setDataJenis();
        }
        else{
            JOptionPane.showMessageDialog(null, "Data gagal di simpan");
        }
    }//GEN-LAST:event_btnSubmitJenisActionPerformed

    private void tblMerkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMerkMouseClicked
        // TODO add your handling code here:
        int row = tblMerk.getSelectedRow();
        String id = tblMerk.getValueAt(row, 0).toString();
        String nama = tblMerk.getValueAt(row, 1).toString();
        this.id_merk = Integer.parseInt(id);
        txtNamaMerk.setText(nama);
    }//GEN-LAST:event_tblMerkMouseClicked

    private void tblTransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTransaksiMouseClicked
        // TODO add your handling code here:
        int row = tblTransaksi.getSelectedRow();
        String id = tblTransaksi.getValueAt(row, 0).toString();
        String id_pelanggan = tblTransaksi.getValueAt(row, 1).toString();
        String id_barang = tblTransaksi.getValueAt(row, 2).toString();
        String id_pegawai = tblTransaksi.getValueAt(row, 3).toString();
        String qty = tblTransaksi.getValueAt(row, 4).toString();
        this.id_transaksi = Integer.parseInt(id);
        txtQtyTransaksi.setText(qty);
    }//GEN-LAST:event_tblTransaksiMouseClicked

    private void btnSubmitTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitTransaksiActionPerformed
        // TODO add your handling code here:
        int id_pelanggan = ((Pelanggan)cbbPelanggan.getSelectedItem()).getId_pelanggan();
        int id_barang = ((Barang)cbbBarang.getSelectedItem()).getId_barang();
        int id_pegawai = ((Pegawai)cbbPegawai.getSelectedItem()).getId_pegawai();
        int qty = Integer.parseInt(txtQtyTransaksi.getText());
        Transaksi t = new Transaksi(id_pelanggan, id_barang, id_pegawai, qty);
        ExecuteTransaksi ex = new ExecuteTransaksi();
        int hasil = ex.insertData(t);
        if(hasil >0){
            JOptionPane.showMessageDialog(null, "Data berhasil di simpan");
            setDataTransaksi();
        }
        else{
            JOptionPane.showMessageDialog(null, "Data gagal di simpan");
        }
    }//GEN-LAST:event_btnSubmitTransaksiActionPerformed

    private void btnUpdateTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateTransaksiActionPerformed
        // TODO add your handling code here:
        int id_pelanggan = ((Pelanggan)cbbPelanggan.getSelectedItem()).getId_pelanggan();
        int id_barang = ((Barang)cbbBarang.getSelectedItem()).getId_barang();
        int id_pegawai = ((Pegawai)cbbPegawai.getSelectedItem()).getId_pegawai();
        int qty = Integer.parseInt(txtQtyTransaksi.getText());
        Transaksi t = new Transaksi(this.id_transaksi, id_pelanggan, id_barang, id_pegawai, qty);
        ExecuteTransaksi ex = new ExecuteTransaksi();
        int hasil = ex.updateData(t);
        if(hasil >0){
            JOptionPane.showMessageDialog(null, "Data berhasil di ubah");
            setDataTransaksi();
        }
        else{
            JOptionPane.showMessageDialog(null, "Data gagal di ubah");
        }
    }//GEN-LAST:event_btnUpdateTransaksiActionPerformed

    private void btnDeleteTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteTransaksiActionPerformed
        // TODO add your handling code here:
        ExecuteTransaksi ex = new ExecuteTransaksi();
        int hasil = ex.deleteData(this.id_transaksi);
        if(hasil >0){
            JOptionPane.showMessageDialog(null, "Data berhasil di hapus");
            setDataTransaksi();
        }
        else{
            JOptionPane.showMessageDialog(null, "Data gagal di hapus");
        }
    }//GEN-LAST:event_btnDeleteTransaksiActionPerformed

    private void txtHargaBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHargaBarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHargaBarangActionPerformed

    private void tblBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBarangMouseClicked
        // TODO add your handling code here:
        int row = tblBarang.getSelectedRow();
        String id = tblBarang.getValueAt(row, 0).toString();
        String nama = tblBarang.getValueAt(row, 1).toString();
        String keterangan = tblBarang.getValueAt(row, 2).toString();
        String garansi = tblBarang.getValueAt(row, 3).toString();
        String stok = tblBarang.getValueAt(row, 4).toString();
        String harga = tblBarang.getValueAt(row, 5).toString();
        String id_jenis = tblBarang.getValueAt(row, 6).toString();
        String id_merk = tblBarang.getValueAt(row, 7).toString();
        txtNamaBarang.setText(nama);
        taKeteranganBarang.setText(keterangan);
        txtGaransiBarang.setText(garansi);
        txtStokBarang.setText(stok);
        txtHargaBarang.setText(harga);
        this.id_barang = Integer.parseInt(id);
    }//GEN-LAST:event_tblBarangMouseClicked

    private void btnTransaksiPenjualanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransaksiPenjualanActionPerformed
        // TODO add your handling code here:
        UserFrame uf = new UserFrame(id_admin);
        uf.setVisible(true);
        this.dispose();
        System.out.println("ID Admin : " + id_admin);
    }//GEN-LAST:event_btnTransaksiPenjualanActionPerformed

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
    private CardLayout cl;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBarang;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDeleteBarang;
    private javax.swing.JButton btnDeleteJenis;
    private javax.swing.JButton btnDeleteMerk;
    private javax.swing.JButton btnDeletePelanggan;
    private javax.swing.JButton btnDeleteTransaksi;
    private javax.swing.JButton btnJabatan;
    private javax.swing.JButton btnJabatanDelete;
    private javax.swing.JButton btnJabatanSubmit;
    private javax.swing.JButton btnJabatanUpdate;
    private javax.swing.JButton btnMerkJenis;
    private javax.swing.JButton btnPegawai;
    private javax.swing.JButton btnPelanggan;
    private javax.swing.JButton btnSubmitBarang;
    private javax.swing.JButton btnSubmitJenis;
    private javax.swing.JButton btnSubmitMerk;
    private javax.swing.JButton btnSubmitPegawai;
    private javax.swing.JButton btnSubmitPelanggan;
    private javax.swing.JButton btnSubmitTransaksi;
    private javax.swing.JButton btnTransaksi;
    private javax.swing.JButton btnTransaksiPenjualan;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnUpdateBarang;
    private javax.swing.JButton btnUpdateJenis;
    private javax.swing.JButton btnUpdateMerk;
    private javax.swing.JButton btnUpdatePelanggan;
    private javax.swing.JButton btnUpdateTransaksi;
    private javax.swing.JComboBox<String> cbbBarang;
    private javax.swing.JComboBox<String> cbbJabatan;
    private javax.swing.JComboBox<String> cbbJenisBarang;
    private javax.swing.JComboBox<String> cbbMerkBarang;
    private javax.swing.JComboBox<String> cbbPegawai;
    private javax.swing.JComboBox<String> cbbPelanggan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JPanel pnlBarang;
    private javax.swing.JPanel pnlJabatan;
    private javax.swing.JPanel pnlJenis;
    private javax.swing.JPanel pnlMerkJenis;
    private javax.swing.JPanel pnlPegawai;
    private javax.swing.JPanel pnlPelanggan;
    private javax.swing.JPanel pnlTransaksi;
    private javax.swing.JPanel pnlUtama;
    private javax.swing.JTextArea taAlamat;
    private javax.swing.JTextArea taKeteranganBarang;
    private javax.swing.JTextArea taKeteranganJenis;
    private javax.swing.JTable tblBarang;
    private javax.swing.JTable tblJabatan;
    private javax.swing.JTable tblJenis;
    private javax.swing.JTable tblMerk;
    private javax.swing.JTable tblPegawai;
    private javax.swing.JTable tblPelanggan;
    private javax.swing.JTable tblTransaksi;
    private javax.swing.JTextField txtAlamatPelanggan;
    private javax.swing.JTextField txtGaransiBarang;
    private javax.swing.JTextField txtHargaBarang;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtNamaBarang;
    private javax.swing.JTextField txtNamaJabatan;
    private javax.swing.JTextField txtNamaJenis;
    private javax.swing.JTextField txtNamaMerk;
    private javax.swing.JTextField txtNamaPelanggan;
    private javax.swing.JTextField txtNoTelpon;
    private javax.swing.JTextField txtNoTelponPelanggan;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtQtyTransaksi;
    private javax.swing.JTextField txtStokBarang;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
