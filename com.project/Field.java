package com.project;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;

public class Field {
    private String Type;
    private String AllowedValues;
    private String Mandatory;
    private String IO;
    private String FieldName;


    public Field(XSSFSheet sheet , int row)
    {
            try {
                IO = sheet.getRow(row).getCell(0).getStringCellValue();
                FieldName = sheet.getRow(row).getCell(1).getStringCellValue();
                Type = sheet.getRow(row).getCell(2).getStringCellValue();
                AllowedValues = sheet.getRow(row).getCell(3).getStringCellValue();
                Mandatory = sheet.getRow(row).getCell(4).getStringCellValue();
            }
            catch (NullPointerException x)
            {

            }
    }

    public String getType()
    {
        if(Type == null)
            return "";
        else
            return Type;

    }

    public String getAllowedValues() {
        if(AllowedValues == null)
            return "";
        else
        return AllowedValues;
    }

    public String getMandatory() {
        if(Mandatory == null)
            return "";
        else
        return Mandatory;
    }

    public String getIO() {
        if(IO == null)
            return "";
        else
        return IO;
    }

    public String getFieldName() {
        if(FieldName == null)
            return "";
        else
        return FieldName;
    }

    @Override
    public String toString() {
        return "Field{" +
                "Type='" + Type + '\'' +
                ", AllowedValues='" + AllowedValues + '\'' +
                ", Mandatory='" + Mandatory + '\'' +
                ", IO='" + IO + '\'' +
                ", FieldName='" + FieldName + '\'' +
                '}';
    }
}