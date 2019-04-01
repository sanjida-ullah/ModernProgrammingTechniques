import java.io.*;
import java.util.*;

public class Phonebook2 {
 public static void main(String [] args) throws Exception {
   int cap=100;
   String [] lastName = new String [cap];
   String [] firstName = new String [cap];
   String [] number = new String[cap];
   File myfile = new File("phonebook.txt"); 
     Scanner infile = new Scanner(myfile);
     
     while(infile.hasNext()) {
       for(int i =0; i < cap; i++)
     lastName = infile.next();
     for(int i =0; i < cap; i++)
       firstName = infile.next();
    for(int i =0; i < cap; i++)
     number = infile.next();
     }
     
     for (int i =0; i<cap; i++)
     System.out.println(lastName[i] + " " + firstName[i] + " " + number[i]);
 }
}