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
import assets.ColorDoc;
import assets.FontDoc;

/**
 *
 * @author Dywa Pratama
 */
public class ViewFormCatatan extends JFrame{
    int idCatatan = 0;
    ColorDoc color = new ColorDoc();
    FontDoc font = new FontDoc();
    
    Header header = new Header("min");
    
    JLabel lTitle = new JLabel("TAMBAH CATATAN BARU");
    
    JLabel lTanggal = new JLabel("Tanggal");
    JLabel lSelectedTanggal = new JLabel();
    Image imageDate = new ImageIcon(this.getClass().getResource("../../assets/images/date.png")).getImage();
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
    
    public ViewFormCatatan(ViewCatatan view, boolean tambah, int idTabungan, String username, String fullname){
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
        
        header.setTitleBounds(420);
        
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
        btnSubmit.setForeground(color.textWhite);
        btnSubmit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        btnCancel.setBounds(220, 362, 170, 40);
        btnCancel.setBorder(new EmptyBorder(0, 0, 0, 0));
        btnCancel.setFont(font.inter.deriveFont(Font.BOLD, 16f));
        btnCancel.setBackground(color.btnCancel);
        btnCancel.setForeground(color.textWhite);
        btnCancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        btnTanggal.addActionListener((ActionEvent arg0) -> {
            lSelectedTanggal.setText(new DatePicker(this).setPickedDate());
        });

        btnSubmit.addActionListener((ActionEvent arg0) -> {
             ControllerFormCatatan form = new ControllerFormCatatan(this);
             try{
                String tanggal = lSelectedTanggal.getText();
                String tipeSelected = cbTipe.getItemAt(cbTipe.getSelectedIndex());
                int jumlah = Integer.parseInt(tfJumlah.getText());
                String keterangan = tfKet.getText();

                if(form.processData(tambah, idTabungan, this.idCatatan, tanggal, tipeSelected, keterangan, jumlah)){
                    view.setVisible(false);
                    ViewCatatan newView = new ViewCatatan(idTabungan, username, fullname);
                    SwingUtilities.updateComponentTreeUI(newView);
                    setVisible(false);
                }  
            }catch(NumberFormatException ex){
                setMessage("Jumlah Harus Angka!");
            }
        });
        
        btnCancel.addActionListener((ActionEvent arg0) -> {
            setVisible(false);
        });
    }
    
    void setMessage(String Message){
        JOptionPane.showMessageDialog(null, Message);
    }
    
    public void setData(int idCatatan, String tanggal, String tipe, String ket, int jumlah){
        this.idCatatan = idCatatan;
        lSelectedTanggal.setText(tanggal);
        int index = 0;
        if(tipe.equals("Pemasukan")) index = 0;
        else index = 1;
        cbTipe.setSelectedIndex(index);
        tfJumlah.setText(Integer.toString(jumlah));
        tfKet.setText(ket);
        lTitle.setText("EDIT CATATAN");
    }
}
