/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exec;
import com.Barang;
import com.Barang;
import com.Pegawai;
import com.Pegawai;
import com.Pelanggan;
import com.Pelanggan;
import com.Transaksi;
import com.Transaksi;
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
public class ExecuteTransaksi {
    public List<Transaksi> getAllData(){
        String query = "select * from transaksi";
        ConnectionManager conMan = new ConnectionManager();
        List<Transaksi> lstransaksi = new ArrayList<>();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()){
                Transaksi t = new Transaksi();
                t.setId_transaksi(rs.getInt("id_transaksi"));
                t.setId_barang(rs.getInt("id_barang"));
                t.setId_pelanggan(rs.getInt("id_pelanggan"));
                t.setId_pegawai(rs.getInt("id_pegawai"));
                t.setQty(rs.getInt("qty"));
                lstransaksi.add(t);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ExecuteTransaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return lstransaksi;
    }
    
    public List<Transaksi> getAllDataWithRelation(){
        String query = "select transaksi.*, barang.*, pelanggan.*, pegawai.* from transaksi "
                + "join barang on transaksi.id_barang = barang.id_barang join pelanggan on transaksi.id_pelanggan = pelanggan.id_pelanggan "
                + "join pegawai on transaksi.id_pegawai = pegawai.id_pegawai";
        ConnectionManager conMan = new ConnectionManager();
        List<Transaksi> lstransaksi = new ArrayList<>();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()){
                Transaksi t = new Transaksi();
                t.setId_transaksi(rs.getInt("transaksi.id_transaksi"));
                t.setId_barang(rs.getInt("transaksi.id_barang"));
                t.setId_pelanggan(rs.getInt("transaksi.id_pelanggan"));
                t.setId_pegawai(rs.getInt("transaksi.id_pegawai"));
                t.setQty(rs.getInt("transaksi.qty"));
                Barang b = new Barang();
                b.setId_barang(rs.getInt("barang.id_barang"));
                b.setNama(rs.getString("barang.nama"));
                Pelanggan p = new Pelanggan();
                p.setId_pelanggan(rs.getInt("pelanggan.id_pelanggan"));
                p.setNama(rs.getString("pelanggan.nama"));
                Pegawai pg = new Pegawai();
                pg.setId_pegawai(rs.getInt("pegawai.id_pegawai"));
                pg.setNama(rs.getString("pegawai.nama"));
                t.setBarang(b);
                t.setPelanggan(p);
                t.setPegawai(pg);
                lstransaksi.add(t);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ExecuteTransaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return lstransaksi;
    }
    
    public int insertData(Transaksi t){
        int hasil = 0;
        String query = "insert into transaksi(id_pelanggan, id_barang, id_pegawai, qty) values"
                + "("+t.getId_pelanggan()+","+t.getId_barang()+ "," +t.getId_pegawai()+ "," +t.getQty() + ")";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);
            System.out.println(query);
        } catch (SQLException ex) {
            Logger.getLogger(ExecuteTransaksi.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(query);
        }
        conMan.logOff();
        return hasil;
    }
    
    public int insertData(int id_pelanggan, int id_barang, int id_pegawai, int qty){
        int hasil = 0;
        String query = "insert into transaksi(id_pelanggan, id_barang, id_pegawai, qty) values"
                + "("+id_pelanggan+","+id_barang+ "," +id_pegawai+ "," +qty + ")";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);
            System.out.println(query);
        } catch (SQLException ex) {
            Logger.getLogger(ExecuteTransaksi.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(query);
        }
        conMan.logOff();
        return hasil;
    }
    
    public int deleteData(int id_transaksi){
        String query = "delete from transaksi where id_transaksi="+ id_transaksi;
        int hasil = 0;
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ExecuteTransaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return hasil;
    }
    public int updateData(Transaksi t){
        int hasil = 0;
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        String query = "Update transaksi set id_pelanggan='"+t.getId_pelanggan()+
                 "', id_barang='"+ t.getId_barang()+  
                "', id_pegawai='" + t.getId_pegawai() +  "', qty=" + t.getQty() +
                " where id_transaksi="+t.getId_transaksi();
        try {
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ExecuteTransaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return hasil;
    }
}
