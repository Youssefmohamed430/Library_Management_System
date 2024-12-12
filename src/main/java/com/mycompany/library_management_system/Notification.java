package com.mycompany.library_management_system;
import java.util.ArrayList;


public class Notification {
    private String message;
    private String recipient;
    private boolean isRead;
    private static ArrayList<Notification> notifications = new ArrayList<>();
    
    public Notification(){
        this("","");
    }
    public Notification(String message , String recipient){
        this.message = message;
        this.recipient = recipient;
        this.isRead = false;
        notifications.add(this);
    }
    
     // Getters and Setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }
    
    public boolean isRead() {
        return isRead;
    }

    public void markAsRead() {
        this.isRead = true;
    }
    public static void addNotification(Notification notification) {
        notifications.add(notification);
    }
    
    public static ArrayList<Notification> getAllNotifications() {
        return new ArrayList<>(notifications); // Return a copy of the list
    }
    
     public static ArrayList<Notification> getUnreadNotifications() {
        ArrayList<Notification> unread = new ArrayList<>();
        for (Notification notification : notifications) {
            if (!notification.isRead) {
                unread.add(notification);
            }
        }
        return unread;
    }
    
    public static void clearNotifications() {
        notifications.clear();
    }
    @Override
    public String toString() {
        return "Notification{" +
                "message='" + message + '\'' +
                ", recipient='" + recipient + '\'' +
                ", isRead=" + isRead +
                '}';
    }
}