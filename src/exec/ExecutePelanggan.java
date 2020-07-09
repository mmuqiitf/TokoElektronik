/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exec;

import com.Pegawai;
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
public class ExecutePelanggan {
    public List<Pelanggan> getAllData(){
        String query = "select * from pelanggan";
        ConnectionManager conMan = new ConnectionManager();
        List<Pelanggan> lsPelanggan = new ArrayList<>();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()){
                Pelanggan p = new Pelanggan();
                p.setId_pelanggan(rs.getInt("id_pelanggan"));
                p.setNama(rs.getString("nama"));
                p.setNo_telpon(rs.getString("no_telpon"));
                p.setAlamat(rs.getString("alamat"));
                lsPelanggan.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ExecutePelanggan.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return lsPelanggan;
    }
    
    public int insertData(Pelanggan p){
        int hasil = 0;
        String query = "insert into pelanggan(nama, no_telpon, alamat) values"
                + "('"+p.getNama()+"','"+p.getNo_telpon()+ "','"
                + p.getAlamat()+ "')"; ;
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);
            System.out.println(query);
        } catch (SQLException ex) {
            Logger.getLogger(ExecutePelanggan.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(query);
        }
        conMan.logOff();
        return hasil;
    }
    public int deleteData(int id_pelanggan){
        String query = "delete from pelanggan where id_pelanggan="+ id_pelanggan;
        int hasil = 0;
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ExecutePelanggan.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return hasil;
    }
    public int updateData(Pelanggan p){
        int hasil = 0;
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        String query = "Update pelanggan set nama='"+p.getNama()+
                 "', no_telpon='"+ p.getNo_telpon()+  
                "', alamat='" + p.getAlamat()
                +"' where id_pelanggan="+p.getId_pelanggan();
        try {
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ExecutePelanggan.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return hasil;
    }
}
