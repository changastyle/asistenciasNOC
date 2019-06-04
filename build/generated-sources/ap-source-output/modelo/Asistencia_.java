package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.MotivoAsistencia;
import modelo.Operador;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-03T17:09:18")
@StaticMetamodel(Asistencia.class)
public class Asistencia_ { 

    public static volatile SingularAttribute<Asistencia, String> descripcion;
    public static volatile SingularAttribute<Asistencia, MotivoAsistencia> motivo;
    public static volatile SingularAttribute<Asistencia, Date> hora;
    public static volatile SingularAttribute<Asistencia, String> titulo;
    public static volatile SingularAttribute<Asistencia, Integer> duracionMinutos;
    public static volatile SingularAttribute<Asistencia, Integer> id;
    public static volatile SingularAttribute<Asistencia, Operador> operador;

}