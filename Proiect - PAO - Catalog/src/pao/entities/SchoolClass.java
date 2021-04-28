
package pao.entities;

public class SchoolClass  extends ADataBaseCSV implements  Comparable<SchoolClass>{

    
       public SchoolClass(String specialization, int clasa, String indicator)
       {
         GenerateId();
        
        this.specialization=specialization.toUpperCase().trim();
        this.clasa=clasa;
        this.indicator=indicator.toUpperCase().trim();

    }
 
     public SchoolClass(){

     }
    private String specialization;

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
     
    private int clasa;

    public int getClasa() {
        return clasa;
    }

    public void setClasa(int clasa) {
        this.clasa = clasa;
    }
       
    private String indicator="";

    public String getIndicator() {
        return indicator;
    }

    public void setIndicator(String indicator) {
        this.indicator = indicator;
    }

    @Override
    public String toString() {
        return   "Clasa: "+Clasa()+"- "+indicator + " Profilul: "+specialization;
                
    }

    public int Clasa(){
       return   clasa;
        
    }
    @Override
    public String objectToCsvRow() {
       return id+","+specialization+","+clasa+","+indicator;
    }

    @Override
    public void csvRowToObject(String row) {
       String[] split=row.split(",");
        
        super.id=Long.parseLong(split[0]);
        this.specialization=split[1];
        this.clasa=Integer.parseInt(split[2]);
        this.indicator=split[3];
        
        if(IDSTART<id){
            IDSTART=id;
        }
    }

    @Override
    public String getCsvHeder() {
       return "id,profil,clasa,indicator";
    }

    @Override
    public int compareTo(SchoolClass o) {
        
        
         if(specialization==o.specialization && clasa==o.clasa && indicator== o.indicator)
         {
             return 0;
         }
         else
         {
             int comp1=specialization.compareTo(o.specialization);
             
             int comp2=indicator.compareTo(o.indicator);
             
             return  comp1+comp2+(clasa>o.clasa?1:-1);
             
            
             
         }
    }
    
}
