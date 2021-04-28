
package pao.entities;

import static pao.entities.ADataBaseCSV.IDSTART;

public class CourseType extends ADataBaseCSV {
    
    public  CourseType(String name){
        
        GenerateId();
        
        this.name=name.toUpperCase().trim();

    }
    
     public  CourseType(){
        
     }
    
    private String name="";

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return  name;
    }

    @Override
    public String objectToCsvRow() {
       return id+","+name;
    }

    @Override
    public void csvRowToObject(String row) {
        
        String[] split=row.split(",");
        
        super.id=Long.parseLong(split[0]);
        this.name=split[1];
        
        if(IDSTART<id){
            IDSTART=id;
        }
 
    }

    @Override
    public String getCsvHeder() {
       
        return "id,materie";
        
    }
    
}
