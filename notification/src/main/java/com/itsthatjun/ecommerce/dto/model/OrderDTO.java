package com.itsthatjun.ecommerce.dto.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class OrderDTO {

    private String orderSn;

    private String memberEmail;

    private double totalAmount;

    private double promotionAmount;

    private double couponAmount;

    private double discountAmount;

    private double shippingCost;

    private double payAmount;

    private String receiverPhone;

    private String receiverName;

    private String receiverDetailAddress;

    private String receiverCity;

    private String receiverState;

    private String receiverZipCode;

    private String deliveryCompany;

    private String deliveryTrackingNumber;

    private Date deliveryTime;

    private Integer status;

    private String comment;
}
