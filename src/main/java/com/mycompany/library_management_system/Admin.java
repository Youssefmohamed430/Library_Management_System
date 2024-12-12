/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.library_management_system;

/**
 *
 * @author youss
 */
import java.util.ArrayList;
import java.util.List;

public class Admin extends User{
    private static final String LIBRARIAN_FILE = "E:\\programming\\Java\\Library_Management_System\\Data\\Librarian.txt";
    private static final String PATRON_FILE = "E:\\programming\\Java\\Library_Management_System\\Data\\patron.txt";
    // constructor
    public Admin(String username, String password, String name, String email, String phone){       
        super(username, password, name, email, phone);
    }
     
    // manage credentials for secure access
    public void updateUsername(String newUsername){
        this.UserName = newUsername;
    }
    
    public void updatePassword(String newPassword){
        this.Password = newPassword;
    }
    
    public boolean authenticate(String username, String password){
        return this.UserName.equals(username) && this.Password.equals(password);
    }
    
    // patron management
    public void createLibrarian(String username, String password, String name, String email, String phone){
        User librarian = new User(username, password, name, email, phone);
        FileManager.saveObject(librarian, LIBRARIAN_FILE);
    }
    
    public void deleteLibrarian(String username, String password){
        FileManager.deleteUser(username, password, LIBRARIAN_FILE);
    }
    
    public void updateLibrarian(String username, String password, String newName, String newEmail, String newPhone){
        ArrayList<User> librarians = FileManager.loadAllUsers(LIBRARIAN_FILE);
        for (User librarian : librarians) {
            if(librarian.getUserName().equals(username) && librarian.getPassWord().equals(password)){
                librarian.Email = newEmail;
                librarian.Name = newName;
                librarian.Phone = newPhone;
                FileManager.saveAllUsers(librarians, LIBRARIAN_FILE);
                return;
            }
        }
    }
    
    public User searchLibrarian(String username){
        ArrayList<User> librarians = FileManager.loadAllUsers(LIBRARIAN_FILE);
        for(User librarian : librarians){
            if(librarian.getUserName().equals(username)){
                return librarian;
            }
        }
        return null;
    }

    
    // patron management
    public void createPatron(String username, String password, String name, String email, String phone){
        User patron = new User(username, password, name, email, phone);
        FileManager.saveObject(patron, PATRON_FILE);
    }
    
    public void deletePatron(String username, String password){
        FileManager.deleteUser(username, password, PATRON_FILE);
    }
    
    public void updatePatron(String username, String password, String newName, String newEmail, String newPhone){
        ArrayList<User> patrons = FileManager.loadAllUsers(PATRON_FILE);
        for (User patron : patrons) {
            if(patron.getUserName().equals(username) && patron.getPassWord().equals(password)){
                patron.Email = newEmail;
                patron.Name = newName;
                patron.Phone = newPhone;
                FileManager.saveAllUsers(patrons, PATRON_FILE);
                return;
            }
        }
    }
    
    public User searchPatron(String username){
        ArrayList<User> patrons = FileManager.loadAllUsers(PATRON_FILE);
        for(User patron : patrons){
            if(patron.getUserName().equals(username)){
                return patron;
            }
        }
        return null;
    }
    
    
    
}