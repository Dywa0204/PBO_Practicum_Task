/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Assets.ColorDoc;
import Assets.FontDoc;
import Component.Header;
import Controller.TabunganController;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Dywa Pratama
 */
public class FormTabunganView extends JFrame implements ActionListener{
    PanelTabunganView view;
    String username, fullname;
    ColorDoc color = new ColorDoc();
    FontDoc font = new FontDoc();
    
    Header header = new Header();
    
    JLabel lTitle = new JLabel("TAMBAH TABUNGAN");
    
    JLabel lName = new JLabel("Nama Tabungan");
    JTextField tfName = new JTextField();
    
    JButton btnSubmit = new JButton("SUBMIT");
    JButton btnCancel = new JButton("BATAL");
    
    public FormTabunganView(PanelTabunganView view, String username, String fullname){
        this.view = view;
        this.username = username;
        this.fullname = fullname;
        
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
        btnSubmit.setForeground(Color.white);
        btnSubmit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        btnCancel.setBounds(170, 220, 120, 40);
        btnCancel.setBorder(new EmptyBorder(0, 0, 0, 0));
        btnCancel.setFont(font.inter.deriveFont(Font.BOLD, 16f));
        btnCancel.setBackground(color.btnCancel);
        btnCancel.setForeground(Color.white);
        btnCancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        btnSubmit.addActionListener(this);
        btnCancel.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnSubmit){
            TabunganController controller = new TabunganController(view);
            controller.setFormTabungan(this);
            if(controller.processData(username, getNamaTabungan())){
                setVisible(false);
            }
        }
        else if(e.getSource() == btnCancel){
            setVisible(false);
        }
    }
    
    String getNamaTabungan(){
        return tfName.getText();
    }
    
    public void setNamaTabungan(String text){
        tfName.setText(text);
    }
    
    void setMessage(String Message){
        JOptionPane.showMessageDialog(null, Message);
    }
}
