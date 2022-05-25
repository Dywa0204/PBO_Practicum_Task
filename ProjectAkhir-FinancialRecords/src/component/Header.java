/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package component;

import auth.ViewForm;
import catatan.ViewCatatan;
import tabungan.ViewTabungan;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import style.ColorDoc;
import style.FontDoc;

/**
 *
 * @author Dywa Pratama
 */
public class Header extends JPanel{
    ColorDoc color = new ColorDoc();
    FontDoc font = new FontDoc();
    ViewTabungan dashboard;
    ViewCatatan catatan;
    
    String currentView;
    
    JLabel lTitle = new JLabel("FINANCE");
    
    Image image = new ImageIcon(this.getClass().getResource("logout.png")).getImage();
    
    JLabel lFullname = new JLabel();
    JButton btnLogout = new JButton();
    
    public Header(String is){
        setBackground(color.header);
        setBounds(0, 0, 1000, 80);
        setLayout(null);
        
        add(lTitle);
        add(lFullname);
        add(btnLogout);
        
        lTitle.setFont(font.inter.deriveFont(Font.BOLD, 32f));
        lTitle.setBounds(30, 0, 300, 80);
        lTitle.setForeground(color.textWhite);
        
        lFullname.setBounds(632, 30, 300, 20);
        lFullname.setFont(font.inter.deriveFont(Font.BOLD, 16f));
        lFullname.setHorizontalAlignment(SwingConstants.RIGHT);
        lFullname.setForeground(color.textWhite);
        
        btnLogout.setBounds(954, 30, 18, 19);
        btnLogout.setBackground(null);
        btnLogout.setBorder(new EmptyBorder(0, 0, 0, 0));
        btnLogout.setIcon(new ImageIcon(image));
        btnLogout.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        btnLogout.addActionListener((ActionEvent arg0) -> {
            ViewForm form = new ViewForm();
            if(this.currentView.equals("dashboard")) dashboard.setVisible(false);
            else catatan.setVisible(false);
        });
        
        if(is.equals("min")){
            lTitle.setBounds(0, 0, 300, 80);
            lTitle.setHorizontalAlignment(SwingConstants.CENTER);
        }
    }
    
    public void setViewDashboard(ViewTabungan dashboard){
        this.dashboard = dashboard;
        this.currentView = "dashboard";
    }
    
    public void setViewCatatan(ViewCatatan catatan){
        this.catatan = catatan;
        this.currentView = "catatan";
    }
    
    public void setFullname(String fullname){
        lFullname.setText(fullname);
    }
    
    public void setTitleBounds(int width){
        lTitle.setBounds(0, 0, width, 80);
    }
    
    public void setPositionX(){
        lFullname.setBounds(330, 30, 300, 20);
        btnLogout.setBounds(652, 30, 18, 19);
    }
}
