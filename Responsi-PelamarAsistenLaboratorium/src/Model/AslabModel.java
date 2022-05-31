/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Dywa Pratama
 */
public class AslabModel extends BaseModel{
    String nama;
    double nilai1, nilai2, nilai3, nilai;
    
    public void setData(String nama, double nilai1, double nilai2, double nilai3){
        this.nama = nama;
        this.nilai1 = nilai1;
        this.nilai2 = nilai2;
        this.nilai3 = nilai3;
        this.nilai = (nilai1 + nilai2 + nilai3) / 3;
    }
    
    public void setData(String nama){
        this.nama = nama;
    }
    
    public String[][] getDataKaryawan(){
        String data[][] = new String[getJumlahData()][5];
        try {
            String query = "SELECT * fROM `aslab`";
            connector.statement = connector.connection.createStatement();
            ResultSet resultSet = connector.statement.executeQuery(query);
            
            int p = 0;
            while(resultSet.next()){
                data[p][0] = resultSet.getString("nama");
                data[p][1] = resultSet.getString("portofolio");
                data[p][2] = resultSet.getString("microteaching");
                data[p][3] = resultSet.getString("wawancara");
                data[p][4] = resultSet.getString("nilai");
                p++;
            }
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Terjadi Kesalahan Database\n" + ex.getMessage());
        }
        return data;
    }
    
    public boolean insertData(){
        boolean success = false;
        try {
            String query = "INSERT INTO `aslab` (`nama`, `portofolio`, `microteaching`, `wawancara`, `nilai`) VALUES "
                    + "('" + this.nama + "', " + this.nilai1 + ", " + this.nilai2 + ", " + this.nilai3 + ", " + this.nilai + ");";
            
            connector.statement = connector.connection.createStatement();
            connector.statement.executeUpdate(query);
            success = true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Terjadi Kesalahan Database\n" + ex.getMessage());
        }
        return success;
    }
    
    public boolean updateData(){
        boolean success = false;
        try {
            String query = "UPDATE `aslab` SET "
                    + "`nama` = '" + this.nama + "',"
                    + "`portofolio` = '" + this.nilai1 + "',"
                    + "`microteaching` = '" + this.nilai2 + "',"
                    + "`wawancara` = '" + this.nilai3 + "',"
                    + "`nilai` = '" + this.nilai + "'"
                    + "WHERE `aslab`.`nama` = '" + this.nama + "'";
            
            connector.statement = connector.connection.createStatement();
            connector.statement.executeUpdate(query);
            success = true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Terjadi Kesalahan Database\n" + ex.getMessage());
        }
        return success;
    }
    
    public boolean hapusData(){
        boolean success = false;
        try {
            String query = "DELETE FROM `aslab` WHERE `aslab`.`nama` = '" + this.nama + "'";
            
            connector.statement = connector.connection.createStatement();
            connector.statement.executeUpdate(query);
            success = true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Terjadi Kesalahan Database\n" + ex.getMessage());
        }
        return success;
    }
}
