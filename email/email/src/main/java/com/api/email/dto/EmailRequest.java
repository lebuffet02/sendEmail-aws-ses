package com.api.email.dto;

public record EmailRequest(String to, String subject, String body){}
