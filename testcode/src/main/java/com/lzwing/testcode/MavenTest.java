/**
 * Project Name:TestCodes
 * File Name:MavenTest.java
 * Package Name:com.test
 * Date:2017年2月15日下午3:58:25
 * Copyright (c) 2017, chenzhongyong@cecdat.com All Rights Reserved.
 *
*/

package com.lzwing.testcode;

import org.ocpsoft.prettytime.PrettyTime;
import org.testng.Assert;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * ClassName:MavenTest <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date:     2017年2月15日 下午3:58:25 <br/>
 * @author   Administrator
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public class MavenTest {

    public void testLocal() {
        PrettyTime p = new PrettyTime(new Locale("ZH_CN"));
        System.out.println(p.format(new Date()));
    }
 
    public void testMinutesFromNow() throws Exception {
        PrettyTime t = new PrettyTime(new Date(0));
        System.out.println(t.format(new Date(1000 * 60 * 12)));
    }
 
    public void testMomentsAgo() throws Exception {
        PrettyTime t = new PrettyTime(new Date(6000));
        System.out.println(t.format(new Date(0)));
    }
 
    public void testMinutesAgo() throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:m:s");
        Date date = format.parse("2012-07-18 23:42:05");
        Date now = new Date();
        PrettyTime t = new PrettyTime(now);
        System.out.println(t.format(date));
    }
    
    public static void main(String[] args) throws Exception{
		MavenTest mavenTest = new MavenTest();
		mavenTest.testLocal();
		mavenTest.testMinutesFromNow();
		mavenTest.testMomentsAgo();
		mavenTest.testMinutesAgo();
	}
}

