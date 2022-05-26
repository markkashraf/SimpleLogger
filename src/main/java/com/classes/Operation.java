package com.classes;

import com.classes.Field;
import com.classes.Obj;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import java.util.ArrayList;


public class Operation {

    private ArrayList<Field> Request;
    private ArrayList<Field> Response;
    private String HTTP_OP;
    private String Rest_URL;
    private String API_Name;


    Operation(XSSFSheet sheet, int Beginning_Row, int Ending_Row)
    {
        Request = new ArrayList<Field>();
        Response = new ArrayList<Field>();
        Init_Operation(sheet,Beginning_Row,Ending_Row);
    }

    //setters and getters
    public void setHTTP_OP(String HTTP_OP) {
        this.HTTP_OP = HTTP_OP;
    }
    public void setRest_URL(String rest_URL) {
        Rest_URL = rest_URL;
    }
    public String getHTTP_OP() {
        return HTTP_OP;
    }
    public String getRest_URL() {
        return Rest_URL;
    }
    public String getAPI_Name() {
        return API_Name;
    }
    public Obj getObjectFromRequest(int i)
    {
        return (Obj)Request.get(i);
    }
    public Obj getObjectFromResponse(int i)
    {
        return (Obj)Response.get(i);
    }
    public int getRequestSize()
    {
        return Request.size();
    }
    public int getResponseSize()
    {
        return Response.size();
    }
    public void setAPI_Name(String API_Name) {
        this.API_Name = API_Name;
    }
    private void Init_Operation(XSSFSheet sheet,int Beginning_Row, int Ending_Row)
    {
        //initialize 2 temp arrays.
        ArrayList<Field> TempFields = new ArrayList<Field>();
        ArrayList<Obj> TempObjects = new ArrayList<Obj>();

        //Get the Fields from the Excel sheet
        for (int i = Beginning_Row; i <= Ending_Row+1; i++)
        {
            Field x = new Field(sheet, i); // Iterator for Rows in the Sheet

            if (x.getType().equals("string")) // if the field type is string, add it to the Fields Array.
            {
                TempFields.add(x);// add the Current Field to the Fields Array.
                continue;
            }
            else if (!(x.getType().equals("Type")) && !(x.getType().equals(""))) //if the current field is not a string nor header of the table

            {
                TempObjects.add(new Obj(x.getName(),x.getType(),x.getMandatory(), x.getParent() , x.getIO())); // Add it to the Objects Array
            }

        }

        for (int i = 0; i < TempFields.size(); i++)
        {
            for (int j = 0; j < TempObjects.size(); j++) //Find the Parent of the Current Field, append it with its parent.
            {
                if (TempObjects.get(j).getName().equals(TempFields.get(i).getParent())) //If you find parent
                {
                    TempObjects.get(j).AddFields(TempFields.get(i));//append the Field to it
                }
                if(i<=j && TempObjects.get(j).getParent().equals(TempObjects.get(i).getName())) //If you find the parent of this object, add this object to its fields
                {
                    TempObjects.get(i).AddFields(TempObjects.get(j));
                }
            }
            if (TempFields.get(i).getParent().equals("")) //If the Field has no parent, add it directly to the Request or Response.
            {
                if(TempFields.get(i).getIO().equals("I")) //if it is a request
                {
                    Request.add(TempFields.get(i)); //add it to the requests array.
                }
                else if(TempFields.get(i).getIO().equals("O"))//if it is a response.
                {
                    Response.add(TempFields.get(i));//add it to the responses array.
                }
            }
        }

        for (Obj x : TempObjects)
        {
            if(x.getIO().equals("I")) //if it is a request
            {
                Request.add(x); //add it to the requests array.
            }

            if(x.getIO().equals("O"))//if it is a response.
            {
                Response.add(x);//add it to the responses array.
            }
        }

    }


}























