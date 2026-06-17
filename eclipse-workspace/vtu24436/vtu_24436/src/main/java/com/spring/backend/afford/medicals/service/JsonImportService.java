package com.spring.backend.afford.medicals.service;

import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.spring.backend.afford.medicals.entity.Notification;
import com.spring.backend.afford.medicals.repository.NotificationRepository;

@Service
public class JsonImportService {

    @Autowired
    private NotificationRepository repository;

    private final ObjectMapper objectMapper = new ObjectMapper()
            .registerModule(new JavaTimeModule());

    public void importJson() throws Exception {

        InputStream is = getClass()
                .getClassLoader()
                .getResourceAsStream("notifications.json");

        if (is == null) {
            throw new RuntimeException("notifications.json not found in resources folder");
        }

        List<Notification> notifications =
                objectMapper.readValue(is, new TypeReference<List<Notification>>() {});

        repository.saveAll(notifications);
    }
}