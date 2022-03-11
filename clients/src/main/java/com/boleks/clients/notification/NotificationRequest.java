package com.boleks.clients.notification;

public record NotificationRequest(
        String massage,
        String sender,
        String toCustomerEmail,
        Integer toCustomerId) {
}
