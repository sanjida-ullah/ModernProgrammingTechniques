import java.io.*;
import java.util.*;

public class Name {
 public Name(String last, String mI, String first) {
  this.last = last;
  this.first = first;
  this.mI= mI;
 }
 public Name(String first) {this("", "", first);}

 public String getFormal() {return first + " " + last;}
 public String getOfficial() {return last + ", " + first;}
 public String initials(){ return first.charAt(0) + "." + last.charAt(0) + ".";}
 public boolean equals(Name other) { return first.equals(other.first) && last.equals(other.last);}

 public String toString() {return first + " " + mI + " " + last;}

 public static Name read(Scanner scanner) {
  if (!scanner.hasNext()) return null;
  String last = scanner.next();
  String first = scanner.next();
  return new Name(last, "" ,first);
 }

 private String first, last, mI;

 public static void main(String [] args) throws Exception {
  Scanner scanner = new Scanner(new File("Name.txt"));

  int count = 0;
  Name other = new Name (" ", "", " ");
  Name name = read(scanner);
  while(name != null) {
   if (name.equals(other)) {
   System.out.println("Duplicate name " + other + " discovered");
   }
   else {
     System.out.println("name: " + name.toString());
    System.out.println("formal: " + name.getFormal());
   System.out.println("official: " + name.getOfficial());
   System.out.println("initials: " + name.initials());
   }
     
   System.out.println();
   count++;
   other = name;
   name = read(scanner);
  }
  System.out.println("---");
  System.out.println(count + " names processed.");
 }
}
 

 