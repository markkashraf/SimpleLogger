package com.project;

import org.apache.poi.xssf.usermodel.XSSFSheet;

public class Project {

    public static void main(String[] args) throws Exception
    {
      XSSFSheet sheet = readexcel.getSheetRemoveBlank("D:\\Project\\Test Excel File\\Example.xlsx");

      Service x = new Service(sheet);

    }

}
