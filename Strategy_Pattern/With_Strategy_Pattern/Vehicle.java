package With_Strategy_Pattern;
import With_Strategy_Pattern.Strategy.Drive_Strategy;
public class Vehicle {
    Drive_Strategy driveobj;
    Vehicle(Drive_Strategy driveobj){
        this.driveobj=driveobj;
    }
    public void drive(){
        driveobj.drive();
    }
}