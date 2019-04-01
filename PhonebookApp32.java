import java.util.*;
import java.io.*;

class PhonebookApp {
  public static void main (String[] args) throws IOException {
    
    final int capacity = 100;
    final String FILENAME = "phonebook.text";
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
    for (int i =1; i<= header; i++)
      phoneNumbers.add(ExtendedPhoneNumber.read(scanner));
    return new PhonebookEntry (name, phoneNumbers);
 }

  public static void main(String [] args) throws Exception {
    Scanner scanner = new Scanner(new File("phonebook3.text"));
    int count = 0;
    PhonebookEntry previous = null;
    PhonebookEntry entry = read(scanner);
    while(entry != null){
      entry = read(scanner);
    }
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

 public static void main(String [] args) throws Exception {
  Scanner scanner = new Scanner(new File("names.txt"));

  int count = 0;

  Name name = read(scanner);
  
  while(scanner.hasNext()) {
    
    Name name2 = read(scanner);
   
    
    if(name.equals(name2)){
         System.out.println("name: " + name);
         System.out.println("formal: " + name.getFormal());
         System.out.println("official: " + name.getOfficial());
         System.out.print("initials: " + name.getInitials()+"\n");
         System.out.println("");
         count++;
         System.out.print("Duplicate name \"" + name2 + "\" discovered\n");
         count++;
         if(scanner.hasNextLine()){
           name = read(scanner);
         }
    }
    
    else{
         
         System.out.println("name: " + name);
         System.out.println("formal: " + name.getFormal());
         System.out.println("official: " + name.getOfficial());
         System.out.print("initials: " + name.getInitials()+"\n");
         System.out.println("");
         count++;
         name = name2;
    }
    
    if( !scanner.hasNext()){
         System.out.println("name: " + name);
         System.out.println("formal: " + name.getFormal());
         System.out.println("official: " + name.getOfficial());
         System.out.print("initials: " + name.getInitials()+"\n");
         System.out.println("");
         count++;
    }
    }
    System.out.println("---");
  System.out.println(count + " names processed.");
}
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
  

  
  public static void main(String [] args) throws Exception {
    Scanner scanner = new Scanner(new File("numbers.txt"));
    
    int count = 0;
    
    PhoneNumber number = read(scanner);
    
    while(scanner.hasNext()) {
      
      PhoneNumber number2 = read(scanner);
      if(number.equals(number2)){
        System.out.println("phone number: " + number);
        System.out.println("area code: " + number.getAreaCode());
        System.out.println("exchange: " + number.getExchange());
        System.out.print("line number: " + number.getLineNumber()+"\n");
        System.out.print("is toll free: " + number.isTollFree()+"\n");
        System.out.println("");
        count++;
        System.out.print("Duplicate phone number \"" + number2 + "\" discovered\n");
        count++;
        if(scanner.hasNext()){
          number = read(scanner);
        }
      }
      
      else{
        
        System.out.println("phone number: " + number);
        System.out.println("area code: " + number.getAreaCode());
        System.out.println("exchange: " + number.getExchange());
        System.out.print("line number: " + number.getLineNumber()+"\n");
        System.out.print("is toll free: " + number.isTollFree()+"\n");
        System.out.println("");
        count++;
        number = number2;
      }
      
      if( !scanner.hasNext()){
        System.out.println("phone number: " + number);
        System.out.println("area code: " + number.getAreaCode());
        System.out.println("exchange: " + number.getExchange());
        System.out.print("line number: " + number.getLineNumber()+"\n");
        System.out.print("is toll free: " + number.isTollFree()+"\n");
        System.out.println("");
        count++;
      }
    }
    System.out.println("---");
    System.out.println(count + " phone numbers processed.");    
  }
}
