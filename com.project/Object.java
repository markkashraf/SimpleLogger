package com.project;

import java.util.ArrayList;

public class Object
{
    ArrayList<Field> Fields;
    String ObjectName;
    String Parent;

    Object()
    {
        Fields = new ArrayList<Field>();

    }

    public void AddFields(Field x)
    {
        Fields.add(x);
    }


}
