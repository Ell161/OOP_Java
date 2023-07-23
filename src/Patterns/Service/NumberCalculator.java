package Patterns.Service;

public class NumberCalculator implements Calculable{
    private Double primaryValue;
    public NumberCalculator(Double primaryValue) {
        this.primaryValue = primaryValue;
    }

    private Double parseToDouble(Object value) {
        Double doubleValue = null;
        try {
            doubleValue = Double.parseDouble((String) value);
        } catch (Exception e) {
            System.out.println("Невозможно выполнить операцию. Введен аргумент несоответствующего типа.");
        }
        return doubleValue;
    }

    @Override
    public Calculable sum(Object value) {
        Double doubleValue = parseToDouble(value);
        if (doubleValue != null) this.primaryValue += doubleValue;
        return this;
    }

    @Override
    public Calculable diff(Object value) {
        Double doubleValue = parseToDouble(value);
        if (doubleValue != null) this.primaryValue -= doubleValue;
        return this;
    }

    @Override
    public Calculable multi(Object value) {
        Double doubleValue = parseToDouble(value);
        if (doubleValue != null) this.primaryValue *= doubleValue;
        return this;
    }

    @Override
    public Double getResult() {
        return this.primaryValue;
    }

    @Override
    public String toString() {
        return String.valueOf(primaryValue);
    }
}
