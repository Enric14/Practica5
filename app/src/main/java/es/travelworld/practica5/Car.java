package es.travelworld.practica5;

public class Car {
    private final String nameCar;
    private final String price;
    private final FeatureCar featureCar;
    public Car(String nameCar, String price, FeatureCar featureCar) {
        this.nameCar = nameCar;
        this.price = price;
        this.featureCar = featureCar;
    }

    public String getNameCar() {
        return nameCar;
    }

    public String getPrice() {
        return price;
    }

    public FeatureCar getFeatureCar() {
        return featureCar;
    }
}
