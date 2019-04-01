import java.io.*;
import java.util.Scanner;

class WindowApp{
  public static void main(String [] args) {
    
    try { Window [] window = read();
   System.out.println(java.util.Arrays.toString(window)); 
                      
    }
    catch(Exception e) {}
    
  }
  
  
  public static Window[] read() throws Exception{

    Window [] window = new Window[25];
    
    Scanner scanner = new Scanner(new File("window.data"));
    
    int size = 0;  
    while(scanner.hasNext()) { 
      String typeOfWindow = scanner.next();
      if(typeOfWindow.equals("C")){
        window[size] = ColoredWindow.read(scanner);
      }
      else if (typeOfWindow.equals("B")) {
        window[size]= BorderedWindow.read(scanner);
      }
      size++;
    }
    return window;  
  }
 
}