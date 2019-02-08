package com.codecool.api;

import java.util.ArrayList;
import java.util.List;

public class SimpleHanger extends Hanger {

    private Clothing clothing;
    private int id;

    public SimpleHanger(int id) {
        super(id);
    }

    @Override
    public void addClothing(Clothing clothing) throws ClothingTypeException, HangerFullException {
        if (this.clothing == null) {
            if (isClothingAllowed(clothing)) {
                this.clothing = clothing;
            } else {
                throw new ClothingTypeException();
            }
        } else {
            throw new HangerFullException();
        }
    }

    @Override
    public void removeClothing(Clothing clothing) throws NoSuchClothingException {
        if (this.clothing.equals(clothing)) {
            this.clothing = null;
        } else {
            throw new NoSuchClothingException();
        }
    }

    public boolean isClothingAllowed(Clothing clothing) {
        return clothing.getClothingType().equals(ClothingType.SHIRT) || clothing.getClothingType().equals(ClothingType.BLOUSE);
    }

    public Clothing getClothing() {
        return clothing;
    }
}
