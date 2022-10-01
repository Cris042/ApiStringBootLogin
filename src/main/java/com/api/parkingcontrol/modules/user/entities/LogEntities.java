package com.api.parkingcontrol.modules.user.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "logUsers")
public class LogEntities implements Serializable 
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false, length = 20)
    private Integer code;
    @Column(nullable = false, length = 20)
    private Integer entities;
    @Column(nullable = false, length = 20)
    private Integer modules;
    @Column(nullable = false)
    private UUID userid;
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

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getEntities() {
        return entities;
    }

    public void setEntities(Integer entities) {
        this.entities = entities;
    }

    public Integer getModules() {
        return modules;
    }

    public void setModules(Integer modules) {
        this.modules = modules;
    }

    public UUID getUserid() {
        return userid;
    }

    public void setUserid(UUID userid) {
        this.userid = userid;
    }

   
}
