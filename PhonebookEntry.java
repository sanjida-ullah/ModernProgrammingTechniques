import java.io.*;
import java.util.*; 

class PhonebookEntry {
  private Name name;
  protected PhoneNumber phoneNumber;

  public PhonebookEntry(String last, String first, String number) {
    name = new Name(last, "", first);
    phoneNumber = new PhoneNumber(number);
  }


  public Name getName(){ return name;}
  public PhoneNumber getPhoneNumber() {return phoneNumber;};
  
  public String call()     { 
    String dial = "Dialing ";
    if (phoneNumber.isTollFree()) {
      dial += "(toll-free) ";
    }
    return dial + name + ": " + phoneNumber; 
  }
  public String toString() { return name + ": " + phoneNumber; }

  public boolean equals(PhonebookEntry other) {
    return name.equals(other.name) && phoneNumber.equals(other.phoneNumber);
  }

  public static PhonebookEntry read(Scanner scanner) {
    if (!scanner.hasNext()) { 
      return null;
    }

    String last = scanner.next();
    String first = scanner.next();
    String number= scanner.next();

    return new PhonebookEntry(last, first, number);
  }

  public static void main(String [] args) throws Exception {
    Scanner scanner = new Scanner(new File("phonebook.text"));
    int counter = 0;
    PhonebookEntry other = new PhonebookEntry (" ", " ", " "); 
    PhonebookEntry phonebookEntry = read(scanner);

    while (phonebookEntry != null) {
      if (phonebookEntry.equals(other)) {
        System.out.println("Duplicate phone book entry \"" + phonebookEntry + "\" discovered");
      }
      else {
        if ((phonebookEntry.name.equals(other.name))) {
          System.out.println("Warning duplicate name encountered \"" + phonebookEntry + "\" discovered");
        }

        System.out.println("phone book entry: " + phonebookEntry);
        System.out.println(phonebookEntry.call());
        System.out.println();
      }

      counter++;
      other = phonebookEntry;
      phonebookEntry = read(scanner);
    }
    System.out.println("---");
    System.out.println(counter + " phonebook entries processed.");
  }
}
