package com.lzwing.testcode.springdemo.el;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong
 * Date: 2020/4/6
 * Time: 11:19
 */
public class SpringELTester {


    private static final String ARGS = "args";

    private static final String HASH = "hash";

    private final ExpressionParser parser = new SpelExpressionParser();

    private final ConcurrentHashMap<String, Expression> expCache = new ConcurrentHashMap<>(1<<6);


    public static void main(String[] args) {
//        common();
//        springContextDemo();
        SpringELTester springELTester = new SpringELTester();

        String key = "'kaoyan-cms-res-list-'+ #args[0]";

        Object[] objects = new Object[2];

        CmsListReqVo vo = new CmsListReqVo();
        vo.setCategoryId(16);
        vo.setPageNo(1);
        vo.setPageSize(10);

        objects[0] = vo;

        objects[1] = vo;

        String val = springELTester.processSpringElKey(key, objects);

        System.out.println(val);
    }

    public String processSpringElKey(String keySpEL, Object[] arguments) {
        StandardEvaluationContext context = new StandardEvaluationContext();
        context.setVariable(ARGS, arguments);
        try {
            context.registerFunction(HASH, this.getClass().getDeclaredMethod("getHashString", Object.class));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        Expression expression = expCache.get(keySpEL);
        if (null == expression) {
            expression = parser.parseExpression(keySpEL);
            expCache.put(keySpEL, expression);

        }
        return expression.getValue(context, Object.class).toString();
    }

    private static void springContextDemo() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        Role2 role2 = context.getBean(Role2.class);
        System.out.println(role2.toString());
        ElBean elBean = context.getBean(ElBean.class);
        System.out.println(elBean.toString());
    }

    private static void common() {
        //表达式解析器
        ExpressionParser parser = new SpelExpressionParser();

        // 设置表达式
        Expression exp = parser.parseExpression("'hello world'");
        String str = (String) exp.getValue();
        System.out.println(str);

        //通过EL访问普通方法
        exp = parser.parseExpression("'hello world'.charAt(0)");
        char ch = (Character) exp.getValue();
        System.out.println(ch);

        //通过EL访问的getter方法
        exp = parser.parseExpression("'hello world'.bytes");
        byte[] bytes = (byte[]) exp.getValue();
        System.out.println(bytes);

        //通过EL访问属性，相当于"hello world".getBytes().length
        exp = parser.parseExpression("'hello world'.bytes.length");
        int length = (Integer) exp.getValue();
        System.out.println(length);

        exp = parser.parseExpression("new String('abc')");
        String abc = (String) exp.getValue();
        System.out.println(abc);
    }
}
