package org.com.clientui.beans;

import lombok.*;

import java.time.LocalDateTime;
@NoArgsConstructor @AllArgsConstructor @Getter @Setter @Builder
public class CommandBean {
    private Integer id;

    private Integer productId;

    private LocalDateTime dateTime;

    private Integer quantity;

    private boolean paidCommand;
}
