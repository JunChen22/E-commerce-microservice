package com.itsthatjun.ecommerce.controller;

import com.itsthatjun.ecommerce.dto.CouponSale;
import com.itsthatjun.ecommerce.dto.UsedCouponHistory;
import com.itsthatjun.ecommerce.mbg.model.Coupon;
import com.itsthatjun.ecommerce.service.impl.CouponHistoryServiceImpl;
import com.itsthatjun.ecommerce.service.impl.CouponServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Map;

import static java.util.logging.Level.FINE;

@RestController
@RequestMapping("/coupon/history")
public class CouponHistoryController {

    private CouponHistoryServiceImpl historyService;

    @Autowired
    public CouponHistoryController(CouponHistoryServiceImpl historyService) {
        this.historyService = historyService;
    }

    @GetMapping("/getAllUsedCoupon")
    @ApiOperation(value = "return all the coupon used between two time")
    public Flux<UsedCouponHistory> couponUsed() {
        return historyService.getAllCouponUsed();
    }

    @GetMapping("/getUserCoupon/{userId}")
    @ApiOperation(value = "shows how many coupon(amount saved) a user used")
    public Flux<UsedCouponHistory> getUserCoupon(@PathVariable int userId) {
        return  historyService.getUserCoupon(userId);
    }
}