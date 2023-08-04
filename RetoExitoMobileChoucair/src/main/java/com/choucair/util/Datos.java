package com.choucair.util;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Datos {

    private XSSFWorkbook libro;
    private FileInputStream file;

    public String leerDatosExcel (String ruta,String hoja, int rowValue, int cellValue) throws IOException {

        String valor;
        file = new FileInputStream(ruta);
        libro= new XSSFWorkbook(file);
        Sheet sheet = libro.getSheet(hoja);
        Row row = sheet.getRow(rowValue);
        Cell cell = row.getCell(cellValue);
        DataFormatter dataFormatter = new DataFormatter();
        valor = dataFormatter.formatCellValue(cell);
        libro.close();
        file.close();
        return valor;
    }
}
