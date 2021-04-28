
package pao.gui;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import pao.entities.Note;
import pao.entities.Professor;
import pao.entities.SchoolClass;
import pao.entities.Student;
import pao.table_data.TableNotes;
import pao.table_data.TableProfesor;
import pao.table_data.TableStudents;

public class JTableModel extends AbstractTableModel {

    SchoolClass schoolClass;

    ArrayList<Student> studentClass;
    ArrayList<Professor> profesorClass;
    TableNotes tableNotes=TableNotes.getInstance();
    JFrame frameMain;
    JTable tableMain;
    
    
    public static int NRNOTE=5;
    public static int nrNoteRow=NRNOTE+2;
    
    public JTableModel(SchoolClass schoolClass, JFrame frameMain,JTable tableMain){
        this.schoolClass=schoolClass;
        this.frameMain=frameMain;
        this.tableMain=tableMain;

        studentClass= new ArrayList<>();
        
        for(Student s : TableStudents.getInstance()){
            if(s.getSchoolClass()==null)continue;
            if(s.getSchoolClass().getId()==schoolClass.getId()){
                studentClass.add(s);
            }
        }

         profesorClass= new ArrayList<>();
        
          for(Professor s : TableProfesor.getInstance()){
               if(s.getSchoolClass()==null)continue;
            if(s.getSchoolClass().getId()==schoolClass.getId()){
                profesorClass.add(s);
            }
        }

    }

     @Override
    public String getColumnName(int column) {
        if(column==0){
            return "Nume elev";
        }else
        {
            Professor p=profesorClass.get(column-1);
            
            return p.getName()+" "+p.getLastName()+" - ("+p.getCourseType()+")";
            
        }
        
    }

    
    @Override
    public int getRowCount() {
      return studentClass.size()*nrNoteRow;
    }

    @Override
    public int getColumnCount() {
        return  profesorClass.size()+1;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        if(columnIndex==0){
            
            if(rowIndex%nrNoteRow==0){
                Student s= studentClass.get(rowIndex/nrNoteRow);
                return s.getName()+" "+s.getLastName();
            } if(rowIndex%nrNoteRow==nrNoteRow-1)
            {
            
                return "Medie";
            }
            else
            {
                return "Nota"+(rowIndex%nrNoteRow);
            }

      }else
      {
           if(rowIndex%nrNoteRow==0){
           
               return "";
           }
           Professor p= profesorClass.get(columnIndex-1);
            Student s= studentClass.get(rowIndex/nrNoteRow);
          
          if(rowIndex%nrNoteRow==nrNoteRow-1)
          {
                double suma=0;
                int count=0;
              for(Note nota: tableNotes)
              {
                    if(nota.getIdProfesor()==p.getId() && nota.getIdStudent()==s.getId() && nota.getNota()!=-1)
                    {
                         suma+=nota.getNota();
                         count++;
                    }
              }
              
              if(count==0){
              return "";    
              }else   return suma/count;
          }

          int notaIndex=rowIndex%nrNoteRow;
          
          for(Note nota: tableNotes){
              if(nota.getIdProfesor()==p.getId() && nota.getIdStudent()==s.getId() && nota.getIndexNota()==notaIndex){
                  return nota.getNota()==-1?"":nota.getNota()+"";
              }
              
          }
          
          Note nota = new Note();
          nota.GenerateId();
          nota.setIdProfesor(p.getId());
          nota.setIdStudent(s.getId());
          nota.setIndexNota(notaIndex);
          
          tableNotes.add(nota);
          tableNotes.SaveChanges();
          return nota.getNota()==-1?"":nota.getNota()+"";

      }

    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {

         if(columnIndex==0||  rowIndex%nrNoteRow==0 || rowIndex%nrNoteRow== nrNoteRow-1){
            return  false;
        }
       
       return true;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
      if(columnIndex==0){
          return  String.class;
      }
      return  String.class;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
     
         double d=-1;
        try{
            
            
            String nota=(String)aValue;
            
            if(nota.trim().length()!=0){
                
           
            
             d= Double.parseDouble(aValue+"");
        
             if(d<=0)
             {
                      JOptionPane.showMessageDialog(frameMain,  "Nota nu poate fi mai mica decat 1",  "Inane warning", JOptionPane.WARNING_MESSAGE);
                       return;
            
              }
            if(d>=11)
            {
                   JOptionPane.showMessageDialog(frameMain,  "Nota nu poate fi mai mare 10",  "Inane warning", JOptionPane.WARNING_MESSAGE);
                    return;
           
             }
          }
        }catch (Exception e)
        {
              JOptionPane.showMessageDialog(frameMain,  "Nota trebuie sa fie inte 1 si 10",  "Inane warning", JOptionPane.WARNING_MESSAGE);
              return;
            
        }
       
         if(columnIndex!=0)
         {

          
          Professor p= profesorClass.get(columnIndex-1);
          Student s= studentClass.get(rowIndex/nrNoteRow);
          int notaIndex=rowIndex%nrNoteRow;
           
          
          for(Note nota: tableNotes){
              if(nota.getIdProfesor()==p.getId() && nota.getIdStudent()==s.getId()&& nota.getIndexNota()==notaIndex){
                   nota.setNota(d);
                   tableNotes.SaveChanges();
                   this.fireTableDataChanged();
                   
                   return;
              }
              
          }
          
          Note nota = new Note();
          nota.GenerateId();
          nota.setIdProfesor(p.getId());
          nota.setIdStudent(s.getId());
          nota.setIndexNota(notaIndex);
          tableNotes.add(nota);
          nota.setNota(d);
          tableNotes.SaveChanges(); 
          this.fireTableDataChanged();
          
      }
         
        
        
    }

  
 

   
    
}

 