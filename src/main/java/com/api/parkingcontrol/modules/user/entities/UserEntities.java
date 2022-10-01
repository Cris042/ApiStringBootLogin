package com.api.parkingcontrol.modules.user.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "users")
public class UserEntities implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false, length = 20)
    private String name;
    @Column(nullable = false, length = 256)
    private String password;
    @Column(nullable = true, length = 20)
    private String course;
    @Column(nullable = true, length = 20)
    private String athletic;
    @Column(nullable = true, length = 20)
    private String email;
    @Column(nullable = true, length = 20)
    private String number;
    @Column(nullable = true, unique = true, length = 20)
    private String insta;
    @Column(nullable = false,  length = 20)
    private String userName;
    @Column(nullable = true)
    private String profilePicture;
    @Column(nullable = false)
    private String status;
    @Column(nullable = true)
    private LocalDateTime registrationDate;
   
    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getAthletic() {
        return athletic;
    }

    public void setAthletic(String athletic) {
        this.athletic = athletic;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getInsta() {
        return insta;
    }

    public void setInsta(String insta) {
        this.insta = insta;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

   
}
