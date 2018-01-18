/**
 * Project Name:TestCodes
 * File Name:JsoupTest.java
 * Package Name:com.test.jsoup
 * Date:2017年12月6日下午12:11:16
 * Copyright (c) 2017, chenzhongyong@cecdat.com All Rights Reserved.
 *
*/

package com.lzwing.testcode.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * ClassName:JsoupTest <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date: 2017年12月6日 下午12:11:16 <br/>
 * 
 * @author Administrator
 * @version
 * @since JDK 1.8
 * @see
 */
public class JsoupTest {
	public static void main(String[] args) {
		final String url = "http://www.nhfpc.gov.cn/htmlfiles/zwgkzt/ptjnj/year2013/helpcontents.html";

		try {

			Document doc = Jsoup.connect(url).get();
			
			System.out.println(doc.toString());
			

			Elements aTags = doc.getElementsByClass("t0i");

			for (Element aTag : aTags) {
				Document aTagDoc = Jsoup.parse(aTag.toString());
				String text = aTagDoc.text();
				System.out.println(text);
			}
			
			System.out.println("..over...");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
