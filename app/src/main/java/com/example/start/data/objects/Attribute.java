package com.example.start.data.objects;


public class Attribute {

    private String mName;
    private String mValue;

    public Attribute(String name, String value) {
        this.mName = name;
        this.mValue = value;
    }

    public String getValue() {
        return mValue;
    }

    public String getName() {
        return mName;
    }
}
