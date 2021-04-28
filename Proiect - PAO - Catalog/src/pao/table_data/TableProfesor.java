
package pao.table_data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import pao.entities.Professor;
import pao.entities.Student;
import pao.services.AuditService;

public class TableProfesor extends ArrayList<Professor> implements ITableDataCSV
{
    
  private static TableProfesor  instance =null;

    /**
     *
     * @return
     */
    public static TableProfesor getInstance() {
        
        if(instance==null){
            instance= new TableProfesor();
        }
        return instance;
    }
    
    
      private String pathTable="DataTables\\Professor.csv";
     private TableProfesor curentInstance=this;
    
    private TableProfesor() {
        
        super();
        Refresh();
    }
    
    
    
    
    @Override
    public void SaveChanges() {
      
        
          Thread t= new Thread(new Runnable() {
            @Override
            public void run() 
            {
                 
        File tmp = new File(pathTable);
        
        if(!tmp.getParentFile().exists()){
            tmp.getParentFile().mkdirs();
            AuditService.writeAudit("SaveChanges","TableStudents","Create directory path for DataTables "  );
        }
        
        
        try (BufferedWriter out = new BufferedWriter(new FileWriter(pathTable,false))) {
             
           out.append(new Student().getCsvHeder());
           out.newLine();
           for (Professor var : curentInstance) 
           {
                out.append(var.objectToCsvRow());
                out.newLine();
               
           }
           
           AuditService.writeAudit("SaveChanges","TableStudents","Done save Student List " );
           
        } catch (IOException e) {
           
              AuditService.writeAudit("SaveChanges","TableStudents","Exception: "+e.getMessage() );
              e.printStackTrace();
        }
                
            }});
          
          t.run();
       
    }

    @Override
    public void Refresh() {
          this.clear();
            try (BufferedReader read = new BufferedReader(new FileReader(pathTable))) {
            
            String thisLine=null;
            boolean isFarst=true;
            while ((  thisLine = read.readLine()) != null) 
            {
                if(isFarst){
                    isFarst=false;
                    continue;
                }
                
                Professor s=new Professor();
                s.csvRowToObject(thisLine);
                this.add(s);
                
            }   
            
             AuditService.writeAudit("Refresh","TableStudents","Done refresh list" );
            
         } catch (IOException e) {
           AuditService.writeAudit("Refresh","TableStudents","Exception: "+e.getMessage() );
        }
    }
    
     public  void AddOrEdit(Professor c){
        
        if(c.getId()==-1){
           c.GenerateId();
           this.add(c);
           
        }
        
    }
    
     
   
     
}
    

