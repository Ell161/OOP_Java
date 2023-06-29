package EncapsulationInheritancePolymorphism;

public class User {
    private String name;
    private String login;
    private String password;
    private Basket basket;

    public User(String name, String login, String password, Basket basket) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.basket = basket;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }
}
