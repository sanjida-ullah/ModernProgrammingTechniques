abstract class Window implements GUIComponent {
  private int height, width;
  private boolean isItVisible, minimized;
  
  public Window(int width, int height){ 
    this.height = height;
    this.width = width;
    
      
  }
  
  public int getHeight() { return height; }
  public int getWidth() { return width; }
  
  @Override
  public String toString() { return "a " + width + "x" + height + " minimal window"; }
  
  
  public void display() { 
    if (!isItVisible) {
      System.out.println("(Nothing to see here)");
    }
   else if  (!minimized) { System.out.println(".......................\n:"  + toString() + ":\n.......................");
   }
  
   else {
    System.out.println("[" + this.toString() + " (minimized)]");
   }
  
  }
 public void minimize(){ minimized = true; }
  
  
  public void setVisible(boolean isItVisible) { this.isItVisible = isItVisible; }
  public boolean isVisible() { return isItVisible; }
  public void restore(){ minimized=false;}
 
 
  public void resize(int width, int height){ 
   this.width = width;
   this.height = height;
  }
  
 abstract void displayNormal();
  
  
}