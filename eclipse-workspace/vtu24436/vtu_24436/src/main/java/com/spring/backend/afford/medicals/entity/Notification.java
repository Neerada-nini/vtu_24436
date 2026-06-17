package com.spring.backend.afford.medicals.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "notifications")
public class Notification {

    @Id
    private String id;

    private String type;

    private String message;

    private LocalDateTime timestamp;

    
}