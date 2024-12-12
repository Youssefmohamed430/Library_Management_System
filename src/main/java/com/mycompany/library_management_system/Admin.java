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

public class Admin extends User{
    private static final String LIBRARIAN_FILE = "E:\\programming\\Java\\Library_Management_System\\Data\\Librarian.txt";
    private static final String PATRON_FILE = "E:\\programming\\Java\\Library_Management_System\\Data\\patron.txt";
    // constructor
    public Admin(String username, String password, String name, String email, String phone){       
        super(username, password, name, email, phone);
    }
     
    // manage admin credentials for secure access
    public void updateUsername(String newUsername){
        this.UserName = newUsername;
    }
    
    public void updatePassword(String newPassword){
        this.Password = newPassword;
    }
    
    public boolean authenticate(String username, String password){
        return this.UserName.equals(username) && this.Password.equals(password);
    }
    
    // LIBRARIAN MANAGEMENT
    // create a librarian account
    public void createLibrarian(String username, String password, String name, String email, String phone){
        User librarian = new User(username, password, name, email, phone);
        FileManager.saveObject(librarian, LIBRARIAN_FILE);
    }    
    // delete a librarian account
    public void deleteLibrarian(String username, String password){
        FileManager.deleteUser(username, password, LIBRARIAN_FILE);
    }
    // update a librarian account
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
    // search for a librarian account
    public User searchLibrarian(String username){
        ArrayList<User> librarians = FileManager.loadAllUsers(LIBRARIAN_FILE);
        for(User librarian : librarians){
            if(librarian.getUserName().equals(username)){
                return librarian;
            }
        }
        return null;
    }

    
    // PATRON MANAGEMENT
    // create a patron account
    public void createPatron(String username, String password, String name, String email, String phone){
        User patron = new User(username, password, name, email, phone);
        FileManager.saveObject(patron, PATRON_FILE);
    }
    // delete a patron account
    public void deletePatron(String username, String password){
        FileManager.deleteUser(username, password, PATRON_FILE);
    }
    // update a patron account
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
    // Search for a patron account
    public User searchPatron(String username){
        ArrayList<User> patrons = FileManager.loadAllUsers(PATRON_FILE);
        for(User patron : patrons){
            if(patron.getUserName().equals(username)){
                return patron;
            }
        }
        return null;
    }
    
    // add a book
    public void addBook(Book book){
        Book.addbook(book);
    }
    
    // UPDATE EXISTING BOOK INFORMATION
    public void updateBookTitle(Book book, String newTitle){
        Book.updateTitle(book, newTitle);
    }
    public void updateBookStatus(Book book, String newStatus){
        Book.updateStatus(book, newStatus);
    }
    public void updateBookAuthor(Book book, String newAuthor){
        Book.updateAuthor(book, newAuthor);
    }
    public void updateBookPublicationYear(Book book, int newPublicationYear){
        Book.updatePublicationYear(book, newPublicationYear);
    }
    public void updateBookCategory(Book book, String newCategory){
        Book.updateCategory(book, newCategory);
    }
    public void updateBookDescription(Book book, String newDescription){
        Book.updateDescription(book, newDescription);
    }
    
    // delete an existing book
    public void deleteBook(String id){
        Book.deleteBook(id);
    }
    
    // CATEGORIZE BOOKS BY A SPECIFIC CRETERIA
    public void categorizeByGenre(String category) {
        Book.categorizeByGenre(category);
    }
    public void categorizeByAuthor(String author) {
        Book.categorizeByAuthor(author);
    }
    public void categorizeByPublicationYear(String publicationYear) {
        Book.categorizeByPublicationYear(publicationYear);
    }
    public void categorizeByStatus(String status) {
        Book.categorizeByStatus(status);
    }
    
    // track the status of a book
    public String trackStatus(Book book){
        return book.getstatus();
    }  
    
}