package com.lzwing.testcode.hash;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/4/1
 * Time: 11:01
 */
public class HashDemo {
    public final static int maxInt = 1000;// 00000;//1亿
    public final static int USER_KEY_SLOT_COUNT = 20; // 定议分配存储用户的Slot位
    // ，如果存储有压力，可调大槽位

    public static void main(String[] args) {

        // int 不用crc16
        for (int i = 1; i < maxInt; i++) {
            // 根据玩家id 分布指定到Slot位
            int ranint = i % USER_KEY_SLOT_COUNT;
            String key = "key:" + ranint;
            System.out.println("key:" + key);
            // redisList.lpush(randomKey, String.valueOf(playerId));
        }

        /**
         * crc16 redis 集群也是用这种方式分配key
         */

        String a = "a,b,c,d,e,f,g,g,g";
        for (String j : a.split(",")) {
            int solt = HashUtils.crc16(j.getBytes()) % USER_KEY_SLOT_COUNT;
            String key = "key:" + solt;
            System.out.println("crc%solt=key:" + key);
        }

        // redisList.lpush(randomKey, String.valueOf(playerId));

    }
}
