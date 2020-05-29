package ru.levelup.andrey.klementev.qa.homework_2.cooking_oop;

import ru.levelup.andrey.klementev.qa.homework_2.cooking_oop.ProductTypes.Fruit;
import ru.levelup.andrey.klementev.qa.homework_2.cooking_oop.ProductTypes.Meat;
import ru.levelup.andrey.klementev.qa.homework_2.cooking_oop.ProductTypes.Sauce;
import ru.levelup.andrey.klementev.qa.homework_2.cooking_oop.ProductTypes.Vegetable;

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
