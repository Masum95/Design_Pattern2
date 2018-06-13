package Observer_Pattern;

public interface Subject {
    public void setMessage(String msg,Observer whoSent);
    public void notifyObservers();
    public void subscribe(Observer observer);
    public void unsubscribe(Observer observer);

}
