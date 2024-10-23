package dev.lpa.util;

public interface QueryItem {


    //create a method to match an instance by one of its field values
    public boolean matchField(String fieldName, String value);

}
