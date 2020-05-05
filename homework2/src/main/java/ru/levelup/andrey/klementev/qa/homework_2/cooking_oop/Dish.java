package ru.levelup.andrey.klementev.qa.homework_2.cooking_oop;

import java.util.List;

public abstract class Dish {

    public abstract double sumCalories();

    public abstract List<BaseProduct> sortByCalories();

    public abstract BaseProduct findByName(String name);


}
