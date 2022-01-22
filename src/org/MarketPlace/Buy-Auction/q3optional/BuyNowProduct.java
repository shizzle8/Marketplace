package org.com1027.coursework.q3optional;

import java.util.ArrayList;



public class BuyNowProduct extends Product{
  
  private double price;
  private int quantity;
  private ArrayList<Purchase> purchases = new ArrayList<Purchase>();
  
  public BuyNowProduct(int ID, String productName, double price,int quantity) {
    
	
	  
	super(ID, productName);
    this.quantity=quantity;
    this.price=price;
    
    if(productName==null || price<0.01 || quantity<1) {
		  throw new IllegalArgumentException();
	  }
    
  }

  public boolean attemptToPurchase(User user, int quantity) {
    if(user == null) {
      throw new IllegalArgumentException();
    }
    
    if(this.quantity>=quantity) {
      purchases.add(new Purchase(user,quantity));
      this.quantity=this.quantity-quantity;
      return true;
    }
    
    else {return false;}
  }
  
  public int howManyPurchases() {
	  int quantity=0;
	    for(Purchase purchase:purchases) {
	    	quantity +=purchase.getQuantityPurchased();
	    }
	    return quantity;  
  
  }
  
  
  @Override
  public String displayHistory() {
	  int quantity=0;
	  for(Purchase purchase:purchases) {
		  quantity += purchase.getQuantityPurchased();
	  }
	  String text= Integer.toString(getProductId()) + ": " + getProductName() + " quantity: " + (this.quantity+quantity) +  "\n";
	  if(this.purchases.isEmpty()) {
		  text += "no purchases";
	  }
   
	  else {
		  text+="buy now history: " + "\n";
		  for(Purchase purchase:purchases) {
       
			  text+= purchase.getBuyer().toString() + " bought " + purchase.getQuantityPurchased() + "\n" ;
		  }
	  }
   
	  return text;
  	}
  
  @Override
  public String displayUserInfoForProduct() {
	  String text="";
	  if(purchases.isEmpty()) {
		  return "";
	  }
    
	  for(Purchase purchase:purchases) {
  
		  if(purchases.size()<2) {
			  text= purchase.getBuyer().toString() + " bought " + purchase.getQuantityPurchased();
		  }
		  else {
			  text+= purchase.getBuyer().toString() + " bought " + purchase.getQuantityPurchased() + "\n";
		  }
	  }
	  System.out.println(text);
	  return text ;
    
  }
  
  public int getQuantity() {
	  return this.quantity;
  }
  
  @Override
  public double getCurrentPrice() {
    
    return this.price;
  }

  @Override
  public boolean isProductSold() {
    if(this.quantity==0) {
    return true;}
    else {return false;}
  }

}
