package com.project;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;

public class Field {
    private String Type;
    private String AllowedValues;
    private String Mandatory;
    private String IO;
    private String FieldName;

    public Field(String type, String allowedValues, String mandatory, String IO) {
        Type = type;
        AllowedValues = allowedValues;
        Mandatory = mandatory;
        this.IO = IO;
    }
    public Field(XSSFSheet sheet , int row)
    {
        IO = readexcel.getCell(sheet,row,0);
        FieldName = readexcel.getCell(sheet,row,1);
        Type = readexcel.getCell(sheet,row,2);
        AllowedValues = readexcel.getCell(sheet,row,3);
        Mandatory = readexcel.getCell(sheet,row,4);

    }

}
