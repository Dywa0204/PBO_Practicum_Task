/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dywa Pratama
 */
public class Konversi {
    double celcius;
    
    public Konversi(double celcius){
        this.celcius = celcius;
    }
    
    public double toFahrenheit(){
        return ((9 * celcius) / 5 + 32);
    }
    
    public double toReamur(){
        return ((4 * celcius)/5);
    }
    
    public double toKelvin(){
        return (celcius + 273.15);
    }
    
    public String waterCondition(){
        if(celcius <= 0){
            return "Beku";
        }else if(celcius >= 100){
            return "Mendidih";
        }else{
            return "Normal";
        }
    }
}
