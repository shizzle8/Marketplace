//package src.org.com1027.coursework.q2;

import java.util.ArrayList;

import org.com1027.coursework.q2.*;


public class BiddableProduct extends Product{
  private double reservedPrice;
  
  private ArrayList<Bid> bids = new ArrayList<Bid>();
  
  public BiddableProduct(int ID, String productName, double reservedPrice) {
    super(ID, productName);
    this.reservedPrice=reservedPrice;
    // TODO Auto-generated constructor stub
  }

  @Override
  public String displayHistory() {
	 String[] name= {};
    String text=Integer.toString(getProductId()) +": "+ getProductName()  + " = " ;
     if(bids.isEmpty()) {
    	 return Integer.toString(getProductId()) +" : "+ getProductName()  + " = no bids" ;
     }
     // DO THIS LOOK AT BUYNOW AND CHANGE IT FOR THIS, COMPARE TO TESTS
     else {
    	 for(Bid bids:bids) {
    	      name[loop] = purchase.getBuyer().toString();
    	      loop++;
    	    }
    	    
    	    for(int i=0;i< name.length;i++) {
    	     char[] text1 =  (name[i]).toCharArray();
    	     for(int x=1; x<text1.length-1;i++) {
    	       text1[x]='*';
    	     }
    	     text+= new String(text1) + " bought " + purchases.get(i).getQuantityPurchased() + "\n";
    	    }
    	    return text ;
     }
    return null;
  }

  @Override
  public String displayUserInfoForProduct() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public double getCurrentPrice() {
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
      // when the loop end with have the highest bid which we just return.
      return highestBid.getBidValue();
    }
    // else return 0
    return 0;
  }

  @Override
  public boolean isProductSold() {
    if(getCurrentPrice()>this.reservedPrice) {
    	return true;
    }
    else {return false;}
    
  }
  
  public boolean attemptedToPurchase(User user, Double bidValue) {
    // some illegal arguments that cannot be inputed.
    if (bids==null || user==null || bidValue<0.01) {
      throw new IllegalArgumentException();
    }
     // now if there isn't a bid the user can place a bid at any price
    if(bids.isEmpty()) {
      this.bids.add(new Bid(null, bidValue));
      return true;
    }
     
     // if there are bid placed we have to check if the bid placed is higher than the highest bid
    else if(bidValue> getCurrentPrice()) {
      this.bids.add(new Bid(user,bidValue));
      return true;
     }
     // if nothing else is met return false to indicate a bid has not placed
     else {return false;}
   
  }
  
}
