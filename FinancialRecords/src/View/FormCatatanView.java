/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Assets.ColorDoc;
import Assets.FontDoc;
import Component.DatePicker;
import Component.Header;
import Controller.CatatanController;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Dywa Pratama
 */
public final class FormCatatanView extends JFrame implements ActionListener{
    PanelCatatanView view;
    CatatanController controller;
    int idTabungan, idCatatan;
    boolean tambah;
    
    ColorDoc color = new ColorDoc();
    FontDoc font = new FontDoc();
    
    Header header = new Header();
    
    JLabel lTitle = new JLabel("TAMBAH CATATAN BARU");
    
    JLabel lTanggal = new JLabel("Tanggal");
    JLabel lSelectedTanggal = new JLabel();
    Image imageDate = new ImageIcon(this.getClass().getResource("../Assets/Images/date.png")).getImage();
    JButton btnTanggal = new JButton(new ImageIcon(imageDate));
    
    JLabel lTipe = new JLabel("Tipe");
    String[] tipe = {"Pemasukan", "Pengeluaran"};
    JComboBox<String> cbTipe = new JComboBox<>(tipe);
    
    JLabel lJumlah = new JLabel("Jumlah");
    JLabel lKet = new JLabel("Keterangan");
    JTextField tfJumlah = new JTextField();
    JTextField tfKet = new JTextField();
    
    JButton btnSubmit = new JButton("SUBMIT");
    JButton btnCancel = new JButton("BATAL");
    
    public FormCatatanView(boolean tambah, PanelCatatanView view, int idTabungan){
        this.view = view;
        this.idTabungan = idTabungan;
        this.controller = new CatatanController(view);
        this.tambah = tambah;
        
        setTitle("Financial Records");
        setSize(435, 480);
        setLayout(null);
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(null);
        getContentPane().setBackground(color.background);
        
        add(header);
        add(lTitle);
        add(lTanggal);
        add(lSelectedTanggal);
        add(btnTanggal);
        add(lTipe);
        add(cbTipe);
        add(lJumlah);
        add(lKet);
        add(tfJumlah);
        add(tfKet);
        add(btnSubmit);
        add(btnCancel);
        
        lTitle.setBounds(0, 110, 420, 24);
        lTitle.setFont(font.inter.deriveFont(Font.BOLD, 20f));
        lTitle.setHorizontalAlignment(SwingConstants.CENTER);
        
        lTanggal.setBounds(30, 150, 200, 15);
        lTanggal.setFont(font.inter.deriveFont(Font.BOLD, 12f));
        lSelectedTanggal.setBounds(30, 170, 140, 30);
        lSelectedTanggal.setBorder(new EmptyBorder(0, 10, 0, 10));
        lSelectedTanggal.setBackground(Color.white);
        lSelectedTanggal.setOpaque(true);
        btnTanggal.setBounds(170, 170, 30, 30);
        btnTanggal.setBorder(new EmptyBorder(0, 0, 0, 0));
        
        lTipe.setBounds(220, 150, 200, 15);
        lTipe.setFont(font.inter.deriveFont(Font.BOLD, 12f));
        cbTipe.setBounds(220, 170, 170, 30);
        cbTipe.setBorder(new EmptyBorder(0, 0, 0, 0));
        cbTipe.setBackground(Color.white);
        
        lJumlah.setBounds(30, 217, 200, 15);
        lJumlah.setFont(font.inter.deriveFont(Font.BOLD, 12f));
        tfJumlah.setBounds(30, 236, 360, 30);
        tfJumlah.setBorder(new EmptyBorder(0, 10, 0, 10));
        
        lKet.setBounds(30, 283, 200, 15);
        lKet.setFont(font.inter.deriveFont(Font.BOLD, 12f));
        tfKet.setBounds(30, 302, 360, 30);
        tfKet.setBorder(new EmptyBorder(0, 10, 0, 10));
        
        btnSubmit.setBounds(30, 362, 170, 40);
        btnSubmit.setBorder(new EmptyBorder(0, 0, 0, 0));
        btnSubmit.setFont(font.inter.deriveFont(Font.BOLD, 16f));
        btnSubmit.setBackground(color.btnSubmit);
        btnSubmit.setForeground(Color.white);
        btnSubmit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        btnCancel.setBounds(220, 362, 170, 40);
        btnCancel.setBorder(new EmptyBorder(0, 0, 0, 0));
        btnCancel.setFont(font.inter.deriveFont(Font.BOLD, 16f));
        btnCancel.setBackground(color.btnCancel);
        btnCancel.setForeground(Color.white);
        btnCancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        btnTanggal.addActionListener(this);
        btnSubmit.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnTanggal){
            lSelectedTanggal.setText(new DatePicker(this).setPickedDate());
        }
        else if(e.getSource() == btnSubmit){
            controller.setFormCatatan(this);
            controller.setData();
            if(controller.processData(tambah)){
                setVisible(false);
            }
        }
    }
    
    public void setIdCatatan(int id){
        this.idCatatan = id;
    }
    
    public int getIdCatatan(){
        return idCatatan;
    }
    
    public int getIdTabungan(){
        return idTabungan;
    }
    
    public String getTanggal(){
        return lSelectedTanggal.getText();
    }
    
    public String getTipe(){
        return cbTipe.getItemAt(cbTipe.getSelectedIndex());
    }
    
    public String getKeterangan(){
        return tfKet.getText();
    }
    
    public int getJumlah(){
        int jumlah = 0;
        try{
            jumlah = Integer.parseInt(tfJumlah.getText());
        }catch(NumberFormatException ex){
            view.setMessage("Jumlah Harus Angka");
        }
        return jumlah;
    }
    
    public void setTitle(String text){
        lTitle.setText(text);
    }
    
    public void setTanggal(String text){
        lSelectedTanggal.setText(text);
    }
    
    public void setTipe(int index){
        cbTipe.setSelectedIndex(index);
    }
    
    public void setKeterangan(String text){
        tfKet.setText(text);
    }
    
    public void setJumlah(String text){
        tfJumlah.setText(text);
    }
    
    public void setFormData(String tanggal, String tipe, String ket, int jumlah){
        lSelectedTanggal.setText(tanggal);
        
        int index;
        if(tipe.equals("Pemasukan")) index = 0;
        else index = 1;
        cbTipe.setSelectedIndex(index);
        
        tfJumlah.setText(Integer.toString(jumlah));
        tfKet.setText(ket);
        lTitle.setText("EDIT CATATAN");
    }
}
