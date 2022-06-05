/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Database.Connector;
import View.AuthView;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Dywa Pratama
 */
public class UserModel {
    private String username, password, fullname;
    Connector connector = new Connector();
    
    private final AuthView view;
    
    public UserModel(AuthView view){
        this.view = view;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
    
    public String login(){
        String temp = "";
        try {
            String query = "SELECT `password`, `fullname` FROM `user` WHERE `username` = '" + this.username + "'";
            
            connector.statement = connector.connection.createStatement();
            ResultSet resultSet = connector.statement.executeQuery(query);
            
            if(resultSet.next()){
                if(resultSet.getString("password").equals(this.password)) temp = resultSet.getString("fullname");
                else view.setMessage("Password Salah");
            }else{
                view.setMessage("Username Tidak Ditemukan");
            }
        } catch (SQLException ex) {
            view.setMessage("Terjadi Kesalahan Database");
        }
        return temp;
    }
    
    public boolean register(){
        boolean temp = false;
        try {
            String query = "INSERT INTO `user` (`username`, `password`, `fullname`) VALUES "
                    + "('" + this.username + "', '" + this.password + "', '" + this.fullname + "')";
            
            connector.statement = connector.connection.createStatement();
            connector.statement.executeUpdate(query);
            temp = true;
        } catch (SQLException ex) {
            if(ex.getMessage().contains("Duplicate")) view.setMessage("Username Telah Terpakai");
            else view.setMessage("Terjadi Kesalahan Database");
        }
        return temp;
    }
}
