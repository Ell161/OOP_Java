package AbstractionAndInterfaces;

public class Robot implements Interfaces {
    private String name;
    private String model;

    public Robot(String name, String model) {
        this.name = name;
        this.model = model;
    }

    public Robot() {
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public void info() {
        System.out.println("\nI'm " + this.name + ". Model " + this.model + ". I can do your tasks.");
    }

    @Override
    public int run(int distance) {
        if (distance > 20) {
            System.out.println("\n...... . .  .   . I couldn't do it. My battery is running low.");
            return 0;
        } else {
            System.out.println("\n─=≡Σ((( つ＞＜)つ");
            return 1;
        }
    }

    @Override
    public int jump(double height) {
        System.out.println("(☉_ ☉) I'm only a robot. I don't jump!");
        return 0;
    }
}
