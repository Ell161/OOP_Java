package AbstractionAndInterfaces;

public class Wall {
    private double height;

    public Wall(double height) {
        this.height = height;
    }

    public Wall() {

    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "\n------------\n |        | \n |        | " + "\n" + this.height + " metres";
    }
}
