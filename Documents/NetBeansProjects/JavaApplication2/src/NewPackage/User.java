/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NewPackage;

/**
 *
 * @author A
 */
import javax.swing.*;

public class User {
     // Attributes
    private String firstName;
    private String lastName;
    public int age;
    public String email;
    public String phoneNumber;
    public ImageIcon photo;
    

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return this.firstName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return this.lastName;
    }
    
    
    public int getAge(){
        return age;
    }
    
    public void setAge(int age){
        this.age = age;
    }
    
    public String getEmail(){
        return email;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public String getPhoneNumber(){
        return phoneNumber;
    }
    
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    
    public void setPhoto(ImageIcon photo) {
        this.photo = photo;
    }

    public ImageIcon getPhoto() {
        return this.photo;
    }
    
    // Constructor
//    public User(String name, int age) {
//        this.name = name;
//        this.age = age;
//    }
}
