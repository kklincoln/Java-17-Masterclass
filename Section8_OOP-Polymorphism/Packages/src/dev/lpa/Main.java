package dev.lpa;

import com.abc.first.Item;

public class Main {
    public static void main(String[] args) {
        Item firstItem = new Item("Burger"); //approach one, this one auto creates the import statement
//        com.abc.first.Item firstItem = new com.abc.first.Item("Drink"); //fully qualified class name needs no import statement
        System.out.println(firstItem);

    }
}
