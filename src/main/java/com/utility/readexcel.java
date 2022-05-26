package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//This is a Utility Class, it contains some methods that are useful when handling Excel sheets.
public abstract class readexcel
{
    public static String getCell(XSSFSheet sheet, int row, int column) //Get a Cell using Row and column.
    {
        try {
            return sheet.getRow(row).getCell(column).getStringCellValue();
        } catch (NullPointerException x) {
            return null;
        }
    }

    public static XSSFSheet getSheet1(String path) throws IOException //Get a sheet after removing blank rows (useful @ Processing).
    {
        FileInputStream inputStream = new FileInputStream(new File(path)); // Get The file as a stream of bytes.
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream); //Get a WorkBook from that FileStream.
        XSSFSheet sheet = workbook.getSheetAt(0); //Get the First sheet in the Workbook.
        boolean isRowEmpty = false; // boolean status for if the row is empty.
        for(int i = 0; i < sheet.getLastRowNum(); i++)
        {
            if(sheet.getRow(i)==null) // if the current row is empty
            {
                isRowEmpty=true; // set the empty flag
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
    } //Gets the last Filled Position of a Row.

}




