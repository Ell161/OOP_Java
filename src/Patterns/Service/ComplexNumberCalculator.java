package Patterns.Service;

import Patterns.Model.Complex;

import java.util.Formatter;

public class ComplexNumberCalculator implements Calculable, TypeOfNumber {
    private final Complex primaryValue;

    public ComplexNumberCalculator(Complex primaryValue) {
        this.primaryValue = primaryValue;
    }

    /**
     * @apiNote Метод для конвертации данных, полученных в результате рассчета, в строковое значение комплексного числа
     * @param real действительная часть комплексного числа, полученная из результата
     * @param imaginary мнимая часть комплексного числа, полученная из результата
     * @return строковое значение комплексного числа
     */
    private String convertComplexValue(Double real, Double imaginary) {
        Formatter f = new Formatter();
        if (imaginary >= 0) f.format("%.2f+%.2fi", real, imaginary);
        else {
            f.format("%.2f%.2fi", real, imaginary);
        }
        return String.valueOf(f);
    }

    @Override
    public Calculable sum(Object value) {
        if (checkComplexNumber((String) value)) {
            Complex complexValue = new Complex((String) value);
            Double resultReal = primaryValue.getReal() + complexValue.getReal();
            Double resultImaginary = primaryValue.getImaginary() + complexValue.getImaginary();
            primaryValue.setValue(convertComplexValue(resultReal, resultImaginary));
        } else if (checkDoubleNumber((String) value)) {
            Double resultReal = primaryValue.getReal() + Double.parseDouble((String) value);
            primaryValue.setValue(convertComplexValue(resultReal, primaryValue.getImaginary()));
        } else System.out.println("Операция не выполнена");
        return this;
    }

    @Override
    public Calculable diff(Object value) {
        if (checkComplexNumber((String) value)) {
            Complex complexValue = new Complex((String) value);
            Double resultReal = primaryValue.getReal() - complexValue.getReal();
            Double resultImaginary = primaryValue.getImaginary() - complexValue.getImaginary();
            primaryValue.setValue(convertComplexValue(resultReal, resultImaginary));
        } else if (checkDoubleNumber((String) value)) {
            Double resultReal = primaryValue.getReal() - Double.parseDouble((String) value);
            primaryValue.setValue(convertComplexValue(resultReal, primaryValue.getImaginary()));
        } else System.out.println("Операция не выполнена");
        return this;
    }

    @Override
    public Calculable multi(Object value) {
        if (checkComplexNumber((String) value)) {
            Complex complexValue = new Complex((String) value);
            Double resultReal = primaryValue.getReal() * complexValue.getReal() - primaryValue.getImaginary() * complexValue.getImaginary();
            Double resultImaginary = primaryValue.getImaginary() * complexValue.getReal() + primaryValue.getReal() * complexValue.getImaginary();
            primaryValue.setValue(convertComplexValue(resultReal, resultImaginary));
        } else if (checkDoubleNumber((String) value)) {
            Double resultReal = primaryValue.getReal() * Double.parseDouble((String) value);
            Double resultImaginary = primaryValue.getImaginary() * Double.parseDouble((String) value);
            primaryValue.setValue(convertComplexValue(resultReal, primaryValue.getImaginary()));
        } else System.out.println("Операция не выполнена");
        return this;
    }

    @Override
    public Complex getResult() {
        return this.primaryValue;
    }

    @Override
    public String toString() {
        return this.primaryValue.toString();
    }
}
