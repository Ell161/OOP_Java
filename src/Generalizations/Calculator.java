package Generalizations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Calculator {

    public Double sum(List<? extends Number> numbers) {
        Double result = 0.0;
        for (Number number : numbers) {
            result += number.doubleValue();
        }
        return result;
    }

    public Double mult(List<? extends Number> numbers) {
        Double result = 1.0;
        for (Number number : numbers) {
            result *= number.doubleValue();
        }
        return result;
    }

    public Object div(List<? extends Number> numbers) {
        Double result = numbers.get(0).doubleValue();
        try {
            for (int i = 1; i < numbers.size(); i++) {
                if (numbers.get(i).doubleValue() != 0) result /= numbers.get(i).doubleValue();
                else {
                    throw new ArithmeticException();
                }
            }
        } catch (ArithmeticException e) {
            return "Invalid divisor: division by zero can't be processed";
        }
        return result;
    }

    public List<String> toBinary(List<?> numbers) {
        List<String> numbersToBinary = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) instanceof Integer) {
                String temp = dec2bin((Integer) numbers.get(i));
                numbersToBinary.add(temp);
            } else if (numbers.get(i) instanceof Double) {
                Integer temp = parseToInt((Double) numbers.get(i));
                if (temp != null) {
                    numbersToBinary.add(dec2bin(temp));
                } else numbersToBinary.add(null);
            } else if (numbers.get(i) instanceof String) {
                try {
                    Double doubleValue = Double.parseDouble((String) numbers.get(i));
                    Integer temp = parseToInt(doubleValue);
                    if (temp != null) {
                        numbersToBinary.add(dec2bin(temp));
                    } else numbersToBinary.add(null);
                } catch (NumberFormatException e) {
                    numbersToBinary.add(null);
                }
            }
        }
        return numbersToBinary;
    }

    private Integer parseToInt(Double value) {
        Integer intValue = value.intValue();
        if (value % intValue != 0) {
            return null;
        } else return intValue;
    }

    private String dec2bin(int value) {
        List<Integer> binaryNum = new ArrayList<>();
        while (value != 0) {
            binaryNum.add(value % 2);
            value /= 2;
        }
        Collections.reverse(binaryNum);
        StringBuilder sb = new StringBuilder();
        for (int x : binaryNum) {
            sb.append(x);
        }
        return sb.toString();
    }
}
