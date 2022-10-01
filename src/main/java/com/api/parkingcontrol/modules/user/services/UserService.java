package com.api.parkingcontrol.modules.user.services;

import com.api.parkingcontrol.modules.user.entities.UserEntities;
import com.api.parkingcontrol.modules.user.repositories.UserRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService 
{

    final UserRepository userRepository;

    public UserService(UserRepository userRepository) 
    {
        this.userRepository = userRepository;
    }

    @Transactional
    public UserEntities save(UserEntities UserModel) 
    {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(); 
        UserModel.setPassword(bCryptPasswordEncoder.encode(UserModel.getPassword())); 
        return userRepository.save(UserModel);
    }

    public boolean existsByUserName(String userName)
    {
        return userRepository.existsByUserName( userName );
    }

    public Page<UserEntities> findAll(Pageable pageable)
    {
        return userRepository.findAll(pageable);
    }

    public Optional<UserEntities> findById(UUID id) 
    {
        return userRepository.findById(id);
    }

    @Transactional
    public void delete(UserEntities UserModel) 
    {
        userRepository.delete(UserModel);
    }
}
