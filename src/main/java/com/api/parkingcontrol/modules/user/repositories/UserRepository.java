package com.api.parkingcontrol.modules.user.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

import com.api.parkingcontrol.modules.user.entities.UserEntities;

@Repository
public interface UserRepository extends JpaRepository<UserEntities, UUID> {
    boolean existsByUserName(String UserName);
}
