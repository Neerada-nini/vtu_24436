package com.spring.backend.afford.medicals.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;

@Service
public class ApiService {

    @Autowired
    private RestClient restClient;

    private static final String TOKEN = "your_token_here";

    public String generatePdf() {
        try {
            String response = restClient.get()
                    .uri("http://4.224.186.213/evaluation-service/notifications")
                    .header("Authorization", "Bearer " + TOKEN)
                    .retrieve()
                    .body(String.class);

            Document document = new Document();

            String path = System.getProperty("user.home") + "/Desktop/notification.pdf";
            PdfWriter.getInstance(document, new FileOutputStream(path));

            document.open();
            document.add(new Paragraph("Notifications Data"));
            document.add(new Paragraph(response));
            document.close();

            return "PDF created at: " + path;

        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
}