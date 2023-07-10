package Generalizations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        List<String> stringList = new ArrayList<>(Arrays.asList("2", "2.5", "1.0"));
        List<Double> doubleList = new ArrayList<>(Arrays.asList(2.5, 4.0, 1.5));
        List<Integer> integerList = new ArrayList<>();
        for (int i = 5; i >= 0; i -=5) {
            integerList.add(i);
        }
        System.out.println(calculator.sum(doubleList));
        System.out.println(calculator.sum(integerList));
        System.out.println(calculator.mult(doubleList));
        System.out.println(calculator.mult(integerList));
        System.out.println(calculator.div(doubleList));
        System.out.println(calculator.div(integerList));
        System.out.println(calculator.toBinary(stringList));
    }
}
