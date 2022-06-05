/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Assets.ColorDoc;
import Assets.FontDoc;
import Component.Header;
import javax.swing.*;

/**
 *
 * @author Dywa Pratama
 */
public class CatatanView extends JFrame{
    ColorDoc color = new ColorDoc();
    FontDoc font = new FontDoc();
    
    Header header = new Header();
    
    JPanel pCatatan;
    
    public CatatanView(int idTabungan, String username, String fullname){
        pCatatan = new PanelCatatanView(this, idTabungan, username, fullname);
        
        setTitle("Financial Records");
        setSize(1015, 635);
        setLayout(null);
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(color.background);
        
        add(header);
        add(pCatatan);
        
        header.setFullname(fullname);
        header.setUsername(username);
        header.setCatatanView(this);
        header.setHeaderWidth(1000);
    }
}
