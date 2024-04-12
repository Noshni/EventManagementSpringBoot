package com.example.demo3.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Login {
    @Id
    private int userId;
    private String userName;
    private String password;

    public int getuserId() {
        return userId;
    }

    public void setuserId(int userId) {
        this.userId = userId;
    }

    public String getuserName() {
        return userName;
    }

    public void setuserName(String userName) {
        this.userName = userName;
    }

    public String getpassword() {
        return password;
    }

    public void setpassword(String password) {
        this.password = password;
    }

    public Login(int userId, String userName, String password) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;

    }

    public Login() {
    }

    @OneToOne(mappedBy = "login", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Event eve;

    public Event getEve() {
        return eve;
    }

    public void setEve(Event eve) {
        this.eve = eve;
    }

}