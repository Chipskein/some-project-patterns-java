package Observable;
public interface Subject {
    public void registerObserver(Observer observer);
    public void removeObserver(Observer observer);
    public void notifyObservers();
    public void checkBidRequested(float price,Observer observer);
}
