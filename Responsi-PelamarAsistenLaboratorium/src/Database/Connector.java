/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author Dywa Pratama
 */
public class Connector {
    String DBurl = "jdbc:mysql://localhost/aslab_db";
    String DBusername = "root";
    String DBpassword = "";
    
    public Connection connection;
    public Statement statement;
    
    public Connector() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = (Connection) DriverManager.getConnection(DBurl, DBusername, DBpassword);
        }catch(Exception ex){
            System.out.println("Connection Failed\n" + ex.getMessage());
        }
    }
}
