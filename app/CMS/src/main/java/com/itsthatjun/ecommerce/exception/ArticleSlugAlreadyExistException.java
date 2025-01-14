package com.itsthatjun.ecommerce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ArticleSlugAlreadyExistException extends RuntimeException{
    public ArticleSlugAlreadyExistException(String message) {
        super(message);
    }
}