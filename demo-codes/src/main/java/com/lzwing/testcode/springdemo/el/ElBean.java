package com.lzwing.testcode.springdemo.el;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("elBean")
@Data
public class ElBean {

    //通过beanName获取bean，然后注入
    @Value("#{role2}")
    private Role2 role2;

    //获取bean的属性id
    @Value("#{role2.id}")
    private Long id;

    //调用bean的getNote方法，获取角色名称
// @Value("#{role.getNote().toString()}")
    @Value("#{role2.getNote()?.toString()}")
    private String note;

    @Value("#{T(Math).PI}")
    private double pi;

    @Value("#{T(Math).random()}")
    private double random;

    @Value("#{role2.id+1}")
    private int num;
}