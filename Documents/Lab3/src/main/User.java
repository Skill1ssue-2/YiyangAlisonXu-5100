/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.awt.Image;
import java.util.Date;

/**
 *
 * @author A
 */
public class User {
    private String firstname;
    private String lastname;
    private int age;
    private String email;
    private String message;
    private String patientType; // This could be an enum or string, depending on your dropdown options
    private String gender; // This could also be an enum for Male, Female, Other
    private String registrationDate; // For the date chooser picker
    // Include an image attribute if you need to store the photo directly in the model
//    private Image photo;
    private String photo;

    public String getDate() {
        return registrationDate;
    }

    public void setDate(String date) {
        this.registrationDate = date;
    }
    
    

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPatientType() {
        return patientType;
    }

    public void setPatientType(String patientType) {
        this.patientType = patientType;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
    
}
