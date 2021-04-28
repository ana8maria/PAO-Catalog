
package pao.table_data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import pao.entities.Note;
import pao.entities.SchoolClass;
import pao.services.AuditService;

public class TableNotes extends ArrayList<Note>  implements ITableDataCSV {
    
     private static TableNotes  instance =null;

    public static TableNotes getInstance() {
        
        if(instance==null){
            instance= new TableNotes();
        }
        return instance;
    }

    private String pathTable="DataTables\\Note.csv";
    
    private TableNotes curentInstance=this;
    
    private TableNotes() {
        
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
                         AuditService.writeAudit("SaveChanges","TableNotes","Create directory path for DataTables "  );
                        }   
        
        
                 try (BufferedWriter out = new BufferedWriter(new FileWriter(pathTable,false))) {
             
                     out.append(new Note().getCsvHeder());
                     out.newLine();
                        for (Note var : curentInstance) 
                    {
                        out.append(var.objectToCsvRow());
                        out.newLine();
               
                    }
           
                    AuditService.writeAudit("SaveChanges","TableNotes","Done save Note List " );
           
                    } catch (IOException e) {
           
                     AuditService.writeAudit("SaveChanges","TableNotes","Exception: "+e.getMessage() );
                     e.printStackTrace();
                }
            }
            
         });
         
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
                
                Note s=new Note();
                s.csvRowToObject(thisLine);
                this.add(s);
                
            }   
            
             AuditService.writeAudit("Refresh","TableNotes","Done refresh list" );
            
         } catch (IOException e) {
           AuditService.writeAudit("Refresh","TableNotes","Exception: "+e.getMessage() );
        }
    }

}
