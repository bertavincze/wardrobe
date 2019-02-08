package com.codecool.api;

import java.util.ArrayList;
import java.util.List;

public class Wardrobe {

    private int size;
    private List<Hanger> hangers;
    private List<Clothing> clothes; // these are not in the wardrobe yet!

    public Wardrobe(int size) {
        this.size = size;
        this.hangers = new ArrayList<>();
        this.clothes = new ArrayList<>();
    }

    public void storeHanger(Hanger hanger) {
        if (!isFull() && !hangers.contains(hanger)) {
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

    public Clothing findClothingById(String id) throws NoSuchClothingException {
        for (Clothing clothing:clothes) {
            if (clothing.getId().equals(id)) {
                return clothing;
            }
        }
        throw new NoSuchClothingException();
    }

    public int getSize() {
        return size;
    }

    public List<Hanger> getHangers() {
        return hangers;
    }
}
