package com.project;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.commons.codec.binary.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public abstract class readexcel {

    public static XSSFSheet getSheet1(String path) throws IOException {
        File file = new File(path); // Create a new File (Path) Object.
        FileInputStream inputStream = new FileInputStream(file); //Get The file as a stream of bytes.
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream); //Get a WorkBook from that FileStream.
        return workbook.getSheetAt(0); // Get the First Sheet from the WorkBook
    }


    public static String getCell(XSSFSheet sheet, int row, int column)
    {
        try {
            return sheet.getRow(row).getCell(column).getStringCellValue();
        } catch (NullPointerException x) {
            return null;
        }
    }

    public static XSSFSheet getSheetRemoveBlank(String path) throws IOException
    {
        FileInputStream inputStream = new FileInputStream(new File(path)); //Get The file as a stream of bytes.
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream); //Get a WorkBook from that FileStream.
        XSSFSheet sheet = workbook.getSheetAt(0);
        boolean isRowEmpty = false;
        for(int i = 0; i < sheet.getLastRowNum(); i++){
            if(sheet.getRow(i)==null){
                isRowEmpty=true;
                sheet.shiftRows(i + 1, sheet.getLastRowNum(), -1);
                i--;
                continue;
            }
            for(int j =0; j<sheet.getRow(i).getLastCellNum();j++){
                if(sheet.getRow(i).getCell(j) == null || sheet.getRow(i).getCell(j).toString().trim().equals(""))
                {
                    isRowEmpty=true;
                }
                else
                {
                    isRowEmpty=false;
                    break;
                }
            }
            if(isRowEmpty==true){
                sheet.shiftRows(i + 1, sheet.getLastRowNum(), -1);
                i--;
            }
        }

        return sheet; // Get the First Sheet from the WorkBook
    }

    public static int getLastFilledCellPosition(Row row) {
        int columnIndex = -1;

        for (int i = row.getLastCellNum() - 1; i >= 0; i--) {
            Cell cell = row.getCell(i);

            if (cell == null || CellType.BLANK.equals(cell.getCellType())) {
                continue;
            } else {
                columnIndex = cell.getColumnIndex();
                break;
            }
        }

        return columnIndex;
    }






}




