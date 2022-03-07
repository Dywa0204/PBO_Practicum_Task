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
public class Tabung extends Lingkaran implements MenghitungRuang{
    double t;
    
    public Tabung(double r, double t){
        super(r);
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
        return ( 2 * PHI * super.getR() * (super.getR() + this.t) );
    }
}
