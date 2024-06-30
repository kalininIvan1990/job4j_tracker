package ru.job4j.cast;

public class VehicleMain {

    public static void main(String[] args) {
        Vehicle airbus = new Airplane();
        Vehicle aircraft = new Airplane();
        Vehicle passengerTrain = new Train();
        Vehicle freightTrain = new Train();
        Vehicle schoolBus = new Bus();
        Vehicle bus = new Bus();
        Vehicle[] vehicle = new Vehicle[]{airbus, aircraft, passengerTrain, freightTrain,
                            schoolBus, bus};

        for (Vehicle vehicles : vehicle) {
            vehicles.move();
        }
    }
}
