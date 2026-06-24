# Abstract Factory Design Pattern

## What is Abstract Factory Pattern?

Abstract Factory is a **Creational Design Pattern** that provides an interface for creating **families of related objects** without specifying their concrete classes.

Think of it as a **Factory of Factories**.

---

## Problem

Suppose your application supports two categories of vehicles:

- Ordinary Vehicles
- Luxury Vehicles

Each category contains:

- Car
- Bike

Without Abstract Factory, the client needs to know which concrete classes to create.

As the number of categories grows, object creation logic becomes difficult to manage.

---

## Solution

Create separate factories for each family of objects.

```text
Ordinary Vehicle Factory
├── Ordinary Car
└── Ordinary Bike

Luxury Vehicle Factory
├── Luxury Car
└── Luxury Bike
```

The client asks for a factory and then uses that factory to create related objects.

---

# Class Diagram

```text
                     Vehicle
                        ^
                        |
        --------------------------------
        |              |              |
 OrdinaryCar     LuxuryCar      OrdinaryBike
                                      |
                                 LuxuryBike


                 VehicleFactory
                        ^
                        |
        --------------------------------
        |                              |
OrdinaryVehicleFactory      LuxuryVehicleFactory
```

---

# Step 1: Product Interface

```java
public interface Vehicle {
    void drive();
}
```

---

# Step 2: Concrete Products

## Ordinary Car

```java
public class OrdinaryCar implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Ordinary Car");
    }
}
```

## Luxury Car

```java
public class LuxuryCar implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Luxury Car");
    }
}
```

## Ordinary Bike

```java
public class OrdinaryBike implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Ordinary Bike");
    }
}
```

## Luxury Bike

```java
public class LuxuryBike implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Luxury Bike");
    }
}
```

---

# Step 3: Abstract Factory

```java
public interface VehicleFactory {

    Vehicle getCar();

    Vehicle getBike();
}
```

---

# Step 4: Concrete Factories

## Ordinary Vehicle Factory

```java
public class OrdinaryVehicleFactory implements VehicleFactory {

    @Override
    public Vehicle getCar() {
        return new OrdinaryCar();
    }

    @Override
    public Vehicle getBike() {
        return new OrdinaryBike();
    }
}
```

## Luxury Vehicle Factory

```java
public class LuxuryVehicleFactory implements VehicleFactory {

    @Override
    public Vehicle getCar() {
        return new LuxuryCar();
    }

    @Override
    public Vehicle getBike() {
        return new LuxuryBike();
    }
}
```

---

# Step 5: Factory Producer

Factory Producer decides which factory to return.

```java
public class FactoryProducer {

    public static VehicleFactory getFactory(String type) {

        return switch(type) {
            case "Luxury" -> new LuxuryVehicleFactory();
            case "Ordinary" -> new OrdinaryVehicleFactory();
            default -> throw new IllegalArgumentException("Invalid Type");
        };
    }
}
```

---

# Step 6: Client

```java
public class Main {

    public static void main(String[] args) {

        VehicleFactory factory =
                FactoryProducer.getFactory("Luxury");

        Vehicle car = factory.getCar();
        Vehicle bike = factory.getBike();

        car.drive();
        bike.drive();
    }
}
```

---

# Output

```text
Luxury Car
Luxury Bike
```

---

# Flow

```text
Client
  |
  v
FactoryProducer
  |
  v
LuxuryVehicleFactory
  |
  |----> LuxuryCar
  |
  └----> LuxuryBike
```

---

# Difference Between Factory and Abstract Factory

| Factory Pattern | Abstract Factory Pattern |
|---------------|--------------------------|
| Creates one product | Creates a family of products |
| One factory | Factory of factories |
| Simpler | More scalable |
| Example: Shape Factory | Example: Vehicle Factories |

### Factory Pattern

```text
ShapeFactory
├── Circle
└── Rectangle
```

### Abstract Factory Pattern

```text
LuxuryFactory
├── LuxuryCar
└── LuxuryBike

OrdinaryFactory
├── OrdinaryCar
└── OrdinaryBike
```

---

# Advantages

- Groups related objects together.
- Reduces coupling.
- Follows Open/Closed Principle.
- Easy to add new product families.
- Hides object creation details from client.

---

# Disadvantages

- More classes are required.
- Structure becomes complex for small projects.

---

# Real World Examples

### GUI Toolkit

```text
Windows Factory
├── Windows Button
└── Windows Checkbox

Mac Factory
├── Mac Button
└── Mac Checkbox
```

### Vehicle Manufacturing

```text
Luxury Factory
├── BMW Car
└── Ducati Bike

Ordinary Factory
├── Swift Car
└── Splendor Bike
```

### Database Drivers

```text
MySQL Factory
PostgreSQL Factory
Oracle Factory
```

---

# Interview One-Liner

**Abstract Factory Pattern provides an interface for creating families of related objects without specifying their concrete implementations.**

---

# Key Idea

Factory Pattern → Creates Objects

Abstract Factory Pattern → Creates Factories that create related Objects
