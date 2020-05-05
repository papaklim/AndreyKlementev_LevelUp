package ru.levelup.andrey.klementev.qa.homework_2.cooking_oop.product_types;

import ru.levelup.andrey.klementev.qa.homework_2.cooking_oop.BaseProduct;

public class Vegetable extends BaseProduct {

    public Vegetable(String name) {
        super(name);
    }

    public String getType() {
        return "vegetable";
    }

}
