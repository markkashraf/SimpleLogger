package com.project;

import javafx.stage.Stage;
import org.apache.poi.sl.draw.geom.GuideIf;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;


public class Project {

    public static void main(String[] args) throws Exception
    {
        File file = new File("D:\\Project\\Test Excel File\\Example.xlsx"); // Create a new File (Path) Object.
        FileInputStream inputStream = new FileInputStream(file); //Get The file as a stream of bytes.
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream); //Get a WorkBook from that FileStream.
        XSSFSheet sheet = workbook.getSheetAt(0);
        Operation x = new Operation(sheet);
        System.out.println();












    }
}