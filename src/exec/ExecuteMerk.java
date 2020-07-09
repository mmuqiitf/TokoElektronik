/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exec;
import db.ConnectionManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.Merk;
/**
 *
 * @author ALIK
 */
public class ExecuteMerk {
    public List<Merk> getAllData(){
        String query = "select * from merk";
        ConnectionManager conMan = new ConnectionManager();
        List<Merk> lsmerk = new ArrayList<>();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()){
                Merk j = new Merk();
                j.setId_merk(rs.getInt("id_merk"));
                j.setNama(rs.getString("nama"));
                lsmerk.add(j);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ExecuteMerk.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return lsmerk;
    }
    
    public int insertData(Merk m){
        int hasil = 0;
        String query = "insert into merk(nama) values"
                + "('"+m.getNama()+ "')"; ;
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);
            System.out.println(query);
        } catch (SQLException ex) {
            Logger.getLogger(ExecuteMerk.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(query);
        }
        conMan.logOff();
        return hasil;
    }
    public int deleteData(int id_merk){
        String query = "delete from merk where id_merk="+ id_merk;
        int hasil = 0;
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ExecuteMerk.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return hasil;
    }
    public int updateData(Merk m){
        int hasil = 0;
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        String query = "Update merk set nama='"+m.getNama()
                +"' where id_merk="+m.getId_merk();
        try {
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ExecuteMerk.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return hasil;
    }
}
