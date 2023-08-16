package es.travelworld.practica5;

import java.util.ArrayList;
import java.util.List;

public abstract class RepositoryCars {

    private RepositoryCars() {
        //utility class
    }

    public static List<Car> getListCar() {
        List<Car> listCar = new ArrayList<>();
        listCar.add(new Car("Classic Car", "$34/day", new FeatureCar(R.color.classicCar, R.drawable.classic_car)));
        listCar.add(new Car("Sport Car", "$55/day", new FeatureCar(R.color.sportCar, R.drawable.sport_car)));
        listCar.add(new Car("Flying Car", "$500/day", new FeatureCar(R.color.flyingCar, R.drawable.flying_car)));
        listCar.add(new Car("Electric Car", "$45/day", new FeatureCar(R.color.electricCar, R.drawable.electric_car)));
        listCar.add(new Car("Motorhome", "$23/day", new FeatureCar(R.color.motorHome, R.drawable.motor_home)));
        listCar.add(new Car("Pickup", "$10/day", new FeatureCar(R.color.pickUp, R.drawable.pick_up_car)));
        listCar.add(new Car("Airplane", "$11/day", new FeatureCar(R.color.airPlane, R.drawable.air_plane)));
        listCar.add(new Car("Bus", "$14/day", new FeatureCar(R.color.bus, R.drawable.bus)));
        return listCar;
    }
}
