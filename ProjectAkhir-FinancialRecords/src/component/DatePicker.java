/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package component;

/**
 *
 * @author Dywa Pratama
 */
import assets.ColorDoc;
import assets.FontDoc;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
 
public final class DatePicker {
    int month = java.util.Calendar.getInstance().get(java.util.Calendar.MONTH);
    int year = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
    
    ColorDoc color = new ColorDoc();
    FontDoc font = new FontDoc();
    
    String[] header = { "Sun", "Mon", "Tue", "Wed", "Thur", "Fri", "Sat" };
    JLabel label = new JLabel("", JLabel.CENTER);
    String day = "";
    JDialog dialog = new JDialog();;
    JButton[] button = new JButton[49];
    
    JPanel p1 = new JPanel(new GridLayout(7, 7));
    JPanel p2 = new JPanel(new GridLayout(1, 3));
    
    JButton previous = new JButton("<<");
    JButton next = new JButton(">>");
    
    public DatePicker(JFrame parent) {
        dialog.setModal(true);

        p1.setPreferredSize(new Dimension(430, 120));
        
        p2.add(previous);
        p2.add(label);
        p2.add(next);
        
        previous.setBackground(color.btnSubmit);
        previous.setBorder(new EmptyBorder(0, 0, 0, 0));
        previous.setFont(font.inter.deriveFont(Font.BOLD, 18f));
        previous.setCursor(new Cursor(Cursor.HAND_CURSOR));
        previous.setForeground(Color.white);
        
        next.setBackground(color.btnSubmit);
        next.setBorder(new EmptyBorder(0, 0, 0, 0));
        next.setFont(font.inter.deriveFont(Font.BOLD, 18f));
        next.setCursor(new Cursor(Cursor.HAND_CURSOR));
        next.setForeground(Color.white);
        
        
        previous.addActionListener((ActionEvent ae) -> {
            month--;
            displayDate();
        });

        next.addActionListener((ActionEvent ae) -> {
            month++;
            displayDate();
        });
        
        for (int x = 0; x < button.length; x++) {
            final int selection = x;
            button[x] = new JButton();
            button[x].setFocusPainted(false);
            button[x].setBackground(Color.white);
            if (x > 6) {
                button[x].addActionListener((ActionEvent ae) -> {
                    day = button[selection].getActionCommand();
                    dialog.dispose();
                });
            }
            if (x < 7) {
                button[x].setText(header[x]);
                button[x].setForeground(Color.black);
            }
            p1.add(button[x]);
        }

        dialog.add(p1, BorderLayout.CENTER);
        dialog.add(p2, BorderLayout.SOUTH);
        dialog.pack();
        dialog.setLocationRelativeTo(parent);
        displayDate();
        dialog.setVisible(true);
    }
    
    public void displayDate() {
        for (int x = 7; x < button.length; x++) button[x].setText("");
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("MMMM yyyy");
        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.set(year, month, 1);
        int dayOfWeek = cal.get(java.util.Calendar.DAY_OF_WEEK);
        int daysInMonth = cal.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);
        for (int x = 6 + dayOfWeek, days = 1; days <= daysInMonth; x++, days++) button[x].setText("" + days);
        label.setText(sdf.format(cal.getTime()));
        dialog.setTitle("Date Picker");
    }
 
    public String setPickedDate() {
        if (day.equals("")) return day;
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.set(year, month, Integer.parseInt(day));
        return sdf.format(cal.getTime());
    }
}