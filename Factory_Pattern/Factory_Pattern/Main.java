package Factory_Pattern;

public class Main {
    public static void main(String[] args) {
        Shape_Factory obj=new Shape_Factory();
        Shape sobj=obj.getshape("Rectangle");
            sobj.draw();
    }
}
