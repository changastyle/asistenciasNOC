package archivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader2
{
    
    public static List parsearXLSX(String ruta, int hojaSeleccionada, int numeroFilaConHeaders  , int cantCols, String nombreClassForName)
    {
        List arr = new ArrayList();
        
        String salida = null;
        String valorDefault = "XXX";
        try 
        {
            // 1 - LEO EL ARCHIVO:
            File archivo = new File(ruta);
            
            // 2 - TRAIGO LA CLASE A USAR:
            Class clase = Class.forName(nombreClassForName);

            // 3 - TRAIGO EL ENCABEZADO DE HEADERS:
            List<String> arrLineas = leerXLSXComoLineas(ruta, cantCols , hojaSeleccionada);
            List<FilaExcelNico> arrFilasNico = new ArrayList<FilaExcelNico>();
            
            if(arrLineas != null)
            {
                for(int i = 0 ; i < arrLineas.size() ; i ++)
                {
                    String lineaLoop = arrLineas.get(i);
                    FilaExcelNico filaLoop = new FilaExcelNico(lineaLoop);
                    
                    arrFilasNico.add(filaLoop);
                }
            }
            
            //  4 - TENGO FILA DE HEADERS EXCEL:
            FilaExcelNico filaHeaders = arrFilasNico.get(numeroFilaConHeaders);
            
            int cantFilas = arrFilasNico.size();
//            int cantCols = filaHeaders.getArrCeldas().size();
            System.out.println("------------------------------------");
            System.out.println("PARSEANDO XLSX DEL ARCHIVO:" + ruta);
            System.out.println("CANT FILAS:" + cantFilas);
            System.out.println("CANT COLS:" + cantCols);
            System.out.println("------------------------------------");
            
            //  5 - PARA CADA FILA DEL EXCEL:
            int contFilas = 0;
            int contCols = 0;
            int contAtt = 0;
            
            for( FilaExcelNico filaLoop : arrFilasNico )
            {
                if(contFilas != 0 && filaLoop.getArrCeldas() != null && filaLoop.getArrCeldas().size() > 0)
                {
                    Object objetito = clase.newInstance();

                    System.out.println("FILA ["+ contFilas + "]: " + filaLoop);

                    // 5 - RECORRO TODAS LAS COLUMNAS DE CADA FILA DEL EXCEL:
                    contCols = 0;

                    for (String valorLoop : filaLoop.getArrCeldas())
                    {
                        String nombreCol = filaHeaders.getArrCeldas().get(contCols);
                        nombreCol = nombreCol.toLowerCase();
                        System.out.println("    COL[" + contCols + "] (" + nombreCol + ") = " + valorLoop);

                        if (valorLoop != null)
                        {
                            // 6 - RECORRO LOS ATT DE LA CLASE PARSER:
                            contAtt = 0;
                            boolean encontre = false;


                            System.out.println("NOMBRE COL: " + nombreCol);
                            Field attEnLaClase = clase.getDeclaredField(nombreCol);

                            if(valorLoop == null || valorLoop.equalsIgnoreCase("null"))
                            {
                                System.out.println("NO ENCONTRE VALOR PARA " + nombreCol);
                                valorLoop = valorDefault;
                            }
                            
                            attEnLaClase.setAccessible(true);
                            attEnLaClase.set(objetito, valorLoop);


                        }
                        contCols++;

                    }
                    
                    System.out.println("----");
                    arr.add(objetito);
                }
                
                contFilas++;
                
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return arr;
    }
    
    
    public static FilaExcelNico dameArrayDeHeaders(String ruta ,int cantCols , int hojaSeleccionada, int numeroFilaConHeaders )
    {
        FilaExcelNico filaHeaders = null;

        List<String> arrLineas = leerXLSXComoLineas(ruta , cantCols ,  hojaSeleccionada);
        
        if(arrLineas != null)
        {
            String strArrHeaders = arrLineas.get(numeroFilaConHeaders);
            
            filaHeaders = new FilaExcelNico(strArrHeaders);
        }
        
        return filaHeaders;
    }
    
    public static List<String> leerXLSXComoLineas(String ruta , int cantCols , int hojaSeleccionada)
    {
        List<String> arrLineas = new ArrayList<String>();
        
        try 
        {
            // 2 - CREO UN OBJETO POI QUE LEE EXCEL:
            Workbook workbook = new XSSFWorkbook(ruta);
            Sheet sheet = workbook.getSheetAt(hojaSeleccionada);
            Iterator<Row> iteratorRows = sheet.iterator();
            
            
            
            int contRows = 0;
            String linea = "";
            for (Row rowLoop : sheet) 
            {
                linea = "";
                
                List<Cell> arrCeldas = new ArrayList<Cell>();

//                System.out.println("ROW : " + contRows + " max: " + row.getLastCellNum());
                
//                int lastColumn = Math.max(row.getLastCellNum(), 5);
                for (int i = 0 ; i < cantCols; i++) 
                {
                    Cell celdaLoop = rowLoop.getCell(i, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
                    
                    String valor = "";
                    if(celdaLoop != null)
                    {
                        if (celdaLoop.getCellType() == Cell.CELL_TYPE_STRING) 
                        {
                            valor = celdaLoop.getStringCellValue() + "|";
    //                        System.out.print(currentCell.getStringCellValue() + " | ");
                        }
                        else if (celdaLoop.getCellType () == Cell.CELL_TYPE_NUMERIC)
                        {
                            valor = celdaLoop.getNumericCellValue() + "|";
    //                        System.out.print(currentCell.getNumericCellValue() + " | ");
                        }
                        else
                        {
                            valor = "|";
                        }
                    }
                    else
                    {
                        valor = "|";
                    }
                    
                    linea += valor;
//                    arrCeldas.add(celdaLoop);
                }
                
                arrLineas.add(linea);
            }
            

//            while (iteratorRows.hasNext())
//            {
//                Row currentRow = iterator.next();
//                Iterator<Cell> cellIterator = currentRow.iterator();
//                System.out.println("PUTO: " + cellIterator.toString());;
//
//                String linea = "";
//                
//                
////                String valor = cellIterator.next().getStringCellValue();
//                while (cellIterator.hasNext()) 
//                {
//                    Cell currentCell = cellIterator.next();
//                    String valor = "";
//                    if (currentCell.getCellType() == Cell.CELL_TYPE_STRING) 
//                    {
//                        valor = currentCell.getStringCellValue() + "|";
////                        System.out.print(currentCell.getStringCellValue() + " | ");
//                    }
//                    else if (currentCell.getCellType () == Cell.CELL_TYPE_NUMERIC)
//                    {
//                        valor = currentCell.getNumericCellValue() + "|";
////                        System.out.print(currentCell.getNumericCellValue() + " | ");
//                    }
//                    else
//                    {
//                        valor = "|";
//                    }
//                    
//                    linea += valor;
//                }
//                
//                arrLineas.add(linea);
//                linea = "";
////                System.out.println("");
//            }
        }
        catch(Exception e)
        {
            e.printStackTrace();;
        }
        
        return arrLineas;
    }
    
    public static boolean escribirXLSX(String ruta , String nombreHoja , List<FilaExcelNico> arrFilas)
    {
        boolean ok = false;
        
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet(nombreHoja);

        int rowNum = 0;
        System.out.println("CREANDO EXCEL (XLSX) " +  ruta  +" | " + nombreHoja);

        
        Font headerFont = workbook.createFont();
        headerFont.setFontHeightInPoints((short) 14);
        headerFont.setColor(IndexedColors.RED.getIndex());
        
        for (FilaExcelNico filaLoop : arrFilas)
        {
            Row row = sheet.createRow(rowNum++);
            int colNum = 0;
            for (String celdaLoop : filaLoop.getArrCeldas()) 
            {
                Cell cell = row.createCell(colNum++);
                if (celdaLoop instanceof String) 
                {
                    cell.setCellValue((String) celdaLoop);
                } 
//                else if (field instanceof Integer) 
//                {
//                    cell.setCellValue((Integer) field);
//                }
            }
        }

        try
        {
            FileOutputStream outputStream = new FileOutputStream(ruta);
            workbook.write(outputStream);
            ok = true;
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }

        System.out.println("Done");
        
        return ok;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static List<String> extractInfo(String ruta) 
    {
        // 1 - LEO EL ARCHIVO:
        File archivo = new File(ruta);
        List<String> arr = new ArrayList<String>();
        Workbook wb = null;

        try
        {
            wb = new XSSFWorkbook(new FileInputStream(archivo));
            Sheet sheet = wb.getSheetAt(0);


            for (Row row : sheet) 
            {

                List<Cell> arrCeldas = new ArrayList<Cell>();

                int lastColumn = Math.max(row.getLastCellNum(), 5);
                for (int cn = 0; cn < lastColumn; cn++) 
                {
                    Cell c = row.getCell(cn, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
                    arrCeldas.add(c);
                }

                for(Cell cellLoop : arrCeldas)
                {
                    if(cellLoop == null)
                    {
                        arr.add("||");
                    }
                    if(cellLoop.getCellType() ==  Cell.CELL_TYPE_BLANK)
                    {
                        arr.add("||");
                    }
                    else
                    {
                        String valor = cellLoop.getStringCellValue();
                        arr.add(valor + "|");
                    }
                }
//                Info info = extractInfoFromCell(cells);
//                infoList.add(info);
            }
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        } 
        finally
        {
            if (wb != null)
            {
                try 
                {
                        wb.close();
                } 
                catch (IOException e) 
                {
                        e.printStackTrace();
                }
            }
        }

        return arr;
	}

}

