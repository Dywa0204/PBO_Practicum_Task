/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package authentication;

import component.Header;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import assets.FontDoc;
import assets.ColorDoc;

/**
 *
 * @author Dywa Pratama
 */
public class ViewFormAuthentication extends JFrame{
    boolean login = true;
    
    ColorDoc color = new ColorDoc();
    FontDoc font = new FontDoc();
    
    Header header = new Header("min");
    JLabel lAuth = new JLabel("LOGIN");
    
    JLabel lUsername = new JLabel("Username");
    JLabel lPassword = new JLabel("Password");
    JLabel lFullname = new JLabel("Nama Lengkap");
    
    JTextField tfUsername = new JTextField();
    JPasswordField tfPassword = new JPasswordField();
    JTextField tfFullname = new JTextField();
    
    JButton btnSubmit = new JButton("LOGIN");
    
    JLabel lAsk = new JLabel("Belum punya akun?");
    JButton btnChange = new JButton(" Register Sekarang");
    
    public ViewFormAuthentication(){
        setTitle("Financial Records");
        setSize(315, 385);
        setLayout(null);
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(color.background);
        
        add(header);
        add(lAuth);
        add(lUsername);
        add(lPassword);
        add(lFullname);
        add(tfUsername);
        add(tfPassword);
        add(tfFullname);
        add(btnSubmit);
        add(lAsk);
        add(btnChange);
        
        lAuth.setBounds(0, 92, 300, 24);
        lAuth.setFont(font.inter.deriveFont(Font.BOLD, 20f));
        lAuth.setHorizontalAlignment(SwingConstants.CENTER);
        
        lUsername.setBounds(30, 120, 240, 15);
        lUsername.setFont(font.inter.deriveFont(Font.BOLD, 12f));
        lPassword.setBounds(30, 181, 240, 15);
        lPassword.setFont(font.inter.deriveFont(Font.BOLD, 12f));
        lFullname.setBounds(30, 241, 240, 15);
        lFullname.setFont(font.inter.deriveFont(Font.BOLD, 12f));
        
        tfUsername.setBounds(30, 140, 240, 30);
        tfUsername.setBorder(new EmptyBorder(0, 10, 0, 0));
        tfPassword.setBounds(30, 200, 240, 30);
        tfPassword.setBorder(new EmptyBorder(0, 10, 0, 0));
        tfFullname.setBounds(30, 260, 240, 30);
        tfFullname.setBorder(new EmptyBorder(0, 10, 0, 0));
        
        lFullname.setVisible(false);
        tfFullname.setVisible(false);
        
        btnSubmit.setBounds(30, 255, 240, 40);
        btnSubmit.setBorder(new EmptyBorder(0, 0, 0, 0));
        btnSubmit.setFont(font.inter.deriveFont(Font.BOLD, 20f));
        btnSubmit.setBackground(color.btnSubmit);
        btnSubmit.setForeground(color.textWhite);
        btnSubmit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        lAsk.setBounds(0, 310, 150, 15);
        lAsk.setFont(font.inter.deriveFont(Font.BOLD, 12f));
        lAsk.setHorizontalAlignment(SwingConstants.RIGHT);
        
        btnChange.setBounds(150, 310, (int) btnChange.getPreferredSize().getWidth(), 15);
        btnChange.setBackground(null);
        btnChange.setBorder(new EmptyBorder(0, 0, 0, 0));
        btnChange.setFont(font.inter.deriveFont(Font.BOLD, 12f));
        btnChange.setHorizontalAlignment(SwingConstants.LEFT);
        btnChange.setForeground(color.btnSubmit);
        btnChange.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        
        btnSubmit.addActionListener((ActionEvent arg0) -> {
            ControllerFormAuthentication controller = new ControllerFormAuthentication(this);
            controller.proccessAuth(login, getUsername(), getPassword(), getFullname());
        });
        
        btnChange.addActionListener((ActionEvent arg0) -> {
            setForm();
        });
    }
    
    void setForm(){
        login = !login;
        if(login){
            setSize(315, 385);
            lAuth.setText("LOGIN");
            btnSubmit.setText("LOGIN");
            btnChange.setText(" Register Sekarang");
            lAsk.setText("Belum punya akun?");
            
            lFullname.setVisible(false);
            tfFullname.setVisible(false);
            
            btnSubmit.setBounds(30, 255, 240, 40);
            
            lAsk.setBounds(0, 310, 150, 15);
            btnChange.setBounds(150, 310, 150, 15);
        }else{
            setSize(315, 435);
            lAuth.setText("REGISTER");
            btnSubmit.setText("REGISTER");
            btnChange.setText(" Login Sekarang");
            lAsk.setText("Sudah punya akun?");
            
            lFullname.setVisible(true);
            tfFullname.setVisible(true);
            
            btnSubmit.setBounds(30, 305, 240, 40);
            
            lAsk.setBounds(0, 360, 155, 15);
            btnChange.setBounds(155, 360, 145, 15);
        }
    }
    
    public String getFullname(){
        return tfFullname.getText();
    }
    
    public String getUsername(){
        return tfUsername.getText();
    }
    
    public String getPassword(){
        return new String(tfPassword.getPassword());
    }
    
    void setMessage(String Message){
        JOptionPane.showMessageDialog(null, Message);
    }
}
