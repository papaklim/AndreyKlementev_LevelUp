package ru.levelup.andrey.klementev.qa.homework_2.cooking_oop.dishes;

import ru.levelup.andrey.klementev.qa.homework_2.cooking_oop.BaseProduct;
import ru.levelup.andrey.klementev.qa.homework_2.cooking_oop.Dish;
import ru.levelup.andrey.klementev.qa.homework_2.cooking_oop.product_types.Fruit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FruitSalad extends Dish {

    List<BaseProduct> fruitSaladIngredients = new ArrayList<>();
    Fruit apple;
    Fruit banana;
    Fruit pinapple;
    double sumCalories;

    public FruitSalad(Fruit apple, Fruit banana, Fruit pinapple) {
        this.apple = apple;
        this.banana = banana;
        this.pinapple = pinapple;
        this.sumCalories = apple.getCalories() + banana.getCalories() + pinapple.getCalories();
        this.fruitSaladIngredients.addAll(Arrays.asList(apple, banana, pinapple));
    }

    @Override
    public double sumCalories() {
        return sumCalories;
    }

    @Override
    public List<BaseProduct> sortByCalories() {
        fruitSaladIngredients.sort(Comparator.comparingDouble(BaseProduct::getCalories));
        return fruitSaladIngredients;
    }

    @Override
    public BaseProduct findByName(String name) {
        for (BaseProduct ingredient : fruitSaladIngredients) {
            if (ingredient.getName().equals(name)) {
                return ingredient;
            }
        }
        return null;
    }

}
