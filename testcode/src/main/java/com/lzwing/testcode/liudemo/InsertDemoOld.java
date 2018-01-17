/**
 * Project Name:TestCodes
 * File Name:InsertDemo.java
 * Package Name:com.test.liudemo
 * Date:2018年1月10日下午5:05:32
 * Copyright (c) 2018, chenzhongyong@cecdat.com All Rights Reserved.
 *
*/

package com.lzwing.testcode.liudemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ClassName:InsertDemo <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date: 2018年1月10日 下午5:05:32 <br/>
 * 
 * @author Administrator
 * @version
 * @since JDK 1.8
 * @see
 */
public class InsertDemoOld {

	public static void main(String[] args) {

		String insertSql = "insert into persons (aa,bb,cc) values (1,'a','b'$#%#$%$#$%),(2,'),(c','d'),((3),('ee'),ff),(4,'g','h'),(5,'i',(j))";

		// String insertSql = "insert into persons (id_p, lastname , firstName,
		// city ) values (200,'haha' , 'deng' , 'shenzhen'),(201,'haha2' ,
		// 'deng' , 'GD'),(202,'haha3' , 'de(n)g' , 'Be(i)jing');";

		List<String> valueList = getAllValues(insertSql);

		System.out.println("总数：" + valueList.size());

		for (String item : valueList) {
			System.out.println(item);
		}
	}

	public static List<String> getAllValues(String insertSql) {

		List<String> values = new ArrayList<>();

		if (insertSql == null || insertSql.indexOf("values") < 0) {
			return null;
		}

		String columnParts = insertSql.split("values")[0];

		Pattern khPattern = Pattern.compile("\\(.*\\)");
		Matcher matcher = khPattern.matcher(columnParts);
		if (!matcher.find())
			return null;

		String columns = matcher.group(0);

		String[] columnNames = columns.split(",");

		if (columnNames == null || columnNames.length <= 0)
			return null;

		int columnSize = columnNames.length;

		StringBuilder ptsb = new StringBuilder();
		ptsb.append("\\(");
		for (int i = 0; i < columnSize; i++) {
			if (i == columnSize - 1) {
				ptsb.append(".+?");
			} else {
				ptsb.append(".+?,");
			}
		}
		ptsb.append("\\)");

		String valueStr = insertSql.split("values")[1].replaceAll("\\s*", "");

		Pattern valuePattern = Pattern.compile(ptsb.toString());
		matcher = valuePattern.matcher(valueStr);
		while (matcher.find()) {
			values.add(matcher.group(0));
		}

		return values;
	}
}
