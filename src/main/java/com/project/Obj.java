package com.project;

import java.util.ArrayList;

public class Obj extends Field
{
    private String ObjectName;
    private ArrayList<Field> Fields;

    Obj(String ObjectName, String ObjectType , String Mandatory ,String Parent, String IO)
    {
        super(ObjectName,  ObjectType ,  Mandatory , Parent, IO);

        Fields = new ArrayList<Field>();
    }
    Obj()
    {
        Fields = new ArrayList<Field>();
    }

    public void AddFields(Field x)
    {
        Fields.add(x);
    }

    public void setObjectName(String objectName) {
        ObjectName = objectName;
    }

    public String getObjectName() {
        return ObjectName;
    }

    public Field getField(int i)
    {
        return Fields.get(i);
    }

    public int getNumberofFields()
    {
        return Fields.size();
    }

}