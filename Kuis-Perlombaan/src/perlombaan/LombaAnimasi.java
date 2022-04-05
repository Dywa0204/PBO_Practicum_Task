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
public interface LombaAnimasi {
    double bobotAlur = 0.15;
    double bobotKonten =  0.35;
    double bobotKreatif = 0.35;
    double bobotsinema = 0.15;
    
    public void setNilaiAnimasi(double n1, double n2, double n3, double n4);
    public double getNilaiAnimasi();
}
