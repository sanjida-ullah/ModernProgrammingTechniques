import java.util.Scanner;
class BorderedWindow extends Window {
  

  public BorderedWindow(int width, int height) {
    super(width, height);
  }
 
  public String toString(){ 
   return "a " + getWidth() + "x" + getHeight()+ " window with a border" ;
  }
  
  
  public void displayNormal() { 
  String delim = "%" + getWidth() + "s";
  String base = "+" + String.format(delim, "").replace(' ', '-') + "+";
  String wall= "|" + String.format(delim, "") + "|";
  System.out.println(base);
  for(int i = 0; i<getHeight(); i++){
    System.out.println(wall);
  }
  System.out.println(base);
  }
 
 public static BorderedWindow read(Scanner scanner){
 if (!scanner.hasNext()) return null;
 int width = scanner.nextInt();
 int height = scanner.nextInt(); 
 return new BorderedWindow(width, height); 
 } 

}