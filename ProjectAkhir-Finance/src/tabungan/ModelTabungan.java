/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabungan;

import java.sql.ResultSet;
import java.sql.SQLException;
import jdbc.Connector;

/**
 *
 * @author Dywa Pratama
 */
public class ModelTabungan {
    Connector connector = new Connector();
    private final ViewTabungan view;
    
    public ModelTabungan(ViewTabungan view){
        this.view = view;
    }
    
    public String[][] getDaftarTabungan(String username){
        String data[][] = new String[getJumlahData(username)][3];
        try {
            String query = "SELECT * fROM `tabungan` WHERE `username` = '" + username + "' ORDER BY `id` DESC";
            connector.statement = connector.connection.createStatement();
            ResultSet resultSet = connector.statement.executeQuery(query);
            
            int p = 0;
            while(resultSet.next()){
                data[p][0] = resultSet.getString("id");
                data[p][1] = resultSet.getString("name");
                data[p][2] = "Rp " + resultSet.getString("saldo");
                p++;
            }
        }catch (SQLException ex) {
            view.setMessage("Terjadi Kesalahan Database\n" + ex.getMessage());
        }
        return data;
    }
    
    public int getJumlahData(String username){
        int jumlah = 0;
        try {
            String query = "SELECT COUNT(*) AS `jumlah` FROM `tabungan` WHERE `username` = '" + username + "'";
            connector.statement = connector.connection.createStatement();
            ResultSet resultSet = connector.statement.executeQuery(query);
            
            if(resultSet.next()){
                jumlah = resultSet.getInt("jumlah");
            }
            else{
                jumlah = 0;
            }
        }catch (SQLException ex) {
            view.setMessage("Terjadi Kesalahan Database\n" + ex.getMessage());
        }
        return jumlah;
    }
}
