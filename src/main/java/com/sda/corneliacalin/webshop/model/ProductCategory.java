package com.sda.corneliacalin.webshop.model;

//public enum ProductCategory {
//    GROCERY,
//    PET_FOOD,
//    ELECTRONICS
//}
public enum ProductCategory {
    GROCERY("Grocery"),
    PET_FOOD("Pet food"),
    ELECTRONICS("Electronics"),
    BEVERAGES("Beverages");
    private final String displayValue;
    ProductCategory(String displayValue) {
        this.displayValue = displayValue;
    }
    public String getDisplayValue() {
        return displayValue;
    }
}