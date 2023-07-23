package Patterns.Service;

public interface TypeOfNumber {
    default boolean checkComplexNumber(String value) {
        if (value.matches("[+-]?([0-9]+|[0-9]+(.|,)[0-9]+)(\\+|-)([0-9]+|[0-9]+(.|,)[0-9]+)i\\b")) {
            return true;
        }
        return false;
    }

    default boolean checkDoubleNumber(String value) {
        try {
            Double.parseDouble(value);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
