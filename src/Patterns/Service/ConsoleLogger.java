package Patterns.Service;

import java.util.Date;

public class ConsoleLogger implements Logable {
    @Override
    public void logging(String methodName, String message) {
        Date date = new Date();
        System.out.println(date + " | Action: " + methodName + " | " + message);
    }
}
