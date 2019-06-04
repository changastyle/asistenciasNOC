package ws;
import com.google.gson.Gson;
import java.util.*;
import modelo.*;
import modelo.Asistencia;
import org.springframework.web.bind.annotation.*;

@RestController
public class wsAsistencia
{
    @RequestMapping(value = "findAsistencias")
    public static List<Asistencia> findAsistencias()
    {
        List<Asistencia> asistenciasList = new ArrayList<Asistencia>();
        
        String jpql = "SELECT a FROM Asistencia a";
        asistenciasList = dao.DAOEclipse.findAllByJPQL(jpql);
        
        Collections.sort(asistenciasList);
        
        return asistenciasList;
    }
    
    @RequestMapping(value = "guardarAsistencia")
    public static boolean guardarAsistencia(@RequestParam(value = "strAsistencia" , defaultValue = "") String strAsistencia)
    {
        boolean guarde = false;
        boolean modoEdit = false;
        
        Asistencia asistenciaDB = null;
        if(strAsistencia != null)
        {
            try
            {
                Asistencia asistenciaRecibido = new Gson().fromJson(strAsistencia, Asistencia.class);
                
                if(asistenciaRecibido != null)
                {
                    // MODO EDIT:
                    if(asistenciaRecibido.getId() != -1)
                    {
                        asistenciaDB = (Asistencia) dao.DAOEclipse.get(Asistencia.class, asistenciaRecibido.getId());
                        
                        if(asistenciaDB != null)
                        {
                            // 0 - ACTUALIZO VALORES DEL OBJ.DB CON LOS DEL OBJ.RECIBIDOS:
                            asistenciaDB.setTitulo(asistenciaRecibido.getTitulo());
                            asistenciaDB.setDescripcion(asistenciaRecibido.getDescripcion());
                            asistenciaDB.setMotivo(asistenciaRecibido.getMotivo());
                            asistenciaDB.setOperador(asistenciaRecibido.getOperador());
                            asistenciaDB.setHora(asistenciaRecibido.getHora());
                            asistenciaDB.setDuracionMinutos(asistenciaRecibido.getDuracionMinutos());
                            guarde = dao.DAOEclipse.update(asistenciaDB);
                        }
                    }
                    else
                    {
                        // 3 - MODO ADD:
                        
                        guarde = dao.DAOEclipse.update(asistenciaRecibido);
                        
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
    
    @RequestMapping(value = "getAsistencia")
    public static Asistencia getAsistencia(@RequestParam(value = "idAsistencia" , defaultValue = "-1") int idAsistencia)
    {
        Asistencia asistenciaDB = null;
        
        if(idAsistencia != -1)
        {
            asistenciaDB = (Asistencia) dao.DAOEclipse.get(Asistencia.class, idAsistencia);
        }
        
        return asistenciaDB;
    }
    @RequestMapping(value = "getAsistenciaEmpty")
    public Asistencia getAsistenciaEmpty()
    {
       Asistencia asistenciaEmpty = new Asistencia();
       asistenciaEmpty.setId(-1);
       return asistenciaEmpty;
    }
}
