package com.project;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import java.util.ArrayList;
import java.util.Iterator;

public class Operation {
    private String API_Name;
    private XSSFSheet Sheet;
    private ArrayList<Field> Fields;

    Operation(XSSFSheet Sheet)
    {
        this.Sheet = Sheet;
        Iterator<Row> iterator = Sheet.iterator();
        for (int i=0; iterator.hasNext(); i++)
        {
            Row nextRow = iterator.next();
            
                if(nextRow.getCell(0).getStringCellValue() == "I" || nextRow.getCell(0).getStringCellValue() == "O")
                {
                    Fields.add(new Field(Sheet, i));


                }


            }

        }

    }



}
