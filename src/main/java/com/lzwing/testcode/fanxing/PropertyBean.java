package com.lzwing.testcode.fanxing;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/3/16
 * Time: 8:28
 */
@Data
public class PropertyBean implements Cloneable{

    String id;
    String name;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
