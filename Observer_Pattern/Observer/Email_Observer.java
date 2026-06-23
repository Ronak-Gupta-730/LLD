package Observer;

import Observable.Stock_Observable;

public class Email_Observer implements Notification_alert {
    String mail;
    Stock_Observable obj;
    public Email_Observer(String mail,Stock_Observable obj){
        this.mail=mail;
        this.obj=obj;
    }
    @Override
    public void update(){
        Sendmail(mail, "Product is in Stock");
    }
    private void Sendmail(String mail, String msg){
        System.out.println(msg+"sent to " +mail);
    }
}
