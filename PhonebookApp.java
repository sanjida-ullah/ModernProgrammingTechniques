import java.util.*;
import java.io.*;
import java.util.TreeMap;
import java.util.Set;
import java.util.Iterator;
import java.util.Map;

class PhonebookApp {
  public static void main (String[] args) throws IOException {
    
    final int capacity = 100;
    final String FILENAME = "phonebook3.text";
    String[] lastName = new String[capacity];
    String[] firstName= new String[capacity];
    String [] numbers = new String[capacity]; 
    
    int size = read(FILENAME, lastName, firstName, numbers,  capacity);
    
    String name = " ", number;
    Scanner kybd = new Scanner(System.in);   
    
    System.out.print("lookup, quit (l/q)? ");
    String input = kybd.next();
    while(input!="q"){
      String last, first;
      if (input.equals("l")){
        System.out.print("last name?");
        last = kybd.next();
        System.out.print(" first name? ");
        first =kybd.next();
        number = lookup(lastName, firstName, numbers, size, last, first);
        if (!number.equals(" "))
          System.out.print(first + " " + last +  "'s phone numbers:" + number);         
        else 
          System.out.print("-- Name not found\n");
        System.out.println();
        System.out.print("lookup, quit (l/q)? \n");
        input = kybd.next();
      }  
      if (input.equals("q")){
        break;
      }
    }
  }
  
  public static int read(String filename, String [] lastName, String[] firstName, String[] numbers, int capacity) throws IOException {
    File myfile = new File (filename);
    Scanner infile = new Scanner (myfile);
    int size = 0;
    
    while (infile.hasNext() && size<lastName.length){
      String pat = "(";
      lastName [size] = infile.next();
      firstName[size] = infile.next();
      numbers[size] = infile.nextLine();
      size++;
    }
    return size;
  }
  
  public static void print(String [] lastName,String[] firstName, String[] numbers, int size) {
    for (int i=0; i<size; i++)
      System.out.println(lastName[i] + " " + firstName[i] + " " +   "[ " + numbers[i] + " ]");
  }
  public static String lookup(String[] lastName, String[] firstName, String[] numbers, int size, String last, String first ){ 
    for (int i=0; i< size; i++) {
      if (lastName[i].equals(last) && firstName[i].equals(first))
        return numbers[i];
    }
    return " ";
  }
}

class PhonebookEntry {
  private Name name;
  private ArrayList <ExtendedPhoneNumber> phoneNumbers = new ArrayList <ExtendedPhoneNumber>();
  
  public PhonebookEntry( Name name, ArrayList<ExtendedPhoneNumber> phoneNumbers){
    this.name = name;
    this.phoneNumbers= phoneNumbers;
  }
  public Name getName(){ 
    return name;
  }
  public ArrayList<ExtendedPhoneNumber> getPhoneNumbers(){ 
    return phoneNumbers;
  }
  public String toString(){
    return name + ":" + phoneNumbers;
  }
  public static PhonebookEntry read(Scanner scanner) {
    ArrayList<ExtendedPhoneNumber> phoneNumbers = new ArrayList <ExtendedPhoneNumber>();
    if (!scanner.hasNext()) return null;
    Name name = Name.read(scanner);
    int header = scanner.nextInt();
    for (int i =0; i<= header; i++)
      phoneNumbers.add(ExtendedPhoneNumber.read(scanner));
    return new PhonebookEntry (name, phoneNumbers);
 }
}
class Name {
 public Name(String last, String first) {
  this.last = last;
  this.first = first;
 }
 public Name(String first) {this("", first);}

 public String getFormal() {return first + " " + last;}
 public String getOfficial() {return last + ", " + first;}
 public String getInitials(){return first.charAt(0) + "." + last.charAt(0)+ ".";}

 public boolean equals(Name other) {return first.equals(other.first) && last .equals(other.last);}

 public String toString() {return first + " " + last;}

 public static Name read(Scanner scanner) {
  if (!scanner.hasNext()) return null;
  String last = scanner.next();
  String first = scanner.next();
  return new Name(last, first);
 }

 private String first, last;

 
} 

class ExtendedPhoneNumber extends PhoneNumber{
  
  private String description;
  
  public ExtendedPhoneNumber(String number, String description){
    super(number);
    this.description = description;
  }
  
  public static ExtendedPhoneNumber read(Scanner scanner) {
    if (!scanner.hasNext())return null;
      String description = scanner.next();
      String number = scanner.next();   
    return new ExtendedPhoneNumber(description, number);
  }
}

class PhoneNumber{
  
  private String number;
 
  public PhoneNumber(String number){
    this.number = number;
  }
  
  public String getAreaCode(){return number.substring(1,4);}
  public String getExchange(){return number.substring(5,8);}
  public String getLineNumber(){return number.substring(9,13);}
  public boolean isTollFree(){return number.startsWith("(8");}
  public boolean equals(PhoneNumber number2) {return number.equals(number2.toString());}
  public String toString() {return number;}
  
  public static PhoneNumber read(Scanner scanner) {
    
    if (!scanner.hasNext())return null;
      String number = scanner.next();
      
    return new PhoneNumber(number);
  }
  

  
  
}
