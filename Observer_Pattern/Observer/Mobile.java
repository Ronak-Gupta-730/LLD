package Observer;

import Observable.Stock_Observable;

public class Mobile implements Notification_alert{
    String username;
    Stock_Observable obj;
    public Mobile(String name,Stock_Observable obj){
        this.username=name;
        this.obj=obj;
    }
    @Override
    public void update(){
        Sendmsg(username, "Product is in Stock");
    }
    private void Sendmsg(String username, String msg){
        System.out.println(msg+"sent to "+username);
    }
}
