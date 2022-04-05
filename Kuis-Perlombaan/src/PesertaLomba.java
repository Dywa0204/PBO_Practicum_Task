/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dywa Pratama
 */

import perlombaan.*;

/**
 *
 * @author Dywa Pratama
 */
public class PesertaLomba implements LombaSurat, LombaAnimasi{
    String nama, asalSekolah;
    int kategori;
    double nilai1, nilai1, nilai1, nilai4, nilaiAkhir;
    
    public PesertaLomba(String nama, String asalSekolah, int kategori){
        this.nama = nama;
        this.asalSekolah = asalSekolah;
        this.kategori = kategori;
    }
    
    @Override
    public void setNilaiAnimasi(double nilai1, double nilai2, double nilai3, double nilai4){
        this.nilaiAkhir = nilai1*bobotAlur + nilai2*bobotKonten + nilai3*bobotKreatif + nilai4*bobotsinema;
    }
    
    @Override
    public double getNilaiAnimasi(){
        return nilaiAkhir;
    }
    
    @Override
    public void setNilaiSurat(double nilai1, double nilai2, double nilai3, double nilai4){
        this.nilaiAkhir = nilai1*bobotStruktur + nilai2*bobotIsi + nilai3*bobotKreativitas + nilai4*bobotkaidah;
    }
    
    @Override
    public double getNilaiSurat(){
        return nilaiAkhir;
    }
}
