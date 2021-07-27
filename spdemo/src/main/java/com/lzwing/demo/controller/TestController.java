package com.lzwing.demo.controller;

import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.support.WebApplicationObjectSupport;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong
 * Date: 2021/7/27
 * Time: 12:07
 */
@Controller
public class TestController extends WebApplicationObjectSupport {

    @ResponseBody
    @GetMapping("/test")
//    public Object test(@PathVariable List<Object> objects) {
    public Object test(Model model, String[] objects) {
        ApplicationContext applicationContext = super.getApplicationContext();
        String[] beanDefinitionNames = ((ConfigurableListableBeanFactory) applicationContext.getAutowireCapableBeanFactory()).getBeanDefinitionNames();
        String[] beanNames = BeanFactoryUtils.beanNamesForTypeIncludingAncestors(getApplicationContext(), Object.class);

        List<String> bdList = Arrays.stream(beanDefinitionNames).collect(Collectors.toList());
        List<String> bnList = Arrays.stream(beanNames).collect(Collectors.toList());

        bdList.removeAll(bnList);

        System.out.println(bdList);

        System.out.println(Arrays.equals(beanNames, beanDefinitionNames));
        System.out.println(Arrays.toString(objects));
        return objects;
    }
}
