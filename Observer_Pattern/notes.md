# Observer Design Pattern (Java) - Quick Revision

## Definition

The Observer Design Pattern is a **Behavioral Design Pattern** where:

- One object (**Observable / Subject**) maintains a list of dependent objects (**Observers**).
- Whenever the state of the Observable changes, all registered Observers are notified automatically.

### Real-Life Example

📱 iPhone Stock Alert System

- Product goes out of stock.
- Users subscribe for notifications.
- When stock becomes available, all subscribed users receive alerts.

---

# Components

## 1. Observable (Subject)

Responsible for:

- Maintaining observer list
- Adding observers
- Removing observers
- Notifying observers
- Managing state (stock count)

### Interface

```java
public interface Stock_Observable {
    void add_observer(Notification_alert observer);
    void remove(Notification_alert observer);
    void notify_observer();
    void setcount(int count);
    int getcount();
}
```

---

## 2. Concrete Observable

Example:

```java
public class iphone_Observable implements Stock_Observable
```

Responsibilities:

- Stores current stock
- Stores subscribed users
- Notifies users when stock becomes available

---

## 3. Observer Interface

Defines a common update method.

```java
public interface Notification_alert {
    void update();
}
```

---

## 4. Concrete Observers

### Email Observer

```java
public class Email_Observer implements Notification_alert
```

Receives notifications through email.

### Mobile Observer

```java
public class Mobile implements Notification_alert
```

Receives notifications through mobile/SMS.

---

# Class Diagram

```text
                 +--------------------+
                 | Stock_Observable   |
                 +--------------------+
                 | add_observer()     |
                 | remove()           |
                 | notify_observer()  |
                 | setcount()         |
                 | getcount()         |
                 +---------+----------+
                           |
                           |
                           v
                 +--------------------+
                 | iphone_Observable  |
                 +--------------------+
                 | stock              |
                 | observer_list      |
                 +--------------------+

                           |
        -----------------------------------------
        |                                       |
        v                                       v

+--------------------+           +--------------------+
| Email_Observer     |           | Mobile            |
+--------------------+           +--------------------+
| update()           |           | update()           |
+--------------------+           +--------------------+

               implements
                     ^
                     |
         +----------------------+
         | Notification_alert   |
         +----------------------+
         | update()             |
         +----------------------+
```

---

# Flow

### Step 1

Create Observable

```java
Stock_Observable iphone = new iphone_Observable();
```

### Step 2

Create Observers

```java
Notification_alert user1 =
    new Email_Observer("abc@gmail.com", iphone);

Notification_alert user2 =
    new Mobile("ronak", iphone);
```

### Step 3

Subscribe

```java
iphone.add_observer(user1);
iphone.add_observer(user2);
```

### Step 4

Stock Arrives

```java
iphone.setcount(10);
```

### Step 5

Observable Notifies Everyone

```java
notify_observer();
```

### Step 6

Observers Execute Their Own Logic

```java
update();
```

---

# Important Interview Point

Notify users **only when stock changes from 0 → positive**.

```java
@Override
public void setcount(int newstock) {

    boolean wasOutOfStock = (stock == 0);

    stock += newstock;

    if(wasOutOfStock) {
        notify_observer();
    }
}
```

---

# Common Mistake

❌ Wrong

```java
notify();
```

Reason:

`notify()` is a method from Java's `Object` class used for thread synchronization.

It has nothing to do with the Observer Pattern.

Calling it incorrectly causes:

```text
IllegalMonitorStateException
```

---

✅ Correct

```java
notify_observer();
```

This calls all registered observers.

```java
for(Notification_alert observer : observer_list) {
    observer.update();
}
```

---

# Why Use Observer Pattern?

Without Observer Pattern:

```java
EmailService.send();
SMSService.send();
WhatsAppService.send();
```

Every time a new notification type is added, Product Service must be modified.

---

With Observer Pattern:

```java
observer.update();
```

New notification types can be added without changing existing code.

---

# SOLID Principle Connection

### Open/Closed Principle (OCP)

Open for Extension ✅

Closed for Modification ✅

Example:

Adding

```java
WhatsApp_Observer
```

requires no changes in:

```java
iphone_Observable
```

---

# Interview Examples

- Amazon "Notify Me"
- Flipkart Stock Alerts
- YouTube Subscribers
- Instagram Followers
- Weather App Notifications
- Newsletter Subscriptions
- Event Listeners in GUI Frameworks

---

# Revision in 30 Seconds

Observable (Subject)
→ Maintains observer list.

Observer
→ Receives updates.

Concrete Observable
→ Detects state change.

Concrete Observer
→ Performs action after notification.

Flow:

```text
Observer Registers
        ↓
State Changes
        ↓
Observable Notifies
        ↓
update() Called
        ↓
Observers React
```

### Formula

```text
One Subject
        ↓
Many Observers
        ↓
Automatic Notification
```
