package com.mycompany.library_management_system;
import java.util.*;

public class Patron extends User {
    private ArrayList<CheckedoutHistory> checkOutBooks;
    private ArrayList<Book> Reservations;
    private ArrayList<Notification> notifications;

    public Patron(String username, String Password, String name, String Email, String phone) {
        super(username, Password, name, Email, phone);
        this.checkOutBooks = new ArrayList<>();
        this.Reservations = new ArrayList<>();
        this.notifications = new ArrayList<>();
    }
    
    public Patron(){}
    
    
    public void updatePatron(String newUserame , String newPassword , String newEmail , String newPhone){
        this.Email = newEmail;
        this.Phone = newPhone;
        this.Password = newPassword;
        this.UserName = newUserame;
    }
    
    public ArrayList<CheckedoutHistory> GetCheckedoutHistory() { return this.checkOutBooks; }  
    
    public ArrayList<Notification> GetNotifications() { return this.notifications ; }
    
    public ArrayList<Book> GetReservations() { return this.Reservations ; }
    
    public void SetNotfication(Notification notification) {this.notifications.add(notification) ;}
    
    public void CheckoutBooks(Book book){
        CheckedoutHistory checkedoutHistory = new CheckedoutHistory(book,this);
        checkOutBooks.add(checkedoutHistory);
        checkedoutHistory.addCheckedoutHistory();
        book.setstatus(false);
    }
    
    public void ReturnBook(Book book)
    {
        for(CheckedoutHistory CheckOutBooks : checkOutBooks)
        {
            if(CheckOutBooks.getBook().equals(book))
            {
                this.checkOutBooks.remove(CheckOutBooks);
                book.setstatus(true);
            }
        }
    }
    public void renewBook(Book book){
        for(var CheckedoutHistorybook : CheckedoutHistory.getCheckedoutHistory())
        {
            if(CheckedoutHistorybook.getBook().equals(book))
            {
                CheckedoutHistorybook.RenewCheckoutPeriod();
            }
        }
    }
    public void requestReservations(Book book){
        boolean Status = book.isAvailable();
        if(!Status){
            Reservations.add(book);
            ReservationBooks ReservationBook = new ReservationBooks(book,this);
            ReservationBook.AddReservationBook();
        }
    }
//    public void savePatronData() {
//        ArrayList<Object> patronData = new ArrayList<>();
//        patronData.add(this); // Save the current Patron object
//        patronData.add(this.checkOutBooks);
//        patronData.add(this.checkOutHistory);
//        FileManager.saveObject(patronData, "E:\\programming\\Java\\Library_Management_System\\Data\\patron.txt");
//        System.out.println("Patron data saved successfully.");
//    }
//    
    
    // Method to load Patron data
//    public static Patron loadPatronData() {
//        Object data = FileManager.LoadBook(, "E:\\programming\\Java\\Library_Management_System\\Data\\Book.txt");
//        if (data instanceof ArrayList) {
//            ArrayList<?> patronData = (ArrayList<?>) data;
//            if (patronData.size() >= 3) {
//                Patron loadedPatron = (Patron) patronData.get(0);
//                loadedPatron.checkOutBooks = (ArrayList<com.mycompany.library_management_system.Book>) patronData.get(1);
//                loadedPatron.checkOutHistory = (ArrayList<com.mycompany.library_management_system.Book>) patronData.get(2);
//                System.out.println("Patron data loaded successfully.");
//                return loadedPatron;
//            }
//        }
//        System.out.println("Failed to load Patron data.");
//        return null;
//    }

    @Override
    public String toString() {
        return "Patron{" +
                "checkOutBooks=" + checkOutBooks +
                ", UserName='" + UserName + '\'' +
                ", Password='" + Password + '\'' +
                ", Email='" + Email + '\'' +
                ", Phone='" + Phone + '\'' +
                ", Name='" + Name + '\'' +
                '}';
    }
}
