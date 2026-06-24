package Factory_Pattern;

import Factory_Pattern.Shape;
 class Rectangle implements Shape {
    @Override
    public void draw(){
        System.out.println("Rectangle");
    }
}

