/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Assets.ColorDoc;
import Assets.FontDoc;
import Component.TableHeaderRenderer;
import Controller.CatatanController;
import Model.CatatanModel;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author Dywa Pratama
 */
public final class PanelCatatanView extends JPanel implements ActionListener{
    CatatanModel model = new CatatanModel(this);
    CatatanController controller = new CatatanController(this);
    
    CatatanView view;
    int idTabungan;
    String username, fullname;
    
    ColorDoc color = new ColorDoc();
    FontDoc font = new FontDoc();
    
    JLabel lTitle = new JLabel("Catatan Uangku");
    
    JLabel lNamaTabungan = new JLabel();
    JTextField tfNamaTabungan = new JTextField();
    
    Image imageEdit = new ImageIcon(this.getClass().getResource("../assets/images/edit.png")).getImage();
    JButton btnEdit = new JButton(new ImageIcon(imageEdit));
    Image imageCheckList = new ImageIcon(this.getClass().getResource("../assets/images/nike.png")).getImage();
    JButton btnChecklist = new JButton(new ImageIcon(imageCheckList));
    
    JButton btnAddNew = new JButton();
    JLabel lAddNew = new JLabel("Tambah Catatan");
    Image imagePlus = new ImageIcon(this.getClass().getResource("../assets/images/plus.png")).getImage();
    JLabel lAddNewIcon = new JLabel(new ImageIcon(imagePlus));
    
    String column[] = {"ID", "TANGGAL", "TIPE", "JUMLAH", "KETERANGAN"};
    JTableHeader tblHeader;
    DefaultTableModel tblModel = new DefaultTableModel();
    JTable tblCatatan = new JTable(tblModel);
    ListSelectionModel selectionModel;
    JScrollPane scrollPane = new JScrollPane(tblCatatan);
    
    JLabel lSaldo = new JLabel("Saldoku : ");
    
    JButton btnBack = new JButton("Kembali");
    JButton btnEditCatatan = new JButton("Edit Catatan");
    JButton btnHapusCatatan = new JButton("Hapus Catatan");
    JButton btnHapusTabungan = new JButton("Hapus Tabungan");
    
    public PanelCatatanView(CatatanView view, int idTabungan, String username, String fullname){
        this.view = view;
        this.idTabungan = idTabungan;
        this.username = username;
        this.fullname = fullname;
        
        setBounds(30, 110, 940, 450);
        setLayout(null);
        setBackground(Color.white);
        
        add(lTitle);
        add(lNamaTabungan);
        add(tfNamaTabungan);
        add(btnEdit);
        add(btnChecklist);
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
        
        btnChecklist.setBounds((getTextWidth() + 50), 48, 25, 25);
        btnChecklist.setBackground(null);
        btnChecklist.setBorder(new EmptyBorder(0, 0, 0, 0));
        btnChecklist.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnChecklist.setVisible(false);
        
        btnAddNew.setBounds(696, 25, 225, 40);
        btnAddNew.setBackground(color.btnSubmit);
        btnAddNew.setBorder(new EmptyBorder(0, 0, 0, 0));
        btnAddNew.setCursor(new Cursor(Cursor.HAND_CURSOR));
            
        btnAddNew.setLayout(null);
        btnAddNew.add(lAddNew);
        btnAddNew.add(lAddNewIcon);
        lAddNew.setBounds(50, 0, 160, 40);
        lAddNew.setFont(font.inter.deriveFont(Font.BOLD, 16f));
        lAddNew.setForeground(Color.white);
        lAddNewIcon.setBounds(15, 10, 21, 21);
        
        tblModel.setDataVector(model.getDaftarCatatan(idTabungan), column);
        tblHeader = tblCatatan.getTableHeader();
        tblHeader.setDefaultRenderer(new TableHeaderRenderer(tblCatatan));
        tblCatatan.getTableHeader().setBackground(Color.white);
        tblCatatan.setShowVerticalLines(false);
        tblCatatan.setRowHeight(57);
        tblCatatan.setGridColor(Color.lightGray);
        tblCatatan.getTableHeader().setFont(font.inter.deriveFont(Font.BOLD, 14f));
        tblCatatan.getTableHeader().setPreferredSize(new Dimension(12, 27));
        tblCatatan.setAutoCreateRowSorter(true);
        tblCatatan.setFont(font.inter.deriveFont(Font.BOLD, 14f));
        tblCatatan.removeColumn(tblCatatan.getColumnModel().getColumn(0));
        tblCatatan.setCursor(new Cursor(Cursor.HAND_CURSOR));
        tblCatatan.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        selectionModel = tblCatatan.getSelectionModel();
        
        scrollPane.setBounds(20, 95, 900, 275);
        scrollPane.getViewport().setBackground(Color.WHITE);
        scrollPane.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.lightGray));
        
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
        
        btnHapusTabungan.addActionListener(this);
        btnEdit.addActionListener(this);
        btnChecklist.addActionListener(this);
        btnAddNew.addActionListener(this);
        btnEditCatatan.addActionListener(this);
        btnHapusCatatan.addActionListener(this);
        btnBack.addActionListener(this);
        
        selectionModel.addListSelectionListener((ListSelectionEvent e) -> {
            if(!e.getValueIsAdjusting()){
                int row = tblCatatan.getSelectedRow();

                if(row == -1){
                    controller.setSelected(false);
                }else{
                    String value = tblCatatan.getModel().getValueAt(row, 0).toString();
                    int idCatatanSelected = Integer.parseInt(value);

                    String tanggal = tblCatatan.getModel().getValueAt(row, 1).toString();
                    String tipe = tblCatatan.getModel().getValueAt(row, 2).toString();
                    String keterangam = tblCatatan.getModel().getValueAt(row, 4).toString();
                    String sJumlah = tblCatatan.getModel().getValueAt(row, 3).toString();
                    sJumlah = sJumlah.replace("Rp ", "");
                    int jumlah = Integer.parseInt(sJumlah);

                    controller.setData(idCatatanSelected, tanggal, tipe, keterangam, jumlah);
                    controller.setSelected(true);
                }
            }
            
        });
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnHapusTabungan){
            int confirm = JOptionPane.showConfirmDialog(null, "Yakin ingin menghapus tabungan ini?");
            if(confirm == 0){
                model.hapusTabungan(idTabungan);
                TabunganView tabungan = new TabunganView(username, fullname);
                view.setVisible(false);
            }
        }
        else if(e.getSource() == btnEdit){
            lNamaTabungan.setVisible(false);
            btnEdit.setVisible(false);
            tfNamaTabungan.setVisible(true);
            btnChecklist.setVisible(true);
        }
        else if(e.getSource() == btnChecklist){
            if(controller.setNamaTabungan(tfNamaTabungan.getText(), idTabungan)){
                lNamaTabungan.setVisible(true);
                btnEdit.setVisible(true);
                tfNamaTabungan.setVisible(false);
                btnChecklist.setVisible(false);
                
                lNamaTabungan.setText(model.getNamaTabungan(idTabungan));
                lNamaTabungan.setBounds(20, 45, getTextWidth(), 30);
                tfNamaTabungan.setText(model.getNamaTabungan(idTabungan));
                tfNamaTabungan.setBounds(20, 45, (getTextWidth() + 20), 30);
                btnEdit.setBounds((getTextWidth()+20), 48, 25, 25);
                btnChecklist.setBounds((getTextWidth() + 50), 48, 25, 25);
            }
        }
        
        else if(e.getSource() == btnAddNew){
            FormCatatanView form = new FormCatatanView(true, this, idTabungan);
        }
        else if(e.getSource() == btnEditCatatan){
            if(controller.isSelected()){
                FormCatatanView form = new FormCatatanView(false, this, idTabungan);
                controller.setFormCatatan(form);
                controller.setDataForm();
            }else{
                setMessage("Tidak Ada Data Yang Dipilih");
            }
        }
        else if(e.getSource() == btnHapusCatatan){
            if(controller.isSelected()){
                int confirm = JOptionPane.showConfirmDialog(null, "Yakin ingin menghapus tabungan ini?");
                if(confirm == 0){
                    controller.hapusData();
                }
            }else{
                setMessage("Tidak Ada Data Yang Dipilih");
            }
        }
        else if(e.getSource() == btnBack){
            TabunganView tabungan = new TabunganView(username, fullname);
            view.setVisible(false);
        }
    }
    
    public void refreshTable(){
        tblModel.setDataVector(model.getDaftarCatatan(idTabungan), column);
        tblCatatan.removeColumn(tblCatatan.getColumnModel().getColumn(0));
    }
    
    public int getTextWidth(){
        int widthNamaTabungan = (int) lNamaTabungan.getPreferredSize().getWidth();
        if(widthNamaTabungan > 300) widthNamaTabungan = 300;
        return widthNamaTabungan;
    }
    
    public void setSaldo(int saldo){
        lSaldo.setText("Saldoku : Rp " + saldo);
        model.setSaldoTabungan(this.idTabungan, saldo);
    }
    
    public void setMessage(String Message){
        JOptionPane.showMessageDialog(null, Message);
    }
}
