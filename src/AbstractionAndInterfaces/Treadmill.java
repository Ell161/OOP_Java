package AbstractionAndInterfaces;

public class Treadmill {
    private int distance;

    public Treadmill(int distance) {
        this.distance = distance;
    }

    public Treadmill() {

    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "\n------------\n- - - - - - \n------------"
                + "\n" + this.distance + " metres";
    }
}
