import java.io.*;
import java.util.*;

public class PhoneNumber{
  private String number; 
  public PhoneNumber(String number) { 
    this.number = number;
  } 
  public String getNumber() {return number;}
  public String getAreaCode() {return number.substring(1,4);}
  public String getExchange() {return number.substring(5,8);}
  public String getLineNumber(){ return number.substring(9,13);}
  public boolean isTollFree() {
    return "8".equals(number.substring(1,2));
  }
  public boolean equals(PhoneNumber other) {
        return this.number.equals(other.number);
    }
  
  
  public String toString() {return number;}
  
  
  public static PhoneNumber read(Scanner scanner) {
    if (!scanner.hasNext()) return null;
    return new PhoneNumber(scanner.next()); } 
  
  
  public static void main(String [] args) throws Exception {
    Scanner scanner = new Scanner(new File("numbers.txt"));
    
    PhoneNumber num= read(scanner);
    PhoneNumber other = new PhoneNumber (" ");
    while (num != null) {
      if (num.equals(other)) {
   System.out.print("Duplicate number \"" + other + "\" discovered");
   }
      else {
      System.out.println("phone number: " + num); 
      System.out.println("area code: " + num.getAreaCode());
      System.out.println("exchange: " + num.getExchange());
      System.out.println("line number: " + num.getLineNumber());
      System.out.println("is toll free: " + num.isTollFree());
      }
      System.out.println();
      other= num;
      num = read(scanner);
      
    }
  }
}

