/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exec;
import com.Jabatan;
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
public class ExecuteJabatan {
    public List<Jabatan> getAllData(){
        String query = "select * from jabatan";
        ConnectionManager conMan = new ConnectionManager();
        List<Jabatan> lsjabatan = new ArrayList<>();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()){
                Jabatan j = new Jabatan();
                j.setId_jabatan(rs.getInt("id_jabatan"));
                j.setNama(rs.getString("nama"));
                lsjabatan.add(j);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ExecuteJabatan.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return lsjabatan;
    }
    
    public int insertData(Jabatan j){
        int hasil = 0;
        String query = "insert into jabatan(nama) values"
                + "('"+j.getNama()+ "')"; ;
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);
            System.out.println(query);
        } catch (SQLException ex) {
            Logger.getLogger(ExecuteJabatan.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(query);
        }
        conMan.logOff();
        return hasil;
    }
    public int deleteData(int id_jabatan){
        String query = "delete from jabatan where id_jabatan="+ id_jabatan;
        int hasil = 0;
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        try {
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ExecuteJabatan.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return hasil;
    }
    public int updateData(Jabatan p){
        int hasil = 0;
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.logOn();
        String query = "Update jabatan set nama='"+p.getNama()
                +"' where id_jabatan="+p.getId_jabatan();
        try {
            Statement stm = conn.createStatement();
            hasil = stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ExecuteJabatan.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return hasil;
    }
}
