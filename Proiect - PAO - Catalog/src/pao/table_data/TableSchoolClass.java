
package pao.table_data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import pao.entities.SchoolClass;
import pao.services.AuditService;


public class TableSchoolClass extends ArrayList<SchoolClass>  implements ITableDataCSV{

    private static TableSchoolClass  instance =null;

    public static TableSchoolClass getInstance() {
        
        if(instance==null){
            instance= new TableSchoolClass();
        }
        return instance;
    }
    
    
    
     
    private String pathTable="DataTables\\ScoolClass.csv";
       private TableSchoolClass curentInstance=this;
    
    private TableSchoolClass() {
        
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
            AuditService.writeAudit("SaveChanges","TableSchoolClass","Create directory path for DataTables "  );
        }
        
        
        try (BufferedWriter out = new BufferedWriter(new FileWriter(pathTable,false))) {
             
           out.append(new SchoolClass().getCsvHeder());
           out.newLine();
           for (SchoolClass var : curentInstance) 
           {
                out.append(var.objectToCsvRow());
                out.newLine();
               
           }
           
           AuditService.writeAudit("SaveChanges","TableSchoolClass","Done save ScoolClass List " );
           
        } catch (IOException e) {
           
              AuditService.writeAudit("SaveChanges","TableSchoolClass","Exception: "+e.getMessage() );
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
                
                SchoolClass s=new SchoolClass();
                s.csvRowToObject(thisLine);
                this.add(s);
                
            }   
            
             AuditService.writeAudit("Refresh","TableSchoolClass","Done refresh list" );
            
         } catch (IOException e) {
           AuditService.writeAudit("Refresh","TableSchoolClass","Exception: "+e.getMessage() );
        }
    }
    
    
    public  void AddOrEdit(SchoolClass c){
        
        if(c.getId()==-1){
           c.GenerateId();
           this.add(c);
           
        }
        
    }
    
    
}
