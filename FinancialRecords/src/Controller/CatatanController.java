/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.CatatanModel;
import View.FormCatatanView;
import View.PanelCatatanView;

/**
 *
 * @author Dywa Pratama
 */
public class CatatanController implements iController{
    private final PanelCatatanView view;
    private final CatatanModel model;
    FormCatatanView form;
    
    String tanggal, tipe, keterangan;
    int idTabungan, idCatatan, jumlah;
    boolean isSeledcted = false;

    public CatatanController(PanelCatatanView view){
        this.view = view;
        this.model = new CatatanModel(view);
    }
    
    public void setData(){
        this.tanggal = form.getTanggal();
        this.tipe = form.getTipe();
        this.keterangan = form.getKeterangan();
        this.jumlah = form.getJumlah();
        this.idTabungan = form.getIdTabungan();
        this.idCatatan = form.getIdCatatan();
    }
    
    public void setData(int idCatatan, String tanggal, String tipe, String keterangan, int jumlah){
        this.idCatatan = idCatatan;
        this.tanggal = tanggal;
        this.tipe = tipe;
        this.keterangan = keterangan;
        this.jumlah = jumlah;
    }
    
    public void setDataForm(){
        form.setTanggal(tanggal);
        switch(tipe){
            case "pemasukan" :
                form.setTipe(0);
                break;
            case "pengeluaran" :
                form.setTipe(1);
                break;
        }
        form.setKeterangan(keterangan);
        form.setJumlah(Integer.toString(jumlah));
        form.setTitle("EDIT CATATAN");
        form.setIdCatatan(idCatatan);
    }
    
    public void setSelected(boolean isSeledcted){
        this.isSeledcted = isSeledcted;
    }
    
    public boolean isSelected(){
        return isSeledcted;
    }
    
    public boolean setNamaTabungan(String nama, int idTabungan){
        boolean temp = false;
        if(nama.equals("")){
            view.setMessage("Nama Tabungan Tidak Boleh Kosong");
        }else{
            model.setNamaTabungan(nama);
            model.setIdTabungan(idTabungan);
            if(model.updateNamaTabungan()) temp = true;
        }
        return temp;
    }
    
    public void setFormCatatan(FormCatatanView form){
        this.form = form;
        
    }
    
    public boolean processData(boolean tambah){
        boolean temp = false;
        if(tanggal.equals("") || jumlah == 0){
            view.setMessage("Tanggal dan Jumlah Tidak Boleh Kosong");
        }else{
            model.setData(tanggal, tipe, keterangan, jumlah, idTabungan);
            if(tambah) temp = model.insertCatatan();
            else temp = model.updateCatatan(idCatatan);
            
            view.refreshTable();
            resetForm();
        }
        return temp;
    }
    
    public void hapusData(){
        model.hapusCatatan(idCatatan);
        view.refreshTable();
    }

    @Override
    public void resetForm() {
        form.setTanggal("");
        form.setTipe(0);
        form.setKeterangan("");
        form.setJumlah("");
    }
}
