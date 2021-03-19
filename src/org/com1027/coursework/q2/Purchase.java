package org.com1027.coursework.q2;


public class Purchase {

    private User buyer;
    private int quantityPurchased;
    
    public Purchase(User buyer, int quantityPurchased) {
      this.buyer=buyer;
      this.quantityPurchased=quantityPurchased;
    }
    
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
