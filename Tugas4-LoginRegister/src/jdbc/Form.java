/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

/**
 *
 * @author Dywa Pratama
 */

import java.awt.HeadlessException;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Form extends JFrame{
    Connector connector = new Connector(); 
    
    JLabel lTitle = new JLabel("Form Login dan Register", SwingConstants.CENTER);
    
    JLabel lUsernameLogin = new JLabel("Username");
    JLabel lPasswordLogin = new JLabel("Password");
    JLabel lUsernameReg = new JLabel("Username");
    JLabel lPasswordReg = new JLabel("Password");
    
    JTextField tfUsernameLogin = new JTextField();
    JTextField tfPasswordLogin = new JTextField();
    JTextField tfUsernameReg = new JTextField();
    JTextField tfPasswordReg = new JTextField();
    
    JButton btnLogin = new JButton("Login");
    JButton btnReg = new JButton("Daftar");
    
    public Form(){
        setTitle("Form Login dan Register");
        setSize(500, 400);
        setLayout(null);
        
        add(lTitle);
        add(lUsernameLogin);
        add(lPasswordLogin);
        add(lUsernameReg);
        add(lPasswordReg);
        add(tfUsernameLogin);
        add(tfPasswordLogin);
        add(tfUsernameReg);
        add(tfPasswordReg);
        add(btnLogin);
        add(btnReg);
        
        lTitle.setBounds(160, 50, 140, 15);
        
        lUsernameLogin.setBounds(60, 100, 80, 20);
        lPasswordLogin.setBounds(60, 180, 80, 20);
        
        tfUsernameLogin.setBounds(60, 130, 140, 30);
        tfPasswordLogin.setBounds(60, 210, 140, 30);
        
        btnLogin.setBounds(80, 280, 100, 20);
        
        lUsernameReg.setBounds(290, 100, 80, 20);
        lPasswordReg.setBounds(290, 180, 80, 20);
        
        tfUsernameReg.setBounds(290, 130, 140, 30);
        tfPasswordReg.setBounds(290, 210, 140, 30);
        
        btnReg.setBounds(310, 280, 100, 20);
        
        btnReg.addActionListener((ActionEvent arg0) -> {
            try {
                if(!getUsernameReg().isEmpty() & !getPasswordReg().isEmpty()){
                    String query = "INSERT INTO `users`(`username`, `password`) VALUES ('" + getUsernameReg() + "','" + getPasswordReg() + "')";
                    
                    connector.statement = connector.koneksi.createStatement();
                    connector.statement.executeUpdate(query);
                    
                    JOptionPane.showMessageDialog(null,"Berhasil Mendaftarkan User");
                }else{
                    JOptionPane.showMessageDialog(null,"Username dan Password Tidak Boleh Kosong");
                }
            } catch (HeadlessException | SQLException ex){
                if(ex.getMessage().contains("Duplicate entry")){
                    JOptionPane.showMessageDialog(null,"Username Sudah Digunakan");
                }
            }
        });
        
        btnLogin.addActionListener((ActionEvent arg0) -> {
            try {
                String query = "SELECT `username`, `password` FROM `users` WHERE `username` = '" + getUsernameLogin() + "'";
                
                connector.statement = connector.koneksi.createStatement();
                ResultSet resultSet = connector.statement.executeQuery(query);
                
                if(resultSet.next()){
                    if(resultSet.getString("password").equals(getPasswordLogin())){
                        JOptionPane.showMessageDialog(null,"Berhasil Login");
                    }else{
                        JOptionPane.showMessageDialog(null,"Password Salah");
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"Username Belum Terdaftar");
                }
            } catch (HeadlessException | SQLException ex){
                JOptionPane.showMessageDialog(null,"Terjadi Kesalahan");
            }
        });
        
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public String getUsernameLogin(){
        return tfUsernameLogin.getText();
    }

    public String getPasswordLogin() {
        return tfPasswordLogin.getText();
    }
    
    public String getUsernameReg(){
        return tfUsernameReg.getText();
    }

    public String getPasswordReg() {
        return tfPasswordReg.getText();
    }
}
