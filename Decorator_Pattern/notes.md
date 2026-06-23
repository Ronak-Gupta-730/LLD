# Decorator Pattern - Quick Revision

## Intent

Add new functionality to an object dynamically without modifying its existing code.

---

## Problem

Suppose a Pizza shop offers:

### Base Pizzas
- Margerita
- VegDelight
- Farmhouse

### Toppings
- Extra Cheese
- Mushrooms
- Corn
- Paneer

If we create subclasses for every combination:

- MargeritaWithCheese
- MargeritaWithCheeseAndMushrooms
- FarmhouseWithPaneerAndCorn
- VegDelightWithCheeseAndCorn

The number of classes grows rapidly (**Class Explosion Problem**).

---

## Solution

Instead of creating new subclasses, wrap an existing pizza object with toppings.

Example:

```text
Margerita
    ↓
Extra Cheese
    ↓
Mushrooms
```

Each wrapper adds its own cost and behavior.

---

## Structure

### Component

Common abstraction for all pizzas.

Responsibilities:
- Defines common operations.
- Used by both pizzas and toppings.

---

### Concrete Components

Actual pizza variants.

Examples:
- Margerita
- VegDelight
- Farmhouse

These provide the base cost.

---

### Decorator

Abstract class that:
- Extends the same component.
- Contains a reference to a component object.

This allows decorators and pizzas to be treated uniformly.

---

### Concrete Decorators

Examples:
- ExtraCheese
- Mushrooms

Responsibilities:
- Hold a reference to another pizza object.
- Add their own cost/behavior.
- Delegate remaining work to wrapped object.

---

## Key Idea

Every decorator:

### IS-A Component

Through inheritance.

```text
ExtraCheese IS-A BasePizza
```

### HAS-A Component

Through composition.

```text
ExtraCheese HAS-A BasePizza
```

Decorator Pattern combines:

- Inheritance
- Composition

---

## Flow

```text
Base Pizza
    ↓
Decorator 1
    ↓
Decorator 2
    ↓
Decorator 3
```

Final result is built layer by layer.

---

## Benefits

### Open/Closed Principle

Open for extension.

Closed for modification.

New toppings can be added without changing existing classes.

---

### Flexible

Features can be combined at runtime.

Example:

```text
Today:
Margerita + Cheese

Tomorrow:
Margerita + Cheese + Mushrooms
```

No new classes required.

---

### Reusable

A topping can work with any pizza type.

---

## Drawbacks

- Many small classes.
- Object creation chain can become harder to debug.

---

## Recognition Pattern

When you hear:

> "Add functionality dynamically"

or

> "Avoid creating subclasses for every combination"

Think:

✅ Decorator Pattern

---

## Real-World Examples

### Food
- Pizza toppings
- Coffee + Milk + Sugar

### Java

Java I/O is a classic Decorator example.

Examples:

- InputStream
- BufferedInputStream
- DataInputStream

Each stream wraps another stream and adds behavior.

---

## Interview One-Liner

Decorator Pattern allows behavior to be added dynamically by wrapping an object inside another object that implements the same abstraction.
