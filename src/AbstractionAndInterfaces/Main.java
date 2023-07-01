package AbstractionAndInterfaces;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Object> players = new ArrayList<Object>();
        players.add(new Robot("Eva", "E001"));
        players.add(new Person("John", 32));
        players.add(new Cat("Garfild", "Savannah"));

        Map<String, Integer> playerResults = new HashMap<>();
        List<Object> obstaclesList = generateObstaclesList(5);

        for (int i = 0; i < players.size(); i++) {
            if (players.get(i) instanceof Interfaces) {
                playerResults.put(((Interfaces) players.get(i)).getName(), 0);
                ((Interfaces) players.get(i)).info();
                obstaclesByPlayer(players.get(i), obstaclesList, playerResults);
            }
            handleWinner(playerResults);
        }
    }

    /**
     *
     * @param player экземпляр классов Человек, Кот, Робот
     * @param obstaclesList список из экземпляров классов Стена и Беговая дорожка
     * @param playerResults словарь со значениями: Игрок - его результат по итогам соревнований
     */
    public static void obstaclesByPlayer(Object player,
                                         List<Object> obstaclesList,
                                         Map<String, Integer> playerResults) {
        for (Object obstacle: obstaclesList) {
            if (obstacle instanceof Treadmill) {
                System.out.println(((Treadmill) obstacle).toString());
                int distance = ((Treadmill) obstacle).getDistance();
                int result = ((Interfaces) player).run(distance);
                handleResult(result);
                if (result == 0) return;
                playerResults.put(((Interfaces) player).getName(),
                        playerResults.get(((Interfaces) player).getName()) + result);
            } else if (obstacle instanceof Wall) {
                System.out.println(((Wall) obstacle).toString());
                double height = ((Wall) obstacle).getHeight();
                int result = ((Interfaces) player).jump(height);
                handleResult(result);
                if (result == 0) return;
                playerResults.put(((Interfaces) player).getName(),
                        playerResults.get(((Interfaces) player).getName()) + result);
            }
        }
    }

    /**
     * @apiNote Метод выводит информацию о победителе и его результат
     * @param results словарь со значениями: Игрок - его результат по итогам соревнований
     */
    public static void handleWinner(Map<String, Integer> results) {
        int maxValue = 0;
        String maxKey = "";
        for (String key : results.keySet()) {
            if (results.get(key) > maxValue) {
                maxValue = results.get(key);
                maxKey = key;
            }
        }
        System.out.println("\n\nWinner is " + maxKey + ", with result - " + maxValue + "! Congratulations!");
    }

    /**
     * @apiNote Метод выводит информацию о прохождении препятсвия игроком
     * @param result результат игрока, представленный целочисленным значением
     */
    public static void handleResult(int result) {
        if (result == 1) System.out.println("The player has passed the task!");
        else System.out.println("The player has failed the task!");
    }

    /**
     * @apiNote Метод возвращает список из экземпляров классов Стена и Беговая дорожка,
     * сгенерированных со случайными значениями
     * @param countObstacles целочисленное значение количества препятсвий
     * @return список из экземпляров классов Стена и Беговая дорожка
     */
    public static List<Object> generateObstaclesList(int countObstacles) {
        List<Object> obstaclesList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < countObstacles; i++) {
            if (random.nextInt(2) == 0) {
                int distance = random.nextInt(120);
                obstaclesList.add(new Treadmill(distance));
            } else {
                double height = random.nextInt(2) + random.nextDouble();
                double heightRoundOff = (double) Math.round(height * 10) / 10;
                obstaclesList.add(new Wall(heightRoundOff));
            }
        }
        return obstaclesList;
    }
}
