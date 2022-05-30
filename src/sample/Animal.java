package sample;



public abstract class Animal {

    String name;
    double weight;
    int numbers;
    int speed;
    double saturation;
    int motion;

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setNumbers(int numbers) {
        this.numbers = numbers;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setSaturation(double saturation) {
        this.saturation = saturation;
    }

    public void setMotion(int motion) {
        this.motion = motion;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public int getNumbers() {
        return numbers;
    }

    public int getSpeed() {
        return speed;
    }

    public double getSaturation() {
        return saturation;
    }

    public int getMotion() {
        return motion;
    }

    public void moveTo() {

    }

    public void toMultiply() {

    }

    public abstract String toEat();



}
