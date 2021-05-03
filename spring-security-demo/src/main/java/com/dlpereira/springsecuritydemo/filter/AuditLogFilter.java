package com.dlpereira.springsecuritydemo.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import java.io.IOException;
import java.time.Instant;

public class AuditLogFilter  implements Filter {

    public static final Logger LOGGER = LoggerFactory.getLogger(AuditLogFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        LOGGER.info("Admin Login Detected at {} ", Instant.now());
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void destroy() {}
}
