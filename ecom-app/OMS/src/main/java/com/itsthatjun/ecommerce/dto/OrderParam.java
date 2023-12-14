package com.itsthatjun.ecommerce.dto;

import com.itsthatjun.ecommerce.dto.model.AddressDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Map;

@Data
public class OrderParam {

    @ApiModelProperty("item in shopping cart, sku code and quantity")
    private Map<String, Integer> orderProductSku;

    @ApiModelProperty("order amount calculated from cart")
    private double amount;

    @ApiModelProperty("Member deliver address")
    private AddressDTO address;

    @ApiModelProperty("coupon for discount")
    private String coupon;

    @ApiModelProperty("coupon discount amount calculated from cart")
    private double discountAmount;

    @ApiModelProperty("paypal, g pay, or finance. currently just paypal")
    private int payType;
}
