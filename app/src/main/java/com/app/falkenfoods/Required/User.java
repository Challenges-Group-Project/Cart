package com.app.falkenfoods.Required;

public class User {
    private String Name, Email, PhoneNumber, Password;

    public User(){
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public User(String name, String email, String phoneNumber, String password) {
        Name = name;
        Email = email;
        PhoneNumber = phoneNumber;
        Password = password;
    }
}
