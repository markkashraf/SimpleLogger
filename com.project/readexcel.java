package com.project;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public abstract class readexcel {

    public static XSSFSheet getSheet1( String path  ) throws IOException
    {
        File file = new File(path); // Create a new File (Path) Object.
        FileInputStream inputStream = new FileInputStream(file); //Get The file as a stream of bytes.
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream); //Get a WorkBook from that FileStream.
        return workbook.getSheetAt(0); // Get the First Sheet from the WorkBook
    }

    public static void Readsheet(XSSFSheet sheet)
    {
        Iterator<Row> iterator = sheet.iterator();
        while (iterator.hasNext()) {
            Row nextRow = iterator.next();
            Iterator<Cell> cellIterator = nextRow.cellIterator();

            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                switch (cell.getCellType()) {
                    case STRING:
                        System.out.print(cell.getStringCellValue());
                        break;
                    case BOOLEAN:
                        System.out.print(cell.getBooleanCellValue());
                        break;
                    case NUMERIC:
                        System.out.print(cell.getNumericCellValue());
                        break;
                }

            }


        }

    }
    public static String getCell(XSSFSheet sheet, int row, int column){
        try {
            return sheet.getRow(row).getCell(column).getStringCellValue();
        }
        catch (NullPointerException x)
        {
            return null;
        }
    }


    }

