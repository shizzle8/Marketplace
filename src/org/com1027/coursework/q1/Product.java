package org.com1027.coursework.q1;

import java.util.ArrayList;

public class Product {
  // all the fields I need to create a product
  private int productID;
  private String productName;
  private double reservedPrice;
  private ArrayList<Bid> bids = new ArrayList<Bid>();
  
  // constructor allows a product instance to be created if it meets the requirements
  public Product(int ID, String productName,double reservedPrice) {
    if(productName==null) {
      throw new IllegalArgumentException();
    }
    else {
      this.productID=ID;
      this.productName=productName;
      this.reservedPrice=reservedPrice;
    }
  }
  
  // this method allows us to calculate the highest bid
  public Bid getHighestBid() {
    //created a variable to store the lowest possible value
    double lowestValue = Double.MIN_VALUE;
    Bid highestBid = null;
    // we go through a for loop which goes through the bids, only if it isnt empty
    if(bids!=null) {
      for(Bid i:bids) {
      // if this condition meets the lowest value is replaced with one that is greater
        if(i.getBidValue()>lowestValue) {
        lowestValue = i.getBidValue();
        highestBid=i;

        }
      }
    }
    // when the loop end with have the highest bid which we just return.
    return highestBid;
  }
  // this method just returns the product ID.
  public int getProductId() {
    return productID;
  }
  // this method just returns the product name.
  public String getProductName() {
    return productName;
  }
  // this method just returns the reserved price
  public double getReservedPrice() {
    return reservedPrice;
  }
  
  // this method allows a user to place a bid on a product.
  public Boolean placeBid(User user, Double bidValue) {
      // some illegal arguments that cannot be inputed.
     if (bids==null || user==null || bidValue<0.01) {
       throw new IllegalArgumentException();
     }
      // now if there isn't a bid the user can place a bid at any price
     if(bids.isEmpty()) {
       this.bids.add(new Bid(user,bidValue));
       return true;
     }
      
      // if there are bid placed we have to check if the bid placed is higher than the highest bid
     else if(bidValue> getHighestBid().getBidValue()) {
       this.bids.add(new Bid(user,bidValue));
       return true;
      }
      // if nothing else is met return false to indicate a bid has not placed
      else {return false;}
    
   }
  
}
