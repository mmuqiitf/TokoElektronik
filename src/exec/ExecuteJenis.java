/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exec;
import com.Jenis;
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
public class ExecuteJenis {
    public List<Jenis> getAllData(){
        String query = "select * from jenis";
        ConnectionManager conMan = new ConnectionManager();
        List<Jenis> lsjenis = new ArrayList<>();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()){
                Jenis p = new Jenis();
                p.setId_jenis(rs.getInt("id_jenis"));
                p.setNama(rs.getString("nama"));
                p.setKeterangan(rs.getString("keterangan"));
                lsjenis.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ExecuteJenis.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return lsjenis;
    }
    
    public int insertData(Jenis p){
        int hasil = 0;
        String query = "insert into jenis(nama, keterangan) values"
                + "('"+p.getNama()+"','"+p.getKeterangan()+ "')"; ;
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);
            System.out.println(query);
        } catch (SQLException ex) {
            Logger.getLogger(ExecuteJenis.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(query);
        }
        conMan.logOff();
        return hasil;
    }
    public int deleteData(int id_jenis){
        String query = "delete from jenis where id_jenis="+ id_jenis;
        int hasil = 0;
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ExecuteJenis.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return hasil;
    }
    public int updateData(Jenis p){
        int hasil = 0;
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        String query = "Update jenis set nama='"+p.getNama()+
                 "', keterangan='"+ p.getKeterangan()
                +"' where id_jenis="+p.getId_jenis();
        try {
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ExecuteJenis.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return hasil;
    }
}
