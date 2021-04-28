
package pao.table_data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import pao.entities.Student;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;
import pao.services.AuditService;

@TableTadaTagsCsv()
public class TableStudents extends ArrayList<Student> implements ITableDataCSV
{
    
  private static TableStudents  instance =null;


    public static TableStudents getInstance() {
        
        if(instance==null){
            instance= new TableStudents();
        }
        return instance;
    }

      private String pathTable="DataTables\\Student.csv";
    
      private TableStudents curentInstance=this;
    private TableStudents() {
        
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
           for (Student var : curentInstance) 
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
                
                Student s=new Student();
                s.csvRowToObject(thisLine);
                this.add(s);
                
            }   
            
             AuditService.writeAudit("Refresh","TableStudents","Done refresh list" );
            
         } catch (IOException e) {
           AuditService.writeAudit("Refresh","TableStudents","Exception: "+e.getMessage() );
        }
    }
    
     public  void AddOrEdit(Student c){
        
        if(c.getId()==-1){
           c.GenerateId();
           this.add(c);
           
        }
        
    }
    
     
   
     
}
