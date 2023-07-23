package Patterns.Model;

import Patterns.Service.TypeOfNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Complex implements TypeOfNumber {
    private String value;
    private Double real;
    private Double imaginary;

    public Complex(String value) {
        if (value.contains(",")) {
            this.value = value.replaceAll(",", ".");
        } else this.value = value;
        Pattern pattern = Pattern.compile("[+-]?([0-9]+|[0-9]+(.|,)[0-9]+)");
        Matcher matcher = pattern.matcher(this.value);
        List<String> complexValues = new ArrayList<>();
        while (matcher.find()) {
            if (!matcher.group().isEmpty()) complexValues.add(matcher.group());
        }
        this.real = Double.parseDouble(complexValues.get(0));
        this.imaginary = Double.parseDouble(complexValues.get(1));
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        if (checkComplexNumber(value)) {
            if (value.contains(",")) {
                this.value = value.replaceAll(",", ".");
            } else this.value = value;
            Pattern pattern = Pattern.compile("[+-]?([0-9]+|[0-9]+(.|,)[0-9]+)");
            Matcher matcher = pattern.matcher(this.value);
            List<String> complexValues = new ArrayList<>();
            while (matcher.find()) {
                if (!matcher.group().isEmpty()) complexValues.add(matcher.group());
            }
            this.real = Double.parseDouble(complexValues.get(0));
            this.imaginary = Double.parseDouble(complexValues.get(1));
        } else {
            System.out.println("Новое значение не задано. Неизвестный тип данных");
        }
    }

    public Double getReal() {
        return real;
    }

    public Double getImaginary() {
        return imaginary;
    }

    @Override
    public String toString() {
        return value;
    }
}
