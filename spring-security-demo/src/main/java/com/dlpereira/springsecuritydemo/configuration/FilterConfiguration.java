package com.dlpereira.springsecuritydemo.configuration;

import com.dlpereira.springsecuritydemo.filter.LogFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.DelegatingFilterProxy;

@Configuration
public class FilterConfiguration {

    public FilterRegistrationBean<DelegatingFilterProxy> delegatingFilterProxyFilterRegistrationBean(){
        DelegatingFilterProxy delegateFilterProxy = new DelegatingFilterProxy(new LogFilter());
        FilterRegistrationBean<DelegatingFilterProxy> regBean = new FilterRegistrationBean<>(delegateFilterProxy);

        // Spring Security’s DelegateFilterProxy filter order is set at the value -100.
        // Any value lower than this would indicate that it'll run before the security DelegateFilterProxy
        regBean.setOrder(-150);
        regBean.setName("LoggerDelegatingFilterProxy");
        return regBean;
    }
}
