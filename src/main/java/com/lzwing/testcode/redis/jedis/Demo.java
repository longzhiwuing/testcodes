package com.lzwing.testcode.redis.jedis;

import redis.clients.jedis.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/5/7
 * Time: 18:28
 */
public class Demo {
    private static JedisPool pool; //线程池对象
//    private static String ADDR = "172.16.21.133";
    private static String ADDR = "10.1.11.109";
    private static int PORT = 6379;
    private static String AUTH = "";
    private static int MAX_IDLE = 10;
    private static int MAX_ACTIVE = 50;
    private static int MAX_WAIT = 100000;
    private static int TIMEOUT = 10000;
    private static boolean TEST_ON_BORROW = true;
    private static boolean TEST_ON_RETURN = true;

    static{
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(MAX_IDLE);
        config.setMaxWaitMillis(MAX_WAIT);
        config.setMaxTotal(MAX_ACTIVE);
        config.setTestOnBorrow(TEST_ON_BORROW);
        config.setTestOnReturn(TEST_ON_RETURN);
        pool = new JedisPool(config, ADDR, PORT, TIMEOUT); //新建连接池，如有密码最后加参数
    }

    public static void main(String[] args) {
//        demo();
//        demo2();
        demo3();
    }

    private static void demo3() {
        Jedis jedis = getJedisResource();

        jedis.set("k1", "v1");
        System.out.println(jedis.get("k1"));

        jedis.close();
    }

    public static Jedis getJedisResource () {
        try {
            if (pool!=null) {
                Jedis resource = pool.getResource();
                return resource;
            }
            return null;
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void returnResource (Jedis used) {

        if(pool!=null){
            pool.returnResource(used);
        }

    }

    public static void demo() {
        Jedis resource = getJedisResource();
        resource.select(2);
        resource.lpush("Countries", "USA");
        resource.lpush("Countries", "UK");
        resource.lpush("Countries", "CHINA");
        System.out.println(resource.rpop("Countries"));
        returnResource(resource);
    }

    public static void demo2() {

//        String match = "^DB.*\\|(350104488099736|350104488099746)\\|.*";
//        String match = "DB*(350104488099736|350104488099746)*";
//        String match = "D{B}*";
        String match = "DB\\|*\\|3501044880997[3-4]6\\|*";

        Jedis jedis = getJedisResource();
        ScanParams params = new ScanParams().match(match).count(1000);
        String scanMarker = "0";
        ScanResult<String> results = null;
        results = jedis.scan(scanMarker, params);
        List<String> keys = results.getResult();

        System.out.println(keys.size());

        System.out.println("ok");
    }


}
