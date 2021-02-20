package org.com1027.coursework.q1;

import static org.junit.Assert.*;

import org.junit.Test;


public class BidTest {

  @Test
  //Testing bidding value
  public void testGetBidValue() {
    User liib = new User("Lii");
    Bid firstBid = new Bid(liib,20.0);
    
    double output=firstBid.getBidValue();
    
    assertEquals(20.0,output,0.01);

  }
  @Test
  //testing who the buyer is (user)
  public void testGetBuyer() {
    User liib = new User("Liil");
    Bid firstBid = new Bid(liib,20.0);
    
    assertEquals(liib,firstBid.getBuyer());
    
  }
  
  @Test
  // test if the correct string is returned
  public void testToString() {
    User liib = new User("Liil");
    Bid firstBid = new Bid(liib,20.0);
    
    assertEquals("Liil has bid £20.0",firstBid.toString());
  }

}
