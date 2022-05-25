/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assets;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dywa Pratama
 */
public class FontDoc {
    public Font inter;

    public FontDoc(){
        try {
            this.inter = Font.createFont(Font.TRUETYPE_FONT, ColorDoc.class.getResourceAsStream("Inter.ttf"));
        } catch (FontFormatException | IOException ex) {
            Logger.getLogger(ColorDoc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
