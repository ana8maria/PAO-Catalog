
package pao.entities;

public class Person extends ADataBaseCSV{
     
     public Person(){
        
      }
   
    protected String name;
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    

    protected String lastName;
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    protected String  city="";
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String objectToCsvRow() {
      
        return id+","+name+","+lastName+","+city;  
    }

    @Override
    public void csvRowToObject(String row) {
       
         String[] split=row.split(",");
        
        super.id=Long.parseLong(split[0]);
        this.name=split[1];
        this.lastName=split[2];
        this.city=split[4];
        
        if(IDSTART<id){
            IDSTART=id;
        }
        
    }

    @Override
    public  String getCsvHeder() {
     return "id,prenume,nume,oras";
    }

    @Override
    public String toString() {
       return name+" "+lastName;
    } 
}
