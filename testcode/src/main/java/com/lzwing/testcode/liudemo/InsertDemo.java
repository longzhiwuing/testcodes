/**
 * Project Name:TestCodes
 * File Name:InsertDemo.java
 * Package Name:com.test.liudemo
 * Date:2018年1月11日上午9:43:56
 * Copyright (c) 2018, chenzhongyong@cecdat.com All Rights Reserved.
 *
*/

package com.lzwing.testcode.liudemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ClassName:InsertDemo <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date: 2018年1月11日 上午9:43:56 <br/>
 * 
 * @author Administrator
 * @version
 * @since JDK 1.8
 * @see
 */
public class InsertDemo {

	public static void main(String[] args) {
		String origin = "(200,'haha' , 'deng' , 'shenzhen'),(201,'haha2' , 'de(ng),dsds' , 'GD'),(202,'haha3' , 'deng' , 'Beiji(ng),')";

		List<String> valueList = getValueList(origin);

		System.out.println("总数:" + valueList.size());
		for (String item : valueList) {
			System.out.println(item);
		}
	}

	public static List<String> getValueList(String origin) {

		List<String> valueList = new ArrayList<>();

		if (origin != null && origin.indexOf("),(") >= 0 && origin.startsWith("(") && origin.endsWith(")")) {
			origin = origin.replaceAll("\\s*", "");
			origin = origin.substring(0, origin.length() - 1).substring(1);
			String[] valueArr = origin.split("\\),\\(");
			List<String> infoList = Arrays.asList(valueArr);
			for (String info : infoList) {
				valueList.add(String.format("%s%s%s", "(", info, ")"));
			}
		}

		return valueList;
	}
}
