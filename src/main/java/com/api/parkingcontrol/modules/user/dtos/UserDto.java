package com.api.parkingcontrol.modules.user.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserDto {

    @NotBlank
    @Size(max = 40)
    private String name;
    @NotBlank
    @Size(max = 256)
    private String password;
    @NotBlank
    private String course;
    @NotBlank
    private String athletic;
    @NotBlank
    private String email;
    @NotBlank
    private String number;
    @NotBlank
    private String insta;
    @NotBlank
    private String userName;
    @NotBlank
    private String profilePicture;
    @NotBlank
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    
}
