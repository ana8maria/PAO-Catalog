
package pao.gui;

import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;


public class JCellEditor extends DefaultCellEditor  {
    
   
      public JCellEditor(JTextField textField) {
          super(textField);

    }
 
    public static JCellEditor make() {
        JTextField field = new JTextField();
        field.setBorder(null);
        System.out.println("make");

        return new JCellEditor(field);
    }
    
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
       JTextField textField= (JTextField)super.getTableCellEditorComponent(table, value, isSelected, row, column);
        
       textField.setHorizontalAlignment( DefaultTableCellRenderer.CENTER);
       textField.selectAll();
       return textField;
        
        
    }
    
    
  
    
    
    
 
    
}
