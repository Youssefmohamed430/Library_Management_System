/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.library_management_system;

/**
 *
 * @author youss
 */
import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class Book {
    
    private String book_id;
    private String  book_name;
    private String author;
    private int publicationyear;
    private String status;
    private Category category;
    public static final String AVAILABLE= "Available";
    public static final String CHECKEDOUT = "Checked Out";
    public static final String RESERVED = "Reversed";
//book manger
    private static List<Book> books;
   
//    private final String fileName;
    
    //constrion class
    public Book(String book_id,String  book_name,String author,int publicationyear,String categroy,String description ){
        
//book manger
       this.books=new ArrayList<Book>();
       //////////////////////////////////
        this.book_id=book_id;
        this.book_name=book_name;
        this.author=author;
        this.publicationyear=publicationyear;
        this.status=AVAILABLE;
        category.setcatagery(categroy);
        category.setdescription(description);
       
    }
    //Getter and Setter 
    public String getId() {
        return book_id; 
    }
    public void setId(String id) {
        this.book_id = id; 
    }
    public String getTitle() {
        return book_name;
    }
    public void setTitle(String title) {
        this.book_name = title; 
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) { 
        this.author = author;
    }
    public int getpublicationyear(){
        return publicationyear;
    }
    public void setpublicationyear(int publicationyear){
        this.publicationyear=publicationyear;
    }
    public String getstatus(){
        return status;
    }
    public void setstatus(String status){
        this.status=status;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
    @Override
    public String toString(){
        
        return "Book{" +
              "id: " + book_id +"\n" +
                 "title: " + book_name + " " +"\n" +
               " author: " + author + " " +"\n" +
                " status: " + status +"\n" + 
                 "categroy: "+category.toString()+  "}"  ;
    }
    
    
   //add book (manger_)
    public static void addbook(Book book) {
        books.add(book);
        //saveObject(book, file path);
}
    public static void updateStatus(Book book, String newstatus){
        
//             for ( Book book : books) {
//            if (book.getId().equals(id)) {
//                 book.setstatus(newstatus);
//                 //      saveObject(book,file path);
//            }
//            System.out .println("not found id book");
//         }
      }
   public static void updateTitle(Book book,String newTitle){
//         for ( Book book : books) {
//            if (book.getId().equals(id)) {
//                 book.setTitle(newTitle);
//                 //      saveObject(book,file path);
//            }
//            System.out .println("not found id book");
//         }
   } 
   public static void updateAuthor(Book book,String newAuthor){
//         for ( Book book : books) {
//            if (book.getId().equals(id)) {
//                 book.setAuthor(newAuthor);
//                 //      saveObject(book,file path);
//            }
//            System.out .println("not found id book");
//         }
   } 
   public static void updatePublicationYear(Book book,int newpublicationyear){
//         for ( Book book : books) {
//            if (book.getId().equals(id)) {
//                 book.setpublicationyear(newpublicationyear);
//                 //      saveObject(book,file path);
//            }
//            System.out .println("not found id book");
//         }
   } 
    public static void updateCategory(Book book,String newcategory){
//         for ( Book book : books) {
//            if (book.getId().equals(id)) {
//                book.category.setcatagery(newcategory);
//                 //      saveObject(book,file path);
//            }
//            System.out .println("not found id book");
//         }
   } 
    public static void updateDescription(Book book, String newdescription){
//          for ( Book book : books) {
//            if (book.getId().equals(id)) {
//                book.category.setdescription(newdescription);
//                 //      saveObject(book,file path);
//            }
//            System.out .println("not found id book");
//         }
    }
    
   public static void categorizeByGenre(String category){
       
   }    
   public static void categorizeByAuthor(String author){
       
   }
   public static void categorizeByPublicationYear(String publicationYear){
       
   }
   public static void categorizeByStatus(String status){
       
   }
//    ///update book (manger_)
//    public void updateBook(String id, String newTitle, String newAuthor,int newpublicationyear,String newcategroy,String newdescription) {
//        for ( Book book : books) {
//            if (book.getId().equals(id)) {
//                book.setTitle(newTitle);
//                book.setAuthor(newAuthor);
//                book.setpublicationyear(newpublicationyear);
//                book.category.setcatagery(newcategroy);
//                book.category.setdescription(newdescription);
//               //      saveObject(book,file path);
//                return;
//            }
//            System.out.println("not found id book");
//        }
//        }
//    
    //delete book (manger_)
    public static void deleteBook(String id) {
        books.removeIf(book -> book.getId().equals(id));
//          saveObject(book,file path);
    }
    
    //list book 
     public void listBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

}
