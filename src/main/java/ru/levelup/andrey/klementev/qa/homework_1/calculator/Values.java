package ru.levelup.andrey.klementev.qa.homework_1.calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Values {

    private static final String INT_MSG = "This input supports 'int' value only, input correct value: ";
    private static final String INT_DOUBLE_MSG = "This input supports 'int/double' value only, input correct value: ";

    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    String getAction() throws IOException {
        return input.readLine();
    }

    public void closeInput() throws IOException {
        input.close();
    }

    double getDoubleValue(String output) throws IOException {
        System.out.print(output);
        while (true) {
            try {
                return Double.parseDouble(getAction());
            } catch (NumberFormatException e) {
                System.out.print(INT_DOUBLE_MSG);
            }
        }
    }

    int getIntValue(String output) throws IOException {
        System.out.print(output);
        while (true) {
            try {
                return Integer.parseInt(getAction());
            } catch (NumberFormatException e) {
                System.out.print(INT_MSG);
            }
        }
    }

}
