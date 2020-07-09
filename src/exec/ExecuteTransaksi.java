/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exec;
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
