package com.project;

import javafx.stage.Stage;
import org.apache.poi.ss.usermodel.Workbook;


public class Project {

    public static void main(String[] args) {
        readexcel.Readsheet(readexcel.getSheet1("D:\\arcane\\tests.xlsx"));
        System.out.println(readexcel.getCell(readexcel.getSheet1("D:\\arcane\\tests.xlsx"),0,0));


    }
}