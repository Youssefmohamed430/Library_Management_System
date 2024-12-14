
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
     
     public Object LogIn(String username,String password,String type) throws FileNotFoundException
     {
          if(type.equals("Admin"))
          {
              String AdminFile = "E:\\programming\\Java\\Library_Management_System\\Data\\Admin.txt";
              return FileManager.LoadUser(username, password,AdminFile );
          }
          else if(type.equals("patron"))
          {
              String PatronFile = "E:\\programming\\Java\\Library_Management_System\\Data\\patron.txt";
              return FileManager.LoadUser(username, password,PatronFile ) ;   
          }
          else
          {
              String LibrarianFile = "E:\\programming\\Java\\Library_Management_System\\Data\\Librarian.txt";
              return FileManager.LoadUser(username, password,LibrarianFile );
          }
     }
     
}
