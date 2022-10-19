package com.api.parkingcontrol.modules.user.controllers;

import com.api.parkingcontrol.modules.user.dtos.UserDto;
import com.api.parkingcontrol.modules.user.dtos.AuthenticatorDto;
import com.api.parkingcontrol.modules.user.dtos.TokenDto;
import com.api.parkingcontrol.modules.user.entities.UserEntities;
import com.api.parkingcontrol.modules.user.services.UserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.crypto.SecretKey;
import javax.validation.Valid;

import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/users")
public class UserController 
{

    final UserService userService;

    public UserController(UserService userService) 
    {
        this.userService = userService;
    }

    public String generateToken( String userName, int time)
    {
        try
        {
           
            String jwtToken = Jwts.builder()
                .setSubject( userName )
                .setIssuer("localhost:8080")
                .setIssuedAt
                (
                    Date.from
                    (
						LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()
                    )
                )
                .setExpiration
                (
					Date.from
                    (
						LocalDateTime.now().plusMinutes( time ).atZone(ZoneId.systemDefault()).toInstant()
                    )
                )
                .signWith(Key)
                .compact();
                
                return jwtToken;
       
        }
        catch(Exception ex)
        {
            return null;
        }
    }
    
    private final SecretKey Key = 
      Keys.hmacShaKeyFor("7f-j&CKk=coNzZc0y7_4obMP?#TfcYq%fcD0mDpenW2nc!lfGoZ|d?f&RNbDHUX6".getBytes(StandardCharsets.UTF_8));

    @PostMapping("/token")
    public ResponseEntity<Object> token(@RequestBody @Valid TokenDto token ) 
    {

        try 
        {

            String jwtToken = Jwts.parserBuilder().setSigningKey(Key).build().parseClaimsJws( token.getToken() ).toString();
            return ResponseEntity.status(HttpStatus.OK).body( jwtToken );

        } 
        catch (Exception e) 
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body( "token not valid" );
        }
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody @Valid AuthenticatorDto obj)
    {
        try
        {
            if( userService.existsByUserName( obj.getUserName() ) )
            {
                String jwtToken = generateToken( obj.getUserName(), 60 );

                String jwtRefreshToken = generateToken( obj.getUserName(), 43200 );
                
                    return ResponseEntity.status(HttpStatus.OK).body("Token : " + jwtToken + "\nRefreshToken : \n" + jwtRefreshToken);

            }
            else
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuário e/ou senha inválidos");
        }
        catch(Exception ex)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    } 

    @PostMapping
    public ResponseEntity<Object> saveuserSpot(@RequestBody @Valid UserDto UserDto)
    {     
        if(userService.existsByUserName(UserDto.getUserName()))
        {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: user Name is already in use!");
        }
       
        var userModel = new UserEntities();
        BeanUtils.copyProperties(UserDto, userModel);
        userModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(userModel));
    }

    @GetMapping
    public ResponseEntity<Page<UserEntities>> getAlluserSpots(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable)
    {
        return ResponseEntity.status(HttpStatus.OK).body(userService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneuserSpot(@PathVariable(value = "id") UUID id)
    {
        Optional<UserEntities> userSpotModelOptional = userService.findById(id);
        if (!userSpotModelOptional.isPresent()) 
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("user Spot not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(userSpotModelOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteuserSpot(@PathVariable(value = "id") UUID id)
    {
        Optional<UserEntities> userSpotModelOptional = userService.findById(id);
        if (!userSpotModelOptional.isPresent())
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("user Spot not found.");
        }
        userService.delete(userSpotModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("user Spot deleted successfully.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateuserSpot(@PathVariable(value = "id") UUID id,@RequestBody @Valid UserDto UserDto)
    {
        Optional<UserEntities> userSpotModelOptional = userService.findById(id);
        if (!userSpotModelOptional.isPresent()) 
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("user Spot not found.");
        }
        var userSpotModel = new UserEntities();
        BeanUtils.copyProperties(UserDto, userSpotModel);
        userSpotModel.setId(userSpotModelOptional.get().getId());
        userSpotModel.setRegistrationDate(userSpotModelOptional.get().getRegistrationDate());
        return ResponseEntity.status(HttpStatus.OK).body(userService.save(userSpotModel));
    }



}
