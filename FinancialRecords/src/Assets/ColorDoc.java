/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assets;

import java.awt.Color;

/**
 *
 * @author Dywa Pratama
 */
public class ColorDoc {
    public Color background;
    public Color header;
    public Color btnSubmit;
    public Color btnCancel;
    
    public ColorDoc(){
        this.background = Color.decode("#E6E9F3");
        this.header = Color.decode("#323954");
        this.btnSubmit = Color.decode("#6695FC");
        this.btnCancel = Color.decode("#E82626");
    }
}
