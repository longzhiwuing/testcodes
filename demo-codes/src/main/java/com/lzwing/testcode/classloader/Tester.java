package com.lzwing.testcode.classloader;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong
 * Date: 2018/12/6
 * Time: 20:22
 */
public class Tester {
    public static void main(String[] args) throws Exception{
//        testClassLoad();
        checkLoader();
    }

    private static void checkLoader() {
        try {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            //String resourceName = "net/sf/cglib/proxy/MethodInterceptor.class";
//            String resourceName = "com/lzwing/testcode/classloader/Tester.class";

            String resourceName = "java/lang/String.class";
            Enumeration<URL> urls = classLoader.getResources(resourceName);
            while(urls.hasMoreElements()){
                System.out.println(urls.nextElement());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void testClassLoad() throws ClassNotFoundException {
        Class<?> x = Class.forName("[[C");
        System.out.println(x);

        x = ClassLoader.getSystemClassLoader().loadClass("com.lzwing.testcode.classloader.Tester");
        System.out.println(x);
    }
}
