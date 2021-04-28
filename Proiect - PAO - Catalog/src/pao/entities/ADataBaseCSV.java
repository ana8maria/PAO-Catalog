package pao.entities;

public abstract  class  ADataBaseCSV {
    
    protected static long IDSTART=0;
     
    protected long id=-1;

    public long getId() {
        return id;
    }
    
    public  void GenerateId(){
      
        if(id==-1){
             id=++IDSTART;
        } 
    }
  
    public abstract String objectToCsvRow();
    
    
    public abstract void csvRowToObject(String row);
        
    
    public  abstract  String getCsvHeder();
    
    
}
