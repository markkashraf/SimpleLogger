package com.project;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import java.util.ArrayList;

public class Service {
    ArrayList<Operation> Operations;
    Service(XSSFSheet sheet)
    {
        Operations = new ArrayList<Operation>();
        int Current_Beginning = 0;
        int Current_End = 0;
        String Current_API_Name = sheet.getRow(0).getCell(0).getStringCellValue();
        String Current_HTTP_OP  = sheet.getRow(2).getCell(0).getStringCellValue();
        String Current_Rest_URL = sheet.getRow(2).getCell(1).getStringCellValue();

            for (Row myRow : sheet)
            {
                if (readexcel.getLastFilledCellPosition(myRow) == 0 && myRow.getRowNum()!=0 || myRow.getRowNum()==sheet.getPhysicalNumberOfRows()-1)
                {
                    Current_End = myRow.getRowNum()-1;
                    Operations.add(new Operation(sheet, Current_Beginning, Current_End));
                    Operations.get(Operations.size()-1).setAPI_Name(Current_API_Name);
                    Operations.get(Operations.size()-1).setRest_URL(Current_Rest_URL);
                    Operations.get(Operations.size()-1).setHTTP_OP(Current_HTTP_OP);
                    if(myRow.getRowNum()<sheet.getPhysicalNumberOfRows()-1)
                    {
                        Current_API_Name = myRow.getCell(0).getStringCellValue();
                        Current_HTTP_OP  = sheet.getRow(myRow.getRowNum()+2).getCell(0).getStringCellValue();
                        Current_Rest_URL = sheet.getRow(myRow.getRowNum()+2).getCell(1).getStringCellValue();
                    }
                    continue;
                }

                if (myRow.getCell(0).getStringCellValue().equals("I/o")) {
                    Current_Beginning = myRow.getRowNum() + 1;
                }

            }
        }

    }





