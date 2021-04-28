
package pao.entities;

import pao.table_data.TableSchoolClass;

public class Professor extends Person{

     public  Professor(){
      
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

    protected  String courseType="";

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }
 
    @Override
    public String objectToCsvRow() {
       return super.objectToCsvRow()+","+idSchoolClass+","+courseType;
    }

    @Override
    public void csvRowToObject(String row) {
        super.csvRowToObject(row);
        String[] split=row.split(",");
        idSchoolClass=Long.parseLong(split[4]);
        courseType=split[5];        
    }

    @Override
    public String getCsvHeder() {
        return super.getCsvHeder()+",idSchoolClass,materie";
    }

    @Override
    public String toString() 
    {
        return super.toString()+ " "+courseType+" "+(getSchoolClass()==null ? "":getSchoolClass().toString());
    }
    
}
