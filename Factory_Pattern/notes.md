# Factory Design Pattern - Quick Revision

## What is Factory Pattern?

Factory Pattern is a **Creational Design Pattern** used to create objects without exposing the object creation logic to the client.

Instead of creating objects using `new` directly, the client asks a factory to create the required object.

---

## Problem It Solves

Without Factory Pattern:

- Client knows all concrete classes.
- Object creation logic is scattered throughout the codebase.
- Adding new types requires modifying multiple places.

With Factory Pattern:

- Object creation is centralized.
- Client depends only on abstractions (interfaces).
- Easier to extend and maintain.

---

## Components

### 1. Product
Common interface that defines behavior.

Examples:
- Shape
- Vehicle
- Notification

### 2. Concrete Products
Actual implementations of the product interface.

Examples:
- Circle
- Rectangle
- Square

### 3. Factory
Responsible for deciding and creating the correct object.

### 4. Client
Requests an object from the factory and uses it through the interface.

---

## Flow

Client → Factory → Concrete Object

1. Client requests an object.
2. Factory checks the input.
3. Factory creates the appropriate object.
4. Factory returns the object as the interface type.
5. Client uses the object without knowing its concrete implementation.

---

## Benefits

- Encapsulates object creation logic.
- Reduces tight coupling.
- Follows Dependency Inversion Principle.
- Easier to add new object types.
- Cleaner and more maintainable code.

---

## Drawbacks

- Introduces an extra class (Factory).
- Factory may become large if too many object types are added.

---

## Real-World Examples

- Payment Gateway Selection
- Notification Service Selection
- Vehicle Creation
- Database Driver Creation
- UI Component Creation

---

## Interview One-Liner

"Factory Pattern delegates object creation to a factory class so that the client does not need to know which concrete object is being instantiated."

---

## Identification Checklist

Use Factory Pattern when:

✅ Object creation logic is complex

✅ Multiple implementations of the same interface exist

✅ Client should not know concrete classes

✅ New object types may be added in the future

---

## Key Idea

**Create objects through a factory, use them through an interface.**
