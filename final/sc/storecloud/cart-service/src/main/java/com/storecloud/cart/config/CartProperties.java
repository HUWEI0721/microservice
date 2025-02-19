package com.storecloud.cart.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "sc.cart")
public class CartProperties {
    private Integer maxAmount;
}
