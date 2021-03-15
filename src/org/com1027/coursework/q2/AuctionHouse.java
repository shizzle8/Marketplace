package org.com1027.coursework.q2;

import java.util.HashMap;

public class AuctionHouse {
  // the fields for the auction house
  // these hash maps will store keys and values of the product and users, which will
  // be interchanged if a product is sold
  private HashMap<Product, User> forSaleProducts = new HashMap<Product, User>();
  private HashMap<Product, User> soldProducts= new HashMap<Product, User>();
  private HashMap<Product, User> unsoldProducts= new HashMap<Product, User>();
  
  
  // method just checks if a product exist true or false boolean
  public boolean checkExistence (Product product) {
      if( forSaleProducts.containsKey(product)) {     
        return true;
      }     
      else {return false;}
  }
  
  /* a simple method that returns all the products that have been sold, these will depend
   on the end auction method and whether the bid was successful which determines whether
    a product is sold or unsold*/
  public String displaySoldProducts() {
    String text="";
    // if the hashmap is empty its best to return an empty String
    if(soldProducts.isEmpty()) {
      return "";
    }
    // for loop to keep adding the sold products onto the string text that can be returned after
    for(HashMap.Entry<Product, User> p:soldProducts.entrySet()) {
      text += p.getKey().getProductId()+" - "+p.getValue().toString()+ " bid £"+ p.getKey().getHighestBid().getBidValue() +"\n";
    }
    return text;
  }
  
  // Similar method to displaySoldProducts()
  public String displayUnsoldProducts() {
    String text="";
    if(unsoldProducts.isEmpty()) {
      return "lol";
    }
    else {  
      for(HashMap.Entry<Product, User> p:unsoldProducts.entrySet()) {
          text += p.getKey().getProductId()+ " - "+ p.getKey().getProductName() +"\n";
    }
    }
        return text;
  
  }
  // this endAuction method determines whether a hashmap set will be transferred
  public void endAuction (Product product) {
    // initialise the user value which will be used to store the set values.
    User value = null;
    value = forSaleProducts.get(product);
    forSaleProducts.remove(product);
    System.out.println(product.getCurrentPrice());
    
    /* if there isnt any bids the products will go to the unsold products map
     since it didnt get sold.*/
    if(product.isProductSold()==false) {
      unsoldProducts.put(product, value);
      System.out.println(displayUnsoldProducts());
    }
    /* When the bidder successfully outbids the bid will be stored in the
     soldProducts
     */
    else  {
      soldProducts.put(product, value);
      System.out.println(displaySoldProducts());
    }
    /* if the bid price doesnt reach the reserved price then it will be stored
      in the unsoldproducts*/
  }
  
  public Boolean placeBid(BiddableProduct product,User user, Double bidValue) {
    if(product==null || user==null) {
      throw new IllegalArgumentException();
    }  
    
    if(!forSaleProducts.containsKey(product)) {
      return false;
    }
    else {
      return product.attemptedToPurchase(user, bidValue);
    }
  }
  
  // this methods allows the user to register a product
  public boolean register(Product product, User user) {
    if(product==null || user==null) {
      throw new IllegalArgumentException();
    }  
    
    if(!(forSaleProducts.containsKey(product))|| forSaleProducts==null) {
        forSaleProducts.put(product, user);
        return true;
      }
      
      else {return false;}
  }
}
