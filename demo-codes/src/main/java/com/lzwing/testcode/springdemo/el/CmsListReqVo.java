package com.lzwing.testcode.springdemo.el;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;


@Data
@ToString
public class CmsListReqVo implements Serializable {

    private Integer categoryId;

    private int pageNo;

    private int pageSize;
}
