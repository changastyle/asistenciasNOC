package modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.*;
import javax.persistence.*;

@Entity @Table(name = "provincias")
public class Provincia implements Comparable<Provincia>
{
    //ATRIBUTOS:
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "provincia")
    private List<Persona> personasList;
    
    
    //CONTRUCTOR VACIO:
    public Provincia() 
    {
        personasList = new ArrayList<>();
    }
    
    //CONTRUCTOR PARAMETROS SIN LISTAS:
    public Provincia(String nombre)
    {
        this.nombre = nombre;
        this.personasList = new ArrayList<>();
    }
    
    //CONTRUCTOR PARAMETROS CON LISTAS:
    public Provincia(String nombre,List<Persona> personasList)
    {
        this.nombre = nombre;
        this.personasList = new ArrayList<>();
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
    public List<Persona> getPersonasList() 
    {
        return personasList;
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
    public void setPersonasList( List<Persona> personasList ) 
    {
        this.personasList = personasList;
        for(Persona personaLoop : personasList)
        {
            personaLoop.setProvincia(this);
        }
    }
   public boolean addPersona(Persona persona)
   {
       boolean agregue = false;
       
       persona.setProvincia(this);
       this.personasList.add(persona);
    
       return agregue;
   }
    //</editor-fold>
    
    //@Override
    public String toString()
    {
        String str = "{";
        str += "id:" + id + ", ";
        str += "nombre:" + nombre + ", ";
        
        if( personasList != null) 
        {
            str += "personasList:" + personasList.size() + ", ";
        }
        
        str += "}";
        
        return str;
    }

 
        
    
    //DYN:

    
    public int compareTo(Provincia otro)
    {
        return 1;
    }
    
}
