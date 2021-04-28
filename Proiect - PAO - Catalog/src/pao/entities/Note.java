
package pao.entities;

public class Note extends ADataBaseCSV {

    private long  idStudent=-1;
    private long  idProfesor=-1;
    private double Nota=-1;

    public long getIdProfesor() {
        return idProfesor;
    }

    public long getIdStudent() {
        return idStudent;
    }

    public double getNota() {
        return Nota;
    }

    public void setIdProfesor(long idProfesor) {
        this.idProfesor = idProfesor;
    }

    public void setIdStudent(long idStudent) {
        this.idStudent = idStudent;
    }

    public void setNota(double Nota) {
        this.Nota = Nota;
    }
    
    private int indexNota=0;

    public int getIndexNota() {
        return indexNota;
    }

    public void setIndexNota(int indexNota) {
        this.indexNota = indexNota;
    }

    @Override
    public String objectToCsvRow() {
       return id+","+idProfesor+","+idStudent+","+Nota+","+indexNota;
    }

    @Override
    public void csvRowToObject(String row) {
        String[] split=row.split(",");
        
        super.id=Long.parseLong(split[0]);
        this.idProfesor=Long.parseLong(split[1]);
        this.idStudent=Long.parseLong(split[2]);
        this.Nota=Double.parseDouble(split[3]);
        this.indexNota=Integer.parseInt(split[4]);
        
        if(IDSTART<id){
            IDSTART=id;
        }
    }

    @Override
    public String getCsvHeder() {
          return "id,idProfesor,idStudent,Nota,indexNota";
    }
  
}
