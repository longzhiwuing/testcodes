package com.lzwing.testcode.java8.niceexample;

import java.util.Optional;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/6/14
 * Time: 15:42
 */
public class OptionalExamples {

    //参考 https://www.cnblogs.com/rjzheng/p/9163246.html


    /**
     * 替换
     * if(user!=null){
         if(user.getAddress()!=null){
             Address address = user.getAddress();
             if(address.getCity()!=null){
             return address.getCity();
             }
         }
        }
        throw new Excpetion("取值错误");
     * @param user
     * @return
     * @throws Exception
     */
    public String getCity(User user) throws Exception{
        return Optional.ofNullable(user)
                .map(u-> u.getAddress())
                .map(a->a.getCity())
                .orElseThrow(()->new Exception("取指错误"));
    }

    public void testUserNotNull(User user) {

        /*if(user!=null){
            dosomething(user);
        }*/

        Optional.ofNullable(user)
                .ifPresent(u->{
                    //dosomething(u);
                });
    }


    /**
     * 替换
     * public User getUser(User user) throws Exception{
         if(user!=null){
             String name = user.getName();
             if("zhangsan".equals(name)){
                return user;
             }
             }else{
                 user = new User();
                 user.setName("zhangsan");
                 return user;
            }
        }
     }
     *
     * @param user
     * @return
     */
    public User getUser(User user) {
        return Optional.ofNullable(user)
                .filter(u->"zhangsan".equals(u.getName()))
                .orElseGet(()-> {
                    User user1 = new User();
                    user1.setName("zhangsan");
                    return user1;
                });
    }
}
