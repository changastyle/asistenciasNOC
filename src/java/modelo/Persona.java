package modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.*;
import javax.persistence.*;

@Entity @Table(name = "personas")
public class Persona implements Comparable<Persona>
{
    //ATRIBUTOS:
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    @ManyToOne() @JoinColumn(name = "fkProvincia") @JsonIgnore
    private Provincia provincia;
    
    
    //CONTRUCTOR VACIO:
    public Persona() 
    {
    }
    
    //CONTRUCTOR PARAMETROS SIN LISTAS:

    public Persona(int id, String nombre)
    {
        this.id = id;
        this.nombre = nombre;
    }
    


    //<editor-fold desc="GETTERS Y SETTERS:">
    public int getId() 
    {
        return id;
    }
    public String getNombre() 
    {
        return nombre;
    }

    public Provincia getProvincia() {
        return provincia;
    }
    

    //SET
    public void setId( int id ) 
    {
        this.id = id;
    }
    public void setNombre( String nombre ) 
    {
        this.nombre = nombre;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }
    
    //</editor-fold>
    
    //@Override
    public String toString()
    {
        String str = "{";
        str += "id:" + id + ", ";
        str += "nombre:" + nombre + ", ";
        
        str += "}";
        
        return str;
    }

 
        
    
    //DYN:

    
    public int compareTo(Persona otro)
    {
        return 1;
    }
    public int getFkProvinciaPadre()
    {
        int fkProvinciaPadre = -1;
        if(provincia != null)
        {
            fkProvinciaPadre = provincia.getId();
        }
        
        return fkProvinciaPadre;
    }
}
