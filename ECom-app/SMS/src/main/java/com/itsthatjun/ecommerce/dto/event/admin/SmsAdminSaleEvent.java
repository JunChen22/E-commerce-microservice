package com.itsthatjun.ecommerce.dto.event.admin;

import com.itsthatjun.ecommerce.dto.OnSaleRequest;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.ZonedDateTime;

import static java.time.ZonedDateTime.now;

@Getter
public class SmsAdminSaleEvent {

    public enum Type {
        CREATE_SALE,
        UPDATE_SALE_INFO,
        UPDATE_SALE_PRICE,
        UPDATE_SALE_STATUS,
        DELETE_SALE,
    }

    private final Type eventType;
    private final OnSaleRequest saleRequest;
    private final ZonedDateTime eventCreatedAt;

    // Jackson needs it, (the library used for JSON serialization/deserialization)
    public SmsAdminSaleEvent() {
        this.eventType = null;
        this.saleRequest = null;
        this.eventCreatedAt = null;
    }

    @Autowired
    public SmsAdminSaleEvent(Type eventType, OnSaleRequest saleRequest) {
        this.eventType = eventType;
        this.saleRequest = saleRequest;
        this.eventCreatedAt = now();
    }
}