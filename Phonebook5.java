import java.io.*;
import java.util.*;

public class Phonebook5 {
 public static void main(String [] args) throws Exception {
  final String FILENAME = "numbersss.txt";
  final int CAPACITY = 100;

  String [] 
   names = new String[CAPACITY],
   numbers = new String[CAPACITY];

  int size = read(FILENAME, names, numbers, CAPACITY);

  Scanner scanner = new Scanner(System.in);

  System.out.print("name? ");
  while (scanner.hasNext()) {
   String name = scanner.next();
   String number = lookup(names, numbers, size, name);
   if (!number.equals("")) 
    System.out.println(number);
   else
    System.out.println("Not found");
   System.out.print("name? ");
  }
 }

 static int read(String filename, String [] names, String [] numbers, int capacity) throws IOException {
  Scanner scanner = new Scanner(new File(filename));

  int size = 0;
  while (scanner.hasNext()) {
   if (size == capacity) {
    System.out.println("Phonebook capacity exceeded - increase size of underlying array");
    System.exit(1);
   }
   names[size] = scanner.next();
   numbers[size] = scanner.next();
   size++;
  }
  return size;
 }

 static String lookup(String [] names, String [] numbers, int size, String name) {
  for (int i = 0; i < size; i++)
   if (names[i].equals(name)) return numbers[i];
  return "";
 }
}
