
package com.mycompany.library_management_system;
import java.io.*;
import java.util.ArrayList;

public class FileManager {
    public static void saveObject(Object ob, String filePath) // دالة لحفظ ال objects في ال files
    {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            // ObjectOutputStream كلاس بيستخدم لكتابة بيانات ال  objects في الملفات 
            oos.writeObject(ob);// دالة بتستدعيها من أوبجكت لكتابة البيانات
        }
        catch (IOException e) { 
            System.err.println("Error saving user: " + e.getMessage());
        }
    }
    
    public static User LoadUser(String Username , String Password,String filepath) 
            // دالة عشان تجيب ال objects من ال files
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
            // دالة عشان تجيب ال objects من ال files
    {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filepath))) {
              while(true)
              {
                  try 
                  {
                      User user = (User) ois.readObject(); //هنا بتعمل read للobject
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
    
    
    
    
    public static Object LoadBook( String BookId,String filepath) // دالة للحصول علي ال objects الكتب
    {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filepath))) {
              while(true)
              {
                  try 
                  {
                      Object book = (Object) ois.readObject();
//                      if() هتشيك علي حجات الكتاب
//                      {
//                          return user;
//                      }
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
    
//    public static Object LoadBook( String BookTitle,String filepath) 
//    {
//        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filepath))) {
//              while(true)
//              {
//                  try 
//                  {
//                      Object book = (Object) ois.readObject();
////                      if() هتشيك علي حجات الكتاب
////                      {
////                          return user;
////                      }
//                  }
//                  catch(EOFException e)
//                  {
//                      break;
//                  }
//              }
//        } 
//        catch (IOException | ClassNotFoundException e) {
//            System.err.println("Error loading user: " + e.getMessage());
//        }
//        return null;
//    }
//    
    
    
    
    
    
    
    
    public static void deleteUser(String username, String password, String filepath) {
        ArrayList<User> users = new ArrayList<>();

        // قراءة جميع الكائنات من الملف
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filepath))) {
            while (true) {
                try {
                    User user = (User) ois.readObject();
                    // إذا لم يكن هو المستخدم الذي نريد حذفه، نضيفه إلى القائمة
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

        // إعادة كتابة جميع الكائنات المتبقية إلى الملف
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filepath))) {
            for (User user : users) {
                oos.writeObject(user);
            }
        } catch (IOException e) {
            System.err.println("Error writing users: " + e.getMessage());
        }
    }
}
