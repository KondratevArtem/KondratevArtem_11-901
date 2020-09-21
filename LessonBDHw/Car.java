package LessonBD;

public class Car {
    private int id;
    private String model;
    private String color;
    private int driver_id;

    public Car(int id, String model, String color, int driver_id) {
        this.id = id;
        this.model = model;
        this.color = color;
        this.driver_id = driver_id;
    }

    public int getDriver_id() {
        return driver_id;
    }

    public int getId() {
        return id;
    }

    public String getColor() {
        return color;
    }

    public String getModel() {
        return model;
    }

    public String toString() {
        return "Car" + "\n" + id + " " + model + " " + color + " " + driver_id;
    }
}
