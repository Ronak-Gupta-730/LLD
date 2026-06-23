package Pizza;

abstract class Base_Pizza{
    public abstract int cost();
}
class Farmhouse extends Base_Pizza{
    @Override
    public int cost() {
        return 200;
    }
}
class Vegdelight extends Base_Pizza{
    @Override
    public int cost(){
        return 180;
    }
}
class Margerita extends Base_Pizza{
    @Override
    public int cost() {
        return 150;
    }
}
abstract class topping extends Base_Pizza{

}
class Mushrooms extends topping{
    Base_Pizza obj;
    Mushrooms(Base_Pizza pizza){
        this.obj=pizza;
    }
    @Override
    public int cost(){
        return obj.cost()+20;
    }
}
class ExtraCheese extends topping{
    Base_Pizza obj;
    ExtraCheese(Base_Pizza pizza){
        this.obj=pizza;
    }
    @Override
    public int cost(){
        return obj.cost()+50;
    }
}
public class Main {
    public static void main() {
        Base_Pizza pizza= new Margerita();
        int cost = pizza.cost();
        System.out.println(cost);
        pizza= (new ExtraCheese(pizza));
        System.out.println(pizza.cost());
    }
}
