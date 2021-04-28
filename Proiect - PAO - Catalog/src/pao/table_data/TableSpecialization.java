
package pao.table_data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import pao.entities.Specialization;
import pao.services.AuditService;


public class TableSpecialization extends ArrayList<Specialization> implements ITableDataCSV {

    
    private static TableSpecialization  instance =null;

    public static TableSpecialization getInstance() {
        
        if(instance==null){
            instance= new TableSpecialization();
        }
        return instance;
    }
    
    
    
       private TableSpecialization curentInstance=this;
    private TableSpecialization() {
        
        super();
        Refresh();
    }
    
    public void Refresh(){
        
        this.clear();
            try (BufferedReader read = new BufferedReader(new FileReader("DataTables\\Specialization.csv"))) {
            
            String thisLine=null;
            boolean isFarst=true;
            while ((  thisLine = read.readLine()) != null) 
            {
                if(isFarst){
                    isFarst=false;
                    continue;
                }
                
                Specialization s=new Specialization();
                s.csvRowToObject(thisLine);
                this.add(s);
                
            }   
            
             AuditService.writeAudit("Refresh","TableSpecialization","Done" );
            
         } catch (IOException e) {
           AuditService.writeAudit("Refresh","TableSpecialization","Exception: "+e.getMessage() );
        }
         
    }

    @Override
    public boolean contains(Object o) {
         if(o.getClass().equals(String.class) ){
              for (Specialization var : this) 
             {
                 
                 if(var.getName().equalsIgnoreCase(o.toString().trim())) return  true;      
             }
         }else
             if(o.getClass().equals(Specialization.class)){
                
                   for (Specialization var : this) 
                     {
                 
                         if(var.getName().equalsIgnoreCase(((Specialization)o).getName())) return  true;      
                     }
                 
             }

         return false;
    }

   
    public boolean remove(Specialization o) {
        
        AuditService.writeAudit("remove","TableSpecialization","Remove "+o.getName() +" from list"  );
        return super.remove(o); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(Specialization e) {
        AuditService.writeAudit("add","TableSpecialization","Add "+e.getName()+" in list" );
        return super.add(e); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
    
    
     
    
    
    
    
    
    
    @Override
    public void SaveChanges() {
       
        
        
          Thread t= new Thread(new Runnable() {
            @Override
            public void run() 
            {
                  Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat formatter= new SimpleDateFormat("dd_MM_yyyy");

        File tmp = new File("DataTables\\Specialization.csv");
        
        if(!tmp.getParentFile().exists()){
            tmp.getParentFile().mkdirs();
            AuditService.writeAudit("SaveChanges","TableSpecialization","Create directory path for DataTables "  );
        }
        
        
        try (BufferedWriter out = new BufferedWriter(new FileWriter("DataTables\\Specialization.csv",false))) {
             
           out.append(new Specialization().getCsvHeder());
           out.newLine();
           for (Specialization var : curentInstance) 
           {
               out.append(var.objectToCsvRow());
                out.newLine();
               
           }
           
           AuditService.writeAudit("SaveChanges","TableSpecialization","Done save Specialization List " );
           
        } catch (IOException e) {
           
              AuditService.writeAudit("SaveChanges","TableSpecialization","Exception: "+e.getMessage() );
              e.printStackTrace();
        }
                
                
            }});
          
          t.run();
        
        
      
    }
    
    
    
    
    
}
