/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabungan.formTabungan;

import component.Header;
import tabungan.ViewTabungan;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import assets.ColorDoc;
import assets.FontDoc;

/**
 *
 * @author Dywa Pratama
 */
public class ViewFormTabungan extends JFrame{
    ColorDoc color = new ColorDoc();
    FontDoc font = new FontDoc();
    
    Header header = new Header("min");
    
    JLabel lTitle = new JLabel("TAMBAH TABUNGAN");
    
    JLabel lName = new JLabel("Nama Tabungan");
    JTextField tfName = new JTextField();
    
    JButton btnSubmit = new JButton("SUBMIT");
    JButton btnCancel = new JButton("BATAL");
    
    public ViewFormTabungan(ViewTabungan view, String username, String fullname){
        setTitle("Financial Records");
        setSize(335, 335);
        setLayout(null);
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(null);
        getContentPane().setBackground(color.background);
        
        add(header);
        add(lTitle);
        add(lName);
        add(tfName);
        add(btnSubmit);
        add(btnCancel);
        
        header.setTitleBounds(320);
        
        lTitle.setBounds(0, 110, 320, 24);
        lTitle.setFont(font.inter.deriveFont(Font.BOLD, 20f));
        lTitle.setHorizontalAlignment(SwingConstants.CENTER);
        
        lName.setBounds(30, 150, 200, 15);
        lName.setFont(font.inter.deriveFont(Font.BOLD, 12f));
        
        tfName.setBounds(30, 170, 260, 30);
        tfName.setBorder(new EmptyBorder(0, 10, 0, 10));
        
        btnSubmit.setBounds(30, 220, 120, 40);
        btnSubmit.setBorder(new EmptyBorder(0, 0, 0, 0));
        btnSubmit.setFont(font.inter.deriveFont(Font.BOLD, 16f));
        btnSubmit.setBackground(color.btnSubmit);
        btnSubmit.setForeground(color.textWhite);
        btnSubmit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        btnCancel.setBounds(170, 220, 120, 40);
        btnCancel.setBorder(new EmptyBorder(0, 0, 0, 0));
        btnCancel.setFont(font.inter.deriveFont(Font.BOLD, 16f));
        btnCancel.setBackground(color.btnCancel);
        btnCancel.setForeground(color.textWhite);
        btnCancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        btnSubmit.addActionListener((ActionEvent arg0) -> {
            ControllerFormTabungan form = new ControllerFormTabungan(this);
            if(form.processData(username, getNamaTabungan())){
                view.setVisible(false);
                ViewTabungan newView = new ViewTabungan(username, fullname);
                SwingUtilities.updateComponentTreeUI(newView);
                setVisible(false);
            }
        });
        
        btnCancel.addActionListener((ActionEvent arg0) -> {
            setVisible(false);
        });
    }
    
    String getNamaTabungan(){
        return tfName.getText();
    }
    
    void setMessage(String Message){
        JOptionPane.showMessageDialog(null, Message);
    }
}
