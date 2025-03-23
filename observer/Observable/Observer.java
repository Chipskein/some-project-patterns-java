package Observable;

public interface Observer {
    public void updateHighestBid(float newBid);
    public void requestBid(float price,Subject subject);
}
