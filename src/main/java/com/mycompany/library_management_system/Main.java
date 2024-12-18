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
public class Main {
    public static void main(String[] args) {
//        new LoginForm().setVisible(true);
        ArrayList<User> Admins = FileManager.loadAllUsers("E:\\programming\\Java\\Library_Management_System\\Data\\Admin.txt");
        User admin = new Admin("youssef", "youssef123","Youssef","youssef@gmail.com", "01120832985");
        Admins.add(admin);
        FileManager.saveAllUsers(Admins, "E:\\programming\\Java\\Library_Management_System\\Data\\Admin.txt");
    }
}
