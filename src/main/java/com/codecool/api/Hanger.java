package com.codecool.api;

import java.util.ArrayList;
import java.util.List;

public abstract class Hanger {

    protected int id;

    public Hanger(int id) {
        this.id = id;
    }

    protected abstract void addClothing(Clothing clothing) throws WardrobeException;

    protected abstract void removeClothing(Clothing clothing) throws WardrobeException;

    public int getId() {
        return id;
    }
}
