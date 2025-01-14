package com.itsthatjun.ecommerce.dto.event.oms;

import com.itsthatjun.ecommerce.dto.oms.OrderParam;
import lombok.Getter;

import java.time.ZonedDateTime;
import java.util.UUID;

import static java.time.ZonedDateTime.now;

@Getter
public class OmsOrderEvent {

    public enum Type {
        GENERATE_ORDER,
        CANCEL_ORDER
    }

    private final Type eventType;
    private final UUID memberId;
    private final String orderSn;
    private final OrderParam orderParam;  // dto from user to endpoint
    private final String successUrl;
    private final String cancelUrl;
    private final ZonedDateTime eventCreatedAt;

    public OmsOrderEvent(Type eventType, UUID memberId, String orderSn, OrderParam orderParam, String successUrl, String cancelUrl) {
        this.eventType = eventType;
        this.memberId = memberId;
        this.orderSn = orderSn;
        this.orderParam = orderParam;
        this.successUrl = successUrl;
        this.cancelUrl = cancelUrl;
        this.eventCreatedAt = now();
    }
}
