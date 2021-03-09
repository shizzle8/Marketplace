package org.com1027.coursework.q2;


public class User {
  // just a field name to store users name
  private String name;
  
  // simple constructor allows us to initialise our name.
  public User(String name){
    if(name!=null) {
      this.name=name;
    }
    
    else {
      throw new IllegalArgumentException();
    }
  }
  
  // this method just returns the name
  public String toString() {
    
    return this.name;
  }
}
