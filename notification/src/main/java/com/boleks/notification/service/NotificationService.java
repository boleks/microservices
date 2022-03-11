package com.boleks.notification.service;

import com.boleks.clients.notification.NotificationRequest;
import com.boleks.notification.model.Notification;
import com.boleks.notification.repository.NotificationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public Notification send(NotificationRequest notificationRequest) {
        var notification = notificationRepository.saveAndFlush(
                Notification.builder()
                        .massage(notificationRequest.massage())
                        .sender(notificationRequest.sender())
                        .sendAt(LocalDateTime.now())
                        .toCustomerEmail(notificationRequest.toCustomerEmail())
                        .toCustomerId(notificationRequest.toCustomerId())
                        .build()
        );
        return notification;
    }
}
