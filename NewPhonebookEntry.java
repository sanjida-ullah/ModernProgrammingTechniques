import java.io.*;
import java.util.*; 

class NewPhonebookEntry {
  private Name name;
  private PhoneNumber phoneNumber;

  public NewPhonebookEntry(String last, String first, String number) {
    name = new Name(last, first)[];
    phoneNumber = new PhoneNumber(number);
  }

  public NewPhonebookEntry(Name name, PhoneNumber phoneNumber) {
    this.name = name;
    this.phoneNumber = phoneNumber;
  }

  public String call()     { 
    String dial = "Dialing ";
    if (phoneNumber.isTollFree()) {
      dial += "(toll-free) ";
    }
    return dial + name + ": " + phoneNumber; 
  }
  public String toString() { return name + ": " + phoneNumber; }

  public boolean equals(NewPhonebookEntry other) {
    return name.equals(other.name) && phoneNumber.equals(other.phoneNumber);
  }

  public static NewPhonebookEntry read(Scanner scanner) {
    if (!scanner.hasNext()) { 
      return null;
    }

    String last = scanner.next();
    String first = scanner.next();
    String number= scanner.next();

    return new NewPhonebookEntry(last, first, number);
  }

  public static void main(String [] args) throws Exception {
    Scanner scanner = new Scanner(new File("phonebook.text"));
    int counter = 0;
    NewPhonebookEntry other = new NewPhonebookEntry (" ", " ", " "); 
    NewPhonebookEntry phonebookEntry = read(scanner);

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

