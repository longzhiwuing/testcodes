package com.lzwing.testcode.gist.mainthreadwait;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/8/10
 * Time: 10:25
 */
public class Tester {
    static class User {
        public String id;
        public int age;
    }
    public static void main(String[] args) throws InterruptedException {

        final User user = new User();
        user.id = "bbb";
        user.age = 18;

        System.out.println(user.id+":"+user.age);

        user.id = "ccd";
        user.age = 19;

        System.out.println(user.id+":"+user.age);

        synchronized (Tester.class) {
            Tester.class.wait();
        }
    }
}
