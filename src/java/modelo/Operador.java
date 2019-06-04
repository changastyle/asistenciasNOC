package modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.*;
import javax.persistence.*;

@Entity @Table(name = "operadores")
public class Operador implements Comparable<Operador>
{
    //ATRIBUTOS:
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String clave;
    private String nombre;
    
    
    //CONTRUCTOR VACIO:
    public Operador() 
    {
    }
    
    //CONTRUCTOR PARAMETROS SIN LISTAS:
    public Operador(String clave,String nombre)
    {
        this.clave = clave;
        this.nombre = nombre;
    }


    //<editor-fold desc="GETTERS Y SETTERS:">
    public int getId() 
    {
        return id;
    }
    public String getClave() 
    {
        return clave;
    }
    public String getNombre() 
    {
        return nombre;
    }

    //SET
    public void setId( int id ) 
    {
        this.id = id;
    }
    public void setClave( String clave ) 
    {
        this.clave = clave;
    }
    public void setNombre( String nombre ) 
    {
        this.nombre = nombre;
    }
    //</editor-fold>
    
    //@Override
    public String toString()
    {
        String str = "{";
        str += "id:" + id + ", ";
        str += "clave:" + clave + ", ";
        str += "nombre:" + nombre + ", ";
        
        str += "}";
        
        return str;
    }

 
        
    
    //DYN:

    
    public int compareTo(Operador otro)
    {
        return 1;
    }
    
}
