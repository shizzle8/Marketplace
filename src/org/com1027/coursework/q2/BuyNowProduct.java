package org.com1027.coursework.q2;

import java.util.ArrayList;

import sun.security.util.Length;

public class BuyNowProduct extends Product{
  
  private double price;
  private int quantity;
  private ArrayList<Purchase> purchases = new ArrayList<Purchase>();
  
  public BuyNowProduct(int ID, String productName, int quantity, int price) {
    super(ID, productName);
    this.quantity=quantity;
    this.price=price;
    
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
    
    return purchases.size();
  }
  
  
  @Override
  public String displayHistory() {
   String text= Integer.toString(getProductId()) + ": " + getProductName() + " quantity: " + this.quantity + "\n"
       + "buy now history:" + "\n";
   if(this.purchases.isEmpty()) {
     text += "no purchases";
   }
   
   else {
     for(Purchase purchase:purchases) {
       
       text+= purchase.getBuyer().toString() + " bought " + purchase.getQuantityPurchased() + "\n" ;
     }
   }
   
   return text;
  }
  
  @Override
  public String displayUserInfoForProduct() {
    String[] name= {};
 
    String text=Integer.toString(getProductId()) +": "+ getProductName()  + " quantity: " + this.quantity + "\n"
        + "buy now history: \n" ;
    int loop=0;
    for(Purchase purchase:purchases) {
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
