/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.AslabView;

/**
 *
 * @author Dywa Pratama
 */
public interface IController {
    public boolean isInputEmpty(AslabView view);
    public boolean isLowwer(double nilai1, double nilai2, double nilai3);
    public boolean isHigher(double nilai1, double nilai2, double nilai3);
    public void clear(AslabView view);
}
