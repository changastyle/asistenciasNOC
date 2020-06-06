
import java.util.List;
import utiles.ManejoArchivos;

public class Main3
{
    public static void main(String args[])
    {
        String ruta = "C:\\jtemp\\";
        String nombreArchivoAndan = ruta + "ANDAN.csv";
        String nombreArchivoNOAndan = ruta + "NO-ANDANN.csv";
        
        
        List<String> arrLineasOK = ManejoArchivos.read(nombreArchivoAndan);
        List<String> arrLineasNO = ManejoArchivos.read(nombreArchivoNOAndan);
        
        for(String strOK : arrLineasOK)
        {
            int posUltimoPuntoYComa = strOK.lastIndexOf(";");
            strOK = strOK.substring(posUltimoPuntoYComa + 1 , strOK.length());
//            System.out.println("TERCER COL:" + strOK );
            for(String strNO : arrLineasNO)
            {
                int posUltimoPuntoYComa2 = strNO.lastIndexOf(";");
                strNO = strNO.substring(posUltimoPuntoYComa2 + 1 , strNO.length());
                
                if(strOK.equalsIgnoreCase(strNO))
                {
                    System.out.println("REPETIDO: " +  strNO );
                }
            }
        }
    }
}
