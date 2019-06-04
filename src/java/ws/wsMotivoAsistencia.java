package ws;
import com.google.gson.Gson;
import java.util.*;
import modelo.*;
import modelo.MotivoAsistencia;
import org.springframework.web.bind.annotation.*;

@RestController
public class wsMotivoAsistencia
{
    @RequestMapping(value = "findMotivos")
    public static List<MotivoAsistencia> findMotivos()
    {
        List<MotivoAsistencia> motivoAsistenciasList = new ArrayList<MotivoAsistencia>();
        
        String jpql = "SELECT m FROM MotivoAsistencia m";
        motivoAsistenciasList = dao.DAOEclipse.findAllByJPQL(jpql);
        
        Collections.sort(motivoAsistenciasList);
        
        return motivoAsistenciasList;
    }
    
    @RequestMapping(value = "guardarMotivoAsistencia")
    public static boolean guardarMotivoAsistencia(@RequestParam(value = "strMotivoAsistencia" , defaultValue = "") String strMotivoAsistencia)
    {
        boolean guarde = false;
        boolean modoEdit = false;
        
        MotivoAsistencia motivoAsistenciaDB = null;
        if(strMotivoAsistencia != null)
        {
            try
            {
                MotivoAsistencia motivoAsistenciaRecibido = new Gson().fromJson(strMotivoAsistencia, MotivoAsistencia.class);
                
                if(motivoAsistenciaRecibido != null)
                {
                    // MODO EDIT:
                    if(motivoAsistenciaRecibido.getId() != -1)
                    {
                        motivoAsistenciaDB = (MotivoAsistencia) dao.DAOEclipse.get(MotivoAsistencia.class, motivoAsistenciaRecibido.getId());
                        
                        if(motivoAsistenciaDB != null)
                        {
                            // 0 - ACTUALIZO VALORES DEL OBJ.DB CON LOS DEL OBJ.RECIBIDOS:
                            motivoAsistenciaDB.setMotivo(motivoAsistenciaRecibido.getMotivo());
                            guarde = dao.DAOEclipse.update(motivoAsistenciaDB);
                        }
                    }
                    else
                    {
                        // 3 - MODO ADD:
                        
                        guarde = dao.DAOEclipse.update(motivoAsistenciaRecibido);
                        
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
    
    @RequestMapping(value = "getMotivoAsistencia")
    public static MotivoAsistencia getMotivoAsistencia(@RequestParam(value = "idMotivoAsistencia" , defaultValue = "-1") int idMotivoAsistencia)
    {
        MotivoAsistencia motivoAsistenciaDB = null;
        
        if(idMotivoAsistencia != -1)
        {
            motivoAsistenciaDB = (MotivoAsistencia) dao.DAOEclipse.get(MotivoAsistencia.class, idMotivoAsistencia);
        }
        
        return motivoAsistenciaDB;
    }
    @RequestMapping(value = "getMotivoAsistenciaEmpty")
    public MotivoAsistencia getMotivoAsistenciaEmpty()
    {
       MotivoAsistencia motivoAsistenciaEmpty = new MotivoAsistencia();
       motivoAsistenciaEmpty.setId(-1);
       return motivoAsistenciaEmpty;
    }
}
