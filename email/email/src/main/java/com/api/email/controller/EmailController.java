package com.api.email.controller;

import com.api.email.dto.EmailRequest;
import com.api.email.service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/email-send")
public class EmailController {

    @Autowired
    EmailSenderService emailSenderService;

    @PostMapping
    public ResponseEntity<?> sendEmail(@RequestBody EmailRequest emailRequest) {
            emailSenderService.sendEmail(emailRequest.to(), emailRequest.subject(), emailRequest.body());
            return ResponseEntity.ok("Email sent successfully!");
    }
}
