/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catatan;

import component.Header;
import javax.swing.*;
import assets.ColorDoc;
import assets.FontDoc;

/**
 *
 * @author Dywa Pratama
 */
public class ViewCatatan extends JFrame{
    ColorDoc color = new ColorDoc();
    FontDoc font = new FontDoc();
    
    Header header = new Header("max");
    
    Catatanku pCatatanku;
    
    public ViewCatatan(int idTabungan, String username, String fullname){
        pCatatanku = new Catatanku(this, idTabungan, username, fullname);
        
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
