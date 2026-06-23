package Observable;

import Observer.Notification_alert;

public interface Stock_Observable {
    public void add_observer(Notification_alert observer);
    public void remove(Notification_alert observer);
    public void notify_observer();
    public void setcount(int newstock);
    public int getcount();
}
