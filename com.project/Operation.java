
package com.project;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class Operation {

    ArrayList<ArrayList<Field>> RealObjects;
    Operation(XSSFSheet sheet)
    {
        ArrayList<Field> Fields = new ArrayList<Field>();
        ArrayList<Field> Objects = new ArrayList<Field>();
        RealObjects = new ArrayList<ArrayList<Field>>();


        for(int i = 0; i < sheet.getPhysicalNumberOfRows(); i++)
        {
            Field x = new Field(sheet,i);

            if(x.getType().equals("string"))
            {
                Fields.add(x);
            }
            else if (!(x.getType().equals("Type")) && !(x.getType().equals("")))
            {
                Objects.add(x);
            }
        }

        for (int i = 0; i<Objects.size(); i++)
        {
            RealObjects.add(new ArrayList<Field>());
            RealObjects.get(i).add(Objects.get(i));
        }

        for (int i=0; i<Fields.size(); i++)
        {

            for (int j=0; j<Objects.size(); j++)
            {
                if(RealObjects.get(j).get(0).getType().equals(Fields.get(i).getParent()))
                {
                    RealObjects.get(j).add(Fields.get(i));

                }
            }
        }






    }
}
















