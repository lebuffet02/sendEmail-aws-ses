package com.api.email.adapter;

public interface EmailSenderGateway {

    void sendEmail(String to, String subject, String body);
}
