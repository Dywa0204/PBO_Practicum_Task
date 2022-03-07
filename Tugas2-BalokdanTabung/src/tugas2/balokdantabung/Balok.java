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
public class Balok extends PersegiPanjang implements MenghitungRuang{
    double t;
    
    public Balok(double p, double l, double t){
        super(p, l);
        this.t = t;
    }
    
    public double getBalok(){
        return this.t;
    }
    
    public void setBalok(double t){
        this.t = t;
    }
    
    @Override
    public double cariVolume(){
        return (super.cariLuas() * this.t);
    }
    
    @Override
    public double cariLuasPermukaan(){
        return (2 * (super.cariLuas() + (super.getP() * this.t) + (super.getL() * this.t)));
    }
}
