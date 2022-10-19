package com.api.parkingcontrol.modules.user.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "rolesUsers")
public class RolesEntities implements Serializable 
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false, length = 20)
    private Integer role;
    @Column(nullable = false, length = 20)
    private Integer entities;
    @Column(nullable = false)
    private UUID userid;

    public UUID getUserid() {
        return userid;
    }

    public void setUserid(UUID userid) {
        this.userid = userid;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Integer getEntities() {
        return entities;
    }

    public void setEntities(Integer entities) {
        this.entities = entities;
    }

    public Integer getRole() {
        return role;
    }
    
    public void setRole(Integer role) {
        this.role = role;
    }

   
}
