package org.com1027.coursework.q3;

public class Bid{
 
    private User buyer;
    private double bidValue;
    
    public Bid(User buyer, double bidValue) {
      this.buyer=buyer;
      this.bidValue=bidValue;
    }
    public User getBuyer() {
      return this.buyer;
    }
    
    public double getBidValue() {
      return this.bidValue;
    }
    
    public String toString() {
      return buyer.toString() + "bid £" + getBidValue();
    }
}