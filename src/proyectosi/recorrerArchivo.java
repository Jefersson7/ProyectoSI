/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectosi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author jefersson
 */
public class recorrerArchivo {
    
    public double totalTemperatura = 0.0, totalHumedad = 0.0, totalViento = 0.0, totalPrecipitacion = 0.0;
    public int numRegistrosLeidos = 0;
    
    public recorrerArchivo(File fileName, LocalDateTime fecha)  {
        
        try {
            FileInputStream fileInputStream = new FileInputStream(fileName);
            XSSFWorkbook workBook = new XSSFWorkbook(fileInputStream);
            XSSFSheet sheet = workBook.getSheetAt(3);
            for (int i = 3; i < 104; i++) {
                Date date = sheet.getRow(i).getCell(0).getDateCellValue();
                LocalDateTime ldt = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
                totalTemperatura += sheet.getRow(i).getCell(1).getNumericCellValue();
                totalHumedad += sheet.getRow(i).getCell(2).getNumericCellValue();
                totalViento += sheet.getRow(i).getCell(3).getNumericCellValue();
                totalPrecipitacion += sheet.getRow(i).getCell(4).getNumericCellValue();
                if(ldt.equals(fecha)) break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
