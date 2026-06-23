package Observable;

import Observer.Notification_alert;

import java.util.ArrayList;
import java.util.List;

public class iphone_Observable implements Stock_Observable {
    public List<Notification_alert> oberver_list= new ArrayList<>();
    public int stock=0;
    @Override
    public void add_observer(Notification_alert observer){
        oberver_list.add(observer);
    }
    @Override
    public void remove(Notification_alert observer){
        oberver_list.remove(observer);
    }
    @Override
    public void notify_observer(){
    for(Notification_alert obj : oberver_list){
        obj.update();
    }
    }
    @Override
    public void setcount(int newstock){
        if(stock==0){
            notify_observer();
        }
        stock+=newstock;
    }
    @Override
    public int getcount(){
        return stock;
    }
}
