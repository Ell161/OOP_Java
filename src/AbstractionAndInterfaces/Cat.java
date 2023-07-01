package AbstractionAndInterfaces;

public class Cat implements Interfaces {
    private String name;
    private String breed;

    public Cat(String name, String breed) {
        this.name = name;
        this.breed = breed;
    }

    public Cat() {
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public void info() {
        System.out.println("\nI'm " + this.name + ". I'm cool " + this.breed + "!");
    }

    @Override
    public int run(int distance) {
        if (distance > 50) {
            System.out.println("\n...... . .  .   Why am I running? I'm a cat.");
            return 0;
        } else {
            System.out.println("\nε=ε=ε=ε=₍^ >ヮ<^₎");
            return 1;
        }
    }

    @Override
    public int jump(double height) {
        if (height > 1.8) {
            System.out.println("/ᐠﹷ ‸ ﹷ ᐟ\\ﾉ  ...( I'm tired )");
            return 0;
        } else {
            System.out.println("(I like jump! It's do fun)...  ฅ/ᐠ. ̫ .ᐟ\\ฅ");
            return 1;
        }
    }
}
