package com.lzwing.testcode.utils.string;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/1/28
 * Time: 11:53
 */
public class StringFormatTest {
    public static void main(String[] args) {
//        t1();
//        numberTest();
//        timeStrTest();
//        dateTest();
        timeshowTest();
    }

    private static void timeshowTest() {
        Date date = new Date();
        //H的使用
        System.out.printf("2位数字24时制的小时（不足2位前面补0）:%tH%n", date);
        //I的使用
        System.out.printf("2位数字12时制的小时（不足2位前面补0）:%tI%n", date);
        //k的使用
        System.out.printf("2位数字24时制的小时（前面不补0）:%tk%n", date);
        //l的使用
        System.out.printf("2位数字12时制的小时（前面不补0）:%tl%n", date);
        //M的使用
        System.out.printf("2位数字的分钟（不足2位前面补0）:%tM%n", date);
        //S的使用
        System.out.printf("2位数字的秒（不足2位前面补0）:%tS%n", date);
        //L的使用
        System.out.printf("3位数字的毫秒（不足3位前面补0）:%tL%n", date);
        //N的使用
        System.out.printf("9位数字的毫秒数（不足9位前面补0）:%tN%n", date);
    }

    private static void numberTest() {
        String str = null;
        //$使用
        str = String.format("格式参数$的使用：%1$d,%2$s", 99, "abc");
        System.out.println(str);
        //+使用
        System.out.printf("显示正负数的符号：%+d与%d%n", 99, -99);
        //补O使用
        System.out.printf("最牛的编号是：%03d%n", 7);
        //空格使用
        System.out.printf("Tab键的效果是：% 8d%n", 7);
        //.使用
        System.out.printf("整数分组的效果是：%,d%n", 9989997);
        //空格和小数点后面个数
        System.out.printf("一本书的价格是：% 50.5f元%n", 49.8);
    }

    private static void t1() {
        String str = null;
        str = String.format("Hi,%s", "王力");
        System.out.println(str);
        str = String.format("Hi,%s:%s.%s", "王南", "王力", "王张");
        System.out.println(str);
        System.out.printf("字母a的大写是：%c %n", 'A');
        System.out.printf("3>7的结果是：%b %n", 3 > 7);
        System.out.printf("100的一半是：%d %n", 100 / 2);
        System.out.printf("100的16进制数是：%x %n", 100);
        System.out.printf("100的8进制数是：%o %n", 100);
        System.out.printf("50元的书打8.5折扣是：%f 元%n", 50 * 0.85);
        System.out.printf("上面价格的16进制数是：%a %n", 50 * 0.85);
        System.out.printf("上面价格的指数表示：%e %n", 50 * 0.85);
        System.out.printf("上面价格的指数和浮点数结果的长度较短的是：%g %n", 50 * 0.85);
        System.out.printf("上面的折扣是%d%% %n", 85);
        System.out.printf("字母A的散列码是：%h %n", 'A');
    }
}
