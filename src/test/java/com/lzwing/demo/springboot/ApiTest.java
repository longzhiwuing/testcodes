package com.lzwing.demo.springboot;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

/**
 * 测试rest-assured接口工具
 *
 * @author: chenzhongyong
 * Date: 2020/2/15
 * Time: 15:33
 */
@Slf4j
public class ApiTest {

    public static RequestSpecification requestSpecification;
    public static ResponseSpecification responseSpecification;

    @Before
    public void gen() {
        //通用请求
        requestSpecification = new RequestSpecBuilder().build();
        requestSpecification.port(80);
        requestSpecification.cookie("s_id", "leitianxiao");
        requestSpecification.header("User-Agent", "Andriod");
        //通用断言
        responseSpecification = new ResponseSpecBuilder().build();
        responseSpecification.statusCode(200);
        //responseSpecification.body(hasItems("0", "1"));
    }

    @Test
    public void testRestAssured() {
//        given().get("http://www.baidu.com").then().statusCode(200);
        given().log().all().get("http://www.baidu.com").then().log().all().statusCode(200);
    }

    @Test
    public void testMp3(){
        given().log().all()
                .queryParam("wd","mp3")
        .when()
                .get("http://www.baidu.com/s")
        .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void testJson(){
        given().when().get("http://localhost:8888/daybreak.json")
                .then()
                //.body("store.book.category",hasItems("reference"));
                .body("store.book[0].author",equalTo("Nigel Rees"));
    }

    //其他用例里使用
    @Test
    public void testGetHtml(){
        given().
                //请求使用
                        spec(requestSpecification);
        get("http://www.qq.com").
                then().
                //断言使用
                        spec(responseSpecification);
    }


}
