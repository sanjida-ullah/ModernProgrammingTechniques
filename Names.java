import java.io.*;
import java.util.*;

public class Names {
 public Names(String last, String mI, String first) {
  this.last = last;
  this.first = first;
  this.mI= mI;
 }
 public Names(String first) {this(" ", " ", first);}

 public String getFormal() {return first + " " + last;}
 public String getOfficial() {return last + ", " + first;}
 public String initials(){ return first.charAt(0) + "." + last.charAt(0) + ".";}
 public boolean equals(Names other) {return first.equals(other.first) && last .equals(other.last);}

 public String toString() {return last + " " + mI + " " + first;}

 public static Names read(Scanner scanner) {
  if (!scanner.hasNext()) return null;
  String last = scanner.next();
  String mi= scanner.next();
  String first = scanner.next();
  return new Names(last, mi ,first);
 }

 private String first, last, mI;

 public static void main(String [] args) throws Exception {
   try { Scanner scanner = new Scanner(new File("Name.txt"));
 
  int count = 0;
  Names other = new Names (" ", "", " ");
  Names name = read(scanner);
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
   catch(FileNotFoundException Exception) {System.out.println("file not found");}
}
}
 

 