package com.lzwing.testcode.jsonresp;

import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/5/2
 * Time: 10:53
 */
@Slf4j
public class Test {

    @org.junit.Test
    public void test() {
        Map data = Maps.newHashMap();
        data.put("data", "test");

        //Page<Object> page = PageHelper.startPage(1, 5);
        //return Resp.success(member, page.getTotal(), page.getPageNum(), page.getPageSize());

        //Map<String, Object> ext = new HashMap<>();
        //ext.put("msg", "扩展内容");
        //esp.success("成功了", member, ext, 5L, 1, 3);

        //Resp.httpStatus(HttpStatus.ACCEPTED, "成功了");

        //Resp.success(member);

        //Resp.result("201", "成功了", member);

        //Resp.fail();


        //这里分页信息，请自己从PageHelper返回的数据中得到。参看下面注释内容：
        log.info("{}",Resp.success(data, 5L, 1, 3).toJSON());
    }
}
