package Patterns.View;

import java.util.Scanner;

public class ViewCalculator {
    public String msgSetCommand() {
        String cmd = prompt("Введите команду (+, -, *, =) : ");
        return cmd;
    }

    public String msgSetValue() {
        String value = prompt("Введите значение: ");
        return value;
    }

    public String msgTry() {
        String value = prompt("Еще посчитать (Y/N)? ");
        return value;
    }

    public void msgGetResult(Object o) {
        System.out.println(o.toString());
    }

    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }
}
