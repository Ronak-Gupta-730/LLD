package Factory_Pattern;

 class Shape_Factory {
    Shape getshape(String input){
        return switch (input) {
            case "Circle" -> new Circle();
            case "Rectangle" -> new Rectangle();
            default -> null;
        };
    }
}
