# Strategy Pattern

## Intent
Encapsulate different algorithms/behaviors and make them interchangeable at runtime.

## Problem
Without Strategy Pattern:

Vehicle
 ├── SportsVehicle
 ├── OffRoadVehicle
 └── PassengerVehicle

Each class may duplicate the same drive logic.

## Solution

Move drive behavior into separate strategy classes.

Vehicle HAS-A DriveStrategy

Vehicle
  |
  +---- DriveStrategy

DriveStrategy
  ├── NormalDriveStrategy
  └── SportsDriveStrategy

## Relationships

Vehicle HAS-A DriveStrategy

NOT

Vehicle IS-A DriveStrategy

Therefore Vehicle does not implement DriveStrategy.

## Benefits

- Open/Closed Principle
- No code duplication
- Easy to add new driving behaviors

## Interview One-Liner

"Strategy Pattern replaces inheritance-based behavior variations with composition."
