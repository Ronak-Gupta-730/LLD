import Observable.Stock_Observable;
import Observable.iphone_Observable;
import Observer.Email_Observer;
import Observer.Mobile;
import Observer.Notification_alert;

public class Store {
    public static void main(String[] args) {
        Stock_Observable iphone_observable=new iphone_Observable();
        Notification_alert observer1= new Email_Observer("vitthal14@gmail.com",iphone_observable);
        Notification_alert observer2= new Email_Observer("sureshpk36@gmail.com",iphone_observable);
        Notification_alert observer3= new Mobile("xyz_123",iphone_observable);
        iphone_observable.add_observer(observer1);
        iphone_observable.add_observer(observer2);
        iphone_observable.add_observer(observer3);
        iphone_observable.setcount(10);
    }
}
