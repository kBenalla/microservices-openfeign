package org.com.clientui.beans;

import lombok.*;

@NoArgsConstructor @AllArgsConstructor @Getter @Setter @Builder
public class PaymentBean {
    private Integer id;

    private Integer commandId;

    private double amount;

    private PaymentType type;

    private String status;
}
