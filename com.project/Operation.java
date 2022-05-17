
package com.project;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import java.util.ArrayList;
import java.util.Iterator;

public class Operation {
    private String API_Name;
    private ArrayList<Field> Fields; // array of all the fields in this file

    Operation(XSSFSheet sheet)
    {
        Fields = new ArrayList<Field>();
        for (int i=7; i<=sheet.getPhysicalNumberOfRows(); i++) // To Be Done Better
        {
            Fields.add(new Field(sheet, i));
        }

}
}










