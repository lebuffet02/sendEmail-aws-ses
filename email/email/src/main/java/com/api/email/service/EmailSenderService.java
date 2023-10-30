package com.api.email.service;

import com.api.email.adapter.EmailSenderGateway;
import com.api.email.core.EmailSenderUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService implements EmailSenderUseCase {

    @Autowired
    EmailSenderGateway emailSenderGateway;

    @Override
    public void sendEmail(String toEmail, String subject, String body) {
        emailSenderGateway.sendEmail(toEmail, subject, body);
    }
}
