package org.com1027.coursework.q3optional;

import java.util.ArrayList;

public abstract class  Product {
  // all the fields I need to create a product
  private int productID;
  private String productName;

  
  // constructor allows a product instance to be created if it meets the requirements
  public Product(int ID, String productName) {
    if(productName==null) {
      throw new IllegalArgumentException();
    }
    else {
      this.productID=ID;
      this.productName=productName;
    }
  }
  
  
  // this method just returns the product ID.
  public int getProductId() {
    return productID;
  }
  // this method just returns the product name.
  public String getProductName() {
    return productName;
  }

  public String toString() {
    return getProductId() + " - " + getProductName();
  }
  
  public abstract String displayHistory();
  public abstract String displayUserInfoForProduct();
  public abstract double getCurrentPrice();
  public abstract boolean isProductSold();
  
}
