/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.AslabModel;
import View.AslabView;
import javax.swing.JOptionPane;

/**
 *
 * @author Dywa Pratama
 */
public class AslabController implements IController{
    AslabModel model = new AslabModel();
    
    public void setInput(AslabView view, String nama, String nilai1, String nilai2, String nilai3){
        view.setNama(nama);
        view.setNilai1(nilai1);
        view.setNilai2(nilai2);
        view.setNilai3(nilai3);
    }
    
    public void tambah(AslabView view){
        if(isInputEmpty(view)){
            JOptionPane.showMessageDialog(null, "Data Tidak Boleh Kosong");
        }else{
            try{
                String judul = view.getNama();
                double nilai1 = Double.parseDouble(view.getNilai1());
                double nilai2 = Double.parseDouble(view.getNilai2());
                double nilai3 = Double.parseDouble(view.getNilai3());
                
                if(isLowwer(nilai1, nilai2, nilai3)){
                    JOptionPane.showMessageDialog(null, "Nilai Tidak Boleh Kurang dari 0");
                }else if(isHigher(nilai1, nilai2, nilai3)){
                    JOptionPane.showMessageDialog(null, "Nilai Tidak Boleh Lebih dari 100");
                }else{
                    model.setData(judul, nilai1, nilai2, nilai3);
                    if(model.insertData()){
                        JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
                        view.refreshTable(model.getDataKaryawan());
                        clear(view);
                    }
                }
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Input angka tidak boleh huruf\n" + e.getMessage());
            }
        }
    }
    
    public void update(AslabView view){
        if(isInputEmpty(view)){
            JOptionPane.showMessageDialog(null, "Data Tidak Boleh Kosong");
        }else{
            try{
                String judul = view.getNama();
                double nilai1 = Double.parseDouble(view.getNilai1());
                double nilai2 = Double.parseDouble(view.getNilai2());
                double nilai3 = Double.parseDouble(view.getNilai3());

                if(isLowwer(nilai1, nilai2, nilai3)){
                    JOptionPane.showMessageDialog(null, "Nilai Tidak Boleh Kurang dari 0");
                }else if(isHigher(nilai1, nilai2, nilai3)){
                    JOptionPane.showMessageDialog(null, "Nilai Tidak Boleh Lebih dari 100");
                }else{
                    model.setData(judul, nilai1, nilai2, nilai3);
                    if(model.updateData()){
                        JOptionPane.showMessageDialog(null, "Data Berhasil Diupdate");
                        view.refreshTable(model.getDataKaryawan());
                        clear(view);
                    }
                }
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Input Angka Tidak Boleh huruf\n" + e.getMessage());
            }
        }
    }
    
    public void hapus(AslabView view){
        if(view.getNama().isEmpty()){
            JOptionPane.showMessageDialog(null, "Nama Tidak Boleh Kosong");
        }else{
            int confirm = JOptionPane.showConfirmDialog(null, "Yakin ingin menghapus data ini?");
            if(confirm == 0){
                String judul = view.getNama();
                model.setData(judul);
                if(model.hapusData()){
                    JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
                    view.refreshTable(model.getDataKaryawan());
                    clear(view);
                }
            }
            
        }
    }

    @Override
    public boolean isInputEmpty(AslabView view){
        return view.getNama().isEmpty() || view.getNilai1().isEmpty() || view.getNilai2().isEmpty() || view.getNilai3().isEmpty();
    }

    @Override
    public boolean isLowwer(double nilai1, double nilai2, double nilai3) {
        return nilai1 < 0 || nilai2 < 0 || nilai3 < 0;
    }

    @Override
    public boolean isHigher(double nilai1, double nilai2, double nilai3) {
        return nilai1 > 100 || nilai2 > 100 || nilai3 > 100;
    }

    @Override
    public void clear(AslabView view) {
        view.setNama("");
        view.setNilai1("");
        view.setNilai2("");
        view.setNilai3("");
    }
}
