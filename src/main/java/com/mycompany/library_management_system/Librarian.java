package com.mycompany.library_management_system;
import java.util.ArrayList;
import java.util.Date;

public class Librarian extends User {
    private final String LIBRARIAN_FILE_PATH = "E:\\programming\\Java\\Library_Management_System\\Data\\Librarian.txt";
    // Constructor
    public Librarian(String username, String password,String Email,String phone,String name) {
        super(username, password,name,Email,phone);// Calls the constructor of the parent class 'User'
    }
    public Librarian() {}

    // Setters for attributes
    public void setUsername(String username) {  this.UserName = username; }
    public void setPassword(String Password) {  this.Password = Password; }
    public void setPhone(String phone) {  this.Phone = phone; }
    public void setEmail(String email) { this.Email = email; }
    
    public void UpdateInfo(String UserName,String Password,String phone ,String Email)
    {
        ArrayList<User> Librarians = FileManager.loadAllUsers(LIBRARIAN_FILE_PATH);
        this.setUsername(UserName);
        this.setPassword(Password);
        this.setEmail(Email);
        this.setPhone(phone);
        FileManager.saveAllUsers(Librarians, LIBRARIAN_FILE_PATH);
    }

    // Method to check out a book for a patron
    public boolean checkoutBook(String UserNamePatron, String BookTitle) { /* Call method With Book Title*/
        Book BookObject =  FileManager.LoadBook(BookTitle,"E:\\programming\\Java\\Library_Management_System\\Data\\Book.txt");
        if(BookObject.isAvailable())
        {
            Patron patron = (Patron)FileManager.LoadUser(UserNamePatron, "E:\\programming\\Java\\Library_Management_System\\Data\\patron.txt");
            patron.CheckoutBooks(BookObject);
            return true;
        }
        else return false;
    }
    
    public void reservation(boolean option,String UserNamePatron, String BookTitle)
    {
        if(option)
        {
            Book BookObject =  FileManager.LoadBook(BookTitle,"E:\\programming\\Java\\Library_Management_System\\Data\\Book.txt");
            Patron patron = (Patron)FileManager.LoadUser(UserNamePatron, "E:\\programming\\Java\\Library_Management_System\\Data\\patron.txt");
            patron.requestReservations(BookObject);
        }
    }

    // Method to return a book from a patron
    public void returnBook(String PatronUserName , String BookId) {
        Patron patron = (Patron)FileManager.LoadUser(PatronUserName , "E:\\programming\\Java\\Library_Management_System\\Data\\patron.txt");
        Book book = FileManager.LoadBook(BookId, "E:\\programming\\Java\\Library_Management_System\\Data\\Book.txt");
        patron.ReturnBook(book);
        for(var ReservationBook : ReservationBooks.getReservationBooksList())
        {
            if(ReservationBook.getBook().equals(book))
            {
                String Masseage = "The book is now available";
                Notification.addNotification(new Notification(Masseage,ReservationBook.getPatron().getName()), ReservationBook.getPatron());
            }
        }
    }

    
    public void notifyPatron()
    {
        CheckedoutHistory checkedoutHistory =  new CheckedoutHistory();
        Date currentDate = new Date();
        long differenceInMillis ,daysBetween;
        for(var checkedoutHistorys : checkedoutHistory.getCheckedoutHistory() )
        {
            differenceInMillis  = currentDate.getTime() - checkedoutHistorys.getDate().getTime();
            daysBetween =  differenceInMillis / (1000 * 60 * 60 * 24);
            if(daysBetween > checkedoutHistorys.getCheckoutPeriod() ){
                Notification notification = new Notification("You have outgrown the metaphor",checkedoutHistorys.GetPatron().getName());
                Notification.addNotification(notification, checkedoutHistorys.GetPatron());
            }
            else if(daysBetween >= (checkedoutHistorys.getCheckoutPeriod()-5) && daysBetween < checkedoutHistorys.getCheckoutPeriod()){
                Notification notification = new Notification("The borrowing date has come soon",checkedoutHistorys.GetPatron().getName());
                Notification.addNotification(notification, checkedoutHistorys.GetPatron());
            }
        }
    }


//    @Override
//    public String toString() {
//        return "Librarian[ID=" + librarianId +
//        ", Name=" + name + ", Email=" + email + "]";
//   }
}

