package com.project;

import org.apache.poi.xssf.usermodel.XSSFSheet;

public class HelloApplication {


    public static void main(String[] args) throws Exception
    {

        XSSFSheet sheet = readexcel.getSheet1("src\\Test Excel File\\Example.xlsx");

        Service x = new Service(sheet);
    }
}