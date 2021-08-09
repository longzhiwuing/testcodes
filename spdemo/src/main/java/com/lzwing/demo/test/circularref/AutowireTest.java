package com.lzwing.demo.test.circularref;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong
 * Date: 2021/8/5
 * Time: 15:47
 */
public class AutowireTest {
    public static void main(String[] args) {
//        new AnnotationConfigApplicationContext(A.class, B.class);
        new AnnotationConfigApplicationContext(B.class,HelloServiceImpl.class);
    }
}

@Component
class A {
    @Autowired
    private B b;
}

@Component
class B {
    /*@Autowired
    private A a;*/
    @Autowired
    private HelloService helloService;
}

interface HelloService{
    Object hello(Integer id);
}

@Service
@EnableAspectJAutoProxy(exposeProxy = true)
class HelloServiceImpl implements HelloService {

    @Transactional
    @Override
    public Object hello(Integer id) {
        return "hello,spring";
    }
}
