package com.percylee.sample.beanvalidation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import java.util.Locale;

/**
 * @author 李鹏翔(lipengxiang1)
 * @date 2019-08-26
 **/
@Configuration
public class CustomerMvcConfig implements WebMvcConfigurer {

    /**
     * 设置cookie或者请求参数的值lang=xxx，则可以控制请求语言
     */
    private static final String LOCALE_NAME = "lang";


    /**
     * spring默认的LocaleResolver是: AcceptHeaderLocaleResolver
     * 获取当前Locale可以使用：LocaleContextHolder.getLocale();
     * @return
     */
    @Bean
    public LocaleResolver localeResolver() {
        CookieLocaleResolver resolver = new CookieLocaleResolver();
        resolver.setCookieName(LOCALE_NAME);
        resolver.setDefaultLocale(Locale.SIMPLIFIED_CHINESE);
        return resolver;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
        interceptor.setParamName(LOCALE_NAME);
        registry.addInterceptor(interceptor);
    }
}
