package Factory_Pattern;
import Factory_Pattern.Shape;

 class Circle implements Shape {
    @Override
    public void draw(){
        System.out.println("Circle");
    }
}

