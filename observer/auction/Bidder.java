package auction;

import Observable.*;


public class Bidder implements Observer{

    private String name;
    private String address;
    private float highestBid;


    @Override
    public void updateHighestBid(float newBid) {
        highestBid = newBid;
        System.out.println("Bidder " + name + " has been notified of the new highest bid: " + highestBid);
    }


    @Override
    public void requestBid(float price,Subject subject) {
        System.out.println("Bidder " + name + " has requested a bid of " + price);
        if (price > highestBid)
            subject.checkBidRequested(price, this);
        else
            System.out.println("Bidder " + name + " has been notified that the bid was not accepted");
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getAddress() {
        return address;
    }


    public void setAddress(String address) {
        this.address = address;
    }

    
}
