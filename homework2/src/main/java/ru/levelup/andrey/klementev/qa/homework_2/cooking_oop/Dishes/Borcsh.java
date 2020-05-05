package ru.levelup.andrey.klementev.qa.homework_2.cooking_oop.Dishes;

import ru.levelup.andrey.klementev.qa.homework_2.cooking_oop.BaseProduct;
import ru.levelup.andrey.klementev.qa.homework_2.cooking_oop.Dish;
import ru.levelup.andrey.klementev.qa.homework_2.cooking_oop.ProductTypes.Meat;
import ru.levelup.andrey.klementev.qa.homework_2.cooking_oop.ProductTypes.Sauce;
import ru.levelup.andrey.klementev.qa.homework_2.cooking_oop.ProductTypes.Vegetable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Borcsh extends Dish {

    List<BaseProduct> borschIngredients = new ArrayList<>();
    Meat beef;
    Vegetable beet;
    Vegetable potato;
    Vegetable cabbage;
    Vegetable carrot;
    Vegetable garlic;
    Vegetable onion;
    Sauce tomatoPaste;
    double sumCalories;

    public Borcsh(Meat beef, Vegetable beet, Vegetable potato, Vegetable cabbage, Vegetable carrot, Vegetable garlic,
                  Vegetable onion, Sauce tomatoPaste) {
        this.beef = beef;
        this.beet = beet;
        this.potato = potato;
        this.cabbage = cabbage;
        this.carrot = carrot;
        this.garlic = garlic;
        this.onion = onion;
        this.tomatoPaste = tomatoPaste;
        this.sumCalories = beef.getCalories() + beet.getCalories() + potato.getCalories() + cabbage.getCalories() +
                carrot.getCalories() + garlic.getCalories() + onion.getCalories() + tomatoPaste.getCalories();
        this.borschIngredients.addAll(Arrays.asList(beef, beet, potato, cabbage, carrot, garlic, onion, tomatoPaste));
    }

    @Override
    public double sumCalories() {
        return sumCalories;
    }

    @Override
    public List<BaseProduct> sortByCalories() {
        borschIngredients.sort(Comparator.comparingDouble(BaseProduct::getCalories));
        return borschIngredients;
    }

    @Override
    public BaseProduct findByName(String name) {
       for (BaseProduct ingredient : borschIngredients) {
            if (ingredient.getName().equals(name)) {
                return ingredient;
            }
        }
        return null;
    }
}
