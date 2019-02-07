package com.codecool.api;

import java.util.ArrayList;
import java.util.List;

public abstract class Hanger {

    protected abstract void addClothing(Clothing clothing) throws WardrobeException;

    protected abstract void removeClothing(Clothing clothing) throws WardrobeException;

    protected abstract boolean isClothingAllowed(Clothing clothing);

}
