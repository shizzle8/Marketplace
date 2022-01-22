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
  
  // this method just returns the encoded name with *
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
