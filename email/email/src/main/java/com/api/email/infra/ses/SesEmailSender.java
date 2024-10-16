package com.api.email.infra.ses;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.*;
import com.api.email.adapter.EmailSenderGateway;
import com.api.email.exception.EmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SesEmailSender implements EmailSenderGateway {

    @Autowired
    AmazonSimpleEmailService sesClient;

    @Override
    public void sendEmail(String to, String subject, String body) {
        SendEmailRequest request = new SendEmailRequest()
                .withSource("teste@gmail.com")
                .withDestination(new Destination().withToAddresses(to))
                .withMessage(new Message()
                        .withSubject(new Content(subject))
                        .withBody(new Body().withText(new Content(body))));
        try {
            sesClient.sendEmail(request);
        } catch (AmazonServiceException e) {
            throw new EmailException(e.getErrorMessage().concat("\n").concat(String.valueOf(e.getStatusCode())));
        }
    }
}
