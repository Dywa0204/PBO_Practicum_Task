/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catatan.formCatatan;

/**
 *
 * @author Dywa Pratama
 */
public class ControllerFormCatatan {
    private ViewFormCatatan view;
    private ModelFormCatatan model;
    
    public ControllerFormCatatan(ViewFormCatatan view){
        this.view = view;
        this.model = new ModelFormCatatan(view);
    }
    public void processData(String tanggal, String tipe, String ket, int jumlah, int idTabungan, boolean tambah, int id){
        if(tanggal.equals("") || jumlah == 0){
            view.setMessage("Tanggal dan Jumlah Tidak Boleh Kosong");
        }else{
            model.setData(tanggal, tipe, ket, jumlah, idTabungan);
            if(tambah) model.insertCatatan();
            else model.updateCatatan(id);
        }
    }
}
