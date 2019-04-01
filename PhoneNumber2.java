import java.io.*;
import java.util.*;

public class PhoneNumber2{
  public static void main(String [] args) throws Exception {
  
  Scanner scanner = new Scanner(new File("numbers.txt"));
  while (scanner.hasNext()) {
    String number = scanner.next();
    System.out.println(number); }
 

  }
  
}