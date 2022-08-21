package com.fakeuserdatagenerator.fakeuserdatagenerator.constant;

public enum PaymentType {
    VISA("Visa"),
    MASTERCARD("Mastercard"),
    AMERICAN_EXPRESS("American-Express");

    private final String label;

    PaymentType(String label) {
        this.label = label;
    }

    public static PaymentType getByLabel(String searchedLabel){
        for (PaymentType value : PaymentType.values()) {
            if(searchedLabel.equals(value.label)){
             return value;
            }
        }
        return null;
    }
}
