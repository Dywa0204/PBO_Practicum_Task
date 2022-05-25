/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabungan.formTabungan;

import java.sql.SQLException;
import jdbc.Connector;

/**
 *
 * @author Dywa Pratama
 */
public class ModelFormTabungan implements InterfaceFormTabungan{
    private String username, name;
    Connector connector = new Connector();
    private final ViewFormTabungan view;
    
    public ModelFormTabungan(ViewFormTabungan view){
        this.view = view;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public boolean insertTabungan(){
        boolean temp = false;
        try {
            String query = "INSERT INTO `tabungan` (`id`, `name`, `saldo`, `username`) VALUES "
                    + "(NULL, '" + this.name + "', " + saldoAwal + ",'" + this.username + "');";
            
            connector.statement = connector.koneksi.createStatement();
            connector.statement.executeUpdate(query);
            temp = true;
        } catch (SQLException ex) {
            if(ex.getMessage().contains("Duplicate"))
                view.setMessage("Tabungan " + this.name + " Sudah Ada");
            else
                view.setMessage("Terjadi Kesalahan Database\n" + ex.getMessage());
        }
        return temp;
    }
}
