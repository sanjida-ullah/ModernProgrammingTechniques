import java.io.*;
import java.util.Scanner;

public class PhonebookEntries {
  private Name name;
  private PhoneNumber phonenumber;

public PhonebookEntries(String first, String last, String number) {
  name = new Name(last, first);
  phoneNumber= new phoneNumber(number);
}
public PhonebookEntries(Name name, PhoneNumber phoneNumber) {
  this.name=name;
  this.phoneNumber=phoneNumber;
}
public Name getName() {return name;}
public PhoneNumber getPhoneNumber() { return phoneNumber;}
public String call(){
  String dial = "Dialing ";
    if(phoneNumber.isTollFree()) { return dial + " " + name + " " + phoneNumber; }
       }
public boolean equals(PhonebookeEntries other) { return name.equals(other.name) && phoneNumber.equals(other.phoneNumber);}
public String toString() {return name + ": " + phoneNumber;}
public static PhonebookEntries read(Scanner scanner) {
  if(!scanner.hasNext()) return null;
  String last = scanner.next();
  String first = scanner.next();
  String number= scanner.next();
  return new PhonebookEntries(last, first,number);
}
public static void main(String[] args) throws IOException {
  Scanner scanner = new Scanner(new File("phonebook.text"));
  int counter = 0;
  PhonebookEntries other = new PhonebookEntries(" ", " ", " ");
  PhonebookEntries phonbookEntries= read(scanner);
  while(phonebookEntries != null) {
    if(phonebookEntries.equals(other)){
      System.out.println("dup entry detected");}
    else if(PhonebookEntries.name.equals(other.name)) {
      System.out.println(" warning double name");
      System.out.println(phonebookEntries.toString());
    }
  }
}
}