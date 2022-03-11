package com.boleks.customer.service;

import com.boleks.clients.fraud.FraudCheckResponse;
import com.boleks.clients.fraud.FraudClient;
import com.boleks.clients.notification.NotificationClient;
import com.boleks.clients.notification.NotificationRequest;
import com.boleks.customer.model.Customer;
import com.boleks.customer.model.CustomerRegistrationRequest;
import com.boleks.customer.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final FraudClient fraudClient;
    private final NotificationClient notificationClient;

    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
        customerRepository.saveAndFlush(customer);

        FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(customer.getId());

        if (fraudCheckResponse.isFraudster()) {
            throw new IllegalStateException("Customer is on fraudster list.");
        }

        notificationClient.sendNotification(new NotificationRequest(
                String.format("Hi %s, walcome to Boleks....", customer.getFirstName()),
                "CustomerRegistration - Boleks",
                customer.getEmail(),
                customer.getId()
        ));
    }
}
