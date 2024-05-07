package org.com.clientui.dtos;

import lombok.*;
import org.com.clientui.beans.CommandBean;
import org.com.clientui.beans.PaymentBean;
import org.com.clientui.beans.ProductBean;
@NoArgsConstructor @AllArgsConstructor @Getter @Setter @Builder
public class FullResponse {
    private ProductBean productBean;
    private CommandBean commandBean;
    private PaymentBean paymentBean;
}
