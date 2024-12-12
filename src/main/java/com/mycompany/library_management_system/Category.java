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
    private String description;

    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }

    // Getters and setters for name and description
    public void setcatagery(String name) { 
        this.name = name;
    }
    public String getcatagery(){
        return name;
    }
     public void setdescription(String description) { 
        this.description = description;
    }
    public String getdescription(){
        return description;
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}