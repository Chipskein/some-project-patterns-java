public class Main {
    public static void main(String[] args) {
        Auction auction = new Auction(100);
        Bidder bidder1 = new Bidder();
        bidder1.setName("John");
        bidder1.setAddress("123 Main St");
        Bidder bidder2 = new Bidder();
        bidder2.setName("Jane");
        bidder2.setAddress("456 Elm St");
        auction.registerObserver(bidder1);
        auction.registerObserver(bidder2);

        bidder1.requestBid(120, auction);
        bidder2.requestBid(125, auction);
        bidder1.requestBid(130, auction);
        bidder2.requestBid(100, auction);
        auction.close();
    }
}
