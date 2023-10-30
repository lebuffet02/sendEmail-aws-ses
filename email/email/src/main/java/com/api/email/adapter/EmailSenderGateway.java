package com.api.email.adapter;

public interface EmailSenderGateway {

    void sendEmail(String toEmail, String subject, String body);
}
