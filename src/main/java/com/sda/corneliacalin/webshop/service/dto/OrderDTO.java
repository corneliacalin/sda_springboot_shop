package com.sda.corneliacalin.webshop.service.dto;

// order data transfer object

import java.util.List;

public class OrderDTO {
    private Long customerId;
    private List<Long> productIds;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public List<Long> getProductIds() {
        return productIds;
    }

    public void setProductIds(List<Long> productId) {
        this.productIds = productId;
    }
}
