package com.itsthatjun.ecommerce.service;

import com.itsthatjun.ecommerce.dto.ArticleInfo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ArticleService {

    /**
     * list all articles
     * @return list of articles
     */
    Flux<ArticleInfo> listAllArticles();

    /**
     * list articles with pagination
     * @param pageNum page number
     * @param pageSize page size
     * @return list of articles
     */
    Flux<ArticleInfo> listArticles(int pageNum, int pageSize);

    /**
     * get article based on slug, added delay and fault percentage for circuit breaker testing
     * @param slug slug
     * @param delay delay in milliseconds
     * @param faultPercent fault percentage
     * @return article info
     */
    Mono<ArticleInfo> getArticleBySlug(String slug, int delay, int faultPercent);
}
