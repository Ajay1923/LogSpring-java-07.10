package com.crud.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.demo.service.EmailService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
public class MailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/sendMail")
    public ResponseEntity<String> sendMail() {
        String to = "ajaychandru19@gmail.com"; 
        String subject = "Log File Analysis Report";
        String text = "Please find attached the log file analysis report.";

        try {
            emailService.sendMail(to, subject, text);
            return ResponseEntity.ok("Mail sent successfully.");
        } catch (Exception e) {
            e.printStackTrace(); 
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to send mail: " + e.getMessage());
        }
    }

    @PostMapping("/sendErrorLogsMail")
    public ResponseEntity<String> sendErrorLogsMail() {
        String to = "ajaychandru19@gmail.com"; 
        String subject = "Error Logs Report";
        String text = "Please find attached the error logs report.";

        try {
            emailService.sendMail(to, subject, text);
            return ResponseEntity.ok("Error logs mail sent successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Failed to send error logs mail: " + e.getMessage());
        }
    }
}
