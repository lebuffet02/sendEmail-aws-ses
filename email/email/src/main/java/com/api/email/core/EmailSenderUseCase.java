package com.api.email.core;

public interface EmailSenderUseCase {

    void sendEmail(String toEmail, String subject, String body);
}
