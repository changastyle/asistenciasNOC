
import java.util.ArrayList;
import java.util.List;
import utiles.LineaAutoEntendible;
import utiles.ParametroEntender;

public class Main
{
    public static void main (String args[])
    {
        String rutaArchivo = "C:\\transformer\\input-lineas-comd.txt";
        List<String> lineasEntrada = utiles.ManejoArchivos.read(rutaArchivo);
        
        List<ParametroEntender> parametrosList = new ArrayList<ParametroEntender>();
        ParametroEntender parametroIP = new ParametroEntender("ip", "|TCP|C|", "/", null); 
        ParametroEntender parametroNombre = new ParametroEntender("nombre", "-", "|", null);
        
        parametrosList.add(parametroIP);
        parametrosList.add(parametroNombre);
        
        //entender(lineasEntrada, "|TCP|C|","/");
        //entender(lineasEntrada, "-","|");
        
        int contador = 1;
        for(String strLineaLoop : lineasEntrada)
        {
            LineaAutoEntendible lineaAI = new LineaAutoEntendible(strLineaLoop);
            System.out.println("************  " + contador + " *************");
            System.out.println("AGENCIA:" + lineaAI.autoentenderme(parametroNombre).getValor());
            System.out.println("IP:" + lineaAI.autoentenderme(parametroIP).getValor());
            contador++;
        }
        
       // System.out.println("*************************");
        /*for(RtaParametroEntender rtaLoop :entender2(lineasEntrada,parametrosList) )
        {
            System.out.println(rtaLoop.toString());
            System.out.println("-*-*-*");
        }*/
        
    }
    
   /* public static List<RtaParametroEntender> entender2(List<String> lineasEntrada, List<ParametroEntender> arrParametros)
    {
        List<RtaParametroEntender> arrRespuesta = new ArrayList<>();
        
        for(String linea : lineasEntrada)
        {
            RtaParametroEntender rta = new RtaParametroEntender();
            
            System.out.println("todo: " + linea);
            
            for(ParametroEntender parametroLoop : arrParametros)
            {
                String medio = "";
                
                String comienzo = parametroLoop.getComienzo();
                String fin = parametroLoop.getFin();
                if(linea.contains(comienzo)&& linea.contains(fin))
                {
                    //int posComienzo =  (linea.lastIndexOf(comienzo) + comienzo.length() ) ;
                    int posComienzo =  (linea.indexOf(comienzo) + comienzo.length() ) ;
                    int posFin =  (linea.indexOf(fin) - fin.length()  + 1 ) ;

                    medio = linea.substring(posComienzo, posFin );
                    //System.out.println("poss: " + posComienzo + " | " + posFin);
                    parametroLoop.setValor(medio);
                    rta.getArrParametros().add(parametroLoop);
                    System.out.println("RTA:" + parametroLoop.getNombre()+ ": " + medio);
                    
                }
            }
            System.out.println("-----");
            
        }
        return arrRespuesta;
    }*/
    
    public static void entender(List<String> lineasEntrada, String comienzo , String fin)
    {
        for(String linea : lineasEntrada)
        {
            String medio = "";
            System.out.println("todo: " + linea);
            
            if(linea.contains(comienzo)&& linea.contains(fin))
            {
                //int posComienzo =  (linea.lastIndexOf(comienzo) + comienzo.length() ) ;
                int posComienzo =  (linea.indexOf(comienzo) + comienzo.length() ) ;
                int posFin =  (linea.indexOf(fin) - fin.length()  + 1 ) ;
                
                medio = linea.substring(posComienzo, posFin );
                //System.out.println("poss: " + posComienzo + " | " + posFin);
                System.out.println("meim: " + medio);
                System.out.println("-----");
            }
            
            
           
            
            
            /* 
            if(s != null)
            {
                if(estadoActual == estados.get(0) && s.contains("EVENT["))
                {
                    //System.out.println(contador + " -> " + s);
                    estadoActual =  estados.get(1);
                }
                if(estadoActual == estados.get(1) && s.contains("]"))
                {
                    int indiceApertura = (s.indexOf("EVENT[") + 6);
                    int indiceCierre = s.indexOf("]");
                    idUltimoEvento = s.substring(indiceApertura, indiceCierre);
                    estadoActual =  estados.get(2);
                }
                if(estadoActual == estados.get(2) && s.contains("Sts:"))
                {
                    int indiceApertura = s.indexOf("Sts:");
                    int indiceCierre = s.indexOf("(");
                    String estado = s.substring( (indiceApertura + 4) ,indiceCierre);
                    if(!estado.equalsIgnoreCase("Payout"))
                    {
                        System.out.println("Evento[" + idUltimoEvento + "] - estado: " + estado );
                    }

                    estadoActual = estados.get(0);

                }
                else
                {
                    //System.out.println(contador + " | " + s);
                }*/
            }

    }
}
