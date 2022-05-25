/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabungan;

import component.Header;
import javax.swing.*;
import style.ColorDoc;
import style.FontDoc;

/**
 *
 * @author Dywa Pratama
 */
public class ViewTabungan extends JFrame{
    ColorDoc color = new ColorDoc();
    FontDoc font = new FontDoc();
    
    Header header = new Header("max");
    
    Tabunganku pTabungan;
    
    public ViewTabungan(String username, String fullname){
        this.pTabungan = new Tabunganku(this, username, fullname);
        
        setTitle("Financial Records");
        setSize(715, 635);
        setLayout(null);
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(color.background);
        
        add(header);
        add(pTabungan);
        
        header.setPositionX();
        
        header.setFullname(fullname);
        header.setViewDashboard(this);
    }
    
    void setMessage(String Message){
        JOptionPane.showMessageDialog(null, Message);
    }
}
