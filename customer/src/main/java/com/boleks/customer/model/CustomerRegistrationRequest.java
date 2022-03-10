package com.boleks.customer.model;

public record CustomerRegistrationRequest(
        String firstName,
        String lastName,
        String email) {
}
