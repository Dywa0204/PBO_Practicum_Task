/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catatan.formCatatan;


import catatan.ViewCatatan;
import component.DatePicker;
import component.Header;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import style.ColorDoc;
import style.FontDoc;

/**
 *
 * @author Dywa Pratama
 */
public class ViewFormCatatan extends JFrame{
    int id = 0;
    ColorDoc color = new ColorDoc();
    FontDoc font = new FontDoc();
    
    Header header = new Header("min");
    
    JLabel lTitle = new JLabel("TAMBAH CATATAN BARU");
    
    JLabel lTanggal = new JLabel("Tanggal");
    JLabel tfTanggal = new JLabel();
    Image imageDate = new ImageIcon(this.getClass().getResource("date.png")).getImage();
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
    
    public ViewFormCatatan(ViewCatatan view, String username, String fullname, int idTabungan, boolean tambah){
        setTitle("Financial Records");
        setSize(435, 480);
        setLayout(null);
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(null);
        getContentPane().setBackground(color.background);
        
        add(header);
        header.setTitleBounds(420);
        
        add(lTitle);
        add(lTanggal);
        add(tfTanggal);
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
        lTipe.setBounds(220, 150, 200, 15);
        lTipe.setFont(font.inter.deriveFont(Font.BOLD, 12f));
        
        tfTanggal.setBounds(30, 170, 140, 30);
        tfTanggal.setBorder(new EmptyBorder(0, 10, 0, 10));
        tfTanggal.setBackground(Color.white);
        tfTanggal.setOpaque(true);
        btnTanggal.setBounds(170, 170, 30, 30);
        btnTanggal.setBorder(new EmptyBorder(0, 0, 0, 0));
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
        
        btnTanggal.addActionListener((ActionEvent arg0) -> {
            tfTanggal.setText(new DatePicker(this).setPickedDate());
        });
        
        btnSubmit.setBounds(30, 362, 170, 40);
        btnSubmit.setBorder(new EmptyBorder(0, 0, 0, 0));
        btnSubmit.setFont(font.inter.deriveFont(Font.BOLD, 16f));
        btnSubmit.setBackground(color.btnSubmit);
        btnSubmit.setForeground(color.textWhite);
        btnSubmit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        btnCancel.setBounds(220, 362, 170, 40);
        btnCancel.setBorder(new EmptyBorder(0, 0, 0, 0));
        btnCancel.setFont(font.inter.deriveFont(Font.BOLD, 16f));
        btnCancel.setBackground(color.btnCancel);
        btnCancel.setForeground(color.textWhite);
        btnCancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        ControllerFormCatatan form = new ControllerFormCatatan(this);
        btnSubmit.addActionListener((ActionEvent arg0) -> {
            try{
                String selected = cbTipe.getItemAt(cbTipe.getSelectedIndex());
                int jumlah = Integer.parseInt(tfJumlah.getText());
                
                form.processData(tfTanggal.getText(), selected, tfKet.getText(), jumlah, idTabungan, tambah, this.id);
                
                view.setVisible(false);
                ViewCatatan newView = new ViewCatatan(username, fullname, idTabungan);
                SwingUtilities.updateComponentTreeUI(newView);
                setVisible(false);
            }catch(NumberFormatException ex){
                setMessage("Input Nomor salah");
            }
        });
        
        btnCancel.addActionListener((ActionEvent arg0) -> {
            setVisible(false);
        });
    }
    
    void setMessage(String Message){
        JOptionPane.showMessageDialog(null, Message);
    }
    
    public void setData(int id, String tanggal, String tipe, String ket, int jumlah){
        this.id = id;
        tfTanggal.setText(tanggal);
        int index = 0;
        if(tipe.equals("Pemasukan")) index = 0;
        else index = 1;
        cbTipe.setSelectedIndex(index);
        tfJumlah.setText(Integer.toString(jumlah));
        tfKet.setText(ket);
        lTitle.setText("EDIT CATATAN");
    }
}
