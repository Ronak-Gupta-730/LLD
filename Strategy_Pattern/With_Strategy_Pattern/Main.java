package With_Strategy_Pattern;

import Without_Strategy_Pattern.Offroad;

public class Main {
    public static void main(String[] args) {
        Vehicle vehicle = new Passenger_vehicle();
        vehicle.drive();

    }
}
