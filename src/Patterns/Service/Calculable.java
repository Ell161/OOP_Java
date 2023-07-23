package Patterns.Service;

public interface Calculable {
    Calculable sum(Object o);
    Calculable diff(Object o);
    Calculable multi(Object o);
    Object getResult();


}
