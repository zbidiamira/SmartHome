package projet_tt;

import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

class ImageRenderer extends DefaultTableCellRenderer {
  JLabel lbl = new JLabel();

  ImageIcon icon = new ImageIcon(".\\src\\images\\Trash.gif");

  public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
      boolean hasFocus, int row, int column) {
    lbl.setText((String) value);
    lbl.setIcon(icon);
    return lbl;
  }
}
