package com.codecool.api;

public class CombinationHanger extends Hanger {

    private Clothing upperClothing;
    private Clothing lowerClothing;

    @Override
    protected void addClothing(Clothing clothing) throws ClothingTypeException, HangerFullException, NoSuchSlotException {
        if (upperClothing == null || lowerClothing == null) {
            if (isClothingAllowed(clothing, "upper")) {
                upperClothing = clothing;
            } else if (isClothingAllowed(clothing, "lower")) {
                lowerClothing = clothing;
            } else {
                throw new ClothingTypeException();
            }
        } else if (upperClothing != null && lowerClothing != null) {
            throw new HangerFullException();
        }
    }

    @Override
    protected void removeClothing(Clothing clothing) throws NoSuchClothingException {
        if (clothing.equals(upperClothing)) {
            upperClothing = null;
        } else if (clothing.equals(lowerClothing)) {
            lowerClothing = null;
        } else {
            throw new NoSuchClothingException();
        }
    }

    @Override
    protected boolean isClothingAllowed(Clothing clothing) {
        return false;
    }

    protected boolean isClothingAllowed(Clothing clothing, String slot) throws NoSuchSlotException {
        if (slot.equals("upper")) {
            return clothing.getClothingType().equals(ClothingType.SHIRT) || clothing.getClothingType().equals(ClothingType.BLOUSE);
        } else if (slot.equals("lower")) {
            return clothing.getClothingType().equals(ClothingType.TROUSERS) || clothing.getClothingType().equals(ClothingType.SKIRT);
        } else {
            throw new NoSuchSlotException();
        }
    }

    public void removeAllClothing() throws NoSuchClothingException {
        if (upperClothing != null || lowerClothing != null) {
            upperClothing = null;
            lowerClothing = null;
        } else {
            throw new NoSuchClothingException();
        }
    }

    public Clothing getUpperClothing() {
        return upperClothing;
    }

    public Clothing getLowerClothing() {
        return lowerClothing;
    }
}
