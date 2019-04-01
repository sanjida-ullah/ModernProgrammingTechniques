import java.util.Scanner;
class ColoredWindow extends Window{
  private char color = '.';
  
  public ColoredWindow(int width, int height, char color) {
    this(width, height);
    this.color=color;
  }
  public ColoredWindow(int width, int height) {
    super(width, height);
  }
  
  public void setColor(char thisColor){ color= thisColor; }
  public char getColor(){ return color; }
  
  
  public String toString(){ 
   return "a " + getWidth() + "x" + getHeight()+ " window with background color '" + color + "'" ;
  }
  
  
  public void displayNormal() { 
   int height = getHeight();
    while(height > 0){
      
      for(int i=0; i< getWidth(); i++){
        System.out.print(color);
      }
      System.out.println();
      height--;
    }
  }
 public static ColoredWindow read(Scanner scanner){
 if (!scanner.hasNext()) return null;
 int width = scanner.nextInt();
 int height = scanner.nextInt();
 String stringcolor = scanner.next();
 char color = stringcolor.charAt(0); 
 return new ColoredWindow(width, height, color); 
 } 
}