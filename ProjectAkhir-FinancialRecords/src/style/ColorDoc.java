/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package style;

import java.awt.Color;


/**
 *
 * @author Dywa Pratama
 */
public class ColorDoc {
    public Color background;
    public Color header;
    public Color panel;
    
    public Color textWhite;
    public Color btnSubmit;
    public Color btnCancel;
    
    public Color line;
    

    public ColorDoc(){
        this.header = Color.decode("#323954");
        this.textWhite = Color.white;
        this.background = Color.decode("#E6E9F3");
        this.btnSubmit = Color.decode("#6695FC");
        this.panel = Color.white;
        this.btnCancel = Color.decode("#E82626");
        this.line = Color.decode("#D9D9D9");
    }
}
