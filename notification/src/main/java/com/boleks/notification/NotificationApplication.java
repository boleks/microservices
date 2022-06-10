package com.boleks.notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@EnableEurekaClient
@SpringBootApplication(
        scanBasePackages = {
                "com.boleks.notification",
                "com.boleks.amqp"
        }
)
@PropertySources({
    @PropertySource("classpath:clients-${spring.profiles.active}.properties")
})
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
