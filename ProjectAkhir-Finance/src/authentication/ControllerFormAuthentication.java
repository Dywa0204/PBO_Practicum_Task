/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package authentication;

import tabungan.ViewTabungan;

/**
 *
 * @author Dywa Pratama
 */
public class ControllerFormAuthentication {
    private final ViewFormAuthentication view;
    private final ModelFormAuthentication model;

    public ControllerFormAuthentication(ViewFormAuthentication view){
        this.view = view;
        this.model = new ModelFormAuthentication(view);
    }

    public void proccessAuth(boolean login, String username, String password, String fullname){
        if(login){
            if(username.equals("") || password.equals("")){
                view.setMessage("Username dan Password Tidak Boleh Kosong");
            }else{
                model.setUsername(username);
                model.setPassword(password);
                if(!model.login().isEmpty()){
                    view.setMessage("Login Berhasil!");
                    view.setVisible(false);
                    ViewTabungan tabungan = new ViewTabungan(username, model.login());
                }
            }
        }else{
            if(username.equals("") || password.equals("") || fullname.equals("")){
                view.setMessage("Nama Lengkap, Username, dan Password Tidak Boleh Kosong");
            }else{
                model.setUsername(username);
                model.setPassword(password);
                model.setFullname(fullname);
                if(model.register()){
                    view.setMessage("Register Berhasil! Silakan Login");
                }
                view.setForm();
            }
            
        }
    }
}
