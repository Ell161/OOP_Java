package Patterns.Service;

import Patterns.Model.Complex;

import java.util.regex.Pattern;

public class CalculableFactory implements ICalculableFactory, TypeOfNumber {
    public Calculable create(String primaryValue) {
       if (checkDoubleNumber(primaryValue)) return new NumberCalculator(Double.parseDouble(primaryValue));
       else if (checkComplexNumber(primaryValue)) return new ComplexNumberCalculator(new Complex(primaryValue));
       return null;
    }
}
