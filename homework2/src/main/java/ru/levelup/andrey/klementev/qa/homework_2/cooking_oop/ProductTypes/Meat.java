package ru.levelup.andrey.klementev.qa.homework_2.cooking_oop.ProductTypes;

import ru.levelup.andrey.klementev.qa.homework_2.cooking_oop.BaseProduct;

public class Meat extends BaseProduct {

    public enum MeatType {HEN, BEEF, PORK}

    public Meat(String name, MeatType type) {
        super(name);
    }

    public String getType() {
        return "meat";
    }


}
