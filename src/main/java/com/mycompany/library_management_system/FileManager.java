
package com.mycompany.library_management_system;
import java.io.*;
import java.util.ArrayList;

public class FileManager {
    
    /*--------->> User Operations <<-----*/
    
//    public static void saveAllUsers(ArrayList<User> users, String filePath) {
//    try (FileOutputStream fos = new FileOutputStream(filePath, true);
//         ObjectOutputStream oos = (fos.getChannel().size() == 0 ? new ObjectOutputStream(fos) :
//                 new AppendableObjectOutputStream(fos))) {
//
//        for (User user : users) {
//            oos.writeObject(user);
//        }
//
//    } 
//    catch (IOException e) {
//            System.err.println("Error saving users: " + e.getMessage());
//        }
//    }
    
    public static void saveAllUsers(ArrayList<User> users, String filePath) {
    try (FileOutputStream fos = new FileOutputStream(filePath, false); // Overwrite mode
         ObjectOutputStream oos = new ObjectOutputStream(fos)) {
        for (User user : users) {
            oos.writeObject(user);
        }           
    } catch (IOException e) {
        System.err.println("Error saving users: " + e.getMessage());
    }
}

    
    public static User LoadUser(String Username , String Password,String filepath) 
            // Load User By username and password
    {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filepath))) {
              while(true)
              {
                  try 
                  {
                      User user = (User) ois.readObject(); //هنا بتعمل read للobject
                      if(user.UserName.equals(Username) && user.Password.equals(Password))
                      {
                          return user;
                      }
                  }
                  catch(EOFException e)
                  {
                      break;
                  }
              }
        } 
        catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading user: " + e.getMessage());
        }
        return null;
    }
    
    public static User LoadUser(String Username ,String filepath) 
            // Load User By username only
    {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filepath))) {
              while(true)
              {
                  try 
                  {
                      User user = (User) ois.readObject(); // Read object From File
                      if(user.UserName.equals(Username))
                      {
                          return user;
                      }
                  }
                  catch(EOFException e)
                  {
                      break;
                  }
              }
        } 
        catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading user: " + e.getMessage());
        }
        return null;
    }
    

public static void deleteUser(String username, String password, String filepath) {
    ArrayList<User> users = new ArrayList<>();

    // Load all users from the file
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filepath))) {
        while (true) {
            try {
                User user = (User) ois.readObject();
                // Add to the list only if it's not the user to be deleted
                if (!user.UserName.equals(username) || !user.Password.equals(password)) {
                    users.add(user);
                }
            } catch (EOFException e) {
                break;
            }
        }
    } catch (IOException | ClassNotFoundException e) {
        System.err.println("Error reading users: " + e.getMessage());
    }

    // Write the updated list back to the file (overwrite)
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filepath, false))) {
        for (User user : users) {
            oos.writeObject(user);
        }
    } catch (IOException e) {
        System.err.println("Error writing users: " + e.getMessage());
    }
}

    
    
    
  // Helper Method: Load all users from a file
    public static ArrayList<User> loadAllUsers(String filePath) {
        ArrayList<User> users = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            while (true) {
                try {
                    users.add((User) ois.readObject());
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading users: " + e.getMessage());
        }
        return users;
    }
    
    /*----------->> Book Operations <<--------------*/

public static void saveAllBooks(ArrayList<Book> Books, String filePath) {
    // Overwrite the file completely
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath, false))) {
        for (Book book : Books) {
            oos.writeObject(book);
        }
    } catch (IOException e) {
        System.err.println("Error saving books: " + e.getMessage());
    }
}


    
    public static Book LoadBook( String BookId,String filepath) // Load Book By Book Id
    {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filepath))) {
              while(true)
              {
                  try 
                  {
                      Book book = (Book) ois.readObject();
                      if(book.getId().equals(BookId)) 
                      {
                          return book;
                      }
                  }
                  catch(EOFException e)
                  {
                      break;
                  }
              }
        } 
        catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading user: " + e.getMessage());
        }
        return null;
    }
    
    
public static void DeleteBook(String id, String filepath) {
    ArrayList<Book> books = new ArrayList<>();

    // Read all objects from the file
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filepath))) {
        while (true) {
            try {
                Book book = (Book) ois.readObject();
                // Add the book to the list if it's not the one to delete
                if (!book.getId().equals(id)) {
                    books.add(book);
                }
            } catch (EOFException e) {
                break;
            }
        }
    } catch (FileNotFoundException e) {
        System.err.println("File not found: " + e.getMessage());
    } catch (IOException | ClassNotFoundException e) {
        System.err.println("Error reading books: " + e.getMessage());
    }

    // Write the updated list back to the file
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filepath))) {
        for (Book book : books) {
            oos.writeObject(book);
        }
    } catch (IOException e) {
        System.err.println("Error writing books: " + e.getMessage());
    }
}
    
        // Helper Method: Load all books from the file
    public static ArrayList<Book> loadAllBooks(String filePath) {
        ArrayList<Book> books = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            while (true) {
                try {
                    books.add((Book) ois.readObject());
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading books: " + e.getMessage());
        }
        return books;
    }
}

    


// كلاس فرعي لتجنب كتابة الـ header عند الإضافة
  class AppendableObjectOutputStream extends ObjectOutputStream {
        AppendableObjectOutputStream(OutputStream out) throws IOException {
            super(out);
        }

        @Override
        protected void writeStreamHeader() throws IOException {
            reset(); // تجاوز كتابة الـ header عند الإضافة
        }
}
