package com.mycompany.library_management_system;

import java.util.ArrayList;

public class Admin extends User{
    private static final String BOOK_FILE_PATH ="E:\\programming\\Java\\Library_Management_System\\Data\\Books.txt";
    private static final String LIBRARIAN_FILE = "E:\\programming\\Java\\Library_Management_System\\Data\\Librarian.txt";
    private static final String PATRON_FILE = "E:\\programming\\Java\\Library_Management_System\\Data\\patron.txt";
    // constructor
    public Admin(){}
    
    public Admin(String username, String password, String name, String email, String phone){       
        super(username, password, name, email, phone);
    }
    
    public String getUsername(){
        return this.UserName;
    }
     
    // manage admin credentials for secure access
    
public void updateAdmin(String username, String newUserName, String newPassword, String newEmail, String newPhone) {
    ArrayList<User> admins = FileManager.loadAllUsers("E:\\programming\\Java\\Library_Management_System\\Data\\Admin.txt"); // Load all admins
    for (User admin : admins) {
        if (admin.getUserName().equals(username)) { // Find the admin by username
            admin.UserName = newUserName;
            admin.Password = newPassword;
            admin.Email = newEmail;
            admin.Phone = newPhone;
            break; // Stop searching after finding the admin
        }
    }
    FileManager.saveAllUsers(admins, "E:\\programming\\Java\\Library_Management_System\\Data\\Admin.txt"); // Save the updated admin list
}

    
    // LIBRARIAN MANAGEMENT
    // create a librarian account
    public void createLibrarian(String username, String password, String name, String email, String phone){
        ArrayList<User> Librarians = FileManager.loadAllUsers(LIBRARIAN_FILE);
        User librarian = new Librarian(username, password, email, phone,name);
        Librarians.add(librarian);
        FileManager.saveAllUsers(Librarians, LIBRARIAN_FILE);
    }    
    // delete a librarian account
    public void deleteLibrarian(String username, String password){
        FileManager.deleteUser(username, password, LIBRARIAN_FILE);
    }
    // update a librarian account
public void updateLibrarian(String username, String newUserName, String newPassword, String newName, String newEmail, String newPhone) {
    ArrayList<User> librarians = FileManager.loadAllUsers(LIBRARIAN_FILE);
    for (User librarian : librarians) {
        if (librarian.getUserName().equals(username)) {
            librarian.UserName = newUserName;
            librarian.Password = newPassword;
            librarian.Email = newEmail;
            librarian.Name = newName;
            librarian.Phone = newPhone;
            break;
        }
    }
    FileManager.saveAllUsers(librarians, LIBRARIAN_FILE);
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
        ArrayList<User> Patrons = FileManager.loadAllUsers(PATRON_FILE);
        User patron = new Patron(username, password, name,email, phone);
        Patrons.add(patron);
        FileManager.saveAllUsers(Patrons, PATRON_FILE);
    }
    // delete a patron account
    public void deletePatron(String username, String password){
        FileManager.deleteUser(username, password, PATRON_FILE);
    }
    // update a patron account
public void updatePatron(String username, String newUserName, String newPassword, String newName, String newEmail, String newPhone) {
    ArrayList<User> patrons = FileManager.loadAllUsers(PATRON_FILE);
    for (User patron : patrons) {
        if (patron.getUserName().equals(username)) {
            patron.UserName = newUserName;
            patron.Password = newPassword;
            patron.Email = newEmail;
            patron.Name = newName;
            patron.Phone = newPhone;
            break;
        }
    }
    FileManager.saveAllUsers(patrons, PATRON_FILE);
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
    //BOOK MANAGEMENT
    // add a book
    public void addBook(Book book){
        Book.addbook(book);
    }
    
    public void UpdateBookInfo(String id,String Newid, String newTitle, String newAuthor,int newpublicationyear,String newcategroy)
    { Book.updateBookInfo(id,Newid,newTitle,newAuthor,newpublicationyear,newcategroy); }
    
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
    public void categorizeByPublicationYear(int publicationYear) {
        Book.categorizeByPublicationYear(publicationYear);
    }
    public void categorizeByStatus(boolean status) {
        Book.categorizeByStatus(status);
    }
    
    // track the status of a book
    public boolean trackStatus(String id){
        Book book = FileManager.LoadBook(id, "E:\\programming\\Java\\Library_Management_System\\Data\\Book.txt");
        return book.getstatus();
    }
    
}