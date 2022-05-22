package com.project;


import com.google.gson.GsonBuilder;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import com.google.gson.Gson;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;


public class Project {

    public static void main(String[] args) throws Exception
    {
      XSSFSheet sheet = readexcel.getSheetRemoveBlank("D:\\Project\\Test Excel File\\Example.xlsx");

    Service x = new Service(sheet);



      //  System.out.println(x.Operations.get(0).RealObjects.get(1).getObjectName());



     /*   GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        String JSONObject = gson.toJson(x.RealObjects);
        System.out.println(JSONObject);*/
    }



}
