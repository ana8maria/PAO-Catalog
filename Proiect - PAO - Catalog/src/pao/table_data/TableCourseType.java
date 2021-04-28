
package pao.table_data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import pao.entities.CourseType;
import pao.entities.SchoolClass;
import pao.entities.Specialization;
import pao.services.AuditService;

public class TableCourseType extends ArrayList<CourseType> implements ITableDataCSV {
    
    private static TableCourseType  instance =null;

    public static TableCourseType getInstance() {
        
        if(instance==null){
            instance= new TableCourseType();
        }
        return instance;
    }

    private String pathTable="DataTables\\CourseType.csv";
     private TableCourseType curentInstance=this;
    
    private TableCourseType() {
        
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
            AuditService.writeAudit("SaveChanges","TableCourseType","Create directory path for DataTables "  );
        }
        
        
        try (BufferedWriter out = new BufferedWriter(new FileWriter(pathTable,false))) {
             
           out.append(new SchoolClass().getCsvHeder());
           out.newLine();
           for (CourseType var : curentInstance) 
           {
                out.append(var.objectToCsvRow());
                out.newLine();
               
           }
           
           AuditService.writeAudit("SaveChanges","TableCourseType","Done save TableCourseType List " );
           
        } catch (IOException e) {
           
              AuditService.writeAudit("SaveChanges","TableCourseType","Exception: "+e.getMessage() );
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
                
                CourseType s=new CourseType();
                s.csvRowToObject(thisLine);
                this.add(s);
                
            }   
            
             AuditService.writeAudit("Refresh","TableCourseType","Done refresh list" );
            
         } catch (IOException e) {
           AuditService.writeAudit("Refresh","TableCourseType","Exception: "+e.getMessage() );
        }
    }

      public boolean add(CourseType e) {
        AuditService.writeAudit("add","TableSpecialization","Add "+e.getName()+" in list" );
        return super.add(e); //To change body of generated methods, choose Tools | Templates.
    }

       public boolean remove(Specialization o) {
        
        AuditService.writeAudit("remove","TableSpecialization","Remove "+o.getName() +" from list"  );
        return super.remove(o); //To change body of generated methods, choose Tools | Templates.
    }
       
         @Override
      public boolean contains(Object o) {
         if(o.getClass().equals(String.class) ){
              for (CourseType var : this) 
             {
                 
                 if(var.getName().equalsIgnoreCase(o.toString().trim())) return  true;      
             }
         }else
             if(o.getClass().equals(Specialization.class)){
                
                   for (CourseType var : this) 
                     {
                 
                         if(var.getName().equalsIgnoreCase(((Specialization)o).getName())) return  true;      
                     }
                 
             }

         return false;
    }

    
    
}
