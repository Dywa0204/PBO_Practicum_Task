/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catatan.formCatatan;

import catatan.Catatanku;
import java.sql.ResultSet;
import java.sql.SQLException;
import jdbc.Connector;

/**
 *
 * @author Dywa Pratama
 */
public class ModelFormCatatan {
    private String tanggal, tipe, keterangan;
    int jumlah, idTabungan;
    Connector connector = new Connector();
    private final ViewFormCatatan view;
    
    public ModelFormCatatan(ViewFormCatatan view){
        this.view = view;
    }
    
    public void insertCatatan(){
        try {
            String query = "INSERT INTO `catatan` (`id`, `tanggal`, `tipe`, `jumlah`, `keterangan`, `id_tabungan`) VALUES "
                    + "(NULL, '" + this.tanggal + "', '" + this.tipe + "', " + this.jumlah + ", '" + this.keterangan + "',"
                    + this.idTabungan + ");";
            
            connector.statement = connector.koneksi.createStatement();
            connector.statement.executeUpdate(query);
        } catch (SQLException ex) {
            view.setMessage("Terjadi Kesalahan Database\n" + ex.getMessage());
        }
    }
    
    public void updateCatatan(int id){
        try {
            String query = "UPDATE `catatan` SET "
                    + "`tanggal` = '" + this.tanggal + "', "
                    + "`tipe` = '" + this.tipe + "', "
                    + "`jumlah` = " + this.jumlah + ", "
                    + "`keterangan` = '" + this.keterangan + "' "
                    + "WHERE `catatan`.`id` = " + id;
            
            connector.statement = connector.koneksi.createStatement();
            connector.statement.executeUpdate(query);
        } catch (SQLException ex) {
            view.setMessage("Terjadi Kesalahan Database\n" + ex.getMessage());
        }
    }
    
    public void setData(String tanggal, String tipe, String ket, int jumlah, int idTabungan) {
        this.tanggal = tanggal;
        this.tipe = tipe;
        this.keterangan = ket;
        this.jumlah = jumlah;
        this.idTabungan = idTabungan;
    }
}
