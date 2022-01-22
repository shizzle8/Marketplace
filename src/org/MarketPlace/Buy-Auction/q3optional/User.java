package org.com1027.coursework.q3optional;

import java.util.HashMap;

public class User {
  // just a field name to store users name
  private String name;
  private HashMap<Integer,Integer> purchases = new HashMap<Integer,Integer>();
  private HashMap<Integer,Double> successfulBids = new HashMap<Integer,Double>();
  
  // simple constructor allows us to initialise our name.
  public User(String name){
    if(name!=null) {
      this.name=name;
    }
    
    else {
      throw new IllegalArgumentException();
    }
  }
  
  // display all the users successful bids on a product
  public String displayAllPurchases() {
	  return "All Purchased Products: \n" + displayPurchases() + displaySuccessfulBids();
  }
  // display all the successful purchases of the user
  public String displayPurchases() {
	  String text="Purchases: \n";
	  for(HashMap.Entry<Integer,Integer> p:purchases.entrySet()) {
		  text+= p.getKey() + " with quantity " + p.getValue() + "\n";
	  }
	  return text;
  }
  // display all the successful bids of the user
  public String displaySuccessfulBids() {
	  String text="Successful Bids: \n";
	  for(HashMap.Entry<Integer,Double> p:successfulBids.entrySet()) {
		  text+= p.getKey() + " at a cost of " + p.getValue() + "\n";
	  }
	  return text;
  }
  
  // allow us to store the users purhcases in a hashmap allowing to see all the users purchases
  public void buy(int productId, int quantity) {
	  if(productId<0 || quantity<1) {
		  throw new IllegalArgumentException();
	  }
	  else {
	  purchases.put(productId, quantity);
	  }
  }
  // check if the auction bid was succesful and if it was it will store it in the successful bids hashmap
  public void wonAuction(int productId, double winningPrice) {
	  if(productId<0 || winningPrice<0) {
		  throw new IllegalArgumentException();
	  }
	  else {
	  successfulBids.put(productId, winningPrice);
	  }
  }
  
  // this method just returns the name
  public String toString() {
    char[] text1 =  (this.name).toCharArray();
    char[] pname = new char[5];
    for(int x=1; x<6;x++) {
   	 pname[0]= text1[0];
   	 if(x==5) {
   		 pname[4]=text1[text1.length-1];
   		 break;
        }
   	 pname[x]='*';
    }
    return new String(pname);
  }
}
