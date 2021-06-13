package com.sda.corneliacalin.webshop.error;

import java.time.Instant;
// obiectul care va fi returnat in caz de eroare

public class ErrorDetails {
    private final Instant timestamp;
    private String message;
    private String details;

    public ErrorDetails(Instant timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }
}
