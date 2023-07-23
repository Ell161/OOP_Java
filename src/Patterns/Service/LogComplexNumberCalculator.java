package Patterns.Service;

import Patterns.Model.Complex;

import java.util.Formatter;

public class LogComplexNumberCalculator extends ComplexNumberCalculator {
    private Logable logger;

    public LogComplexNumberCalculator(Complex primaryValue, Logable logger) {
        super(primaryValue);
        this.logger = logger;
    }

    @Override
    public Calculable sum(Object value) {
        Formatter f = new Formatter();
        f.format("Primary value = %s, added value = %s", super.toString(), value);
        logger.logging(new Object(){}.getClass().getEnclosingMethod().getName(), String.valueOf(f));
        return super.sum(value);
    }

    @Override
    public Calculable diff(Object value) {
        Formatter f = new Formatter();
        f.format("Primary value = %s, added value = %s", super.toString(), value);
        logger.logging(new Object(){}.getClass().getEnclosingMethod().getName(), String.valueOf(f));
        return super.diff(value);
    }

    @Override
    public Calculable multi(Object value) {
        Formatter f = new Formatter();
        f.format("Primary value = %s, added value = %s", super.toString(), value);
        logger.logging(new Object(){}.getClass().getEnclosingMethod().getName(), String.valueOf(f));
        return super.multi(value);
    }
}
