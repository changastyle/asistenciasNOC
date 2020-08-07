
import java.util.ArrayList;
import java.util.List;
import modelo.Sitio;
import utiles.wsSSH;
import ws.wsComD;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nico-NOC
 */
public class Main2
{
    public static void main(String args[])
    {
        List<Sitio> arrSitiosNOT = new ArrayList<Sitio>();
        List<Sitio> arrSitiosOKNOPuertos = new ArrayList<Sitio>();
        List<Sitio> arrSitiosOK = new ArrayList<Sitio>();
        List<Sitio> arrSitios = wsComD.findSitios();
        List<Sitio> arrSitiosYaProcesados = new ArrayList<Sitio>();
        System.out.println("LINEAS: " + arrSitios.size());
        
        System.out.println("COMIENZO A PINGEAR:");
        int contador = 1;
        boolean deboScanearPuertos = false;
        for(Sitio sitio : arrSitios)
        {
            
            String direccionIP = "172.20.168.108";
            String user = "root";
            String pass = "tecacc";
            String comando = "/scripts/getusbserial";
            
            List<String> arrRtas = wsSSH.ssh(direccionIP, user, pass, 2200, comando , false);
           
            boolean ok = utiles.wsSSH.ping(sitio.getIp());

            if( !yaProcesado(arrSitiosYaProcesados, sitio.getIp())) 
            {
                System.out.println(contador + " - ip:" + sitio.getIp() + "| " + ok);
                contador++;
                if(ok)
                {
                    boolean andanPuertos = false;

                    if(arrRtas != null)
                    {
                        if( arrRtas.size() > 0 )
                        {
                            String lineaRespuesta = arrRtas.get(0);

                            System.out.println("linea-rta: " + lineaRespuesta);
                            if(lineaRespuesta.contains("MUX port"))
                            {
                                andanPuertos = true;
                            }
                        }
                    }

                    if(deboScanearPuertos)
                    {
                        if(ok && andanPuertos)
                        {
                            arrSitiosOK.add(sitio);
                        }
                        else
                        {
                            arrSitiosOKNOPuertos.add(sitio);
                        }
                    }
                    else
                    {
                         arrSitiosOK.add(sitio);
                    }
                }
                else
                {
                    arrSitiosNOT.add(sitio);
                }
                arrSitiosYaProcesados.add(sitio);
            }
            
            

            
            
//             System.out.println(direccionIP + " -> andanPuertos : " + andanPuertos);
        }
        
        System.out.println("------------- CORRECTOs:");
        for(Sitio sitio : arrSitiosOK)
        {
            String nombreSitio = sitio.getNombre();
            String localidad = "";
            String agencia = "";
            int posGuion = nombreSitio.indexOf("-");
            if( posGuion != -1)
            {
                localidad = nombreSitio.substring(0 , posGuion -1);
                agencia = nombreSitio.substring(posGuion + 1 , nombreSitio.length()-1);
            }
            
            
            System.out.println(localidad +";" + agencia + ";" + sitio.getIp());
        }
        System.out.println("------------------- NO ANDAN:");
        for(Sitio sitio : arrSitiosNOT)
        {
            String nombreSitio = sitio.getNombre();
            String localidad = "";
            String agencia = "";
            int posGuion = nombreSitio.indexOf("-");
            if( posGuion != -1)
            {
                localidad = nombreSitio.substring(0 , posGuion -1);
                agencia = nombreSitio.substring(posGuion + 1 , nombreSitio.length()-1);
            }
            
            
            System.out.println(localidad +";" + agencia + ";" + sitio.getIp());
        }
        System.out.println("------------------- NO ANDAN PUERTOS:");
        for(Sitio sitio : arrSitiosOKNOPuertos)
        {
            String nombreSitio = sitio.getNombre();
            String localidad = "";
            String agencia = "";
            int posGuion = nombreSitio.indexOf("-");
            if( posGuion != -1)
            {
                localidad = nombreSitio.substring(0 , posGuion -1);
                agencia = nombreSitio.substring(posGuion + 1 , nombreSitio.length()-1);
            }
            
            
            System.out.println(localidad +";" + agencia + ";" + sitio.getIp());
        }
    }
    public static boolean yaProcesado(List<Sitio> arrSitiosYaProcesados , String direccionIP)
    {
        boolean yaEstaba = false;
        
        if(arrSitiosYaProcesados != null)
        {
            for(Sitio sitioLoop: arrSitiosYaProcesados)
            {
                if(sitioLoop.getIp().equalsIgnoreCase(direccionIP))
                {
                    yaEstaba = true;
                }
            }
        }
        
        return yaEstaba;
    }
}
