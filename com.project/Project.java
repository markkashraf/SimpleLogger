package com.project;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import javafx.stage.Stage;
import org.apache.poi.sl.draw.geom.GuideIf;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.google.gson.Gson;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Project {

    public static void main(String[] args) throws Exception
    {
        XSSFSheet sheet = readexcel.getSheet1("D:\\Project\\Test Excel File\\Example.xlsx");

        Operation x = new Operation(sheet);

        System.out.println(x.RealObjects.get(0).get(0).getFieldName());



    }
}