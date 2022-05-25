package jdbc;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dywa Pratama
 */

import java.sql.*;

public class Connector {
    String DBurl = "jdbc:mysql://localhost/finance";
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
