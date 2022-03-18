package com.boleks.notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication(
        scanBasePackages = {
                "com.boleks.notification",
                "com.boleks.amqp"
        }
)
public class NotificationApplication {
    public static void main(String[] args) {
        SpringApplication.run(NotificationApplication.class, args);
    }
//
//    @Bean
//    CommandLineRunner commandLineRunner(
//            RabbitMQMessageProducer producer,
//            NotificationConfig notificationConfig
//    ) {
//        return args -> producer.publish(
//                new Person("Bojan Trosic", 40),
//                notificationConfig.getInternalExchange(),
//                notificationConfig.getInternalNotificationRoutingKey());
//    }
//
//    record Person(String name, int age){}
}
