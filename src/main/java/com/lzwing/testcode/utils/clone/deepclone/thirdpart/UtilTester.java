package com.lzwing.testcode.utils.clone.deepclone.thirdpart;

import com.google.gson.Gson;
import org.apache.commons.lang3.SerializationUtils;

import static org.junit.Assert.assertFalse;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong
 * Date: 2020/2/2
 * Time: 14:24
 */
public class UtilTester {
    public static void main(String[] args) {
        Order order = OrderMocker.mock();
        //common-lang3
        Order cloneOrder = SerializationUtils.clone(order);


        //gson
        order = OrderMocker.mock();
        // gson序列化方式
        cloneOrder = deepCloneByGson(order, Order.class);

        assertFalse(order == cloneOrder);
        assertFalse(order.getItemList() == cloneOrder.getItemList());
    }

    /**
     * Gson方式实现深拷贝
     */
    public static <T> T deepCloneByGson(T origin, Class<T> clazz) {
        Gson gson = new Gson();
        return gson.fromJson(gson.toJson(origin), clazz);
    }
}
