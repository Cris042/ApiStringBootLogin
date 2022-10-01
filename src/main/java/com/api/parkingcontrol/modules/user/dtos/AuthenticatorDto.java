package com.api.parkingcontrol.modules.user.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AuthenticatorDto {

    @NotBlank
    @Size(max = 20)
    private String userName;
    @NotBlank
    @Size(max = 256)
    private String password;
  

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

   
}
