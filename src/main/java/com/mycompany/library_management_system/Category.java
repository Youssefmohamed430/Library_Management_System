/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.library_management_system;

/**
 *
 * @author youss
 */
class Category {
    
     private String name;

    public Category(String name) {
        this.name = name;
    }

    // Getters and setters for name and description
    public void setcatagery(String name) { 
        this.name = name;
    }
    public String getcatagery(){
        return name;
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                '}';
    }
}