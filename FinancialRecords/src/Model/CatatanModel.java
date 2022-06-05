/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Database.Connector;
import View.PanelCatatanView;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Dywa Pratama
 */
public class CatatanModel {
    Connector connector = new Connector();
    private final PanelCatatanView view;
    String namaTabungan, tanggal, tipe, keterangan;
    int idTabungan, jumlah;
    
    public CatatanModel(PanelCatatanView view){
        this.view = view;
    }
    
    public void setNamaTabungan(String nama){
        this.namaTabungan = nama;
    }
    
    public void setIdTabungan(int idTabungan){
        this.idTabungan = idTabungan;
    }
    
    public String getNamaTabungan(int idCatatan){
        String localNamaTabungan = "";
        
        try {
            String query = "SELECT `name` FROM `tabungan` WHERE `id` = '" + idCatatan + "'";
            connector.statement = connector.connection.createStatement();
            ResultSet resultSet = connector.statement.executeQuery(query);
            
            if(resultSet.next()){
                localNamaTabungan = resultSet.getString("name");
            }
        }catch (SQLException ex) {
            view.setMessage("Terjadi Kesalahan Database\n" + ex.getMessage());
        }
        
        return localNamaTabungan;
    }
    
    public boolean updateNamaTabungan(){
        boolean temp = false;
        try {
            String query = "UPDATE `tabungan` SET `name` = '" + this.namaTabungan + "' WHERE `tabungan`.`id` = " + this.idTabungan;
            
            connector.statement = connector.connection.createStatement();
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
    
    public void hapusTabungan(int idTabungan){
        try {
            String query = "DELETE FROM `tabungan` WHERE `tabungan`.`id` = " + idTabungan;
            
            connector.statement = connector.connection.createStatement();
            connector.statement.executeUpdate(query);
        } catch (SQLException ex) {
            view.setMessage("Terjadi Kesalahan Database\n" + ex.getMessage());
        }
    }
    
    
    
    public String[][] getDaftarCatatan(int idTabungan){
        String data[][] = new String[getJumlahData(idTabungan)][5];
        try {
            String query = "SELECT * fROM `catatan` WHERE `id_tabungan` = '" + idTabungan + "' ORDER BY `id` DESC";
            connector.statement = connector.connection.createStatement();
            ResultSet resultSet = connector.statement.executeQuery(query);
            
            int saldo = 0;
            int p = 0;
            while(resultSet.next()){
                data[p][0] = resultSet.getString("id");
                data[p][1] = resultSet.getString("tanggal");
                data[p][2] = resultSet.getString("tipe");
                data[p][3] = "Rp " + resultSet.getString("jumlah");
                data[p][4] = resultSet.getString("keterangan");
                
                if(resultSet.getString("tipe").equals("Pemasukan")) saldo = saldo + resultSet.getInt("jumlah");
                else saldo = saldo - resultSet.getInt("jumlah");
                
                p++;
            }
            view.setSaldo(saldo);
        }catch (SQLException ex) {
            view.setMessage("Terjadi Kesalahan Database\n" + ex.getMessage());
        }
        
        return data;
    }
    
    public int getJumlahData(int idTabungan){
        int jumlahData = 0;
        try {
            String query = "SELECT COUNT(*) as `jumlah` FROM `catatan` WHERE `id_tabungan` = '" + idTabungan + "'";
            connector.statement = connector.connection.createStatement();
            ResultSet resultSet = connector.statement.executeQuery(query);
            
            if(resultSet.next()){
                jumlahData = resultSet.getInt("jumlah");
            }
            else{
                jumlahData = 0;
            }
        }catch (SQLException ex) {
            view.setMessage("Terjadi Kesalahan Database\n" + ex.getMessage());
        }
        return jumlahData;
    }
    
    public void setData(String tanggal, String tipe, String ket, int jumlah, int idTabungan) {
        this.tanggal = tanggal;
        this.tipe = tipe;
        this.keterangan = ket;
        this.jumlah = jumlah;
        this.idTabungan = idTabungan;
    }
    
    public boolean insertCatatan(){
        boolean temp = false;
        try {
            String query = "INSERT INTO `catatan` (`id`, `tanggal`, `tipe`, `jumlah`, `keterangan`, `id_tabungan`) VALUES "
                    + "(NULL, '" + this.tanggal + "', '" + this.tipe + "', " + this.jumlah + ", '" + this.keterangan + "',"
                    + this.idTabungan + ");";
            
            connector.statement = connector.connection.createStatement();
            connector.statement.executeUpdate(query);
            
            temp = true;
        } catch (SQLException ex) {
            view.setMessage("Terjadi Kesalahan Database\n" + ex.getMessage());
        }
        return temp;
    }
    
    public boolean updateCatatan(int idCatatan){
        boolean temp = false;
        try {
            String query = "UPDATE `catatan` SET "
                    + "`tanggal` = '" + this.tanggal + "', "
                    + "`tipe` = '" + this.tipe + "', "
                    + "`jumlah` = " + this.jumlah + ", "
                    + "`keterangan` = '" + this.keterangan + "' "
                    + "WHERE `catatan`.`id` = " + idCatatan;
            
            connector.statement = connector.connection.createStatement();
            connector.statement.executeUpdate(query);
            
            temp = true;
        } catch (SQLException ex) {
            view.setMessage("Terjadi Kesalahan Database\n" + ex.getMessage());
        }
        return temp;
    }
    
    public void hapusCatatan(int idCatatan){
        try {
            String query = "DELETE FROM `catatan` WHERE `catatan`.`id` = " + idCatatan;
            
            connector.statement = connector.connection.createStatement();
            connector.statement.executeUpdate(query);
        } catch (SQLException ex) {
            view.setMessage("Terjadi Kesalahan Database\n" + ex.getMessage());
        }
    }

    public void setSaldoTabungan(int idTabungan, int saldo){
        try {
            String query = "UPDATE `tabungan` SET `saldo` = " + saldo + " WHERE `tabungan`.`id` = " + idTabungan;
            
            connector.statement = connector.connection.createStatement();
            connector.statement.executeUpdate(query);
            
        } catch (SQLException ex) {
            view.setMessage("Terjadi Kesalahan Database\n" + ex.getMessage());
        }
    }
}
