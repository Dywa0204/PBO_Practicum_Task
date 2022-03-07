/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas2.balokdantabung;

/**
 *
 * @author Dywa Pratama
 */

public class Lingkaran implements MenghitungBidang{
    double r;
    
    public Lingkaran(double r){
        this.r = r;
    }
    
    public double getR(){
        return this.r;
    }
    
    public void setR(double r){
        this.r = r;
    }
    
    @Override
    public double cariLuas(){
        return (PHI * this.r * this.r);
    }
    
    @Override
    public double cariKeliling(){
        return (PHI * (2 * this.r));
    }
}
