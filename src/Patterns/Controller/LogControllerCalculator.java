package Patterns.Controller;

import Patterns.Service.*;
import Patterns.View.ViewCalculator;

public class LogControllerCalculator {
    private final ICalculableFactory logCalculableFactory;
    private final ViewCalculator view;
    private final Logable logger;

    public LogControllerCalculator() {
        this.logger = new ConsoleLogger();
        this.logCalculableFactory = new LogCalculableFactory(this.logger);
        this.view = new ViewCalculator();
    }

    public void run() {
        while (true) {
            String primaryArg = view.msgSetValue();
            Calculable calculator = logCalculableFactory.create(primaryArg);
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
