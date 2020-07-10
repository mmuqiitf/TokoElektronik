/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exec;

import com.Barang;
import com.Pelanggan;
import db.ConnectionManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ALIK
 */
public class ExecuteBarang {
    public List<Barang> getAllData(){
        String query = "select * from barang";
        ConnectionManager conMan = new ConnectionManager();
        List<Barang> lsBarang = new ArrayList<>();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()){
                Barang b = new Barang();
                b.setId_barang(rs.getInt("id_barang"));
                b.setNama(rs.getString("nama"));
                b.setKeterangan(rs.getString("keterangan"));
                b.setGaransi(rs.getString("garansi"));
                b.setStok(rs.getInt("stok"));
                b.setHarga(rs.getInt("harga"));
                b.setId_jenis(rs.getInt("id_jenis"));
                b.setId_merk(rs.getInt("id_merk"));
                lsBarang.add(b);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ExecuteBarang.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return lsBarang;
    }
    
    public List<Barang> getAllDataWithStock(){
        String query = "SELECT barang.*, barang.stok - SUM(transaksi.qty) AS sisa FROM barang "
                + "JOIN transaksi ON barang.id_barang = transaksi.id_barang GROUP BY barang.id_barang";
        ConnectionManager conMan = new ConnectionManager();
        List<Barang> lsBarang = new ArrayList<>();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()){
                Barang b = new Barang();
                b.setId_barang(rs.getInt("barang.id_barang"));
                b.setNama(rs.getString("barang.nama"));
                b.setKeterangan(rs.getString("barang.keterangan"));
                b.setGaransi(rs.getString("barang.garansi"));
                b.setStok(rs.getInt("sisa"));
                b.setHarga(rs.getInt("barang.harga"));
                b.setId_jenis(rs.getInt("barang.id_jenis"));
                b.setId_merk(rs.getInt("barang.id_merk"));
                lsBarang.add(b);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ExecuteBarang.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return lsBarang;
    }
    
    public int insertData(Barang b){
        int hasil = 0;
        String query = "insert into barang(nama, keterangan, garansi, stok, harga, id_jenis, id_merk) values"
                + "('"+b.getNama()+"','"+b.getKeterangan()+ "','"
                + b.getGaransi()+ "',"
                + b.getStok()+ "," +
                + b.getHarga()+ "," +
                + b.getId_jenis() + ", "
                + b.getId_merk() + ")";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);
            System.out.println(query);
        } catch (SQLException ex) {
            Logger.getLogger(ExecuteBarang.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(query);
        }
        conMan.logOff();
        return hasil;
    }
    public int deleteData(int id_barang){
        String query = "delete from barang where id_barang="+ id_barang;
        int hasil = 0;
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ExecuteBarang.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return hasil;
    }
    public int updateData(Barang b){
        int hasil = 0;
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        String query = "Update barang set nama='"+b.getNama()+
                 "', keterangan='"+ b.getKeterangan()+  
                "', garansi='" + b.getGaransi()+  
                "', stok=" + b.getStok()+
                ", id_jenis=" + b.getId_jenis()+  
                ", id_merk=" + b.getId_merk()
                +" where id_barang="+b.getId_barang();
        try {
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ExecuteBarang.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return hasil;
    }
}
