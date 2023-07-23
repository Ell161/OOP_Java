package Patterns.Controller;

import Patterns.Service.Calculable;
import Patterns.Service.CalculableFactory;
import Patterns.Service.ICalculableFactory;
import Patterns.View.ViewCalculator;

public class ControllerCalculator {
    private final ICalculableFactory calculableFactory;
    private final ViewCalculator view;

    public ControllerCalculator() {
        this.calculableFactory = new CalculableFactory();
        this.view = new ViewCalculator();
    }

    public void run() {
        while (true) {
            String primaryArg = view.msgSetValue();
            Calculable calculator = calculableFactory.create(primaryArg);
            while (true) {
                if (calculator != null) {
                    String cmd = view.msgSetCommand();
                    if (cmd.equals("*")) {
                        String arg = view.msgSetValue();
                        calculator.multi(arg);
                        continue;
                    }
                    if (cmd.equals("+")) {
                        String arg = view.msgSetValue();
                        calculator.sum(arg);
                        continue;
                    }
                    if (cmd.equals("-")) {
                        String arg = view.msgSetValue();
                        calculator.diff(arg);
                        continue;
                    }
                    if (cmd.equals("=")) {
                        var result = calculator.getResult();
                        view.msgGetResult(result);
                        break;
                    }
                } else {
                    System.out.println("Неизвестный тип данных.");
                    break;
                }
            }
            String retry = view.msgTry();
            if (retry.equalsIgnoreCase("Y")) {
                continue;
            }
            break;
        }
    }
}
