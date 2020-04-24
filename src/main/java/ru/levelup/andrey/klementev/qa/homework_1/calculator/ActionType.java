package ru.levelup.andrey.klementev.qa.homework_1.calculator;

public enum ActionType {

    SUM, SUB, MUL, POW, FAC, FIB, EXIT, UNKNOWN;

    public static ActionType getAction(String actionValue) {
        if (actionValue.equalsIgnoreCase("sum") || actionValue.equalsIgnoreCase("sub") ||
                actionValue.equalsIgnoreCase("mul") || actionValue.equalsIgnoreCase("pow") ||
                actionValue.equalsIgnoreCase("fac") || actionValue.equalsIgnoreCase("fib") ||
                actionValue.equalsIgnoreCase("exit")) {
            return ActionType.valueOf(actionValue.toUpperCase());
        }
        return ActionType.UNKNOWN;
    }

}

