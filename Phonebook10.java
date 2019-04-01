import java.io.*;
import java.util.*;

class Phonebook10 {
  public static void main(String [] args) {
    final String FILENAME = "phonebook.text";
    final int CAPACITY = 100;
    
    PhonebookEntry [] entries = new PhonebookEntry[CAPACITY];
    
    int size = 0;
    try {
      size = read(FILENAME, entries, CAPACITY);
      
      Scanner scanner = new Scanner(System.in);
      int lookup=0;
      int reverselookup=0;
      
      System.out.print("lookup, reverse-lookup, quit (l/r/q)?");
      char typeOfLookup = scanner.next().charAt(0);
      
      while (typeOfLookup != 'q') {
        if (typeOfLookup== 'l') {
          lookup++;
          System.out.print(" last name?");
          String last= scanner.next();
          System.out.print(" first name?");
          String first = scanner.next(); 
          Name searchName = new Name(last,"", first);
          PhoneNumber number = lookup(entries, size, searchName);
          if (number != null) 
            System.out.println(" " +first + " " + last + "'s phone number is "+ number);
          else
            System.out.println(" -- Name not found");
          System.out.println(); 
        }
        if (typeOfLookup == 'r') {
          reverselookup++;
          System.out.print(" phone number (nnn-nnn-nnnn)?") ;
          String phoneNumber = scanner.next();
          PhoneNumber searchNumber = new PhoneNumber(phoneNumber);
          Name name  = lookupReverse(entries, size, searchNumber);
          if (name != null) 
            System.out.println(" " +phoneNumber + " belongs to " + name);
          else
            System.out.print(" -- Phone number not found" + "\n" );
          System.out.println(); 
        }
        System.out.print("lookup, reverse-lookup, quit (l/r/q)?");
        typeOfLookup = scanner.next().charAt(0);   
      }
      System.out.println(" \n" + lookup + " lookups performed");
      System.out.println(reverselookup+ " reverse lookups performed" );
    }
    catch (IOException e) {
      System.out.println("*** IOException *** " + e.getMessage());
    }
    catch (Exception e) {
      System.out.println(e.getMessage());
    }
  } 
  static int read(String filename, PhonebookEntry [] entries, int capacity) throws IOException, Exception {
    Scanner scanner = new Scanner(new File(filename));
    
    int size = 0;
    while (scanner.hasNext()) {
      if (size >= capacity) {
        throw new Exception("*** Exception *** Phonebook capacity exceeded - increase size of underlying array");
      }
      entries[size] = PhonebookEntry.read(scanner);
      size++;
    }
    return size;
  }
  static PhoneNumber lookup(PhonebookEntry [] entries, int size, Name searchName) {
    for (int i = 0; i < size; i++) {
      if (entries[i].getName().equals(searchName)) {
        return entries[i].getPhoneNumber();
      }
    }
    return null;
  }
  static Name lookupReverse(PhonebookEntry [] entries, int size, PhoneNumber searchNumber) {
    for (int i = 0; i < size; i++) {
      if (entries[i].getPhoneNumber().equals(searchNumber)) {
        return entries[i].getName();
      }
    }
    return null; 
  } 
}