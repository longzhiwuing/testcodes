package com.lzwing.testcode.utils.clone.deepclone.thirdpart;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Order implements Cloneable, Serializable {

    private Long id;

    private String orderNo;

    private List<Item> itemList;

    @Override
    public Order clone() {
        try {
            return (Order)super.clone();
        } catch (CloneNotSupportedException ignore) {
            // 不会调到这里
        }
        return null;
    }
}