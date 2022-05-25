/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catatan;

/**
 *
 * @author Dywa Pratama
 */
public class ControllerCatatan {
    private final ViewCatatan view;
    private final ModelCatatan model;

    public ControllerCatatan(ViewCatatan view, Catatanku viewPanel){
        this.view = view;
        this.model = new ModelCatatan(view, viewPanel);
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
    
    public void hapusData(int idTabungan, int idCatatan, String username, String fullname){
        model.hapusCatatan(idCatatan);
        view.setVisible(false);
        ViewCatatan viewBaru = new ViewCatatan(idTabungan, username, fullname);
    }
}
