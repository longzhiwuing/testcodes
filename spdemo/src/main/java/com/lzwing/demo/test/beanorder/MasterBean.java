package com.lzwing.demo.test.beanorder;

import org.springframework.beans.factory.InitializingBean;

// 它作为Master的代理，把它放进容器内，而非Master本身
public class MasterBean implements InitializingBean {

    // 初始化完成后，立马放一条鱼
    @Override
    public void afterPropertiesSet() throws Exception {
        Master.getMaster().giveFish();
    }
}