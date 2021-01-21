package com.lzwing.testcode.introspector;

import lombok.SneakyThrows;

import java.beans.*;
import java.lang.reflect.Method;

/**
 * Java内省
 *
 * @author: chenzhongyong
 * Date: 2020/9/18
 * Time: 22:15
 */
public class Tester {
    public static void main(String[] args) {
//        testPropertyDescriptor();
//        testIntrospector();
    }


    @SneakyThrows
    private static void testIntrospector() {
        BeanInfo beanInfo = Introspector.getBeanInfo( User.class );
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        MethodDescriptor[] methodDescriptors = beanInfo.getMethodDescriptors();
        BeanDescriptor beanDescriptor = beanInfo.getBeanDescriptor();
    }

    @SneakyThrows
    private static void testPropertyDescriptor() {
        User user = new User();
        System.out.println( user );
        PropertyDescriptor propertyDescriptor = new PropertyDescriptor( "name", User.class );
        Method readMethod = propertyDescriptor.getReadMethod();
        System.out.println( readMethod.invoke( user ) );
        Method writeMethod = propertyDescriptor.getWriteMethod();
        writeMethod.invoke( user, "hello" );
        System.out.println( user );
    }
}
