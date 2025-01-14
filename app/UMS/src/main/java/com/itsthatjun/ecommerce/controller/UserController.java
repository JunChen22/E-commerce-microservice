package com.itsthatjun.ecommerce.controller;

import com.itsthatjun.ecommerce.dto.MemberDetail;
import com.itsthatjun.ecommerce.service.impl.MemberServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/user")
@Tag(name = "User related", description = "retrieve user information")
public class UserController {

    private final MemberServiceImpl memberService;

    @Autowired
    public UserController(MemberServiceImpl memberService) {
        this.memberService = memberService;
    }

    @Operation(summary = "Get user information", description = "Get user information")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User information retrieved"),
            @ApiResponse(responseCode = "404", description = "User not found")})
    @GetMapping("/getInfo")
    public Mono<MemberDetail> getInfo() {
        return memberService.getInfo();
    }

    @Operation(summary = "Check email", description = "Check if email is already in use")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Email is available"),
            @ApiResponse(responseCode = "400", description = "Email is already in use")})
    @GetMapping("/checkEmail")
    private Mono<Boolean> checkEmail(@RequestParam String email) {
        return memberService.checkEmail(email);
    }
}
