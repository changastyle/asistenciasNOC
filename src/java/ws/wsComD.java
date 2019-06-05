package ws;
import com.google.gson.Gson;
import java.util.*;
import modelo.*;
import modelo.Provincia;
import org.springframework.web.bind.annotation.*;
import utiles.LineaAutoEntendible;
import utiles.ManejoArchivos;
import utiles.ParametroEntender;
import utiles.wsSSH;

@RestController
public class wsComD
{
    @RequestMapping(value = "dameIpDeAg")
    public static List<Sitio> dameIpDeAg
    (@RequestParam(value = "ag") String ag)
    {
        List<Sitio> arrSitiosSalida = new ArrayList<>();
        List<Sitio> arrSitiosTodos = findSitios();
        
        for(Sitio sitioLoop : arrSitiosTodos)
        {
            if(sitioLoop.getNombre().contains(ag))
            {
                arrSitiosSalida.add(sitioLoop);
            }
        }
        
        return arrSitiosSalida;
        
    }
    @RequestMapping(value = "findSitios")
    public static List<Sitio> findSitios()
    {
        List<Sitio> arrSitios = new ArrayList<>();
        
        String rutaArchivo = "C:\\transformer\\salida-comd.txt";
        List<String> lineasLeidas = ManejoArchivos.read(rutaArchivo);
        
        lineasLeidas = lineasLeidas.subList(2, (lineasLeidas.size() - 1) );
        
        for(String strLoop : lineasLeidas)
        {
            System.out.println(strLoop);
        }
        
        //List<String> lineasEntrada = utiles.ManejoArchivos.read(rutaArchivo);
        
        List<ParametroEntender> parametrosList = new ArrayList<ParametroEntender>();
        ParametroEntender parametroIP = new ParametroEntender("ip", "|TCP|C|", "/", null); 
        ParametroEntender parametroNombre = new ParametroEntender("nombre", "-", "|", null);
        
        parametrosList.add(parametroIP);
        parametrosList.add(parametroNombre);
        
        //entender(lineasEntrada, "|TCP|C|","/");
        //entender(lineasEntrada, "-","|");
        
        int contador = 1;
        for(String strLineaLoop : lineasLeidas)
        {
            LineaAutoEntendible lineaAI = new LineaAutoEntendible(strLineaLoop);
            System.out.println("************  " + contador + " *************");
            String nombreSitio = lineaAI.autoentenderme(parametroNombre).getValor();
            System.out.println("AGENCIA:" + nombreSitio );
            
            String ip = lineaAI.autoentenderme(parametroIP).getValor();
            System.out.println("IP:" + ip);
            
            if(nombreSitio != null && ip != null)
            {
                Sitio sitio = new Sitio(nombreSitio, ip);
                arrSitios.add(sitio);
                
            }
            contador++;
        }
        
        return arrSitios;
    }
}
