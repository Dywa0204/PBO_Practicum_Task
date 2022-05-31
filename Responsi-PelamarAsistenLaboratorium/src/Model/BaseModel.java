/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Database.Connector;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Dywa Pratama
 * 
 * 
 */
abstract class BaseModel {
    protected Connector connector = new Connector();
    
    public int getJumlahData(){
        int jumlah = 0;
        try {
            String query = "SELECT COUNT(*) AS `jumlah` FROM `aslab`";
            connector.statement = connector.connection.createStatement();
            ResultSet resultSet = connector.statement.executeQuery(query);
            
            if(resultSet.next()){
                jumlah = resultSet.getInt("jumlah");
            }
            else{
                jumlah = 0;
            }
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Terjadi Kesalahan Database\n" + ex.getMessage());
        }
        return jumlah;
    }
}
