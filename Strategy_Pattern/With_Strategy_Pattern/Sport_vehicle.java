package With_Strategy_Pattern;

import With_Strategy_Pattern.Strategy.Special_Drive_Strategy;

public class Sport_vehicle extends Vehicle {
    Sport_vehicle(){ super(new Special_Drive_Strategy()) ;}
}
