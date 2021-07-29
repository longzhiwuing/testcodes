package com.lzwing.demo.test.beanorder;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration(proxyBeanMethods = false)
public class Config {

    // @DependsOn // 若里面不写值，该注解无效。但若写了值，请确保里面的Bean都有，否则报错
    @DependsOn({"cc", "tom"})
    @Bean
    public MasterBean master() {
        return new MasterBean();
    }

    @Bean
    public Cat tom() {
        Cat tom = new Cat("Tom");
        Master.getMaster().addObserver(tom);
        return tom;
    }
    @Bean
    public Cat cc() {
        Cat cc = new Cat("Cc");
        Master.getMaster().addObserver(cc);
        return cc;
    }
}