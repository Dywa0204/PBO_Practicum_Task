/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.UserModel;
import View.AuthView;
import View.TabunganView;

/**
 *
 * @author Dywa Pratama
 */
public class AuthController implements iController{
    boolean login = true;
    String username, password, fullname;
    
    private final AuthView view;
    private final UserModel model;
    
    public AuthController(AuthView view){
        this.view = view;
        this.model = new UserModel(view);
    }
    
    public void setForm(){
        login = !login;
        if(login) view.setForm("login");
        else view.setForm("register");
        resetForm();
    }
    
    public void setData(){
        this.username = view.getUsername();
        this.password = view.getPassword();
        this.fullname = view.getFullname();
    }
    
    public void proccessAuth(){
        if(login){
            if(username.equals("") || password.equals("")){
                view.setMessage("Username dan Password Tidak Boleh Kosong");
            }else{
                model.setUsername(username);
                model.setPassword(password);
                if(!model.login().isEmpty()){
                    view.setMessage("Login Berhasil!");
                    view.setVisible(false);
                    TabunganView tabungan = new TabunganView(username, fullname);
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
                    resetForm();
                    setForm();
                }
            }
            
        }
    }

    @Override
    public void resetForm() {
        view.setUsername("");
        view.setPassword("");
        view.setFullname("");
    }
}
