import java.io.*;
import java.util.*; 

public class PhonebookEntry2 {
  private String last;
  private String first;
  private String number; 
  public PhonebookEntry2(String last, String first, String number) {
    this.last = last;
    this.first = first;
    this.number = number;  
  }
  public String call() {return "Dialing " + first + " " + last + ": " + number ;}
  public String toString() {return first + " " + last + " " + number;}
  public boolean equals(PhonebookEntry other) {
    return this.first.equals(other.first) && this.last.equals(other.last) && this.number.equals(other.number);
  }
  public static PhonebookEntry read(Scanner scanner) {
    if (!scanner.hasNext()) return null;
    String last = scanner.next();
    String first = scanner.next();
    String number= scanner.next();
    return new PhonebookEntry(last, first, number);
  }
  
  public static void main(String [] args) throws Exception {
    
    Scanner scanner = new Scanner(new File("phonebook.text"));
    int counter=0;
    PhonebookEntry other = new PhonebookEntry (" ", " ", " "); 
    PhonebookEntry phonebookEntry= read(scanner);
    
    while (phonebookEntry != null) {
      if (phonebookEntry.equals(other)) {
        System.out.print("Warning duplicate name encountered \"" + other + "\" discovered");
      }
      else {
        System.out.println("phone book entry: " + phonebookEntry.toString());
        System.out.println(phonebookEntry.call());
        other= phonebookEntry;
      }
      System.out.println();
      counter++;
      other= phonebookEntry;
      phonebookEntry = read(scanner);
    }
    System.out.println("---");
    System.out.println(counter + " entries processed.");
    
    
  }
  
}
