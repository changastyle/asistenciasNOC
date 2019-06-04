package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Provincia;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-03T17:09:18")
@StaticMetamodel(Persona.class)
public class Persona_ { 

    public static volatile SingularAttribute<Persona, String> clave;
    public static volatile SingularAttribute<Persona, Integer> id;
    public static volatile SingularAttribute<Persona, Provincia> provincia;
    public static volatile SingularAttribute<Persona, String> nombre;

}