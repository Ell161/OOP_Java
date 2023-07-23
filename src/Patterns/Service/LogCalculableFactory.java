package Patterns.Service;

import Patterns.Model.Complex;

public class LogCalculableFactory implements ICalculableFactory, TypeOfNumber {
    private final Logable logger;

    public LogCalculableFactory(Logable logger) {
        this.logger = logger;
    }

    @Override
    public Calculable create(String primaryValue) {
        if (checkDoubleNumber(primaryValue)) return new LogNumberCalculator(Double.parseDouble(primaryValue), logger);
        else if (checkComplexNumber(primaryValue))
            return new LogComplexNumberCalculator(new Complex(primaryValue), logger);
        return null;
    }
}
