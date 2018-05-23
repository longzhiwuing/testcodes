package com.lzwing.testcode.java8.closure;

import javax.xml.ws.Holder;
import java.util.function.Function;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/5/23
 * Time: 9:31
 */
public class Closure {
    Function<Integer, Integer> adder(){
        final Holder<Integer> sum = new Holder<>(0);

        return (Integer value) ->{
            sum.value +=value;
            return sum.value;
        };
    }

    public static void main(String[] args) {
        Closure closure = new Closure();
        Function<Integer, Integer> adder = closure.adder();

        for (int i = 1; i <= 10; i++) {
            Integer apply = adder.apply(i);
            System.out.printf("0+1+...+%d=%d\n",i,apply);
        }

    }

}
