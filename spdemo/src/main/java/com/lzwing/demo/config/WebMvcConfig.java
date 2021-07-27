package com.lzwing.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.HandlerTypePredicate;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong
 * Date: 2021/7/27
 * Time: 16:42
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        //关闭后缀名匹配，关闭最后一个/匹配
        configurer.setUseSuffixPatternMatch(true);
        //configurer.setUseTrailingSlashMatch(false);

        // 使用Spring提供的HandlerTypePredicate，更加的强大
        HandlerTypePredicate predicate = HandlerTypePredicate.forBasePackage("com.lzwing.demo.controller");
/*
        HandlerTypePredicate predicate = HandlerTypePredicate.forBasePackageClass(HelloController.class);
        HandlerTypePredicate predicate = HandlerTypePredicate.forAssignableType(...);
        HandlerTypePredicate predicate = HandlerTypePredicate.forAnnotation(...);
        HandlerTypePredicate predicate = HandlerTypePredicate.builder()
                .basePackage()
                .basePackageClass()
                .build();
*/
        configurer.addPathPrefix("/api/v2", predicate);
    }
}
