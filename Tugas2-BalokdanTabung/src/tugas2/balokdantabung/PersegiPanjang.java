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
public class PersegiPanjang implements MenghitungBidang{
    double p, l;
    
    public PersegiPanjang(double p, double l){
        this.p = p;
        this.l = l;
    }
    
    public double getP(){
        return this.p;
    }
    
    public void setP(double p){
        this.p = p;
    }
    
    public double getL(){
        return this.l;
    }
    
    public void setL(double l){
        this.l = l;
    }
    
    @Override
    public double cariLuas(){
        return (this.p * this.l);
    }
    
    @Override
    public double cariKeliling(){
        return (2 * (this.p + this.l));
    }
}
