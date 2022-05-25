/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catatan;

import catatan.formCatatan.ViewFormCatatan;
import component.TableHeaderRenderer;
import tabungan.ViewTabungan;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import style.ColorDoc;
import style.FontDoc;

/**
 *
 * @author Dywa Pratama
 */
public final class Catatanku extends JPanel{
    ModelCatatan model;
    boolean isSelected = false;
    int id;
    int idTabung;
    
    ColorDoc color = new ColorDoc();
    FontDoc font = new FontDoc();
    
    JLabel lTitle = new JLabel("Catatan Uangku");
    
    JLabel lNamaTabungan = new JLabel();
    JTextField tfNamaTabungan = new JTextField();
    
    Image imageEdit = new ImageIcon(this.getClass().getResource("edit.png")).getImage();
    JButton btnEdit = new JButton(new ImageIcon(imageEdit));
    Image imageNike = new ImageIcon(this.getClass().getResource("nike.png")).getImage();
    JButton btnNike = new JButton(new ImageIcon(imageNike));
    
    JButton btnAddNew = new JButton();
    JLabel lAddNew = new JLabel("Tambah Catatan");
    Image imagePlus = new ImageIcon(this.getClass().getResource("plus.png")).getImage();
    JLabel lAddNewIcon = new JLabel(new ImageIcon(imagePlus));
    
    JTable tblCatatan;
    DefaultTableModel tblModel;
    String kolom[] = {"ID", "TANGGAL", "TIPE", "JUMLAH", "KETERANGAN"};
    JScrollPane scrollPane;
    
    JLabel lSaldo = new JLabel("Saldoku : ");
    
    JButton btnBack = new JButton("Kembali");
    JButton btnEditCatatan = new JButton("Edit Catatan");
    JButton btnHapusCatatan = new JButton("Hapus Catatan");
    JButton btnHapusTabungan = new JButton("Hapus Tabungan");
    
    public Catatanku(ViewCatatan view, String username, String fullname, int idTabungan){
        this.idTabung = idTabungan;
        model = new ModelCatatan(view, this);
        tblModel = new DefaultTableModel(model.getDaftarCatatan(idTabungan), kolom);
        tblCatatan = new JTable(tblModel);
        scrollPane = new JScrollPane(tblCatatan);
        
        setBounds(30, 110, 940, 450);
        setLayout(null);
        setBackground(color.panel);
        
        add(lTitle);
        add(lNamaTabungan);
        add(tfNamaTabungan);
        add(btnEdit);
        add(btnNike);
        add(btnAddNew);
        add(scrollPane);
        add(lSaldo);
        add(btnBack);
        add(btnEditCatatan);
        add(btnHapusCatatan);
        add(btnHapusTabungan);
        
        lTitle.setBounds(20, 15, 130, 22);
        lTitle.setFont(font.inter.deriveFont(Font.BOLD, 16f));
        
        lNamaTabungan.setText(model.getNamaTabungan(idTabungan));
        lNamaTabungan.setFont(font.inter.deriveFont(Font.BOLD, 24f));
        lNamaTabungan.setBounds(20, 45, getTextWidth(), 30);
        
        tfNamaTabungan.setText(model.getNamaTabungan(idTabungan));
        tfNamaTabungan.setFont(font.inter.deriveFont(Font.BOLD, 24f));
        tfNamaTabungan.setBounds(20, 45, (getTextWidth() + 20), 30);
        tfNamaTabungan.setVisible(false);
        
        btnEdit.setBounds((getTextWidth()+20), 48, 25, 25);
        btnEdit.setBackground(null);
        btnEdit.setBorder(new EmptyBorder(0, 0, 0, 0));
        btnEdit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        btnNike.setBounds((getTextWidth() + 50), 48, 25, 25);
        btnNike.setBackground(null);
        btnNike.setBorder(new EmptyBorder(0, 0, 0, 0));
        btnNike.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnNike.setVisible(false);
        
        btnAddNew.setBounds(696, 25, 225, 40);
        btnAddNew.setBackground(color.btnSubmit);
        btnAddNew.setBorder(new EmptyBorder(0, 0, 0, 0));
        btnAddNew.setCursor(new Cursor(Cursor.HAND_CURSOR));
            
        btnAddNew.setLayout(null);
        btnAddNew.add(lAddNew);
        btnAddNew.add(lAddNewIcon);
        lAddNew.setBounds(50, 0, 160, 40);
        lAddNew.setFont(font.inter.deriveFont(Font.BOLD, 16f));
        lAddNew.setForeground(color.textWhite);
        lAddNewIcon.setBounds(15, 10, 21, 21);
        
        JTableHeader header = tblCatatan.getTableHeader();
        header.setDefaultRenderer(new TableHeaderRenderer(tblCatatan));
        tblCatatan.getTableHeader().setBackground(Color.white);
        tblCatatan.setShowVerticalLines(false);
        tblCatatan.setRowHeight(57);
        tblCatatan.setGridColor(color.line);
        tblCatatan.getTableHeader().setFont(font.inter.deriveFont(Font.BOLD, 14f));
        tblCatatan.getTableHeader().setPreferredSize(new Dimension(12, 27));
        tblCatatan.setAutoCreateRowSorter(true);
        tblCatatan.setFont(font.inter.deriveFont(Font.BOLD, 14f));
        tblCatatan.removeColumn(tblCatatan.getColumnModel().getColumn(0));
        tblCatatan.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        scrollPane.setBounds(20, 95, 900, 275);
        scrollPane.getViewport().setBackground(Color.WHITE);
        scrollPane.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, color.line));
        
        lSaldo.setBounds(20, 400, 340, 24);
        lSaldo.setFont(font.inter.deriveFont(Font.BOLD, 20f));
        
        btnHapusTabungan.setBounds(400, 25, 176, 40);
        btnHapusTabungan.setBackground(color.btnCancel);
        btnHapusTabungan.setBorder(new EmptyBorder(0, 0, 0, 0));
        btnHapusTabungan.setFont(font.inter.deriveFont(Font.BOLD, 18f));
        btnHapusTabungan.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnHapusTabungan.setForeground(Color.white);
        
        btnEditCatatan.setBounds(500, 390, 142, 40);
        btnEditCatatan.setBackground(color.btnSubmit);
        btnEditCatatan.setBorder(new EmptyBorder(0, 0, 0, 0));
        btnEditCatatan.setFont(font.inter.deriveFont(Font.BOLD, 18f));
        btnEditCatatan.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnEditCatatan.setForeground(Color.white);
        
        btnHapusCatatan.setBounds(655, 390, 158, 40);
        btnHapusCatatan.setBackground(color.btnCancel);
        btnHapusCatatan.setBorder(new EmptyBorder(0, 0, 0, 0));
        btnHapusCatatan.setFont(font.inter.deriveFont(Font.BOLD, 18f));
        btnHapusCatatan.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnHapusCatatan.setForeground(Color.white);
        
        btnBack.setBounds(826, 390, 95, 40);
        btnBack.setBackground(Color.DARK_GRAY);
        btnBack.setBorder(new EmptyBorder(0, 0, 0, 0));
        btnBack.setFont(font.inter.deriveFont(Font.BOLD, 18f));
        btnBack.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnBack.setForeground(Color.white);
        
        btnHapusTabungan.addActionListener((ActionEvent arg0) -> {
            model.hapusTabungan(idTabungan);
            ViewTabungan dashboard = new ViewTabungan(username, fullname);
            view.setVisible(false);
        });
        
        btnAddNew.addActionListener((ActionEvent arg0) -> {
            ViewFormCatatan form = new ViewFormCatatan(view, username, fullname, idTabungan, true);
        });
        
        btnEdit.addActionListener((ActionEvent arg0) -> {
            lNamaTabungan.setVisible(false);
            btnEdit.setVisible(false);
            tfNamaTabungan.setVisible(true);
            btnNike.setVisible(true);
        });
        
        btnNike.addActionListener((ActionEvent arg0) -> {
            ControllerCatatan controller = new ControllerCatatan(view, this);
            if(controller.setNamaTabungan(tfNamaTabungan.getText(), idTabungan)){
                lNamaTabungan.setVisible(true);
                btnEdit.setVisible(true);
                tfNamaTabungan.setVisible(false);
                btnNike.setVisible(false);
                
                lNamaTabungan.setText(model.getNamaTabungan(idTabungan));
                lNamaTabungan.setBounds(20, 45, getTextWidth(), 30);
                tfNamaTabungan.setText(model.getNamaTabungan(idTabungan));
                tfNamaTabungan.setBounds(20, 45, (getTextWidth() + 20), 30);
                btnEdit.setBounds((getTextWidth()+20), 48, 25, 25);
                btnNike.setBounds((getTextWidth() + 50), 48, 25, 25);
            }
        });
        
        tblCatatan.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        ListSelectionModel selectionModel = tblCatatan.getSelectionModel();
        
        selectionModel.addListSelectionListener((ListSelectionEvent e) -> {
            int column = 0;
            int row = tblCatatan.getSelectedRow();
            String value = tblCatatan.getModel().getValueAt(row, column).toString();
            int idSelected = Integer.parseInt(value);
            setID(idSelected);
            this.isSelected = true;
        });
        
        btnEditCatatan.addActionListener((ActionEvent arg0) -> {
            if(isSelected){
                int row = tblCatatan.getSelectedRow();
                String idSelected = tblCatatan.getModel().getValueAt(row, 0).toString();
                int idSelec = Integer.parseInt(idSelected);
                String tanggal = tblCatatan.getModel().getValueAt(row, 1).toString();
                String tipe = tblCatatan.getModel().getValueAt(row, 2).toString();
                String keterangam = tblCatatan.getModel().getValueAt(row, 4).toString();
                String sJumlah = tblCatatan.getModel().getValueAt(row, 3).toString();
                sJumlah = sJumlah.replace("Rp ", "");
                int jumlah = Integer.parseInt(sJumlah);

                ViewFormCatatan form = new ViewFormCatatan(view, username, fullname, idTabungan, false);
                form.setData(idSelec, tanggal, tipe, keterangam, jumlah);
            }else{
                view.setMessage("Tidak Ada Catatan yang Dipilih");
            }
        });
        
        btnHapusCatatan.addActionListener((ActionEvent arg0) -> {
            if(isSelected){
                int row = tblCatatan.getSelectedRow();
                String idSelected = tblCatatan.getModel().getValueAt(row, 0).toString();
                int idSelec = Integer.parseInt(idSelected);
                ControllerCatatan controller = new ControllerCatatan(view, this);
                controller.hapusData(idSelec, username, fullname, idTabungan);
            }else{
                view.setMessage("Tidak Ada Catatan yang Dipilih");
            }
        });
        
        btnBack.addActionListener((ActionEvent arg0) -> {
            ViewTabungan dashboard = new ViewTabungan(username, fullname);
            view.setVisible(false);
        });
    }
    
    public int getTextWidth(){
        int widthNamaTabungan = (int) lNamaTabungan.getPreferredSize().getWidth();
        return widthNamaTabungan;
    }
    
    public void setSaldo(int saldo){
        lSaldo.setText("Saldoku : Rp " + saldo);
        model.setSaldoTabungan(saldo, this.idTabung);
    }
    
    public void setID(int id){
        this.id = id;
    }
}
