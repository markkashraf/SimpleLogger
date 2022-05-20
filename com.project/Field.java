package com.project;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.Objects;

public class Field {
    private String Type;
    private String AllowedValues;
    private String Mandatory;
    private String IO;
    private String[] FieldName;
    private String Parent;
    JSONObject jo = new JSONObject();

    public Field(XSSFSheet sheet , int row)
    {
            try {
                Type = sheet.getRow(row).getCell(2).getStringCellValue();
                IO = sheet.getRow(row).getCell(0).getStringCellValue();
                //FieldName = sheet.getRow(row).getCell(1).getStringCellValue();
                FieldName = sheet.getRow(row).getCell(1).getStringCellValue().substring(1).split("/");
                AllowedValues = sheet.getRow(row).getCell(3).getStringCellValue();
                Mandatory = sheet.getRow(row).getCell(4).getStringCellValue();
                if(FieldName.length >=2)
                    Parent = FieldName[FieldName.length-2];
                else
                    Parent = null;
            }
            catch (NullPointerException x)
            {

            }
    }
    public Field()
    {

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
            return null;
        else if (FieldName.length>=2)
        {return FieldName[FieldName.length-2];}
        else
            return null;
    }
    public String getParent()
    {
       if (Parent == null)
           return null;
       else
           return Parent;
    }


}