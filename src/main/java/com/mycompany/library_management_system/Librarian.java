package com.mycompany.library_management_system;

public class Librarian extends User {
    // Constructor
    public Librarian(String username, String password,String Email,String phone) {
        super(username, password,Email,phone);// Calls the constructor of the parent class 'User'
    }
    public Librarian() {}

    // Setters for attributes
    public void setUsername(String username) {  this.UserName = username; }
    public void setPassword(String Password) {  this.Password = Password; }
    public void setPhone(String phone) {  this.Phone = phone; }
    public void setEmail(String email) { this.Email = email; }
    
    public void UpdateInfo(String UserName,String Password,String phone ,String Email)
    {
        this.setUsername(UserName);
        this.setPassword(Password);
        this.setEmail(Email);
        this.setPhone(phone);
        FileManager.saveObject(this, "E:\\programming\\Java\\Library_Management_System\\Data\\Librarian.txt");
    }

    // Method to check out a book for a patron
    public boolean checkoutBook(String UserNamePatron, String BookTitle) { /* Call method With Book Title*/
        BOOK BookObject =  FileManager.LoadBook(BookTitle,"E:\\programming\\Java\\Library_Management_System\\Data\\Book.txt");
        if(BookObject.isAvalible())
        {
            User Patron = FileManager.LoadUser(UserNamePatron, "E:\\programming\\Java\\Library_Management_System\\Data\\patron.txt");
            //BookObject.setisAvailble(false)
            // Patron.checkedoutbooks.add(BookObject)
            return true;
        }
        else return false;
    }
    
    public void reservation(boolean option,String UserNamePatron, String BookTitle)
    {
        if(option)
        {
            BOOK BookObject =  FileManager.LoadBook(BookTitle,"E:\\programming\\Java\\Library_Management_System\\Data\\Book.txt");
            User Patron = FileManager.LoadUser(UserNamePatron, "E:\\programming\\Java\\Library_Management_System\\Data\\patron.txt");
            // Patron.reservationbooks.add(BookObject);
        }
    }

    // Method to return a book from a patron
//    public void returnBook(Patron patron, Book book) {
//        patron.returnBook(book);
//        book.setAvailable(true);
//        System.out.println("Book returned successfully: " + book);
//    }



//    @Override
//    public String toString() {
//        return "Librarian[ID=" + librarianId +
//        ", Name=" + name + ", Email=" + email + "]";
//   }
}

