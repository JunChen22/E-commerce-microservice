package com.itsthatjun.ecommerce.config;

import com.itsthatjun.ecommerce.converter.PublishStatusReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.r2dbc.convert.R2dbcCustomConversions;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class R2dbcConfig {

    @Bean
    public R2dbcCustomConversions customConverters() {
        List<Converter<?, ?>> converters = new ArrayList<>();
        converters.add(new PublishStatusReader());
        return new R2dbcCustomConversions(converters);
    }
}