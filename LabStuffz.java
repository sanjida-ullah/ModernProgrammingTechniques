import java.io.*;
import java.util.Scanner;

public class Names{
  private String first;
  private String last;
  
  public Names( String last, String first) {
    this.last= last;
    this.first = first;
  }
  public String getFormal() {return first + " " + last;}
  public String getOfficial() { return last + ", " + first;} 
  public String toString() { return first + " " + last;}
  public boolean equals(Names other) {return first.equals(other.first) && last.equals(other.last);}
  public String getInitials(){ return first.charAt(0) + "." + last.charAt(0);}
  public static Names read(Scanner scanner){
    if(!scanner.hasNext()) return null;
    String last = scanner.next();
    String first = scanner.next(); 
    return new Names(last, first);
  }
  public static void main(String [] args) {
    Scanner scanner = new Scanner(new File("names.test"));
    int counter=0;
    Names names = read(scanner);
    Names other= new Names(" ", " ");
      while(names != null) {
        if(name.equals(other)) {
          System.out.println("duplicate name Found");
        } else { System.out.println("name:" + names.toString());
          System.out.println("formal:" + names.getFormal());
           System.out.println("official" + names.getOfficial());
           System.out.println("initials: " + names.getInitials);
           System.out.println(); }
           other= names;
           counter++;
           names= read(scanner);
           }
   System.out.println(counter + " names processed" );
           }
}

   