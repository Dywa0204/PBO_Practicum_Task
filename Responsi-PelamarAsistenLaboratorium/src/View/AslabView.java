/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.AslabController;
import Model.AslabModel;
import java.awt.GridLayout;
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
public class AslabView extends JFrame implements ActionListener{
    AslabController controller = new AslabController();
    AslabModel model = new AslabModel();
    
    String nama;
    
    String[] column = {"Nama", "Protofolio", "Microteaching", "Wawancara", "Nilai Akhir"};
    JTableHeader tblHeader;
    JTable tblPelamar;
    DefaultTableModel tblModel;
    JScrollPane scrollPane;
    ListSelectionModel selection;
    
    JPanel pForm = new JPanel();
    
    JPanel pInput = new JPanel();
    JLabel lNama = new JLabel("Nama");
    JLabel lNilai1 = new JLabel("Nilai Protofolio");
    JLabel lNilai2 = new JLabel("Nilai Microteaching");
    JLabel lNilai3 = new JLabel("Nilai Wawancara");
    
    JTextField tfNama = new JTextField();
    JTextField tfNilai1 = new JTextField();
    JTextField tfNilai2 = new JTextField();
    JTextField tfNilai3 = new JTextField();
    
    JPanel pActions = new JPanel();
    JButton btnTambah = new JButton("Tambah");
    JButton btnUpdate = new JButton("Update");
    JButton btnDelete = new JButton("Delete");
    JButton btnClear = new JButton("Clear");
    
    public AslabView(){
        setTitle("EDIT KARYAWAN");
        setSize(700, 500);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
        getRootPane().setBorder(new EmptyBorder(15, 15, 15, 15));
        
        tblModel = new DefaultTableModel();
        tblModel.setDataVector(model.getDataKaryawan(), column);
        tblPelamar = new JTable(tblModel);
        scrollPane = new JScrollPane(tblPelamar);
        
        add(scrollPane);
        add(pForm);
        
        pForm.setLayout(new GridLayout(2, 1, 0, 20));
        pForm.add(pInput);
        pForm.add(pActions);
        pForm.setBorder(new EmptyBorder(15, 15, 15, 15));
        
        pInput.setLayout(new GridLayout(8, 1, 0, 6));
        pInput.add(lNama);
        pInput.add(tfNama);
        pInput.add(lNilai1);
        pInput.add(tfNilai1);
        pInput.add(lNilai2);
        pInput.add(tfNilai2);
        pInput.add(lNilai3);
        pInput.add(tfNilai3);
        
        pActions.setLayout(new GridLayout(4, 1, 0, 8));
        pActions.add(btnTambah);
        pActions.add(btnUpdate);
        pActions.add(btnDelete);
        pActions.add(btnClear);
        
        tblPelamar.setAutoCreateRowSorter(true);
        tblPelamar.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        selection = tblPelamar.getSelectionModel();
        
        selection.addListSelectionListener((ListSelectionEvent e) -> {
            try{
                if(!e.getValueIsAdjusting()){
                    int baris = tblPelamar.getSelectedRow();
                    nama = tblPelamar.getModel().getValueAt(baris, 0).toString();
                    String nilai1 = tblPelamar.getModel().getValueAt(baris, 1).toString();
                    String nilai2 = tblPelamar.getModel().getValueAt(baris, 2).toString();
                    String nilai3 = tblPelamar.getModel().getValueAt(baris, 3).toString();

                    controller.setInput(this, this.nama, nilai1, nilai2, nilai3);
                }
            }catch(Exception ex){
                
            }
        });
        
        btnTambah.addActionListener(this);
        btnUpdate.addActionListener(this);
        btnDelete.addActionListener(this);
        btnClear.addActionListener(this);
        
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnTambah){
            controller.tambah(this);
        }
        else if(e.getSource() == btnUpdate){
            controller.update(this);
        }
        else if(e.getSource() == btnDelete){
            controller.hapus(this);
        }
        else if(e.getSource() == btnClear){
            controller.clear(this);
        }
    }
    
    public String getNama(){
        return tfNama.getText();
    }
    
    public String getNilai1(){
        return tfNilai1.getText();
    }
    
    public String getNilai2(){
        return tfNilai2.getText();
    }
    public String getNilai3(){
        return tfNilai3.getText();
    }
    
    public void setNama(String nama){
        tfNama.setText(nama);
    }
    
    public void setNilai1(String nilai){
        tfNilai1.setText(nilai);
    }
    
    public void setNilai2(String nilai){
        tfNilai2.setText(nilai);
    }
    
    public void setNilai3(String nilai){
        tfNilai3.setText(nilai);
    }
    
    public void refreshTable(String[][] object){
        tblModel.setDataVector(object, column);
    }
}
