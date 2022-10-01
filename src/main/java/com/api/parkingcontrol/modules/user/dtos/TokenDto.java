package com.api.parkingcontrol.modules.user.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class TokenDto {

    @NotBlank
    @Size(max = 256)
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
  
     
}
