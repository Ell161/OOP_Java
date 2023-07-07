package AbstractionClassesPart2;

import java.util.Scanner;

import static AbstractionClassesPart2.AbstractGame.choiceGame;
import static AbstractionClassesPart2.AbstractGame.gameGreeting;

public class Main {
    public static void main(String[] args) {
        Logger logger = new Logger();
        gameGreeting();
        try {
            gameBuLlAndCow(logger);
        } catch (Exception exception) {
            logger.logging("Error:", exception);
        }
    }

    public static void gameBuLlAndCow(Logger logger) {
        Scanner scanner = new Scanner(System.in);
        String userChoice = choiceGame();
        System.out.println("Введи количество букв в угадываемом слове и количество попыток:");
        if (userChoice.equals("ru")) {
            logger.logging("Start RuGame", null);
            RuGame ruGame = new RuGame();
            ruGame.start(scanner.nextInt(), scanner.nextInt());
            scanner.nextLine();
            logger.logging("Computer word: " + ruGame.getComputerWord(), null);
            while (!ruGame.getGameStatus().equals(GameStatus.FINISH)) {
                String value = scanner.nextLine();
                Answer answer = ruGame.inputValue(value);
                if (answer != null) {
                    logger.logging("Answer: " + value + " NumTry: " + answer.getNumTry(), null);
                    System.out.println("Коров - " + answer.getCow()
                            + ", быков - " + answer.getBull() + ", попытка - " + answer.getNumTry());
                }
            }
            logger.logging("Game status: " + ruGame.getGameStatus(), null);
        } else if (userChoice.equals("en")) {
            logger.logging("Start EnGame", null);
            EnGame enGame = new EnGame();
            enGame.start(scanner.nextInt(), scanner.nextInt());
            scanner.nextLine();
            logger.logging("Computer word: " + enGame.getComputerWord(), null);
            while (!enGame.getGameStatus().equals(GameStatus.FINISH)) {
                String value = scanner.nextLine();
                Answer answer = enGame.inputValue(value);
                if (answer != null) {
                    logger.logging("Answer: " + value + " NumTry: " + answer.getNumTry(), null);
                    System.out.println("Коров - " + answer.getCow()
                            + ", быков - " + answer.getBull() + ", попытка - " + answer.getNumTry());
                }
            }
            logger.logging("Game status: " + enGame.getGameStatus(), null);
        } else if (userChoice.equals("num")) {
            logger.logging("Start NumberGame", null);
            NumberGame numberGame = new NumberGame();
            numberGame.start(scanner.nextInt(), scanner.nextInt());
            scanner.nextLine();
            logger.logging("Computer word: " + numberGame.getComputerWord(), null);
            while (!numberGame.getGameStatus().equals(GameStatus.FINISH)) {
                String value = scanner.nextLine();
                Answer answer = numberGame.inputValue(value);
                if (answer != null) {
                    logger.logging("Answer: " + value + " NumTry: " + answer.getNumTry(), null);
                    System.out.println("Коров - " + answer.getCow()
                            + ", быков - " + answer.getBull() + ", попытка - " + answer.getNumTry());
                }
            }
            logger.logging("Game status: " + numberGame.getGameStatus(), null);
        }
        System.out.println("Начать еще игру? Да - 1, Нет - 0");
        int input = scanner.nextInt();
        if (input == 1) gameBuLlAndCow(logger);
        else if (input == 0) {
            System.out.println("Пока!");
        }
    }
}
