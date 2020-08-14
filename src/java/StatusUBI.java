
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.StringReader;
import java.util.List;
import org.json.JSONObject;
import parsers.ParserStatusUBI;

public class StatusUBI
{
    public static void main(String args[])
    {
//        String direccionIP = "192.168.28.211";
        String direccionIP = "172.26.1.228";
        
        System.out.println("DIRECCION IP UBI:" + direccionIP + " | unplugged: " + ubiEstaUnplugged(direccionIP));
    }
    
    public static boolean ubiEstaUnplugged(String direccionIP)
    {
        boolean unplugged = true;
//        String direccionIP = "192.168.28.211";
//        System.out.println("HACIENDO SSH A " + direccionIP);
        
        // 1 - HAGO SSH A UBI - CON EL COMANDO STATUS.CGI
        List<String> arrLineas = utiles.wsSSH.ssh(direccionIP, "root", "tecacc", 22, "/usr/www/status.cgi", false);
        
        //System.out.println("LINEAS:" + arrLineas.size());
        
        // 2 - CREO UN UNICO STRING DE LAS LINEAS DE RESPUESTA AL SSH:
        String jsonStr = "";
        for(String strLineaLoop: arrLineas)
        {
            jsonStr += strLineaLoop;
        }
        
        boolean valido = true;
        if(jsonStr.trim().length() == 0 || jsonStr.contains("No such file or directory"))
        {
            System.out.println("NO ES UBI");
            valido = false;
        }
 
        if(valido)
        {
       
            // 4 - QUITO ESPACIOS Y COMIENZO A PROCESAR EL JSON DE STATUS.CGI
            jsonStr = jsonStr.trim();
    //        System.out.println("PROCESANDO JSON: " + jsonStr.length());

            jsonStr = jsonStr.replaceAll("\\s+","");
            int posPrimerLlave = jsonStr.indexOf("{");

            jsonStr = jsonStr.substring(posPrimerLlave, jsonStr.length());
    //        System.out.println("jsonStr:" + jsonStr );


            // 5 - PARSEO EL STRING A OBJETO JAVA:
            JsonParser parser = new JsonParser();
            JsonElement jsonElement = parser.parse(jsonStr);
    //        System.out.println("jsono:" + jsonElement );
    //        System.out.println("SOY OBJETO: " + jsonElement.isJsonObject());

            // 6 - BUSCO LA ETH0 Y ME FIJO SI ESTA PLUGED:
            if(jsonElement.isJsonObject())
            {
                JsonObject status = jsonElement.getAsJsonObject();
    //            System.out.println("STATUS: " + status);

                JsonElement interfaces = status.get("interfaces").getAsJsonArray();
                JsonArray arrayInterfaces = status.get("interfaces").getAsJsonArray();
    //            System.out.println("interfaces: " + interfaces);

                JsonObject eth0 = arrayInterfaces.get(1).getAsJsonObject();
    //            System.out.println("eth0: " + eth0);

                JsonObject statusEth = eth0.getAsJsonObject("status");
                System.out.println("STATUS ETH0: " + statusEth);

                String enchufado = statusEth.get("plugged").getAsString();
    //            System.out.println("ESTA ENCUFADO EL CABLE DE RED: " +  enchufado);

                if(enchufado.equalsIgnoreCase("1"))
                {
                    unplugged = false;
                }
            }
        }
        return unplugged;
    }
}
