package With_Strategy_Pattern.Strategy;

import With_Strategy_Pattern.Strategy.Drive_Strategy;

public class Special_Drive_Strategy implements Drive_Strategy {
    @Override
    public void drive(){
        System.out.println("Special Drive Capability");
    }
}
