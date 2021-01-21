package com.lzwing.testcode.audition;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/8/4
 * Time: 10:53
 */
public class IntegerTest {
    public static void main(String[] args) {
         Integer a = 1;
         Integer b = 2;
         Integer c = 3;
         Integer d = 3;
         Integer e = 321;
         Integer f = 321;
         Long g = 3L;
         Long h = 2L;

        System.out.println(c == d);  //true
        System.out.println(e == f);  //false
        System.out.println(c == (a + b)); //false --true
        System.out.println(c.equals(a + b)); //true
        System.out.println(g == (a + b)); //false --true
        System.out.println(g.equals(a + b)); //true --false
        System.out.println(g.equals(a + h)); //true
        System.out.println(a.equals(g - h));
        System.out.println(a.equals(g - b));

    }
}
