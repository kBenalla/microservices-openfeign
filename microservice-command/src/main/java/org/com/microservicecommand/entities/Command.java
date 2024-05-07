package org.com.microservicecommand.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;
@Entity
@NoArgsConstructor @AllArgsConstructor @Getter @Setter @Builder
public class Command {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer productId;

    private LocalDateTime dateTime;

    private Integer quantity;

    private Boolean paidCommand;
}
