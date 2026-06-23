package With_Strategy_Pattern;

import With_Strategy_Pattern.Strategy.Normal_Drive_Strategy;

public class Passenger_vehicle extends Vehicle{
    Passenger_vehicle(){ super(new Normal_Drive_Strategy());}
}
