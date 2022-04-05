/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perlombaan;

/**
 *
 * @author Dywa Pratama
 */
public interface LombaSurat {
    double bobotStruktur = 0.10;
    double bobotIsi =  0.40;
    double bobotKreativitas = 0.30;
    double bobotkaidah = 0.20;
    
    public void setNilaiSurat(double n1, double n2, double n3, double n4);
    public double getNilaiSurat();
}
