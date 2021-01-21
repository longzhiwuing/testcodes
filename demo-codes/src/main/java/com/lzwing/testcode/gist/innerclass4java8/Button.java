package com.lzwing.testcode.gist.innerclass4java8;

/**
 * java8 不需要必须声明final变量
 */
public class Button {
    //java8 不需要必须声明final变量
    public void click(int params){
        //匿名内部类，实现的是ActionListener接口
        new ActionListener(){
            @Override
            public void onAction(){
                System.out.println("click action..." + params);
            }
        }.onAction();
    }
    //匿名内部类必须继承或实现一个已有的接口
    public interface ActionListener{
        public void onAction();
    }

    public static void main(String[] args) {
        Button button=new Button();
        button.click(2);
    }
}