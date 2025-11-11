package com.example.filters;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<RequestLoggingFilter> booksFilterStar() {
        FilterRegistrationBean<RequestLoggingFilter> reg = new FilterRegistrationBean<>();
        reg.setFilter(new RequestLoggingFilter());
        reg.addUrlPatterns("/books/*");
        reg.setOrder(1);
        return reg;
    }

    @Bean
    public FilterRegistrationBean<RequestLoggingFilter> booksFilterRoot() {
        FilterRegistrationBean<RequestLoggingFilter> reg = new FilterRegistrationBean<>();
        reg.setFilter(new RequestLoggingFilter());
        reg.addUrlPatterns("/books");
        reg.setOrder(1);
        return reg;
    }
}
