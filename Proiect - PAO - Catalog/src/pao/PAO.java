
package pao;

import pao.gui.JFrameMain;
import pao.table_data.TableCourseType;
import pao.table_data.TableNotes;
import pao.table_data.TableProfesor;
import pao.table_data.TableSchoolClass;
import pao.table_data.TableSpecialization;
import pao.table_data.TableStudents;


public class PAO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
            
            TableSpecialization.getInstance();
            TableSchoolClass.getInstance();
            TableStudents.getInstance();
            TableCourseType.getInstance();
            TableProfesor.getInstance();
            TableNotes.getInstance();
            
            
        
          JFrameMain jMainForm= new JFrameMain();
            
            jMainForm.show();
            
    }
    
}
