package modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.*;
import javax.persistence.*;

@Entity @Table(name = "asistencias")
public class Asistencia implements Comparable<Asistencia>
{
    //ATRIBUTOS:
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String descripcion;
    private int duracionMinutos;
    @Temporal(TemporalType.TIMESTAMP)
    private Date hora;
    private String titulo;
    @OneToOne() @JoinColumn(name = "fkMotivo")
    private MotivoAsistencia motivo;
    @OneToOne() @JoinColumn(name = "fkOperador")
    private Operador operador;
    
    
    //CONTRUCTOR VACIO:
    public Asistencia() 
    {
    }
    
    //CONTRUCTOR PARAMETROS SIN LISTAS:
    public Asistencia(String descripcion,int duracionMinutos,Date hora,String titulo,MotivoAsistencia motivo,Operador operador)
    {
        this.descripcion = descripcion;
        this.duracionMinutos = duracionMinutos;
        this.hora = hora;
        this.titulo = titulo;
        this.motivo = motivo;
        this.operador = operador;
    }


    //<editor-fold desc="GETTERS Y SETTERS:">
    public int getId() 
    {
        return id;
    }
    public String getDescripcion() 
    {
        return descripcion;
    }
    public int getDuracionMinutos() 
    {
        return duracionMinutos;
    }
    public Date getHora() 
    {
        return hora;
    }
    public String getTitulo() 
    {
        return titulo;
    }
    public MotivoAsistencia getMotivo() 
    {
        return motivo;
    }
    public Operador getOperador() 
    {
        return operador;
    }

    //SET
    public void setId( int id ) 
    {
        this.id = id;
    }
    public void setDescripcion( String descripcion ) 
    {
        this.descripcion = descripcion;
    }
    public void setDuracionMinutos( int duracionMinutos ) 
    {
        this.duracionMinutos = duracionMinutos;
    }
    public void setHora( Date hora ) 
    {
        this.hora = hora;
    }
    public void setTitulo( String titulo ) 
    {
        this.titulo = titulo;
    }
    public void setMotivo( MotivoAsistencia motivo ) 
    {
        this.motivo = motivo;
    }
    public void setOperador( Operador operador ) 
    {
        this.operador = operador;
    }
    //</editor-fold>
    
    //@Override
    public String toString()
    {
        String str = "{";
        str += "id:" + id + ", ";
        str += "descripcion:" + descripcion + ", ";
        str += "duracionMinutos:" + duracionMinutos + ", ";
        str += "hora:" + hora + ", ";
        str += "titulo:" + titulo + ", ";
        str += "motivo:" + motivo + ", ";
        str += "operador:" + operador + ", ";
        
        str += "}";
        
        return str;
    }

 
        
    
    //DYN:

    
    public int compareTo(Asistencia otro)
    {
        return 1;
    }
    
}
