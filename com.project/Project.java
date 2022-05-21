package com.project;


import com.google.gson.GsonBuilder;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import com.google.gson.Gson;



public class Project {

    public static void main(String[] args) throws Exception
    {
        XSSFSheet sheet = readexcel.getSheet1("D:\\Project\\Test Excel File\\Example.xlsx");

        Operation x = new Operation(sheet);

        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        String JSONObject = gson.toJson(x.RealObjects);
        System.out.println(JSONObject);
    }



}
