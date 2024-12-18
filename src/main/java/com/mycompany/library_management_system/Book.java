package com.mycompany.library_management_system;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;


public class Book implements Serializable {
    private static final long serialVersionUID = 1L; 
    private String book_id;
    private String  book_name;
    private String author;
    private int publicationyear;
    private boolean status;
    private Category category;
    //book manager
    private static List<Book> books;
    private static final String BOOK_FILE_PATH ="E:\\programming\\Java\\Library_Management_System\\Data\\Books.txt";

    
    //constrion class
    public Book(String book_id,String  book_name,String author,int publicationyear,String categoryName){      
       //////////////////////////////////
        this.book_id=book_id;
        this.book_name=book_name;
        this.author=author;
        this.publicationyear=publicationyear;
        this.status=true;
        this.category = new Category(categoryName);
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

    /**
     *
     * @param category
     */
    public void setCategory(String category) {
        this.category.setcatagery(category);
    }
    
    public String getCategory()
    {
        return this.category.getcatagery();
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
    
    
   //add book (manager_)
public static void addbook(Book book) {
    // Load all existing books
    ArrayList<Book> Books = FileManager.loadAllBooks(BOOK_FILE_PATH);
    // Add the new book
    Books.add(book);

    // Save all books back to the file
    FileManager.saveAllBooks(Books, BOOK_FILE_PATH);
}

    
    public static void categorizeByGenre(String Genre){
        books = new ArrayList<>();
        books = FileManager.loadAllBooks(BOOK_FILE_PATH);
     for (Book book : books) {
            if (book.category.getcatagery().equalsIgnoreCase(Genre)) {
                System.out.println(book);
            }
        }
   }
   public static void categorizeByAuthor(String author){
        books = new ArrayList<>();
        books= FileManager.loadAllBooks(BOOK_FILE_PATH);
         for (Book book : books) {
               if (book.getAuthor().equalsIgnoreCase(author)) 
                System.out.println(book);
            }
   }
   public static void categorizeByPublicationYear(int publicationYear){
        books=new ArrayList<>();
        books= FileManager.loadAllBooks(BOOK_FILE_PATH);
          books=new ArrayList<>();
      for (Book book : books) {
            if (book.getpublicationyear() != publicationYear ) {
                System.out.println("not found");
            }else {
                System.out.println(book);
            }
   }
   }
   public static void categorizeByStatus(boolean status){
        books= FileManager.loadAllBooks(BOOK_FILE_PATH);
         books=new ArrayList<>();
         for (Book book : books) {
            if (book.isAvailable() == status) {
                System.out.println(book);
            }
        }
   }
    ///update book (manager_)
public static void updateBookInfo(String id, String newId, String newTitle, String newAuthor, int newPublicationYear, String newCategory) {
    ArrayList<Book> books = FileManager.loadAllBooks(BOOK_FILE_PATH);

    for (Book book : books) {
        if (book.getId().equals(id)) {
            book.book_id = newId;
            book.book_name = newTitle;
            book.author = newAuthor;
            book.publicationyear = newPublicationYear;
            book.setCategory(newCategory);
        }
    }

    // Save the updated list back to the file
    FileManager.saveAllBooks(books, BOOK_FILE_PATH);
}

    
    //delete book (manager_)
    public static void deleteBook(String id) {
       FileManager.DeleteBook(id, BOOK_FILE_PATH);
    }
    
    //list book 
     public void listBooks() {
        books= FileManager.loadAllBooks(BOOK_FILE_PATH);
         for (Book book : books) {
                System.out.println(book);
            }
     }
       

}
