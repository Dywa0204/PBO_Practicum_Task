/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.TabunganModel;
import View.FormTabunganView;
import View.PanelTabunganView;

/**
 *
 * @author Dywa Pratama
 */
public class TabunganController implements iController{
    private final PanelTabunganView view;
    private final TabunganModel model;
    private FormTabunganView form;
    
    public TabunganController(PanelTabunganView view){
        this.view = view;
        this.model = new TabunganModel(view);
    }
    
    public void setFormTabungan(FormTabunganView form){
        this.form = form;
    }
    
    public boolean processData(String username, String nama){
        boolean temp = false;
        if(nama.equals("")){
            view.setMessage("Nama Tabungan Tidak Boleh Kosong");
        }else{
            model.setNamaTabungan(nama);
            model.setUsername(username);
            if(model.insertTabungan()){
                temp = true;
                view.refreshTable();
                resetForm();
            }
        }
        return temp;
    }

    @Override
    public void resetForm() {
        form.setNamaTabungan("");
    }
}
