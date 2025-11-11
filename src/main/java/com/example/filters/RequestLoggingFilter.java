// src/main/java/com/example/web/RequestLoggingFilter.java
package com.example.filters;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.MDC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.UUID;

public class RequestLoggingFilter extends OncePerRequestFilter {
    private static final Logger log = LoggerFactory.getLogger(RequestLoggingFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest req,
                                    HttpServletResponse res,
                                    FilterChain chain)
            throws ServletException, IOException {

        String rid = UUID.randomUUID().toString();
        MDC.put("rid", rid);
        long t0 = System.currentTimeMillis();

        try {
            log.info("[{}] -> {} {}", rid, req.getMethod(), req.getRequestURI());
            chain.doFilter(req, res); // IMPORTANT: permite continuarea lanțului (diagramă Baeldung)
        } finally {
            long took = System.currentTimeMillis() - t0;
            log.info("[{}] <- {} {} (status={}, {} ms)", rid, req.getMethod(),
                    req.getRequestURI(), res.getStatus(), took);
            MDC.clear();
        }
    }
}
