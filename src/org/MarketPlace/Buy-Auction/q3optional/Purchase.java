package org.com1027.coursework.q3optional;


public class Purchase {

    private User buyer;
    private int quantityPurchased;
    // creating constructor to allow user to purchase a quantity
    public Purchase(User buyer, int quantityPurchased) {
      this.buyer=buyer;
      this.quantityPurchased=quantityPurchased;
    }
    
    //simple getters to return information
    
    public User getBuyer() {
      return this.buyer;
    }
    
    public int getQuantityPurchased() {
      return this.quantityPurchased;
    }
    
    public String toString() {
      return getBuyer() + " bought " + getQuantityPurchased(); 
    }
}
