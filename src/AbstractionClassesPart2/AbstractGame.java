package AbstractionClassesPart2;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public abstract class AbstractGame implements Game {
    Integer sizeWord;
    Integer maxTry;
    int currentTry;
    String computerWord;
    GameStatus gameStatus = GameStatus.INIT;

    public String getComputerWord() {
        return this.computerWord;
    }

    @Override
    public void start(Integer sizeWord, Integer maxTry) {
        this.sizeWord = sizeWord;
        this.maxTry = maxTry;
        computerWord = generateWord();
        System.out.println("Я загадал слово из " + this.sizeWord + " букв. У тебя " + this.maxTry + ", чтобы отгадать!");
        this.gameStatus = GameStatus.START;
        this.currentTry = 0;
    }

    @Override
    public Answer inputValue(String value) {
        value = value.toLowerCase();
        if (currentTry >= maxTry) {
            gameStatus = GameStatus.FINISH;
            System.out.println("вы проиграли по количеству попыток");
            return null;
        }
        int bull = 0;
        int cow = 0;
        for (int i = 0; i < value.length(); i++) {
            if (value.charAt(i) == computerWord.charAt(i)) {
                bull++;
                cow++;
            } else if (computerWord.contains(String.valueOf(value.charAt(i)))) {
                cow++;
            }
        }
        currentTry++;
        if (sizeWord.equals(bull)) {
            gameStatus = GameStatus.FINISH;
            System.out.println("вы Победили!!");
            return null;
        }
        return new Answer(bull, cow, currentTry);
    }

    public static void gameGreeting() {
        System.out.println(".\n" +
                "▄▄▄░░░░░░░░░░░░░░░░░░░░░░▄▄▄\n" +
                "░███░░░░░░░░▄▄▄▄░░░░░░░░███░\n" +
                "░░█▀█▄▄▄░░░██████░░░▄▄▄█▀█░░\n" +
                "░░▀█░░░▀▀██▄▄▄▄▄▄██▀▀░░░█▀░░\n" +
                "░░░░▀███▄██████████▄███▀░░░░\n" +
                "░░░▄█▀▄███▀██████▀███▄▀█░░░░\n" +
                "░░▄██▄██░██████████░██▄██▄░░\n" +
                "░░███████░████████░███████░░\n" +
                "░░████████░█▀▀▀▀█░████████░░\n" +
                "░░▀███████░█▄▄▄▄█░███████▀░░\n" +
                "░░░▀███████▄▄▄▄▄▄███████▀░░░\n" +
                "░░░░▀██████████████████▀░░░░\n" +
                "░░░░░▀████████████████▀░░░░░\n" +
                "░░░░░░████████████████░░░░░░\n" +
                "░░░░░░█████░░▀▀░░█████░░░░░░\n" +
                "░░░░░░▀███░░░░░░░░███▀░░░░░░\n" +
                "░░░░░░░███░░░░░░░░███░░░░░░░\n" +
                "░░░░░░░███░░░░░░░░███░░░░░░░\n" +
                "░░░░░░█████░░░░░░█████░░░░░░\n" +
                "\n" +
                "Привет! Это игра \"Быки и Коровы\". Я загадываю слово, а ты за определенное количество попыток его отгадываешь. " +
                "\nПосле каждой попытки я сообщу тебе количество угаданных букв без совпадения с их позициями (количество «коров») " +
                "\nи полных совпадений (количество «быков»).");
    }

    public static String choiceGame() {
        System.out.println("Выбери настройки игры. 1 - русский язык, 2 - английский язык, 3 - цифры.");
        Scanner scanner = new Scanner(System.in);
        int userChoice = scanner.nextInt();
        switch (userChoice) {
            case 1:
                return "ru";
            case 2:
                return "en";
            case 3:
                return "num";
            default:
                return null;
        }
    }

    @Override
    public GameStatus getGameStatus() {
        return gameStatus;
    }

    abstract List<String> generateCharList();

    private String generateWord() {
        List<String> charList = generateCharList();
        String result = "";
        Random random = new Random();
        for (int i = 0; i < sizeWord; i++) {
            int randomIndex = random.nextInt(charList.size());
            result += charList.get(randomIndex);
            charList.remove(randomIndex);
        }
        return result;
    }
}
