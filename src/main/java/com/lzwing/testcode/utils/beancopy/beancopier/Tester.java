package com.lzwing.testcode.utils.beancopy.beancopier;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.beans.BeanCopier;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong
 * Date: 2019/11/7
 * Time: 10:47
 */
@Slf4j
public class Tester {

    public static void main(String[] args) {
        testCopy();
    }

    private static void testCopy() {
        UserDO userDO = DataUtil.createData();
        log.info("拷贝前：userDO:{}", userDO);
        // 第一个参数：源对象， 第二个参数：目标对象，第三个参数：是否使用自定义转换器（下面会介绍），下同
        BeanCopier b = BeanCopier.create(UserDO.class, UserDTO.class, false);
        UserDTO userDTO = new UserDTO();
        b.copy(userDO, userDTO, null);
        log.info("拷贝后：userDTO:{}", userDTO);
    }
}
