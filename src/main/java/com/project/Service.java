package com.project;

import org.apache.poi.sl.draw.geom.GuideIf;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import java.util.ArrayList;

public class Service
{
    private ArrayList<Operation> Operations;//List Of the Operation inside the Service.
    Service(XSSFSheet sheet)
    {
        Operations = new ArrayList<Operation>(); //Initialize the Operations ArrayList.
        int Current_Beginning = 0; // Initialize Variables to get the Beginning and the end indices of a file.
        int Current_End = 0;
        //The first few rows inside the sheet represent the API Name, HTTP Operation, and Rest URL.
        String Current_API_Name =  readexcel.getCell(sheet,0,0);
        String Current_HTTP_OP  =  readexcel.getCell(sheet,2,0);
        String Current_Rest_URL =  readexcel.getCell(sheet,2,1);
        //(REMEMBER) -----> Sheet has no empty rows so these 3 lines are legal.

        //At this point all I have done is that I have initialized variables needed to scan the sheet correctly.
        //Now, I want to scan the whole sheet for Operations, and save them in an Arraylist.
        for (Row myRow : sheet) //for every row inside the sheet
        {


            if (myRow.getCell(0).getStringCellValue().equals("I/o"))  //If you find the row that contains column names.
            {
                Current_Beginning = myRow.getRowNum() + 1; //Set the current beginning to the row after that.
            }

            if (readexcel.getLastFilledCellPosition(myRow) == 0 && myRow.getRowNum()!=0 || myRow.getRowNum()==sheet.getPhysicalNumberOfRows()-1)
            {
                //When you reach the row that has API Name, and the row is not at the beginning.
                //(Remember that we initialized API_Name, Rest URL, HTTP Operation which are at the beginning)
                //Or If the Row is at the End of the sheet.

                Current_End = myRow.getRowNum()-1; // Set the Current Ending to the row before.
                Operations.add(new Operation(sheet, Current_Beginning, Current_End)); // Create a new operation.
                Operations.get(Operations.size()-1).setAPI_Name(Current_API_Name); // Set the api name
                Operations.get(Operations.size()-1).setRest_URL(Current_Rest_URL); // Set the rest url
                Operations.get(Operations.size()-1).setHTTP_OP(Current_HTTP_OP);  // set the http op

                if(myRow.getRowNum()<sheet.getPhysicalNumberOfRows()-1) // if you didn't reach the end of the file
                {
                    //update the current data from the row
                    Current_API_Name =  readexcel.getCell(sheet,myRow.getRowNum(),0);
                    Current_HTTP_OP  =  readexcel.getCell(sheet,myRow.getRowNum()+2,0);
                    Current_Rest_URL = readexcel.getCell(sheet,myRow.getRowNum()+2,1);
                }

            }

        }
    }

    public int GetNumberOfOperations()
    {
        return Operations.size();
    }
    public Operation getOperation(int OpIndex)
    {
        return Operations.get(OpIndex);
    }








}





