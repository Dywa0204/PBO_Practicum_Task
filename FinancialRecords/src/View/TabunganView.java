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
public class TabunganView extends JFrame{
    ColorDoc color = new ColorDoc();
    FontDoc font = new FontDoc();
    
    Header header = new Header();
    
    JPanel pTabungan;
    
    public TabunganView(String username, String fullname){
        pTabungan = new PanelTabunganView(this,username, fullname);
        
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
        
        header.setFullname(fullname);
        header.setUsername(username);
        header.setTabunganView(this);
    }
}
