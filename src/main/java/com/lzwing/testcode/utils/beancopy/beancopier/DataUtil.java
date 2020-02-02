package com.lzwing.testcode.utils.beancopy.beancopier;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DataUtil {

    /**
     * 模拟查询出一条数据
     * @return
     */
    public static UserDO createData() {
        return new UserDO(1, "Van", LocalDateTime.now(),new BigDecimal(100L));
    }

    /**
     * 模拟查询出多条数据
     * @param num 数量
     * @return
     */
    public static List<UserDO> createDataList(int num) {
        List<UserDO> userDOS = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            UserDO userDO = new UserDO(i+1, "Van", LocalDateTime.now(),new BigDecimal(100L));
            userDOS.add(userDO);
        }
        return userDOS;
    }
}