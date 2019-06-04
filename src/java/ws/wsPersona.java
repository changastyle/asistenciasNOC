package ws;
import com.google.gson.Gson;
import java.util.*;
import modelo.*;
import modelo.Persona;
import org.springframework.web.bind.annotation.*;

@RestController
public class wsPersona
{
    @RequestMapping(value = "findPersonas")
    public static List<Persona> findPersonas()
    {
        List<Persona> personasList = new ArrayList<Persona>();
        
        String jpql = "SELECT p FROM Persona p";
        personasList = dao.DAOEclipse.findAllByJPQL(jpql);
        
        Collections.sort(personasList);
        
        return personasList;
    }
    
    @RequestMapping(value = "guardarPersona")
    public static boolean guardarPersona(@RequestParam(value = "strPersona" , defaultValue = "") String strPersona)
    {
        boolean guarde = false;
        boolean modoEdit = false;
        
        Persona personaDB = null;
        if(strPersona != null)
        {
            try
            {
                Persona personaRecibido = new Gson().fromJson(strPersona, Persona.class);
                
                if(personaRecibido != null)
                {
                    // MODO EDIT:
                    if(personaRecibido.getId() != -1)
                    {
                        personaDB = (Persona) dao.DAOEclipse.get(Persona.class, personaRecibido.getId());
                        
                        if(personaDB != null)
                        {
                            // 0 - ACTUALIZO VALORES DEL OBJ.DB CON LOS DEL OBJ.RECIBIDOS:
                            personaDB.setNombre(personaRecibido.getNombre());
                            guarde = dao.DAOEclipse.update(personaDB);
                        }
                    }
                    else
                    {
                        // 3 - MODO ADD:
                        
                        guarde = dao.DAOEclipse.update(personaRecibido);
                        
                    }
                }
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            
        }
        
        return guarde;
    }
    
    @RequestMapping(value = "getPersona")
    public static Persona getPersona(@RequestParam(value = "idPersona" , defaultValue = "-1") int idPersona)
    {
        Persona personaDB = null;
        
        if(idPersona != -1)
        {
            personaDB = (Persona) dao.DAOEclipse.get(Persona.class, idPersona);
        }
        
        return personaDB;
    }
    @RequestMapping(value = "getPersonaEmpty")
    public Persona getPersonaEmpty()
    {
       Persona personaEmpty = new Persona();
       personaEmpty.setId(-1);
       return personaEmpty;
    }
}
