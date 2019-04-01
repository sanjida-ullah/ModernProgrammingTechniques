import java.io.*;
import java.util.*;

public class Phonebook {
 public static void main(String [] args) throws Exception {
  final String FILENAME = "phonebook.txt";
  final int CAPACITY = 100;

   String [] lastname = new String[CAPACITY];
   String [] firstname = new String[CAPACITY];
   String [] numbers = new String[CAPACITY];
   

  int size = read(FILENAME, lastname, firstname, numbers, CAPACITY);

  Scanner scanner = new Scanner(System.in);
  int counter=0;
  int counter2=0;
  
  System.out.print("lookup, reverse-lookup, quit (l/r/q)? ");
  char typeOfLookup = scanner.next().charAt(0);
  
  while (typeOfLookup != 'q') {
    if (typeOfLookup== 'l') {
     counter++;
    System.out.println("last name? ");
    String last= scanner.next();
    System.out.println("first name");
    String first = scanner.next(); 
   String number = lookup(lastname, firstname, numbers, size, last, first);
   if (!number.equals("")) 
    System.out.println(number);
   else
    System.out.println("Not found");
   System.out.print("name? ");
    }
    if (typeOfLookup == 'r') {
      counter2++;
      System.out.println("phone number (nnn-nnn-nnnn)?");
    String phoneNumber = scanner.next();
    String name  = lookupReverse(lastname, firstname, numbers, size, phoneNumber);
    if (!name.equals("")) 
    System.out.println(name);
   else
    System.out.println("Not found");
    }
    System.out.print("lookup, reverse-lookup, quit (l/r/q)? ");
    typeOfLookup = scanner.next().charAt(0);   
  }
  System.out.println(counter + " lookups performed " + counter2+ " reverse lookups performed" );
 }

 static int read(String filename, String [] lastname, String [] firstname, String [] numbers, int capacity) throws IOException {
  Scanner scanner = new Scanner(new File(filename));

  int size = 0;
  while (scanner.hasNext()) {
   if (size == capacity) {
    System.out.println("Phonebook capacity exceeded - increase size of underlying array");
    System.exit(1);
   }
   lastname[size] = scanner.next();
   firstname[size] = scanner.next();
   numbers[size] = scanner.next();
   size++;
  }
  return size;
 }

 static String lookup(String [] lastname, String [] firstname, String [] numbers, int size, String last, String first) {
  for (int i = 0; i < size; i++)
   if ((lastname[i].equals(last)) && (firstname[i].equals(first))) return numbers[i];
  return "";
 }
 static String lookupReverse(String [] lastname, String [] firstname, String [] numbers, int size, String phoneNumber) {
  for (int i = 0; i < size; i++)
   if (numbers[i].equals(phoneNumber)) return firstname[i] + " " + lastname[i];
  return "";
 
}
}
