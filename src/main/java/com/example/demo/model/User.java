package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserID")
    private Long userID;

    @Column(name = "UserName", nullable = false, unique = true)
    private String username;

    @Column(name = "IdentificationID", unique = true)
    private String identificationID;

    @Column(name = "Password", nullable = false)
    private String password;

    @Column(name = "Email")
    private String email;

    @Column(name = "PhoneNumber")
    private String phoneNumber;

    @Column(name = "Role", nullable = false)
    private String role;

    @Column(name = "Experience")
    private String experience;

    @Column(name = "School")
    private String school;

    @Column(name = "SelfIntroduction")
    private String selfIntroduction;

    @Column(name = "CreatedTime", insertable = false, updatable = false)
    private Date createdTime;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String encode) {
        this.password = encode;
    }

    public void setRegistrationDate(Date date) {
        this.createdTime = date;
    }
}
