import java.io.*;
import java.util.Scanner;

class WindowApp{
  public static void main(String [] args) {
    
    try { 
       Window [] window = read();
     System.out.println("Creating window data from file data, loading it into an array, and displaying");
     
    for (int i= 0; i < window.length; i++) {  
      if(window[i] == null) {break;}
      System.out.println("--- Window " + i+ ": " + window[i]);
      window[i].display();
      System.out.println();
    }
    System.out.println("\nTurning on visibility");
    for (int i= 0; i < window.length; i++) {  
      if(window[i] == null) {break;}
      System.out.println("--- Window " + i+ ": " + window[i]);
      window[i].setVisible(true);
      window[i].displayNormal();
      System.out.println();
    }
     System.out.println("\nResizing (flipping width and height) and displaying");
    for (int i= 0; i < window.length; i++) {  
      if(window[i] == null) {break;}
      window[i].resize(window[i].getHeight(), window[i].getWidth());
      System.out.println("--- Window " + i+ ": " + window[i]);
      window[i].displayNormal();
      System.out.println();
    }
      System.out.println("\nMinimizing and Displaying");
    for (int i= 0; i < window.length; i++) {  
      if(window[i] == null) {break;}
      window[i].minimize();
      System.out.println("--- Window " + i+ ": " + window[i]);
      window[i].display();
    }

      
    }
    catch(Exception e) { }
    
  }
  
  
  public static Window[] read() throws Exception{
    
    Window [] window = new Window[25];
    
    Scanner scanner = new Scanner(new File("window.txt"));
    
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