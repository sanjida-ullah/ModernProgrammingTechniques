import java.util.Scanner;
import java.io.*;

class Authenticator{
  
  final int CAPACITY = 100;
  User[] users = new User[CAPACITY];
  int size;
  
  public Authenticator(String FILENAME)throws IOException{      
    Scanner sc=new Scanner(new File(FILENAME));
    int i=0;
    while(sc.hasNext()){
      users[i]=User.read(sc);
      i++;
    }
    size = i;
    sc.close();
  }
  
  public void authenticate(String userName, String passWord) throws Exception{
    /*
     int count = 0;
     // check on usernames
     for(int i=0;i<size;i++){
     if(!users[i].getUsername().equals(userName)){
     throw new Exception("username not found")
     }
     while(!users[i].verifyPassword(passWord)&& count<3){
     try{
     System.out.println("*** Invalid password - hint: " + users[i].getPasswordHint());
     count++;
     }
     catch(Exception e){
     System.out.println("Too many failed attempts... please try again later");
     System.exit(0);
     }
     }
     }
     */
    
    int count = 0;
    boolean found = false;
    // check if user name exists
    for (int i = 0; i < size; i++) {
      if (users[i].getUsername().equals(userName)) {
        // there's a match!
        found = true;
        break;
      }
    }
    
    // throw exception if not found, otherwise look for password
    if (!found) {
      throw new Exception("username not found");
    }
  }
}