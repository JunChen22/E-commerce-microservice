package com.itsthatjun.ecommerce.dto.event;

import lombok.Getter;

import java.time.ZonedDateTime;
import java.util.Map;

import static java.time.ZonedDateTime.now;

@Getter
public class SmsCouponEvent {
    public enum Type {
        UPDATE_COUPON_USAGE,

    }

    private final Type eventType;
    private final int orderId;
    private final String coupon;
    private final int memberId;
    private final ZonedDateTime eventCreatedAt;

    // Jackson needs it, (the library used for JSON serialization/deserialization)
    public SmsCouponEvent() {
        this.eventType = null;
        this.coupon = null;
        this.memberId = 0;
        this.orderId = 0;
        this.eventCreatedAt = null;
    }

    // update coupon usage
    public SmsCouponEvent(Type eventType, String coupon, int memberId, int orderId) {
        this.eventType = eventType;
        this.coupon = coupon;
        this.memberId = memberId;
        this.orderId = orderId;
        this.eventCreatedAt = now();
    }
}