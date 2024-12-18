/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.library_management_system;

import java.util.ArrayList;

/**
 *
 * @author youss
 */
public class ReservationBooks {
    private Book book;
    private Patron patron;
    private static ArrayList<ReservationBooks> ReservationBooksList;
    
    public ReservationBooks(Book book,Patron patron)
    {
        this.book = book;
        this.patron = patron;
        ReservationBooks.ReservationBooksList = new ArrayList<>();
    }
    
    public Book getBook() { return this.book; }
    
    public Patron getPatron() { return this.patron ;}
    
    public static ArrayList<ReservationBooks> getReservationBooksList() { return ReservationBooks.ReservationBooksList;}
    
    public void AddReservationBook() {ReservationBooks.ReservationBooksList.add(this);}
}
