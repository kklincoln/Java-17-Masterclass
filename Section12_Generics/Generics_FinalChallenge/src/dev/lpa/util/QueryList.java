package dev.lpa.util;

import dev.lpa.model.Student;

import java.util.ArrayList;
import java.util.List;

//query or search a list, looking for matches, when they specify a field and a value in that field.
//e.g. get a list of all students taking Java course, pass course as the field to use and pass Java as the value to match on
public class QueryList <T extends Student & QueryItem> extends ArrayList<T> {  //extend the instance we created
//     private List<T> items;

    //no args constructor
    public QueryList(){

    }

     //generate constructor
    public QueryList(List<T> items) {
//        this.items = items;
        super(items); //pass items into the super constructor instead
    }

    // adjust the method to account for arg of any List type to be passed for a search
    public static <S extends QueryItem> List<S> getMatches(List<S> items, String field, String value){
        List<S> matches = new ArrayList<>(); //create a new ArrayList
        //loop through all items, check if match on field and value
        for (var item : items){
            if (item.matchField(field, value)){
                matches.add(item);
            }
        }
        //return the list
        return matches;
    }


    //add method taking field name and value, to attempt to find match
    public QueryList<T> getMatches(String field, String value){ //return a QueryList type, this lets you chain calls to getMatches
        QueryList<T> matches = new QueryList<>(); //create a new ArrayList
        //loop through all items, check if match on field and value
        for (var item : this){
            if (item.matchField(field, value)){
                matches.add(item);
            }
        }
        //return the list
        return matches;
    }



}
