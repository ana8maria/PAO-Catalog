
package pao.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;


public class JTableCellRenderer   extends DefaultTableCellRenderer {
    

  public Component getTableCellRendererComponent(JTable table,
                                                 Object value,
                                                 boolean isSelected,
                                                 boolean hasFocus,
                                                 int row,
                                                 int column) {
    DefaultTableCellRenderer c = 
     (DefaultTableCellRenderer) super.getTableCellRendererComponent(table, value,
                                          isSelected, hasFocus,
                                          row, column);
    
    
 
    if ( row%JTableModel.nrNoteRow==0) {
       
       Font myFont = new Font("Serif", Font.BOLD, 20);
       c.setForeground(Color.WHITE);
       c.setFont(myFont);
       c.setBackground(Color.BLACK);
       c.setHorizontalAlignment( DefaultTableCellRenderer.RIGHT);
      
        
    }else
    if (row%JTableModel.nrNoteRow==JTableModel.nrNoteRow-1 && column==0 ) 
    {
       
      Font myFont = new Font("Serif", Font.BOLD, 18);
       c.setFont(myFont);
       c.setForeground(Color.RED);
       c.setBackground(Color.white);
       c.setHorizontalAlignment( DefaultTableCellRenderer.RIGHT);
      

    }else
    if (row%JTableModel.nrNoteRow==JTableModel.nrNoteRow-1 ) 
    {
       
      Font myFont = new Font("Serif", Font.BOLD, 18);
       c.setFont(myFont);
       c.setForeground(Color.RED);
       c.setBackground(Color.white);
       c.setHorizontalAlignment( DefaultTableCellRenderer.CENTER);
      

    }else
    if(column==0)
    {
         Font myFont = new Font("Serif", Font.BOLD, 16);
         c.setFont(myFont);
         c.setForeground(Color.BLACK);
         c.setBackground(Color.white);
         c.setHorizontalAlignment( DefaultTableCellRenderer.RIGHT);
        
        
    }
    else
    {
        
        Font myFont = new Font("Serif", Font.BOLD, 16);
         c.setFont(myFont);
         c.setForeground(Color.BLACK);
         c.setBackground(Color.white);
         c.setHorizontalAlignment( DefaultTableCellRenderer.CENTER);
    }
    
    
    return c;
  }
  
}

