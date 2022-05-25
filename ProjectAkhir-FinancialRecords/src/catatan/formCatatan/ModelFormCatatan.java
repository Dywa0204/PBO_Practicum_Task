/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catatan.formCatatan;

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
    
    public void setData(String tanggal, String tipe, String ket, int jumlah, int idTabungan) {
        this.tanggal = tanggal;
        this.tipe = tipe;
        this.keterangan = ket;
        this.jumlah = jumlah;
        this.idTabungan = idTabungan;
    }
}
