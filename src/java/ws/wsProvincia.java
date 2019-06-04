package ws;
import com.google.gson.Gson;
import java.util.*;
import modelo.*;
import modelo.Provincia;
import org.springframework.web.bind.annotation.*;

@RestController
public class wsProvincia
{
    @RequestMapping(value = "findProvincias")
    public static List<Provincia> findProvincias()
    {
        List<Provincia> provinciasList = new ArrayList<Provincia>();
        
        String jpql = "SELECT p FROM Provincia p";
        provinciasList = dao.DAOEclipse.findAllByJPQL(jpql);
        
        Collections.sort(provinciasList);
        
        return provinciasList;
    }
    
    @RequestMapping(value = "guardarProvincia")
    public static boolean guardarProvincia(@RequestParam(value = "strProvincia" , defaultValue = "") String strProvincia)
    {
        boolean guarde = false;
        boolean modoEdit = false;
        
        Provincia provinciaDB = null;
        if(strProvincia != null)
        {
            try
            {
                Provincia provinciaRecibido = new Gson().fromJson(strProvincia, Provincia.class);
                
                if(provinciaRecibido != null)
                {
                    // MODO EDIT:
                    if(provinciaRecibido.getId() != -1)
                    {
                        provinciaDB = (Provincia) dao.DAOEclipse.get(Provincia.class, provinciaRecibido.getId());
                        
                        if(provinciaDB != null)
                        {
                            // 0 - ACTUALIZO VALORES DEL OBJ.DB CON LOS DEL OBJ.RECIBIDOS:
                            provinciaDB.setNombre(provinciaRecibido.getNombre());
                            
                            // ---- PERSONASLISTS ----
                            // 1 - BORRO TODAS/OS LAS/LOS PERSONASLISTS DE ANTES:
                            boolean borreTodos1 = true;
                            for(Persona personasListLoop: provinciaDB.getPersonasList())
                            {
                                boolean borreEsta = dao.DAOEclipse.remove(personasListLoop);
                                if(!borreEsta)
                                {
                                    borreTodos1 = false;
                                }
                            }
                            
                            // 2 - ASOCIO LAS/LOS NUEVAS/OS PERSONASLISTS:
                            provinciaDB.setPersonasList(provinciaRecibido.getPersonasList());
                                                 
                            if( borreTodos1 )
                            {
                                guarde = dao.DAOEclipse.update(provinciaDB);
                            }
                        }
                    }
                    else
                    {
                        // 3 - MODO ADD:
                        
                        // ---- ASOCIO PERSONAS ----
                        for(Persona personaLoop: provinciaRecibido.getPersonasList())
                        {
                            personaLoop.setProvincia(provinciaRecibido);
                        }
                        
                        guarde = dao.DAOEclipse.update(provinciaRecibido);
                        
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
    
    @RequestMapping(value = "getProvincia")
    public static Provincia getProvincia(@RequestParam(value = "idProvincia" , defaultValue = "-1") int idProvincia)
    {
        Provincia provinciaDB = null;
        
        if(idProvincia != -1)
        {
            provinciaDB = (Provincia) dao.DAOEclipse.get(Provincia.class, idProvincia);
        }
        
        return provinciaDB;
    }
    @RequestMapping(value = "getProvinciaEmpty")
    public Provincia getProvinciaEmpty()
    {
       Provincia provinciaEmpty = new Provincia();
       provinciaEmpty.setId(-1);
       return provinciaEmpty;
    }
}
