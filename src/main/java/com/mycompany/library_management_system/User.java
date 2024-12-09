
package com.mycompany.library_management_system;
import java.io.*;
import java.io.Serializable;



public class User implements Serializable {
     private static final long serialVersionUID = 1L; 
     protected String UserName;
     protected String Password;
     protected String Email;
     protected String Phone;
     
     public User() {}
     public User(String username,String Password,String Email, String phone) {
         this.UserName = username;
         this.Password = Password;
         this.Email = Email;
         this.Phone = phone;
     }
     
     public String getUserName() { return this.UserName; }
     public String getPassWord() { return this.Password; }
     public String getEmail() { return this.Email; }
     public String getPhone() { return this.Phone; }
     
     public boolean LogIn(String username,String password,String type) throws FileNotFoundException
     {
          if(type.equals("Admin"))
          {
              String AdminFile = "E:\\programming\\Java\\Library_Management_System\\Data\\Admin.txt";
              if(FileManager.LoadUser(username, password,AdminFile ) != null)
                 return true;
              else 
                  return false;
          }
          else if(type.equals("Patron"))
          {
              String PatronFile = "E:\\programming\\Java\\Library_Management_System\\Data\\patron.txt";
              if(FileManager.LoadUser(username, password,PatronFile ) != null)
                 return true;
              else 
                  return false;     
          }
          else
          {
              String LibrarianFile = "E:\\programming\\Java\\Library_Management_System\\Data\\Librarian.txt";
              if(FileManager.LoadUser(username, password,LibrarianFile ) != null)
                 return true;
              else 
                  return false; 
          }
     }
}
