/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author ALIK
 */
public class ConnectionManager {
    private Connection con;
    private final String driver = "com.mysql.jdbc.Driver";
    private final String url = "jdbc:mysql://localhost:3306/toko_elektronik";  // myDB --> nama database kita
    private final String username = "root";       // user name DMBS
    private final String password = "";    // pswd DMBS
    public Connection logOn(){
        try {
            //Load JDBC Driver
            Class.forName( driver ).newInstance();
            //Buat object Connection
            con = DriverManager.getConnection( url, username, password );
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return con;
    }
    public void logOff(){
        try {
            con.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
