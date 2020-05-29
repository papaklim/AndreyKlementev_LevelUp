package ru.levelup.andrey.klementev.qa.homework_2.cooking_oop;

import java.text.DecimalFormat;

public abstract class BaseProduct{

    String FORMATTED_DOUBLE = "#0.00";
    int MAX_RAND = 100;
    int MIN_RAND = 0;
    double RANDOM_FORMULA = (MAX_RAND - MIN_RAND + 1) + MIN_RAND;

    private final String name;
    private final double protein;
    private final double fat;
    private final double carbohydrate;
    private final double calories;


    public BaseProduct(String name) {
        this.name = name;
        this.protein = Math.random() * RANDOM_FORMULA;
        this.fat = Math.random() * RANDOM_FORMULA;
        this.carbohydrate = Math.random() * RANDOM_FORMULA;
        this.calories = Math.random() * RANDOM_FORMULA;
    }

    @Override
    public String toString() {
        return name + ": (" +
                "БЖУ=" + new DecimalFormat(FORMATTED_DOUBLE).format(protein) + "/" +
                new DecimalFormat(FORMATTED_DOUBLE).format(fat) + "/" +
                new DecimalFormat(FORMATTED_DOUBLE).format(carbohydrate) +
                ", ККал=" + new DecimalFormat(FORMATTED_DOUBLE).format(calories) + ")";
    }

    public String getName() {
        return name;
    }

    public double getProtein() {
        return protein;
    }

    public double getFat() {
        return fat;
    }

    public double getCarbohydrate() {
        return carbohydrate;
    }
    public double getCalories() {
        return calories;
    }
}
