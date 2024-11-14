package dev.lpa;

// product should be immutable, so we use record
public record Product(String sku, String name, String mfgr, Category category){

}