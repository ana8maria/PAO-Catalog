
package pao.entities;

import pao.table_data.TableSchoolClass;

public class Student extends Person  {
 
    public  Student(){
        super();
    }
    
    private long idSchoolClass=-1;

    private SchoolClass schoolClass=null;
  
    public SchoolClass getSchoolClass(){
        
        if(idSchoolClass==-1) return null;
        if(schoolClass!=null){
            return  schoolClass;
        }
        
        
        for(SchoolClass var : TableSchoolClass.getInstance()){
            
            if(var.getId()==idSchoolClass){
                schoolClass=var;
                return schoolClass;
            }
            
        }
        
        return null;

    }
    
    public void setScoolClass( SchoolClass var ){
        schoolClass=var;
        
        if(schoolClass==null){
            idSchoolClass=-1;
        }else{
            idSchoolClass=schoolClass.getId();
        }
        
    }

    @Override
    public String objectToCsvRow() {
       return super.objectToCsvRow()+","+idSchoolClass;
 
    }

    @Override
    public void csvRowToObject(String row) {
      super.csvRowToObject(row);
      
      
        String[] split=row.split(",");
         
        idSchoolClass=Long.parseLong(split[4]);

    }

    @Override
    public String getCsvHeder() {
        return super.getCsvHeder()+",idClasa";
    }

    @Override
    public String toString() {
 
        return super.toString()+" (CLASA:"+ (getSchoolClass()==null ? "":getSchoolClass().toString())+")";
               
    }
    
    
    
    
    
    
}
