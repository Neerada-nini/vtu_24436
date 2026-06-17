package com.spring.backend.afford.medicals.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.backend.afford.medicals.entity.Notification;

public interface NotificationRepository
extends JpaRepository<Notification, String> {
}