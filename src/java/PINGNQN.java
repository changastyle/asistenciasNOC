
import java.io.File;
import java.util.List;

public class PINGNQN
{
    public static void main(String args[])
    {
        String rutaCarpeta = "C:\\jtemp\\";
        String rutaArchivo = "NQNCOMM1.txt";
        System.out.println("LEO ARCHIVO NQN");
        
        
        String rutaCompleta = rutaCarpeta + File.separator + rutaArchivo;
        
        List<String> arrLineas = archivos.ManejoArchivos.read2(rutaCompleta);
        
        System.out.println("EL ARCHIVO: " +  rutaCompleta + " TIENE " + arrLineas.size() + " LINEAS");
        
        for(String lineaLoop : arrLineas)
        {
            String salida = "";
            
            String[] arrSplit = lineaLoop.split("\\|");
            
//            System.out.println("arrSplit: " + arrSplit.length);
            String descripcionLinea = arrSplit[0];
            String ipPrimaria = arrSplit[3];
            if(ipPrimaria != null)
            {
                if(ipPrimaria.length() > 0)
                {
                    int posSlash = ipPrimaria.lastIndexOf("/");
                    ipPrimaria = ipPrimaria.substring(0, posSlash);
                }
            }
            
            
            String[] arrSplit2 = ipPrimaria.split("\\.");
            String ultimoDigito = arrSplit2[3]; 
            int numIpActual = Integer.parseInt(ultimoDigito);
            int numeroMenos = numIpActual - 1;
            String unaIPMenos = arrSplit2[0] + "." +arrSplit2[1] + "." + arrSplit2[2] + "." + numeroMenos;
//            System.out.println("arrSplit2:" + arrSplit2.length);
            
//            System.out.println("DESCRIPCION: " + descripcionLinea);
//            System.out.println("IP ACTUAL: " + ipPrimaria);
//            System.out.println("UNA IP MENOS: " + unaIPMenos );
            
            if(!utiles.wsSSH.ping(ipPrimaria))
            {
//                System.out.println("LINEA:" + lineaLoop);
                
                salida += descripcionLinea + ";";
//                System.out.println("DESCRIPCION: " + descripcionLinea);
                salida += ipPrimaria + ";";
                salida += "0;";
//                System.out.println("IP ACTUAL: " + ipPrimaria);
//                System.out.println("UNA IP MENOS: " + unaIPMenos );
                
//                System.out.println("NO RESPONDIO EL FLEX: " + ipPrimaria);
                salida += unaIPMenos + ";";
                if(utiles.wsSSH.ping(unaIPMenos))
                {
                    salida += "1;";
//                    System.out.println("RESPONDIO OK EL UBI: " + unaIPMenos);
                    
                    if(StatusUBI.ubiEstaUnplugged(unaIPMenos))
                    {
                        salida +=  "UNPLUGGED;";
                    }
                    else
                    {
                        salida +=  "OK;";
                    }
//                    System.out.println("UBI UNPLUGGED: " + StatusUBI.ubiEstaUnplugged(unaIPMenos));
                }
                else
                {
                    salida += "0;";
//                    System.out.println("!!!!! NO RESPONDIO EL UBI: " + unaIPMenos);
                }
//                System.out.println("----");
            }
            else
            {
                salida += "OPERATIVO: " + descripcionLinea + ";;;;;";
//                    System.out.println("LINEA:" + lineaLoop);
//                System.out.println("DESCRIPCION: " + descripcionLinea);
//                System.out.println("IP ACTUAL: " + ipPrimaria);
//                System.out.println("UNA IP MENOS: " + unaIPMenos );
//                System.out.println("FLEX OK");
//                System.out.println("----");
            }
            
//            salida += "\n ----------";
            System.out.println(salida);
            
            
        }
    }
}
