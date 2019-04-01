import java.io.*;
import java.util.*;

class PhonebookLab {
  public static void main(String [] args) throws Exception {
    final String FILENAME = "phonebook.text";
    final int CAPACITY = 100;
    PhonebookLab phoneStuff = new PhonebookLab();
    PhonebookEntry [] entries = new PhonebookEntry[CAPACITY];
    
    int size = read(FILENAME, entries, CAPACITY);
    
    Scanner scanner = new Scanner(System.in);
    int counter=0;
    int counter2=0;
    
    System.out.print("lookup, reverse-lookup, quit (l/r/q)?");
    char typeOfLookup = scanner.next().charAt(0);
    
    while (typeOfLookup != 'q') {
      if (typeOfLookup== 'l') {
        counter++;
        System.out.print(" last name?");
        String last= scanner.next();
        System.out.print(" first name?");
        String first = scanner.next(); 
        Name searchName = new Name(last, first);
        String number = phoneStuff.lookup(entries, size, searchName);
        if (!number.equals("")) 
          System.out.println(" " +first + " " + last + "'s phone number is "+ number);
        else
          System.out.println(" -- Name not found");
        System.out.println(); 
      }
      if (typeOfLookup == 'r') {
        counter2++;
        System.out.print(" phone number (nnn-nnn-nnnn)?") ;
        String phoneNumber = scanner.next();
        PhoneNumber searchNumber = new PhoneNumber(phoneNumber);
        String name  = phoneStuff.lookupReverse(entries, size, searchNumber);
        if (!name.equals("")) 
          System.out.println(" " +phoneNumber + " belongs to " + name);
        else
          System.out.print(" -- Phone number not found" + "\n" );
        System.out.println(); 
      }
      System.out.print("lookup, reverse-lookup, quit (l/r/q)?");
      typeOfLookup = scanner.next().charAt(0);   
    }
    System.out.println(" \n" +counter + " lookups performed");
    System.out.println(counter2+ " reverse lookups performed" );
  } 
  static int read(String filename, PhonebookEntry [] entries, int capacity) throws IOException {
    Scanner scanner = new Scanner(new File(filename));
    
    int size = 0;
    while (scanner.hasNext()) {
      if (size == capacity) {
        System.out.println("Phonebook capacity exceeded - increase size of underlying array");
        System.exit(1);
      }
      entries[size] = PhonebookEntry.read(scanner);
      size++;
    }
    for(int i= 0; i<size; i++)
      System.out.println(entries[i] + " " );
    return size;
  }
  String lookup(PhonebookEntry [] entries, int size, Name searchName) {
    for (int i = 0; i < size; i++)
      if (entries[i].equals(searchName))  return entries[i].phoneNumber.getNumber();
    return "";
  }
 String  lookupReverse(PhonebookEntry [] entries, int size, PhoneNumber searchNumber) {
    for (int i = 0; i < size; i++)
      if (entries[i].equals(searchNumber))
      return "";
    return ""; 
  } 
}