package sample;

public class ColorMyClass implements Comparable<ColorMyClass> {
    String name;
    Integer distance;

    public ColorMyClass(String name, Integer distance) {
        this.name = name;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public Integer getDistance() {
        return distance;
    }

    @Override
    public int compareTo(ColorMyClass a) {
        if(this.distance>a.distance)
            return 1;
        else if(this.distance<a.distance)
                return -1;
        else
            return 0;
    }

    @Override
    public String toString() {
        return "ColorMyClass{" +
                "name='" + name + '\'' +
                ", distance=" + distance +
                '}';
    }
}
