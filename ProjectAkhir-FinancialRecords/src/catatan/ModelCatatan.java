/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catatan;

import java.sql.ResultSet;
import java.sql.SQLException;
import jdbc.Connector;

/**
 *
 * @author Dywa Pratama
 */
public class ModelCatatan {
    Connector connector = new Connector();
    String namaTabungan;
    int idTabungan;
    private final ViewCatatan view;
    private final Catatanku viewPanel;
    
    public ModelCatatan(ViewCatatan view, Catatanku viewPanel){
        this.view = view;
        this.viewPanel = viewPanel;
    }
    
    public String getNamaTabungan(int idCatatan){
        String namaTabungan = "";
        
        try {
            String query = "SELECT `name` FROM `tabungan` WHERE `id` = '" + idCatatan + "'";
            connector.statement = connector.koneksi.createStatement();
            ResultSet resultSet = connector.statement.executeQuery(query);
            
            if(resultSet.next()){
                namaTabungan = resultSet.getString("name");
            }
        }catch (SQLException ex) {
            view.setMessage("Terjadi Kesalahan Database\n" + ex.getMessage());
        }
        
        return namaTabungan;
    }
    
    public void setNamaTabungan(String nama){
        this.namaTabungan = nama;
    }
    
    public void setIdTabungan(int idTabungan){
        this.idTabungan = idTabungan;
    }
    
    public boolean updateNamaTabungan(){
        boolean temp = false;
        try {
            String query = "UPDATE `tabungan` SET `name` = '" + this.namaTabungan + "' WHERE `tabungan`.`id` = " + this.idTabungan;
            
            connector.statement = connector.koneksi.createStatement();
            connector.statement.executeUpdate(query);
            
            temp = true;
        } catch (SQLException ex) {
            if(ex.getMessage().contains("Duplicate"))
                view.setMessage("Tabungan " + this.namaTabungan + " Sudah Ada");
            else
                view.setMessage("Terjadi Kesalahan Database\n" + ex.getMessage());
        }
        return temp;
    }
    
    public String[][] getDaftarCatatan(int idTabungan){
        String data[][] = new String[getJumlahData(idTabungan)][5];
        try {
            String query = "SELECT * fROM `catatan` WHERE `id_tabungan` = '" + idTabungan + "' ORDER BY `id` DESC";
            connector.statement = connector.koneksi.createStatement();
            ResultSet resultSet = connector.statement.executeQuery(query);
            
            int saldo = 0;
            int p = 0;
            while(resultSet.next()){
                data[p][0] = resultSet.getString("id");
                data[p][1] = resultSet.getString("tanggal");
                data[p][2] = resultSet.getString("tipe");
                data[p][3] = "Rp " + resultSet.getInt("jumlah");
                data[p][4] = resultSet.getString("keterangan");
                if(resultSet.getString("tipe").equals("Pemasukan")){
                    saldo = saldo + resultSet.getInt("jumlah");
                    
                }else{
                    saldo = saldo - resultSet.getInt("jumlah");
                }
                p++;
            }
            viewPanel.setSaldo(saldo);
        }catch (SQLException ex) {
            view.setMessage("Terjadi Kesalahan Database\n" + ex.getMessage());
        }
        
        return data;
    }
    
    public int getJumlahData(int idTabungan){
        int jumlah = 0;
        try {
            String query = "SELECT COUNT(*) as `jumlah` FROM `catatan` WHERE `id_tabungan` = '" + idTabungan + "'";
            connector.statement = connector.koneksi.createStatement();
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
    
    public void hapusCatatan(int id){
        try {
            String query = "DELETE FROM `catatan` WHERE `catatan`.`id` = " + id;
            
            connector.statement = connector.koneksi.createStatement();
            connector.statement.executeUpdate(query);
        } catch (SQLException ex) {
            view.setMessage("Terjadi Kesalahan Database\n" + ex.getMessage());
        }
    }
    
    public void setSaldoTabungan(int saldo, int id){
        try {
            String query = "UPDATE `tabungan` SET `saldo` = " + saldo + " WHERE `tabungan`.`id` = " + id;
            
            connector.statement = connector.koneksi.createStatement();
            connector.statement.executeUpdate(query);
            
        } catch (SQLException ex) {
            view.setMessage("Terjadi Kesalahan Database\n" + ex.getMessage());
        }
    }
    
    public void hapusTabungan(int id){
        try {
            String query = "DELETE FROM `tabungan` WHERE `tabungan`.`id` = " + id;
            
            connector.statement = connector.koneksi.createStatement();
            connector.statement.executeUpdate(query);
        } catch (SQLException ex) {
            view.setMessage("Terjadi Kesalahan Database\n" + ex.getMessage());
        }
    }
}
