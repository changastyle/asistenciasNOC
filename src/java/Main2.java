
import java.util.ArrayList;
import java.util.List;
import modelo.Sitio;
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
        List<Sitio> arrSitiosNOK = new ArrayList<Sitio>();
        List<Sitio> arrSitiosOK = new ArrayList<Sitio>();
        List<Sitio> arrSitios = wsComD.findSitios();
        System.out.println("LINEAS: " + arrSitios.size());
        
        System.out.println("COMIENZO A PINGEAR:");
        int contador = 1;
        for(Sitio sitio : arrSitios)
        {
//            Thread t = new  Thread(new Runnable()
//            {
//                public void run()
//                {
                    boolean ok = utiles.wsSSH.ping(sitio.getIp());
                    System.out.println(contador + " - ip:" + sitio.getIp() + "| " + ok);
                    contador++;

                    if(ok)
                    {
                        arrSitiosOK.add(sitio);
                    }
                    else
                    {
                        arrSitiosNOK.add(sitio);
                    }
//                }
//            });
            
//            t.start();
            
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
        for(Sitio sitio : arrSitiosNOK)
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
}
