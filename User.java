import java.util.Scanner;
import java.io.*;

class User{
  
  private String username;
  private String password;
  private String passwordHint;
  
  public User(String username, String password, String passwordHint){
    
    this.username = username;
    this.password = password;
    this.passwordHint = passwordHint;
  }
  
  public String getUsername(){
    return username;
  }
  
  public String getPasswordHint(){
    return passwordHint;
  }

 public Boolean verifyPassword(String pw){
    if(pw.equals(password))
      return true;
    else
      return false;
  }
  
  public String toString(){return "User" + username;}
  
  public static User read(Scanner scanner){
    if (!scanner.hasNext()) return null;
    String username = scanner.nextLine();
    String password = scanner.nextLine();
    String passwordHint = scanner.next();
    return new User(username, password, passwordHint);
  }
 
}
