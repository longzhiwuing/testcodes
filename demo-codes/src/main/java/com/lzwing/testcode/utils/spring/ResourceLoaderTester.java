package com.lzwing.testcode.utils.spring;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Charsets;
import com.google.common.collect.Maps;
import com.google.common.io.Resources;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong
 * Date: 2019/11/8
 * Time: 12:20
 */

@Slf4j
public class ResourceLoaderTester {
    /**
     * 文件名
     */
    private static String fileName = "testData.json";

    /**
     * 初始化 Map
     */
    private Map<String, String> initMap = Maps.newHashMap();

    public static void main(String[] args) throws Exception{
        JSONObject jsonObject = loadingJSONFile();
        log.info("json Data are as follows:{}", jsonObject);
        //使用Gson将json转成map
        Gson gson = new Gson();
        Map map = gson.fromJson(jsonObject.toJSONString(), Map.class);

        log.info("map:{}", map);
    }

    private static JSONObject loadingJSONFile() {

        log.info("开始加载resources/testData.json");

        Enumeration<URL> resources;
        JSONObject jsonObject = new JSONObject();
        try {
            resources = getClassLoader().getResources(fileName);
        } catch (IOException e) {
            log.warn("getJsonResource fail {}", fileName, e);
            return jsonObject;
        }
        while (resources.hasMoreElements()) {
            URL url = resources.nextElement();
            try {
                String json = Resources.toString(url, Charsets.UTF_8);
                // 有多个的时候，后面的覆盖前面的
                jsonObject.putAll(JSON.parseObject(json));
            } catch (IOException e) {
                log.warn("addJsonFile fail url:{}", url, e);
            }
        }
        return jsonObject;
    }

    private static ClassLoader getClassLoader() {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        if (classLoader != null) {
            return classLoader;
        }
        return ResourceLoaderTester.class.getClassLoader();
    }
}
