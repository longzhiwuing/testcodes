package com.lzwing.testcode.clone.deepclone;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/3/15
 * Time: 20:44
 */
public class TestClone {
    public static void main(String[] args) throws CloneNotSupportedException {
        TestBean testBean = new TestBean();
        testBean.setName("aaa");
        testBean.setId("bbb");
        PropertyBean propertyBean = new PropertyBean();
        propertyBean.setId("1");
        propertyBean.setName("prop");
        testBean.setPropertyBean(propertyBean);

        TestBean cloneBean = (TestBean) testBean.clone();

        testBean.getPropertyBean().setName("change prop");

        System.out.println(testBean);
        System.out.println(cloneBean);
    }
}
