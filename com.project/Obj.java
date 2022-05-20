package com.project;

import java.util.ArrayList;

public class Obj
{
    ArrayList<Field> Fields;
    String ObjectName;
    ArrayList<Obj> InternalObjects;
    String Parent;

    Obj()
    {
        Fields = new ArrayList<Field>();
        ArrayList<Obj> InternalObjects = new ArrayList<Obj>();
    }

    public void AddFields(Field x)
    {
        Fields.add(x);
    }


}
