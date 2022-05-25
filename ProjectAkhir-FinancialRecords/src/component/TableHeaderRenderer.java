/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package component;

import java.awt.Component;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import style.ColorDoc;

/**
 *
 * @author Dywa Pratama
 */
public class TableHeaderRenderer implements TableCellRenderer {

    DefaultTableCellRenderer renderer;
    JLabel lbl;

    public TableHeaderRenderer(JTable table) {
        renderer = (DefaultTableCellRenderer) (JLabel) table.getTableHeader().getDefaultRenderer();
        renderer.setHorizontalAlignment(JLabel.LEFT);
        renderer.setBorder(BorderFactory.createCompoundBorder(renderer.getBorder(), BorderFactory.createEmptyBorder(0, 5, 0, 0)));
    }

    @Override
    public Component getTableCellRendererComponent(
        JTable table, Object value, boolean isSelected,
        boolean hasFocus, int row, int col) {
        return renderer.getTableCellRendererComponent(
            table, value, isSelected, hasFocus, row, col);
    }
}
