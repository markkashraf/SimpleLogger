package com.project;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import java.util.ArrayList;
import java.util.Iterator;

public class Service {
    ArrayList<Operation> Operations;


    Service(XSSFSheet sheet) {
        Operations = new ArrayList<Operation>();
        int Current_Beginning = Integer.MAX_VALUE;
        int Current_End = Integer.MAX_VALUE;
        String Current_API_Name = null;
        String Current_HTTP_OP = null;
        String Current_Rest_URL = null;

            for (Row myRow : sheet) {

                Field x = new Field(sheet, myRow.getRowNum());

                if (readexcel.getLastFilledCellPosition(myRow) == 0 )
                {
                    Current_API_Name = myRow.getCell(0).getStringCellValue();
                    Current_HTTP_OP = sheet.getRow(myRow.getRowNum()+2).getCell(0).getStringCellValue();
                    Current_Rest_URL = sheet.getRow(myRow.getRowNum()+2).getCell(1).getStringCellValue();
                }

                if (x.getIO().equals("I/o")) {
                    Current_Beginning = myRow.getRowNum() + 1;
                }
                if (myRow.getRowNum() > Current_Beginning && readexcel.getLastFilledCellPosition(myRow) == 0 || myRow.getRowNum() == sheet.getPhysicalNumberOfRows()-1)
                {

                    Current_End = myRow.getRowNum();
                    Operations.add(new Operation(sheet, Current_Beginning, Current_End));
                    Operations.get(Operations.size()-1).setAPI_Name(Current_API_Name);
                    Operations.get(Operations.size()-1).setRest_URL(Current_Rest_URL);
                    Operations.get(Operations.size()-1).setHTTP_OP(Current_HTTP_OP);
                }


            }


        }
    }





