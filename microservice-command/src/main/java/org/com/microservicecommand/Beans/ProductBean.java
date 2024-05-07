package org.com.microservicecommand.Beans;

import lombok.*;

@NoArgsConstructor @AllArgsConstructor @Getter @Setter @Builder
public class ProductBean {
    private Integer id;
    private String name;
    private String description;
    private Double price;
}
