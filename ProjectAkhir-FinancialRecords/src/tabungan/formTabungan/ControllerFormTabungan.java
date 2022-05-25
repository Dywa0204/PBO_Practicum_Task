/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabungan.formTabungan;

/**
 *
 * @author Dywa Pratama
 */
public class ControllerFormTabungan {
    private ViewFormTabungan view;
    private ModelFormTabungan model;
    
    public ControllerFormTabungan(ViewFormTabungan view){
        this.view = view;
        this.model = new ModelFormTabungan(view);
    }
    
    public boolean processData(String username, String nama){
        boolean temp = false;
        if(nama.equals("")){
            view.setMessage("Nama Tabungan Tidak Boleh Kosong");
        }else{
            model.setName(nama);
            model.setUsername(username);
            if(model.insertTabungan()) temp = true;
        }
        return temp;
    }
}
