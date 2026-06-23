package With_Strategy_Pattern;

import With_Strategy_Pattern.Strategy.Special_Drive_Strategy;

public class offroad_vehicle extends Vehicle {
    offroad_vehicle() { super (new Special_Drive_Strategy());}
}
