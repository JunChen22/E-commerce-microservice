package com.itsthatjun.ecommerce.controller;

import com.itsthatjun.ecommerce.dto.ProductReview;
import com.itsthatjun.ecommerce.mbg.model.Review;
import com.itsthatjun.ecommerce.service.impl.ReviewServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
@Api(tags = "Product related", description = "CRUD a specific product reviews")
public class ReviewController {

    private final ReviewServiceImpl reviewService;

    @Autowired
    public ReviewController(ReviewServiceImpl reviewService) {
        this.reviewService = reviewService;
    }
    @GetMapping("/detail/{reviewId}")
    @ApiOperation(value = "get detail of a review")
    public ProductReview getDetailReview(@PathVariable int reviewId) {
        return reviewService.getDetailReview(reviewId);
    }

    @GetMapping("/getAllProductReview/{productId}")
    @ApiOperation(value = "get all reviews for a product")
    public List<ProductReview> getProductReviews(@PathVariable int productId) {
        return reviewService.listProductAllReview(productId);
    }

    @PostMapping("/create")
    @ApiOperation(value = "create review for a product")
    public ProductReview createProductReview(@RequestBody ProductReview newReview, @RequestParam int userId) {
        reviewService.createReview(newReview.getReview(), newReview.getPicturesList(), userId);
        return newReview;
    }

    @PostMapping("/update")
    @ApiOperation(value = "update a review")
    public ProductReview updateProductReviews(@RequestBody ProductReview newReview, @RequestParam int userId) {
        reviewService.updateReview(newReview.getReview(), newReview.getPicturesList(), userId);
        return newReview;
    }

    @DeleteMapping("/delete/{reviewId}")
    @ApiOperation(value = "Get product with page and size")
    public void deleteProductReviews(@PathVariable int reviewId, @RequestParam int userId) {
        reviewService.deleteReview(reviewId, userId);
    }
}
