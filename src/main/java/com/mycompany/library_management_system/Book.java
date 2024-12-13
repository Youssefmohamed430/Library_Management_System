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
    private boolean status;
    private Category category;
    private String date;
//    public static final String AVAILABLE= "Available";
//    public static final String CHECKEDOUT = "Checked Out";
//    public static final String RESERVED = "Reversed";
//book manger
    private static List<Book> books;
   

    
    //constrion class
    public Book(String book_id,String  book_name,String author,int publicationyear,String categroy,String description ){
        
//book manger
      
       //////////////////////////////////
        this.book_id=book_id;
        this.book_name=book_name;
        this.author=author;
        this.publicationyear=publicationyear;
        this.status=true;
        this.date=null;
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
    public boolean getstatus(){
        return status;
    }
    public void setstatus(boolean status){
        this.status=status;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
    public String getDueDate() {
        return date;
    }

    public void setDueDate(String dueDate) {
        this.date = dueDate;
    }
    public boolean isAvailable(){
        return status;
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
       
         String FilePath="E:\\programming\\Java\\Library_Management_System\\Data\\booh.txt";
         FileManager.saveObject(book, FilePath);
}
    public static void updateStatus(Book book,String id,boolean newstatus){
        String FilePath="E:\\programming\\Java\\Library_Management_System\\Data\\booh.txt";
//       book=FileManger.looadbook(); search id 
        book.setstatus(newstatus);
        FileManager.saveObject(book, FilePath);

      }
   public static void updateTitle(Book book,String id,String newTitle){
       String FilePath="E:\\programming\\Java\\Library_Management_System\\Data\\booh.txt";
//       book=FileManger.looadbook();search id
        book.setTitle(newTitle);
        FileManager.saveObject(book, FilePath);
      
   } 
   public static void updateAuthor(Book book,String id,String newAuthor){
       
       String FilePath="E:\\programming\\Java\\Library_Management_System\\Data\\booh.txt";
//       book=FileManger.looadbook();search id
       book.setAuthor(newAuthor);
       FileManager.saveObject(book, FilePath);
     
   } 
   public static void updatePublicationYear(Book book,String id,int newpublicationyear){
        String FilePath="E:\\programming\\Java\\Library_Management_System\\Data\\booh.txt";
//       book=FileManger.looadbook();search id
       book.setpublicationyear(newpublicationyear);
       FileManager.saveObject(book, FilePath);
     
   } 
    public static void updateCategory(Book book,String id,String newcategory){
        String FilePath="E:\\programming\\Java\\Library_Management_System\\Data\\booh.txt";
//       book=FileManger.looadbook();search id
       book.category.setcatagery(newcategory);
       FileManager.saveObject(book, FilePath);
     }
    public static void updateDescription(Book book,String id, String newdescription){
  
 String FilePath="E:\\programming\\Java\\Library_Management_System\\Data\\booh.txt";
//       book=FileManger.looadbook();search id
       book.category.setdescription(newdescription);
       FileManager.saveObject(book, FilePath);
    }
    
   public static void categorizeByGenre(String category){
       books=new ArrayList<Book>();
        String FilePath="E:\\programming\\Java\\Library_Management_System\\Data\\booh.txt";
        books= FileManager.loadAllBooks(FilePath);
     for (Book book : books) {
            if (book.category.getcatagery().equalsIgnoreCase(category)) {
                System.out.println(book);
            }
        }
   }
   public static void categorizeByAuthor(String author){
        books=new ArrayList<Book>();
       String FilePath="E:\\programming\\Java\\Library_Management_System\\Data\\booh.txt";
        books= FileManager.loadAllBooks(FilePath);
         for (Book book : books) {
               if (book.getAuthor().equalsIgnoreCase(author)) 
                System.out.println(book);
            }
   }
   public static void categorizeByPublicationYear(int publicationYear){
        books=new ArrayList<Book>();
        String FilePath="E:\\programming\\Java\\Library_Management_System\\Data\\booh.txt";
        books= FileManager.loadAllBooks(FilePath);
          books=new ArrayList<Book>();
      for (Book book : books) {
            if (book.getpublicationyear() != publicationYear ) {
                System.out.println("not found");
            }else {
                System.out.println(book);
            }
   }
   }
   public static void categorizeByStatus(boolean status){
       String FilePath="E:\\programming\\Java\\Library_Management_System\\Data\\booh.txt";
        books= FileManager.loadAllBooks(FilePath);
         books=new ArrayList<Book>();
         for (Book book : books) {
            if (book.isAvailable() == status) {
                System.out.println(book);
            }
        }
   }
    ///update book (manger_)
    public void updateBook(Book book, String id, String newTitle, String newAuthor,int newpublicationyear,String newcategroy,String newdescription) {
         String FilePath="E:\\programming\\Java\\Library_Management_System\\Data\\booh.txt";
//       book=FileManger.looadbook();search id
       book.setAuthor(newAuthor);
       book.setTitle(newTitle);
       book.setpublicationyear(publicationyear);
       book.category.setcatagery(newcategroy);
       book.category.setdescription(newdescription);
       FileManager.saveObject(book, FilePath);
     
        
        }
//    
    //delete book (manger_)
    public static void deleteBook(String id) {
       //delete book (id);
    }
    
    //list book 
     public void listBooks() {
         String FilePath="E:\\programming\\Java\\Library_Management_System\\Data\\booh.txt";
        books= FileManager.loadAllBooks(FilePath);
         for (Book book : books) {
                System.out.println(book);
            }
     }
       

}
