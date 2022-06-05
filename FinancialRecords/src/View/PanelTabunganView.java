/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Assets.ColorDoc;
import Assets.FontDoc;
import Component.Placeholder;
import Component.TableHeaderRenderer;
import Model.TabunganModel;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Dywa Pratama
 */
public class PanelTabunganView extends JPanel implements ActionListener{
    TabunganModel model = new TabunganModel(this);
    String username, fullname;
    
    ColorDoc color = new ColorDoc();
    FontDoc font = new FontDoc();
    
    JLabel lTitle = new JLabel("Tabunganku");
    JButton btnAddNew = new JButton();
    JLabel lAddNew = new JLabel("Tambah Tabungan");
    Image imagePlus = new ImageIcon(this.getClass().getResource("../assets/images/plus.png")).getImage();
    JLabel lAddNewIcon = new JLabel(new ImageIcon(imagePlus));
    
    String[] column = {"ID", "NAMA", "SALDO"};
    JTableHeader tblHeader;
    DefaultTableModel tblModel = new DefaultTableModel();
    JTable tblDaftarTabungan = new JTable(tblModel);
    ListSelectionModel selectionModel;
    JScrollPane scrollPane = new JScrollPane(tblDaftarTabungan);
    
    JPanel pSearch = new JPanel();
    JTextField tfSearch = new JTextField();
    Placeholder placeholder = new Placeholder("Search", tfSearch);
    Image imageSearch = new ImageIcon(this.getClass().getResource("../assets/images/search.png")).getImage();
    JLabel lSearch = new JLabel(new ImageIcon(imageSearch));
    
    public PanelTabunganView(TabunganView view, String username, String fullname){
        this.username = username;
        this.fullname = fullname;
        
        setBounds(30, 110, 640, 460);
        setLayout(null);
        setBackground(Color.white);
        
        add(lTitle);
        add(btnAddNew);
        add(scrollPane);
        add(pSearch);
        
        lTitle.setBounds(20, 15, 110, 22);
        lTitle.setFont(font.inter.deriveFont(Font.BOLD, 18f));
        
        btnAddNew.setBounds(20, 52, 210, 40);
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
        
        pSearch.setBounds(396, 50, 220, 40);
        pSearch.setBackground(Color.white);
        pSearch.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.lightGray));
        pSearch.setLayout(null);
        pSearch.add(tfSearch);
        pSearch.add(lSearch);
        lSearch.setBounds(179, 1, 39, 38);
        lSearch.setBorder(new EmptyBorder(0, 0, 0, 0));
        tfSearch.setBounds(1, 1, 179, 38);
        tfSearch.setBorder(new EmptyBorder(0, 10, 0, 10));
        
        tblModel.setDataVector(model.getDaftarTabungan(username), column);
        tblHeader = tblDaftarTabungan.getTableHeader();
        tblHeader.setDefaultRenderer(new TableHeaderRenderer(tblDaftarTabungan));
        tblDaftarTabungan.getTableHeader().setBackground(Color.white);
        tblDaftarTabungan.setShowVerticalLines(false);
        tblDaftarTabungan.setRowHeight(57);
        tblDaftarTabungan.setGridColor(Color.lightGray);
        tblDaftarTabungan.getTableHeader().setFont(font.inter.deriveFont(Font.BOLD, 14f));
        tblDaftarTabungan.getColumnModel().getColumn(0).setMinWidth(200);
        tblDaftarTabungan.getTableHeader().setPreferredSize(new Dimension(12, 27));
        tblDaftarTabungan.setAutoCreateRowSorter(true);
        tblDaftarTabungan.setFont(font.inter.deriveFont(Font.BOLD, 14f));
        tblDaftarTabungan.removeColumn(tblDaftarTabungan.getColumnModel().getColumn(0));
        tblDaftarTabungan.setCursor(new Cursor(Cursor.HAND_CURSOR));
        tblDaftarTabungan.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        selectionModel = tblDaftarTabungan.getSelectionModel();
        
        scrollPane.setBounds(20, 136, 600, 285);
        scrollPane.getViewport().setBackground(Color.WHITE);
        scrollPane.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.lightGray));

        btnAddNew.addActionListener(this);
        
        tfSearch.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                search();
            }
            public void removeUpdate(DocumentEvent e) {
                search();
            }
            public void insertUpdate(DocumentEvent e) {
                search();
            }

            public void search() {
                TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(tblModel);
                tblDaftarTabungan.setRowSorter(sorter); 
                sorter.setRowFilter(RowFilter.regexFilter(tfSearch.getText()));
            }
        });
        
        selectionModel.addListSelectionListener((ListSelectionEvent e) -> {
            if(!e.getValueIsAdjusting()){
                int row = tblDaftarTabungan.getSelectedRow();
                String value = tblDaftarTabungan.getModel().getValueAt(row, 0).toString();
                int idTabunganSelected = Integer.parseInt(value);
                CatatanView catatan = new CatatanView(idTabunganSelected, username, fullname);
                view.setVisible(false);
            }
            
        });
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnAddNew){
            FormTabunganView form = new FormTabunganView(this, username, fullname);
        }
    }
    
    public void refreshTable(){
        tblModel.setDataVector(model.getDaftarTabungan(username), column);
        tblDaftarTabungan.removeColumn(tblDaftarTabungan.getColumnModel().getColumn(0));
    }
    
    public void setMessage(String Message){
        JOptionPane.showMessageDialog(null, Message);
    }
}
