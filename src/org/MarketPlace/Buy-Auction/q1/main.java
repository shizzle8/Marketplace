package org.com1027.coursework.q1;


public class main {
  public static void main(String[] args) {
    AuctionHouse ac = new AuctionHouse();
    Product p = new Product(1, "teddy",10.00);
    User u = new User("bob");
    System.out.println("Hi");
    ac.register(p,u);
    
    System.out.println(ac.displayUnsoldProducts());
    ac.endAuction(p);
    
    System.out.println(ac.displayUnsoldProducts());
  }
}
