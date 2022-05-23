package com.project;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import java.util.ArrayList;


public class Operation {

    private ArrayList<Obj> Request;
    private ArrayList<Obj> Response;
    private String HTTP_OP;
    private String Rest_URL;
    private String API_Name;

    public void setAPI_Name(String API_Name) {
        this.API_Name = API_Name;
    }

    Operation(XSSFSheet sheet, int Beginning_Row, int Ending_Row)
    {
        ArrayList<Field> TempFields = new ArrayList<Field>();
        ArrayList<Field> TempObjects = new ArrayList<Field>();
        ArrayList<ArrayList<Field>> SortedObjects = new ArrayList<ArrayList<Field>>();
        Request = new ArrayList<Obj>();
        Response = new ArrayList<Obj>();
        //Get the Fields from the Excel sheet
        for (int i = Beginning_Row; i <= Ending_Row; i++)
        {
            Field x = new Field(sheet, i); // Iterator for Rows in the Sheet

            if (x.getType().equals("string")) // if the field type is string, add it to the Fields Array.
            {
                TempFields.add(x);// add the Current Field to the Fields Array.
                continue;
            }
            else if (!(x.getType().equals("Type")) && !(x.getType().equals(""))) //if the current field is not a string nor
            // Headers of the Table
            {
                TempObjects.add(x); // Add it to the Objects Array
            }

        }
        //At this point, all I've done is that I have separated the Normal Fields from the Objects from the table.
        //I needed to do this, so I can Access both of them separately.


        for (int i = 0; i < TempObjects.size(); i++)
        {
            SortedObjects.add(new ArrayList<Field>());    //SortedObjects is a 2D Array (ArrayList of an ArrayList of Fields).
            SortedObjects.get(i).add(TempObjects.get(i)); //Occupy the First element of Each array with an Object.
        }

        //OK, So basically what I've done here is that I have occupied a New Array to hold my Object and its Fields
        //in the same array, I needed to do this, so I can easily connect Fields with their Parent Object easily.
        //(Index 0 is always the main object, all the rest are its Corresponding Fields)

        //After Adding the Objects as index 0 in every ArrayList, it's Time to add the Fields.
        for (int i = 0; i < TempFields.size(); i++)
        {
            for (int j = 0; j < TempObjects.size(); j++) //Find the Parent of the Current Field, append it with its parent.
            {
                if (SortedObjects.get(j).get(0).getType().equals(TempFields.get(i).getParent())) //If you find parent
                {
                    SortedObjects.get(j).add(TempFields.get(i));//append the object to it
                }
            }
            if (TempFields.get(i).getParent().equals("")) //If the Field has no parent, treat it as an object.
            {
                SortedObjects.add(new ArrayList<Field>(1)); //Create a new ArrayList
                SortedObjects.get(SortedObjects.size()-1).add(TempFields.get(i)); //Add the field to that arraylist
                //(Note:I am certain that it is the last element)
            }
        }
        //Until Now, I've been treating the Object as a Field, this would not suffice as our goal
        //is to combine the Object with its Corresponding Fields.
        //At this Point, I have created a new class (obj), this class is needed to combine the Fields and its Object.
        //Also, I created a new ArrayList to Hold my Objects (Created from the Obj Class).

        for (int i = 0; i < SortedObjects.size(); i++)
        {
            Obj x = new Obj(); //Create an Iterating Object
            x.setObjectName(SortedObjects.get(i).get(0).getName()); // Set the Object's Name.
            //Remember: Index 0 of the Array SortedObjects Held the Object (as a Field Only).

            for (int j = 0; j < SortedObjects.get(i).size(); j++) //Fill the Fields of the Object.
            {
                if (SortedObjects.get(i).get(j).getType().equals("string")) //If this is a Field
                {
                    x.AddFields(SortedObjects.get(i).get(j)); // Add it to the Fields Array of the Object.
                }
            }
            if(SortedObjects.get(i).get(0).getIO().equals("I"))
            {
                Request.add(x);
            }
            if(SortedObjects.get(i).get(0).getIO().equals("O")) {
                Response.add(x);
            }
            // Append the Object to an Array.
        }
        //We now have an Array of our Objects, it is just missing the nested Objects.
        //so I added them manually.

        for (int i = 0; i < TempObjects.size(); i++) //Here, I made use of the Array I made that stored the Objects as Fields Only.
        {
            for (int j = 0; j < TempObjects.size(); j++)
            {      //If the Object has the same name of the parent.
                if(j<Request.size()-1)
                {
                    if(TempObjects.get(i).getParent().equals(Request.get(j).getObjectName()))
                    {
                        Request.get(j).AddFields(TempObjects.get(i)); //Add it as a Field.
                    }
                }

                if(j<Response.size()-1)
                {
                    if(TempObjects.get(i).getParent().equals(Response.get(j).getObjectName()))
                    {
                        Response.get(j).AddFields(TempObjects.get(i)); //Add it as a Field.
                    }
                }

            }
        }
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
        return Request.get(i);
    }
    public Obj getObjectFromResponse(int i)
    {
        return Response.get(i);
    }
    public int getRequestSize()
    {
        return Request.size();
    }
    public int getResponseSize()
    {
        return Response.size();
    }

}























