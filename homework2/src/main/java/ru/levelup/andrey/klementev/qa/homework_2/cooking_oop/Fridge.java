package ru.levelup.andrey.klementev.qa.homework_2.cooking_oop;

import ru.levelup.andrey.klementev.qa.homework_2.cooking_oop.product_types.Fruit;
import ru.levelup.andrey.klementev.qa.homework_2.cooking_oop.product_types.Meat;
import ru.levelup.andrey.klementev.qa.homework_2.cooking_oop.product_types.Sauce;
import ru.levelup.andrey.klementev.qa.homework_2.cooking_oop.product_types.Vegetable;

import java.text.DecimalFormat;

public class Fridge {

    public Vegetable getSomeVegetable(String name) {
        return new Vegetable(name);
    }

    public Fruit getSomeFruit(String name) {
        return new Fruit(name);
    }

    public Meat getSomeMeat(String name, Meat.MeatType type) {
        return new Meat(name, type);
    }

    public Sauce getSomeSauce(String name) {
        return new Sauce(name);
    }

}
