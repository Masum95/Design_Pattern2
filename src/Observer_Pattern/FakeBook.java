package Observer_Pattern;

import java.util.ArrayList;
import java.util.List;

public class FakeBook implements Subject {

    List<Observer> observerList = new ArrayList<>();
    String msg;

    @Override
    public void setMessage(String msg, Observer whoSent) {
        this.msg = msg + "\nPosted by -" +whoSent.getName() +" on "+getClass().getSimpleName();
        notifyObservers();
    }

    @Override
    public void notifyObservers() {
        for(Observer observer:observerList)
        {
            observer.getMessage(msg);
        }
    }

    @Override
    public void subscribe(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void unsubscribe(Observer observer) {
        observerList.remove(observer);
    }
}
