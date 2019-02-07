package com.codecool.api;

public class Clothing {

    private String id;
    private String brand;
    private ClothingType clothingType;

    public Clothing(String id, String brand, ClothingType clothingType) {
        this.id = id;
        this.brand = brand;
        this.clothingType = clothingType;
    }

    public ClothingType getClothingType() {
        return clothingType;
    }

    public String getBrand() {
        return brand;
    }

    public String getId() {
        return id;
    }
}
