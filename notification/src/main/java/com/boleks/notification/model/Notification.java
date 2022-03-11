package com.boleks.notification.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Notification {

    @Id
    @SequenceGenerator(
            name = "notification_id_sequence",
            allocationSize = 1,
            sequenceName = "notification_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "notification_id_sequence"
    )
    private Integer notificationId;
    private String massage;
    private String sender;
    private LocalDateTime sendAt;
    private String toCustomerEmail;
    private Integer toCustomerId;
}
