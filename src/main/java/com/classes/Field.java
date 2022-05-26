package com.classes;

import org.apache.poi.xssf.usermodel.XSSFSheet;


public class Field
{
    private String Type;
    private String AllowedValues;
    private String Mandatory;
    private String IO;
    private transient String[] FieldName;
    private String Name;
    private transient String Parent;

    public Field(String ObjectName, String ObjectType , String Mandatory ,String Parent, String IO)
    {
        this.Name = ObjectName;
        this.Type = ObjectType;
        this.Mandatory = Mandatory;
        this.Parent = Parent;
        this.IO=IO;
    }

    public Field(XSSFSheet sheet, int row)
    {
        try
        {
            Type = sheet.getRow(row).getCell(2).getStringCellValue();
            IO = sheet.getRow(row).getCell(0).getStringCellValue();
            FieldName = sheet.getRow(row).getCell(1).getStringCellValue().substring(1).split("/");
            Name = sheet.getRow(row).getCell(1).getStringCellValue().substring(1).split("/")[FieldName.length-1];
            AllowedValues = sheet.getRow(row).getCell(3).getStringCellValue();
            Mandatory = sheet.getRow(row).getCell(4).getStringCellValue();

            if(FieldName.length >=2)
                Parent = sheet.getRow(row).getCell(1).getStringCellValue().split("/")[FieldName.length-1];
            else
                Parent = "";
        }


        catch (NullPointerException x)
        {

        }
    }

    public Field()
    {

    }

    public String getType() {
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
        if(FieldName.length >= 2)
        {
            return FieldName[FieldName.length-2];
        }
        else if(FieldName.length == 0)
        {
            return null;
        }
        else
            return FieldName[0];

    }
    public String getParent() {
        if (Parent == null)
            return null;
        else
            return Parent;
    }
    public String getName() {
        return Name;
    }
}