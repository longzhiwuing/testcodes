package com.lzwing.testcode.idgenerator;

import org.apache.commons.lang.StringUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class CreateSerialNo {

	private static Map<String, String> map = new HashMap<String, String>();
	private static String STATNUM = "000001";

	/**
	 * 判断序号是否到了最后一个
	 * 
	 * @param s
	 * @return
	 */
	/*
	 * public String getLastSixNum(String s) { String rs = s; int i =
	 * Integer.parseInt(rs); i += 1; rs = "" + i; for (int j = rs.length(); j <
	 * 6; j++) { // rs="0"+rs; // 直接使用StringUtils类的leftPad方法处理补零 rs =
	 * StringUtils.leftPad(rs, j + 1, "0"); } return rs; }
	 */

	/**
	 * 产生不重复的号码 加锁
	 * 
	 * @return
	 */
	public static synchronized String getNum() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
		String yearAMon = df.format(cal.getTime());
		String last6Num = map.get(yearAMon);
		if (last6Num == null) {
			map.put(yearAMon, STATNUM);
		} else {
			String rs = last6Num;
			int i = Integer.parseInt(rs);
			i += 1;
			rs = "" + i;
			for (int j = rs.length(); j < 6; j++) {
				// 直接使用StringUtils类的leftPad方法处理补零
				rs = StringUtils.leftPad(rs, j + 1, "0");
			}
			map.put(yearAMon, rs);
		}

		return yearAMon + map.get(yearAMon);
	}

	/**
	 * main测试
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// CreateSerialNo t = new CreateSerialNo();
		for (int i = 0; i < 200; i++) {
			System.out.println(CreateSerialNo.getNum());
		}
	}
}