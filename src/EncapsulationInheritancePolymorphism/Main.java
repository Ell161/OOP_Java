package EncapsulationInheritancePolymorphism;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        String[] toysNames = new String[]{"Infinity nado", "Sonic", "Car", "Constructor", "Barbie", "LEGO"};
        String[] clothesNames = new String[]{"Shirt", "T-shirt", "Dress", "Jacket", "Coat", "Skirt", "Trousers"};
        String[] accessoriesNames = new String[]{"Glasses", "Belt", "Umbrella", "Bag", "Gloves", "Scarf"};
        Category toys = new Category("Toys");
        Category clothes = new Category("Clothes");
        Category accessories = new Category("Accessories");

        for (int i = 0; i < 5; i++) {
            toys.add(createProduct(toysNames));
            clothes.add(createProduct(clothesNames));
            accessories.add(createProduct(accessoriesNames));
        }

        User Anna = new User();
        Anna.setName("Anna");
        Anna.setLogin("annaLogin");
        Anna.setPassword("annaPassword");

        Category[] store = new Category[]{toys, clothes, accessories};
        Category categoryByAnna = userChoiceCategory(store, Anna);
        userChoiceProduct(categoryByAnna, Anna);

        User John = new User();
        Anna.setName("John");
        Anna.setLogin("johnLogin");
        Anna.setPassword("johnPassword");

        Category categoryByJohn = userChoiceCategory(store, John);
        userChoiceProduct(categoryByJohn, John);

    }

    /**
     * @apiNote Метод выводит список товаров заданной категории
     * @param productList список товаров класса Категории
     */
    public static void outCategoryProducts(Category productList) {
        for (int i = 0; i < productList.size(); i++) {
            System.out.println(productList.get(i).toString());
        }
    }

    /**
     * @apiNote Выводит список товаров корзины Пользователя
     * @param user экземпляр класса Пользователь
     */
    public static void outBasket(User user) {
        for (int i = 0; i < user.getBasket().size(); i++) {
            System.out.println(user.getBasket().get(i).toString());
        }
    }

    /**
     * @apiNote Метод создает экземпляр класса Товар со слачайно заданными параметрами
     * @param productNames список названий товаров
     * @return экземпляр класса Товар
     */
    public static Product createProduct(String[] productNames) {
        Random random = new Random();
        int productIndex = random.nextInt(productNames.length);
        String product = productNames[productIndex];
        int price = random.nextInt(10000) + 100;
        double rating = random.nextInt(5) + 1 + random.nextDouble();
        double ratingRoundOff = (double) Math.round(rating * 10) / 10;
        return new Product(product, price, ratingRoundOff);
    }

    /**
     * @apiNote Метод задает случайное значение категории товаров (выбор Пользователя)
     * @param categories список категорий товаров
     * @param user экземпляр класса Пользователь
     * @return список товаров случайно заданной категории
     */
    public static Category userChoiceCategory(Category[] categories, User user) {
        Random random = new Random();
        System.out.println("\nWelcome to our store, " + user.getName() + "! Choice a category, please.");
        for (int i = 0; i < categories.length; i++) {
            System.out.println(i + " - " + categories[i].getName());
        }
        int userChoice = random.nextInt(3);
        System.out.println("Hmm...I think, I want this... " + userChoice);

        return categories[userChoice];
    }

    /**
     * @apiNote Метод задает случайный значения товарам для добавления в Корзину (выбор Пользователя)
     * @param products список товаров заданной категории
     * @param user экземпляр класса Пользователь
     * @return список товаров, добавленных в корзину
     */
    public static Basket userChoiceProduct(Category products, User user) {
        Random random = new Random();
        Basket userChoice = new Basket();
        ArrayList<Integer> soldProducts = new ArrayList<>();
        System.out.println("\nLook at the our products and make your choice!");
        outCategoryProducts(products);
        System.out.println("\nI want this...this...and this!!! (^_^)");
        for (int i = 0; i < products.size(); i++) {
            int choice = random.nextInt(2);
            if (choice == 1) {
                userChoice.add(products.get(i));
                soldProducts.add(i);
            }
        }
        user.setBasket(userChoice);
        outBasket(user);
        for (int i = 0; i < soldProducts.size(); i++) {
            products.remove(soldProducts.get(i) - i);
        }
        System.out.println("\nThe rest of the products from the category " + products.getName());
        outCategoryProducts(products);
        return userChoice;
    }
}