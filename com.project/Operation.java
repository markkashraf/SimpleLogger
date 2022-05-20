
package com.project;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import java.util.ArrayList;

public class Operation {

    ArrayList<ArrayList<Field>> SortedObjects;
    Operation(XSSFSheet sheet)
    {
        ArrayList<Field> TempFields = new ArrayList<Field>();
        ArrayList<Field> TempObjects = new ArrayList<Field>();
        SortedObjects = new ArrayList<ArrayList<Field>>();
        ArrayList<Obj> RealObjects = new ArrayList<Obj>();


        for(int i = 0; i < sheet.getPhysicalNumberOfRows(); i++)
        {
            Field x = new Field(sheet,i);

            if(x.getType().equals("string"))
            {
                TempFields.add(x);
            }
            else if (!(x.getType().equals("Type")) && !(x.getType().equals("")))
            {
                TempObjects.add(x);
            }
        }

        for (int i = 0; i<TempObjects.size(); i++)
        {
            SortedObjects.add(new ArrayList<Field>());
            SortedObjects.get(i).add(TempObjects.get(i));
        }

        for (int i=0; i<TempFields.size(); i++)
        {

            for (int j=0; j<TempObjects.size(); j++)
            {
                if(SortedObjects.get(j).get(0).getType().equals(TempFields.get(i).getParent()))
                {
                    SortedObjects.get(j).add(TempFields.get(i));

                }
            }
        }
        Obj x;
        for (int i=0; i < SortedObjects.size(); i++)
        {
            x = new Obj();
            x.ObjectName = SortedObjects.get(i).get(0).getType();
            for (int j=0; j < SortedObjects.get(i).size(); j++)
            {
                if(SortedObjects.get(i).get(j).getType().equals("string"))
                {x.Fields.add(SortedObjects.get(i).get(j));}







            }

        }









    }
}
















