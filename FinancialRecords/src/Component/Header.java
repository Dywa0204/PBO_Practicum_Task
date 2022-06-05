/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Component;

import Assets.ColorDoc;
import Assets.FontDoc;
import Controller.AuthController;
import View.AuthView;
import View.CatatanView;
import View.TabunganView;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Dywa Pratama
 */
public class Header extends JPanel implements ActionListener{
    String username = "";
    ColorDoc color = new ColorDoc();
    FontDoc font = new FontDoc();
    
    TabunganView tabungan;
    CatatanView catatan;
    String currentView;
    
    JLabel lTitle = new JLabel("FINANCE");
    
    Image image = new ImageIcon(this.getClass().getResource("../assets/images/logout.png")).getImage();
    
    JLabel lFullname = new JLabel("");
    JButton btnLogout = new JButton();
    
    JPanel pUser = new JPanel();
    
    public Header(){
        setBackground(color.header);
        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(20, 30, 20, 30));
        setBounds(0, 0, 700, 80);
        
        add(lTitle, BorderLayout.WEST);
        add(pUser, BorderLayout.EAST);
        
        
        lTitle.setFont(font.inter.deriveFont(Font.BOLD, 32f));
        lTitle.setForeground(Color.white);
        
        pUser.setLayout(new BoxLayout(pUser, BoxLayout.X_AXIS));
        
        pUser.add(lFullname);
        pUser.add(Box.createRigidArea(new Dimension(20, 0)));
        pUser.add(btnLogout);
        
        pUser.setBackground(null);
        
        lFullname.setFont(font.inter.deriveFont(Font.BOLD, 16f));
        lFullname.setForeground(Color.white);
        
        btnLogout.setBackground(null);
        btnLogout.setContentAreaFilled(false);
        btnLogout.setBorder(BorderFactory.createEmptyBorder());
        btnLogout.setIcon(new ImageIcon(image));
        btnLogout.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnLogout.setFocusPainted(false);
        
        btnLogout.addActionListener(this);
    }
    
    public void setFullname(String fullname){
        lFullname.setText(fullname);
    }
    
    public void setUsername(String username){
        this.username = username;
    }
    
    public void setHeaderWidth(int width){
        setBounds(0, 0, width, 80);
    }
    
    public void setTabunganView(TabunganView tabungan){
        this.tabungan = tabungan;
        this.currentView = "tabungan";
    }
    
    public void setCatatanView(CatatanView catatan){
        this.catatan = catatan;
        this.currentView = "catatan";
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnLogout){
            AuthView auth = new AuthView();
            if(currentView.equals("tabungan")) tabungan.setVisible(false);
            else catatan.setVisible(false);
        }
    }
}
