
package com.mycompany.library_management_system;
import java.util.Scanner; 
import java.io.*;


public class User {
     protected String UserName;
     protected String Password;
     protected String Email;
     protected String Phone;
     public User() {}
     
     public boolean LogIn(String username,String password,String type) throws FileNotFoundException
     {
          if(type.equals("Admin"))
          {
              File AdminFile = new File("E:\\programming\\Java\\Library_Management_System\\Data\\Admin.txt");
              Scanner input = new Scanner(AdminFile); 
              
              while(input.hasNext())
              {
                  String name = input.next();
                  String PassWord = input.next();
                  if(name.equals(username) && password.equals(PassWord))
                  {
                      input.close();
                      return true;
                  }
              }
              input.close();
              return false;
          }
          else if(type.equals("Patron"))
          {
              File PatronFile = new File("E:\\programming\\Java\\Library_Management_System\\Data\\patron.txt");
              Scanner input = new Scanner(PatronFile); 
              
              while(input.hasNext())
              {
                  String name = input.next();
                  String PassWord = input.next();
                  if(name.equals(username) && password.equals(PassWord))
                  {
                      input.close();
                      return true;
                  }
              }
              input.close();
              return false;      
          }
          else
          {
              File LibrarianFile = new File("E:\\programming\\Java\\Library_Management_System\\Data\\Librarian.txt");
              Scanner input = new Scanner(LibrarianFile); 
              
              while(input.hasNext())
              {
                  String name = input.next();
                  String PassWord = input.next();
                  if(name.equals(username) && password.equals(PassWord))
                  {
                      input.close();
                      return true;
                  }
              }
              input.close();
              return false;      
          }
     }
}
