
package com.mycompany.library_management_system;
import java.util.Date;
import java.util.*;

public class CheckedoutHistory {
    private Book book;
    private Date CheckedoutDate;
    private Patron patron;
    private int CheckoutPeriod; 
    private static ArrayList<CheckedoutHistory>CheckedoutHistoryList;
    
    public CheckedoutHistory(Book book,Patron patron)
    {
        CheckedoutHistory.CheckedoutHistoryList = new ArrayList<>();
        this.book = book;
        this.CheckedoutDate = new Date();
        this.patron = patron;
        this.CheckoutPeriod = 30 ;
    }
    
    public CheckedoutHistory() {}
    
    public static ArrayList<CheckedoutHistory> getCheckedoutHistory()
    { return CheckedoutHistory.CheckedoutHistoryList; }
    
    public void addCheckedoutHistory()
    { CheckedoutHistoryList.add(this); }
    
    public Book getBook()
    { return this.book; }
    
    public Date getDate()
    { return this.CheckedoutDate ;}
    
    public Patron GetPatron()
    { return this.patron;}
    
    public int getCheckoutPeriod()
    { return this.CheckoutPeriod;}
    
    public void RenewCheckoutPeriod() {this.CheckoutPeriod+=30;}
}
