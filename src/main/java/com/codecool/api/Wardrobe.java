package com.codecool.api;

import java.util.ArrayList;
import java.util.List;

public class Wardrobe {

    private int size;
    private List<Hanger> hangers;

    public Wardrobe(int size) {
        this.size = size;
        this.hangers = new ArrayList<>();
    }

    public void storeHanger(Hanger hanger) {
        if (!isFull()) {
            hangers.add(hanger);
        }
    }

    private boolean isFull() {
        return hangers.size() >= size;
    }

    public boolean isSpaceFree(Clothing clothing) {
        if (!isFull()) {
            return true;
        }
        else if (clothing.getClothingType().equals(ClothingType.SHIRT) || clothing.getClothingType().equals(ClothingType.BLOUSE)) {
            for (Hanger hanger:hangers) {
                if (hanger instanceof CombinationHanger) {
                    return ((CombinationHanger) hanger).getUpperClothing() == null;
                }
            }
        }
        else if (clothing.getClothingType().equals(ClothingType.TROUSERS) || clothing.getClothingType().equals(ClothingType.SKIRT)) {
            for (Hanger hanger:hangers) {
                if (hanger instanceof CombinationHanger) {
                    return ((CombinationHanger) hanger).getLowerClothing() == null;
                }
            }
        }
        return false;
    }

}
