package auction;

import Observable.*;

import java.util.ArrayList;
import java.util.List;

public class Auction implements Subject {
    private List<Observer> bidders = new ArrayList<Observer>();
    private boolean isClosed = false;
    private float highestBid = 0;

    public Auction(float initialBid) {
        this.highestBid = initialBid;
    }
    
    public List<Observer> getBidders() {
        return bidders;
    }

    public void setBidders(List<Observer> bidders) {
        this.bidders = bidders;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public void close() {
        System.out.println("The auction is now closed.");
        System.out.println("The winning bid is: " + highestBid);
        this.isClosed = true;
        for (Observer observer : bidders) {
            this.removeObserver(observer);
        }
    }

    public float getHighestBid() {
        return highestBid;
    }

    public void setHighestBid(float highestBid) {
        if (highestBid > this.highestBid){
            this.highestBid = highestBid;
            notifyObservers();
        }
    }
    
    public void registerObserver(Observer observer) {
        bidders.add(observer);
    }
    
    public void removeObserver(Observer observer) {
        bidders.remove(observer);
    }
    
    public void notifyObservers() {
        for (Observer observer : bidders) {
            observer.updateHighestBid(highestBid);
        }
    }

    @Override
    public void checkBidRequested(float price, Observer observer) {
        this.setHighestBid(price);
    }    
}
