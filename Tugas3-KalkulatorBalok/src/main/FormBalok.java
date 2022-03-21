/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import ruang.*;

/**
 *
 * @author Dywa Pratama
 */

import javax.swing.*;
import java.awt.Font;
import java.awt.event.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class FormBalok extends JFrame{
    JLabel lTitle = new JLabel("Kalkulator Balok", SwingConstants.CENTER);
    
    JLabel lPanjang = new JLabel("Panjang");
    JLabel lLebar = new JLabel("Lebar");
    JLabel lTinggi = new JLabel("Tinggi");
    JTextField tfPanjang = new JTextField();
    JTextField tfLebar = new JTextField();
    JTextField tfTinggi = new JTextField();
    
    JLabel lHasil = new JLabel("Hasil", SwingConstants.CENTER);
    
    JLabel lLuas = new JLabel("Luas :");
    JLabel lKeliling = new JLabel("Keliling :");
    JLabel lVolume = new JLabel("Volume :");
    JLabel lLuasPermukaan = new JLabel("Luas Permukaan :");
    
    JButton btnHitung = new JButton("Hintung");
    JButton btnReset = new JButton("Reset");
    
    public FormBalok(){
        setTitle("Kalkulator Balok");
        setSize(640, 560);
        setLayout(null);
        
        add(lTitle);
        add(lPanjang);
        add(lLebar);
        add(lTinggi);
        add(tfPanjang);
        add(tfLebar);
        add(tfTinggi);
        add(lHasil);
        
        add(lLuas);
        add(lKeliling);
        add(lVolume);
        add(lLuasPermukaan);
        
        add(btnHitung);
        add(btnReset);
        
        lTitle.setFont(new Font("Verdana", Font.PLAIN, 24));
        lTitle.setBounds(128, 27, 384, 32);

        lPanjang.setBounds(64, 108, 96, 32);
        tfPanjang.setBounds(160, 108, 416, 32);
        
        lLebar.setBounds(64, 162, 96, 32);
        tfLebar.setBounds(160, 162, 416, 32);
        
        lTinggi.setBounds(64, 216, 96, 32);
        tfTinggi.setBounds(160, 216, 416, 32);
        
        lHasil.setFont(new Font("Verdana", Font.PLAIN, 16));
        lHasil.setBounds(192, 270, 256, 32);
        
        lLuas.setBounds(128, 324, 160, 32);
        lKeliling.setBounds(128, 378, 160, 32);
        lVolume.setBounds(352, 324, 160, 32);
        lLuasPermukaan.setBounds(352, 378, 160, 32);
        
        btnHitung.setBounds(160, 454, 128, 32);
        btnReset.setBounds(352, 454, 128, 32);
        
        
        btnHitung.addActionListener((ActionEvent e) -> {
            double p = 0, l = 0, t = 0;
            boolean error = false;
            try{
                p = Double.parseDouble(tfPanjang.getText());
                l = Double.parseDouble(tfLebar.getText());
                t = Double.parseDouble(tfTinggi.getText());
            }catch(NumberFormatException err){
                JOptionPane.showMessageDialog(null, "Error!!\n" + err.getMessage());
                error = true;
            }finally{
                if(!error){
                    Balok balok = new Balok(p, l, t);
                    lLuas.setText("Luas : " + balok.cariLuas());
                    lKeliling.setText("Keliling : " + balok.cariKeliling());
                    lVolume.setText("Volume : " + balok.cariVolume());
                    lLuasPermukaan.setText("Luas Permukaan : " + balok.cariLuasPermukaan());
                }
            }
        });
        
        btnReset.addActionListener((ActionEvent e) -> {
            tfPanjang.setText("");
            tfLebar.setText("");
            tfTinggi.setText("");
            lLuas.setText("Luas :");
            lKeliling.setText("Keliling :");
            lVolume.setText("Volume :");
            lLuasPermukaan.setText("Luas Permukaan :");
        });
        
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
