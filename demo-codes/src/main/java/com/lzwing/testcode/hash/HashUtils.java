package com.lzwing.testcode.hash;
  
/** 
 * 相关hash算法 
 *  
 * @author ruiliang 
 * 
 */  
public class HashUtils {

    /******************************************************************************
     * Compilation: javac CRC16CCITT.java Execution: java CRC16CCITT s
     * Dependencies:
     *
     * Reads in a sequence of bytes and prints out its 16 bit Cylcic Redundancy
     * Check (CRC-CCIIT 0xFFFF).
     *
     * 1 + x + x^5 + x^12 + x^16 is irreducible polynomial.
     *
     * % java CRC16-CCITT 123456789 CRC16-CCITT = 29b1
     *
     ******************************************************************************/

    public static int crc16(final byte[] buffer) {

        int crc = 0xFFFF; // initial value 65535
        int polynomial = 0x1021; // 0001 0000 0010 0001 (0, 5, 12)
        // byte[] testBytes = "123456789".getBytes("ASCII");
        for (byte b : buffer) {
            for (int i = 0; i < 8; i++) {
                boolean bit = ((b >> (7 - i) & 1) == 1);
                boolean c15 = ((crc >> 15 & 1) == 1);
                crc <<= 1;
                if (c15 ^ bit)
                    crc ^= polynomial;
            }
        }

        return crc &= 0xffff;

    }

    /**
     *
     * @param buffer
     * @return
     */
    static int crc162(final byte[] buffer) {
        int crc = 0xFFFF;

        for (int j = 0; j < buffer.length; j++) {
            crc = ((crc >>> 8) | (crc << 8)) & 0xffff;
            crc ^= (buffer[j] & 0xff);// byte to int, trunc sign
            crc ^= ((crc & 0xff) >> 4);
            crc ^= (crc << 12) & 0xffff;
            crc ^= ((crc & 0xFF) << 5) & 0xffff;
        }
        crc &= 0xffff;
        return crc;

    }
    /** 
     * 从Robert Sedgwicks的 Algorithms in C一书中得到了 
     *  
     * @param str 
     * @return 
     */  
    public static long RSHash(String str) {  
        int b = 378551;  
        int a = 63689;  
        long hash = 0;  
        for (int i = 0; i < str.length(); i++) {  
            hash = hash * a + str.charAt(i);  
            a = a * b;  
        }  
        return hash;  
    }  
  
    /** 
     * Justin Sobel写的一个位操作的哈希函数。 
     *  
     * @param str 
     * @return 
     */  
    public static long JSHash(String str) {  
        long hash = 1315423911;  
        for (int i = 0; i < str.length(); i++) {  
            hash ^= ((hash << 5) + str.charAt(i) + (hash >> 2));  
        }  
        return hash;  
    }  
  
    /** 
     * PJW 该散列算法是基于贝尔实验室的彼得J温伯格的的研究。在Compilers一书中（原则，技术和工具），建议采用这个算法的散列函数的哈希方法。 
     *  
     * @param str 
     * @return 
     */  
    public static long PJWHash(String str) {  
        long BitsInUnsignedInt = (long) (4 * 8);  
        long ThreeQuarters = (long) ((BitsInUnsignedInt * 3) / 4);  
        long OneEighth = (long) (BitsInUnsignedInt / 8);  
        long HighBits = (long) (0xFFFFFFFF) << (BitsInUnsignedInt - OneEighth);  
        long hash = 0;  
        long test = 0;  
        for (int i = 0; i < str.length(); i++) {  
            hash = (hash << OneEighth) + str.charAt(i);  
            if ((test = hash & HighBits) != 0) {  
                hash = ((hash ^ (test >> ThreeQuarters)) & (~HighBits));  
            }  
        }  
        return hash;  
    }  
  
    /** 
     * ELF 和PJW很相似，在Unix系统中使用的较多。 
     *  
     * @param str 
     * @return 
     */  
    public static long ELFHash(String str) {  
        long hash = 0;  
        long x = 0;  
        for (int i = 0; i < str.length(); i++) {  
            hash = (hash << 4) + str.charAt(i);  
            if ((x = hash & 0xF0000000L) != 0) {  
                hash ^= (x >> 24);  
            }  
            hash &= ~x;  
        }  
        return hash;  
    }  
  
    /** 
     * BKDR 这个算法来自Brian Kernighan 和 Dennis Ritchie的 The C Programming 
     * Language。这是一个很简单的哈希算法,使用了一系列奇怪的数字,形式如31,3131,31...31,看上去和DJB算法很相似。 
     *  
     * @param str 
     * @return 
     */  
  
    public static long BKDRHash(String str) {  
        long seed = 131; // 31 131 1313 13131 131313 etc..  
        long hash = 0;  
        for (int i = 0; i < str.length(); i++) {  
            hash = (hash * seed) + str.charAt(i);  
        }  
        return hash;  
    }  
  
    public static long SDBMHash(String str) {  
        long hash = 0;  
        for (int i = 0; i < str.length(); i++) {  
            hash = str.charAt(i) + (hash << 6) + (hash << 16) - hash;  
        }  
        return hash;  
    }  
  
    /** 
     * DJB 这个算法是Daniel J.Bernstein 教授发明的，是目前公布的最有效的哈希函数。 
     *  
     * @param str 
     * @return 
     */  
    public static long DJBHash(String str) {  
        long hash = 5381;  
        for (int i = 0; i < str.length(); i++) {  
            hash = ((hash << 5) + hash) + str.charAt(i);  
        }  
        return hash;  
    }  
  
    /** 
     * .DEK 由伟大的Knuth在《编程的艺术 第三卷》的第六章排序和搜索中给出。 
     *  
     * @param str 
     * @return 
     */  
    public static long DEKHash(String str) {  
        long hash = str.length();  
        for (int i = 0; i < str.length(); i++) {  
            hash = ((hash << 5) ^ (hash >> 27)) ^ str.charAt(i);  
        }  
        return hash;  
    }  
  
    /** 
     * jdk hash 
     *  
     * @param a 
     * @return 
     */  
    public static int hashCode(int a) {  
        final int prime = 48;  
        int result = 1;  
        result = prime * result + a;  
        return result;  
    }  
}  