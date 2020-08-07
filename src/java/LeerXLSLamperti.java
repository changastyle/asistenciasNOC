
import archivos.ExcelReader2;
import java.io.IOException;
import java.util.List;
import parsers.ParserWatchDog;

public class LeerXLSLamperti
{
    public static void main(String args[])
    {
        // 1 - RUTA ARCHIVO EXCEL A LEER:
        String rutaCarpeta = "C:\\jtemp\\";
        String rutaArchivo = "sde.xlsx";
        String rutaTotal  = rutaCarpeta + rutaArchivo;
        System.out.println("LEO EXCEL : "  + rutaTotal);
        
        
//        for(String strLoop : ExcelReader2.leerXLSXComoLineas(rutaTotal, 5, 0))
//        {
//            System.out.println(strLoop);
//        }
        // 2 - PARSEO ARR LINEAS A JAVA:
        List<ParserWatchDog> arrLineasExcel = ExcelReader2.parsearXLSX(rutaTotal, 0, 0, 5, "parsers.ParserWatchDog");
        
        
        // 3 - RECORRO LINEA A LINEA DEL EXCEL:
        int indice = 0;
        for(ParserWatchDog parserLoop : arrLineasExcel)
        {
            System.out.println(parserLoop.toJSON());
            
            if(indice > 0)
            {
                int codigo = indice;
                System.out.println("--------");
            }

            indice++;
        }
    }
}
