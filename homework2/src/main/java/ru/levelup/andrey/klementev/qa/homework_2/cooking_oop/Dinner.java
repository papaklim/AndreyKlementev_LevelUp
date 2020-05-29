package ru.levelup.andrey.klementev.qa.homework_2.cooking_oop;

public class Dinner implements Eatable {

    private final Dish firstDish;
    private final Dish secondDish;

    public Dinner(Dish firstDish, Dish secondDish) {
        this.firstDish = firstDish;
        this.secondDish = secondDish;
    }

    @Override
    public double calculateCalories() {
        return firstDish.sumCalories() + secondDish.sumCalories();
    }
}
