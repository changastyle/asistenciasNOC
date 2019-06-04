package modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.*;
import javax.persistence.*;

@Entity @Table(name = "motivos")
public class MotivoAsistencia implements Comparable<MotivoAsistencia>
{
    //ATRIBUTOS:
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String motivo;
    
    
    //CONTRUCTOR VACIO:
    public MotivoAsistencia() 
    {
    }
    
    //CONTRUCTOR PARAMETROS SIN LISTAS:
    public MotivoAsistencia(String motivo)
    {
        this.motivo = motivo;
    }


    //<editor-fold desc="GETTERS Y SETTERS:">
    public int getId() 
    {
        return id;
    }
    public String getMotivo() 
    {
        return motivo;
    }

    //SET
    public void setId( int id ) 
    {
        this.id = id;
    }
    public void setMotivo( String motivo ) 
    {
        this.motivo = motivo;
    }
    //</editor-fold>
    
    //@Override
    public String toString()
    {
        String str = "{";
        str += "id:" + id + ", ";
        str += "motivo:" + motivo + ", ";
        
        str += "}";
        
        return str;
    }

 
        
    
    //DYN:

    
    public int compareTo(MotivoAsistencia otro)
    {
        return 1;
    }
    
}
