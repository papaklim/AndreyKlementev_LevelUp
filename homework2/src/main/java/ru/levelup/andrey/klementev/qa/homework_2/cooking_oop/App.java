package ru.levelup.andrey.klementev.qa.homework_2.cooking_oop;

import ru.levelup.andrey.klementev.qa.homework_2.cooking_oop.Dishes.Borcsh;
import ru.levelup.andrey.klementev.qa.homework_2.cooking_oop.Dishes.FruitSalad;
import ru.levelup.andrey.klementev.qa.homework_2.cooking_oop.ProductTypes.Fruit;
import ru.levelup.andrey.klementev.qa.homework_2.cooking_oop.ProductTypes.Meat;
import ru.levelup.andrey.klementev.qa.homework_2.cooking_oop.ProductTypes.Sauce;
import ru.levelup.andrey.klementev.qa.homework_2.cooking_oop.ProductTypes.Vegetable;

import java.text.DecimalFormat;

public class App {
    public static void main(String[] args) {

        Fridge fridge = new Fridge();

//        Получение овощей из холодильника для приготовления борща
        Meat beef = fridge.getSomeMeat("Говядина", Meat.MeatType.BEEF);
        Vegetable beet = fridge.getSomeVegetable("Свекла");
        Vegetable potato = fridge.getSomeVegetable("Картофель");
        Vegetable cabbage = fridge.getSomeVegetable("Капуста");
        Vegetable carrot = fridge.getSomeVegetable("Морковь");
        Vegetable garlic = fridge.getSomeVegetable("Чеснок");
        Vegetable onion = fridge.getSomeVegetable("Лук");
        Sauce tomatoPaste = fridge.getSomeSauce("Томатная паста");

//        Приготовление борща
        Dish borcsh = new Borcsh(beef, beet, potato, cabbage, carrot, garlic, onion, tomatoPaste);

//        Получение фруктов из холодильника для приготовления фруктового салата
        Fruit apple = fridge.getSomeFruit("Яблоко");
        Fruit banana = fridge.getSomeFruit("Банан");
        Fruit pinapple = fridge.getSomeFruit("Ананас");

//        Приготовление фруктового салата
        Dish fruitSalad = new FruitSalad(apple, banana, pinapple);


//        Приготовление обеда
        Dinner complexDinner = new Dinner(borcsh, fruitSalad);

////        Получение мяса из холодильника
//        Meat hen = fridge.getSomeMeat(new Meat("Курица", Meat.meatType.HEN));
//        Meat pork = fridge.getSomeMeat(new Meat("Свинина", Meat.meatType.PORK));


        System.out.println(potato.getCalories());
        System.out.println(cabbage.getCalories());
        System.out.println();
        System.out.println(apple.getCalories());
        System.out.println("Количество калорий в борще: " + getFormat(borcsh.sumCalories()) + " ККал");
        System.out.println("Количество калорий во фруктовом салате: " + getFormat(fruitSalad.sumCalories()) + " ККал");
        System.out.println("Количество калорий в обеде " + getFormat(complexDinner.calculateCalories()) + " ККал");

//        Сортировка ингредиентов блюда по калориям:
        System.out.println(borcsh.sortByCalories());
        System.out.println(fruitSalad.sortByCalories());
        System.out.println();

//        Поиск ингредиентов блюда по названию
        System.out.println(borcsh.findByName("Лук"));
        System.out.println(borcsh.findByName("Тыква"));
        System.out.println();
        System.out.println(fruitSalad.findByName("Клубника"));
        System.out.println(fruitSalad.findByName("Банан"));

    }

    private static String getFormat(double v) {
        return new DecimalFormat("#0.00").format(v);
    }
}
