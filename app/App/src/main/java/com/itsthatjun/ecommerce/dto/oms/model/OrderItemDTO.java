package com.itsthatjun.ecommerce.dto.oms.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class OrderItemDTO {

    private String productPic;

    private String productName;

    private String productBrand;

    private String productSn;

    private BigDecimal productPrice;

    private Integer productQuantity;

    private String productSkuCode;

    private BigDecimal promotionAmount;

    private BigDecimal couponAmount;

    private BigDecimal realAmount;
}
