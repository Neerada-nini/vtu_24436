package com.spring.backend.afford.medicals.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.backend.afford.medicals.service.JsonImportService;
import com.spring.backend.afford.medicals.service.ApiService;

@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    private JsonImportService service;

    @Autowired
    private ApiService apiService;

    @PostMapping("/import")
    public String importData() throws Exception {

        service.importJson();   // no arguments

        return "Imported Successfully";
    }

    @GetMapping("/generate-pdf")
    public String generatePdf() {
        return apiService.generatePdf();
    }
}
