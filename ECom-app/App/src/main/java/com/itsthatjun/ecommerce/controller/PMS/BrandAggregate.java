package com.itsthatjun.ecommerce.controller.PMS;

import com.itsthatjun.ecommerce.mbg.model.Brand;
import com.itsthatjun.ecommerce.mbg.model.Product;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;

import static java.util.logging.Level.FINE;
import static reactor.core.publisher.Flux.empty;

@RestController
@Api(tags = "", description = "")
@RequestMapping("/brand")
public class BrandAggregate {

    private static final Logger LOG = LoggerFactory.getLogger(BrandAggregate.class);

    private final WebClient webClient;

    private final Scheduler publishEventScheduler;

    @Value("${app.PMS-service.host}")
    String brandServiceURL;
    @Value("${app.PMS-service.port}")
    int port;

    @Autowired
    public BrandAggregate(WebClient.Builder webClient, @Qualifier("publishEventScheduler")Scheduler publishEventScheduler) {
        this.webClient = webClient.build();
        this.publishEventScheduler = publishEventScheduler;
    }
    @GetMapping("/listAll")
    @ApiOperation(value = "Get all brands")
    public Flux<Brand> getAllBrand(){
        String url = "http://" + brandServiceURL + ":" + port + "/listAll/";
        return webClient.get().uri(url).retrieve().bodyToFlux(Brand.class)
                .log(LOG.getName(), FINE).onErrorResume(error -> empty());
    }

    @GetMapping("/list")
    @ApiOperation(value = "Get brands with page and size")
    public Flux<Brand> getAllBrand(@RequestParam(value = "page", defaultValue = "1") int pageNum,
                                   @RequestParam(value = "size", defaultValue = "3") int pageSize){
        String url = "http://" + brandServiceURL + ":" + port + "/list/" + "?pageNum=" + pageNum + "&pageSize=" + pageSize;

        return webClient.get().uri(url).retrieve().bodyToFlux(Brand.class)
                .log(LOG.getName(), FINE).onErrorResume(error -> empty());
    }

    @GetMapping("/product/{brandId}")
    @ApiOperation(value = "Get all product of this brand")
    public Flux<Product> getBrandProduct(@PathVariable int brandId){
        String url = "http://" + brandServiceURL + ":" + port + "/product/" + brandId;
        return webClient.get().uri(url).retrieve().bodyToFlux(Product.class)
                .log(LOG.getName(), FINE).onErrorResume(error -> empty());
    }

    @GetMapping("/{brandId}")
    @ApiOperation(value = "Get brand info")
    public Mono<Brand> getBrand(@PathVariable int brandId){
        String url = "http://" + brandServiceURL + ":" + port +"/" + brandId;

        return webClient.get().uri(url).retrieve().bodyToMono(Brand.class)
                .log(LOG.getName(), FINE).onErrorResume(error -> Mono.empty());
    }

}