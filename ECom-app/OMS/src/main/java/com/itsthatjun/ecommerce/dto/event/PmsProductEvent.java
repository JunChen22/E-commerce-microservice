package com.itsthatjun.ecommerce.dto.event;

import lombok.Getter;

import java.time.ZonedDateTime;
import java.util.Map;

import static java.time.ZonedDateTime.now;

@Getter
public class PmsProductEvent {
    public enum Type {
        UPDATE_PURCHASE,   // Generated order, increase sku lock stock
        UPDATE_PURCHASE_PAYMENT, // Generated order and success payment, decrease product stock, decrease sku stock and sku lock stock
        UPDATE_RETURN,  // Generated order and success payment and return, increase product stock and sku stock
        UPDATE_FAIL_PAYMENT  // Generated order and failure payment, decrease sku lock stock
    }

    private final Type eventType;
    private final String orderSN;                         // order serial number associated with this stock update
    private final Map<String, Integer> productMap;        // sku and quantity
    private final ZonedDateTime eventCreatedAt;

    public PmsProductEvent() {
        this.eventType = null;
        this.orderSN = null;
        this.productMap = null;
        this.eventCreatedAt = null;
    }

    public PmsProductEvent(Type eventType, String orderSN, Map<String, Integer> productMap) {
        this.eventType = eventType;
        this.orderSN = orderSN;
        this.productMap = productMap;
        this.eventCreatedAt = now();
    }
}