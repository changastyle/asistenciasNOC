package ws;
import com.google.gson.Gson;
import java.util.*;
import modelo.*;
import modelo.Operador;
import org.springframework.web.bind.annotation.*;

@RestController
public class wsOperador
{
    @RequestMapping(value = "findOperadors")
    public static List<Operador> findOperadors()
    {
        List<Operador> operadorsList = new ArrayList<Operador>();
        
        String jpql = "SELECT o FROM Operador o";
        operadorsList = dao.DAOEclipse.findAllByJPQL(jpql);
        
        Collections.sort(operadorsList);
        
        return operadorsList;
    }
    
    @RequestMapping(value = "guardarOperador")
    public static boolean guardarOperador(@RequestParam(value = "strOperador" , defaultValue = "") String strOperador)
    {
        boolean guarde = false;
        boolean modoEdit = false;
        
        Operador operadorDB = null;
        if(strOperador != null)
        {
            try
            {
                Operador operadorRecibido = new Gson().fromJson(strOperador, Operador.class);
                
                if(operadorRecibido != null)
                {
                    // MODO EDIT:
                    if(operadorRecibido.getId() != -1)
                    {
                        operadorDB = (Operador) dao.DAOEclipse.get(Operador.class, operadorRecibido.getId());
                        
                        if(operadorDB != null)
                        {
                            // 0 - ACTUALIZO VALORES DEL OBJ.DB CON LOS DEL OBJ.RECIBIDOS:
                            operadorDB.setNombre(operadorRecibido.getNombre());
                            operadorDB.setClave(operadorRecibido.getClave());
                            guarde = dao.DAOEclipse.update(operadorDB);
                        }
                    }
                    else
                    {
                        // 3 - MODO ADD:
                        
                        guarde = dao.DAOEclipse.update(operadorRecibido);
                        
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
    
    @RequestMapping(value = "getOperador")
    public static Operador getOperador(@RequestParam(value = "idOperador" , defaultValue = "-1") int idOperador)
    {
        Operador operadorDB = null;
        
        if(idOperador != -1)
        {
            operadorDB = (Operador) dao.DAOEclipse.get(Operador.class, idOperador);
        }
        
        return operadorDB;
    }
    @RequestMapping(value = "getOperadorEmpty")
    public Operador getOperadorEmpty()
    {
       Operador operadorEmpty = new Operador();
       operadorEmpty.setId(-1);
       return operadorEmpty;
    }
}
