package ru.level.up.andrey.klementev.qa.homework_7.api;

public enum ColorLabel {

    YELLOW ("yellow"),
    PURPLE ("purple"),
    BLUE ("blue"),
    RED ("red"),
    GREEN ("green"),
    ORANGE ("orange"),
    BLACK ("black"),
    SKY ("sky"),
    PINK ("pink"),
    LIME ("lime");

    public final String color;

    ColorLabel(String color){
        this.color = color;
    }
}
