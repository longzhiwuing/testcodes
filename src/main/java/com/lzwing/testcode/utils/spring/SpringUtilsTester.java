package com.lzwing.testcode.utils.spring;

import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/4/20
 * Time: 15:41
 */
public class SpringUtilsTester {
    
    public static void main(String[] args) {
         testAntPathMather();
    }

    private static void testAntPathMather() {
        PathMatcher pathMatcher = new AntPathMatcher();
        assertTrue(pathMatcher.match("test", "test"));
        assertTrue(pathMatcher.match("/test", "/test"));
        assertTrue(pathMatcher.match("http://example.org", "http://example.org")); // SPR-14141
        assertFalse(pathMatcher.match("/test.jpg", "test.jpg"));
        assertFalse(pathMatcher.match("test", "/test"));
        assertFalse(pathMatcher.match("/test", "test"));

    }
}
