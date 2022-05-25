/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catatan;

import component.Header;
import javax.swing.*;
import style.ColorDoc;
import style.FontDoc;

/**
 *
 * @author Dywa Pratama
 */
public class ViewCatatan extends JFrame{
    ColorDoc color = new ColorDoc();
    FontDoc font = new FontDoc();
    
    Header header = new Header("max");
    
    Catatanku pCatatanku;
    
    public ViewCatatan(String username, String fullname, int idTabungan){
        this.pCatatanku = new Catatanku(this, username, fullname, idTabungan);
        
        setTitle("Financial Records");
        setSize(1015, 635);
        setLayout(null);
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(color.background);
        
        add(header);
        add(pCatatanku);
        
        header.setFullname(fullname);
        header.setViewCatatan(this);
    }
    
    void setMessage(String Message){
        JOptionPane.showMessageDialog(null, Message);
    }
}
