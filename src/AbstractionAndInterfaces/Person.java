package AbstractionAndInterfaces;

public class Person implements Interfaces {
    private String name;
    private int old;

    public Person(String name, int old) {
        this.name = name;
        this.old = old;
    }

    public Person() {
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOld() {
        return old;
    }

    public void setOld(int old) {
        this.old = old;
    }

    @Override
    public void info() {
        System.out.println("\nHello! I'm " + this.name + ". I'm " + this.old + " years old.");
    }

    @Override
    public int run(int distance) {
        if (distance > 100) {
            System.out.println("\n( Ŏ艸Ŏ) Oh, no! I can't do it.");
            return 0;
        } else {
            System.out.println("\nε=ε=ε=ε=┌(;￣▽￣)┘");
            return 1;
        }
    }

    @Override
    public int jump(double height) {
        if (height > 0.8) {
            System.out.println("(╯‵□′)╯︵ ┴─┴  ...( The obstacle is too high! )");
            return 0;
        } else {
            System.out.println("I'm a winner! I'll do it... ミ(ノ_ _)ノ");
            return 1;
        }
    }
}
